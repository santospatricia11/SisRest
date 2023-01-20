
package com.sisrest.batch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartFile;

import com.sisrest.model.entities.Aluno;
import com.sisrest.repositories.AlunoRepository;

@Configuration
@EnableBatchProcessing
@Import(DataSourceAutoConfiguration.class)
public class AlunoConfigurationBatch {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private DataSource dataSource;
	private AlunoRepository alunoRepository;
	
	@Value("D:\\GitHub\\Sisrest\\sisrest\\src\\resources\\files")
	private String raiz;

	@Value("CSV")
	private String diretorioCSV;

	private File file;

	public void salvarCSV(MultipartFile arquivoCSV) {
		this.salvar(this.diretorioCSV, arquivoCSV);
	}

	private void salvar(String diretorio, MultipartFile arquivo) {
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
		file = arquivoPath.toFile();
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());

		} catch (IOException e) {
			throw new RuntimeException("Erro ao Salvar!!");
		}
	}
		
	@Bean
	public FlatFileItemReader<Aluno> readerDataFromCsv() {

		FlatFileItemReader<Aluno> reader = new FlatFileItemReader<>();
		reader.setResource(new FileSystemResource(raiz));
		reader.setLineMapper(new DefaultLineMapper<Aluno>() {

			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(Aluno.fields());
					}

				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Aluno>() {
					{
						setTargetType(Aluno.class);
					}
				});
			}

		});

		return reader;

	}

	@Bean
	public ItemProcessor processor() {
		return new AlunoProcessor();
	}

	@Bean

	public FlatFileItemWriter<Aluno> writer() {

		FlatFileItemWriter<Aluno> writer = new FlatFileItemWriter<Aluno>();
		writer.setResource(new FileSystemResource(raiz));
		DelimitedLineAggregator<Aluno> aggregator = new DelimitedLineAggregator<>();
		BeanWrapperFieldExtractor<Aluno> fieldExtractor = new BeanWrapperFieldExtractor<>();
		fieldExtractor.setNames(Aluno.fields());
		aggregator.setFieldExtractor(fieldExtractor);
		writer.setLineAggregator(aggregator);
		return writer;
	}

	@Bean
	public Step executeAlunoStep() {

		return stepBuilderFactory.get("executeAlunoStep")
				.<Aluno, Aluno>chunk(5)
				.reader(readerDataFromCsv())
				.processor(processor())
				.writer(writer())
				.build();

	}

	
	
	@Bean(name = "launcher")
	public Job processAlunoJob() {
		return jobBuilderFactory.get("processAluno").flow(executeAlunoStep()).end().build();

	}
	///////////////////////////////banco//////////////////
	@Bean
	public FlatFileItemReader<Aluno> readFromCsv() {
		FlatFileItemReader<Aluno> reader = new FlatFileItemReader<Aluno>();
		reader.setResource(new FileSystemResource(""));
		// reader.setResource(new ClassPathResource("alunos.csv"));
		reader.setResource(new FileSystemResource(raiz));
		reader.setLineMapper(new DefaultLineMapper<Aluno>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(Aluno.fields());
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Aluno>() {
					{
						setTargetType(Aluno.class);
					}
				});

			}
		});
		return reader;
	}

	
	@Bean 
	public JdbcBatchItemWriter<Aluno> writerIntoDb(){
		JdbcBatchItemWriter<Aluno>writer= new JdbcBatchItemWriter<Aluno>();
		writer.setDataSource(dataSource);
		writer.setSql("insert into csvtodbdata(id,nome,matricula,email,CPF)values(:id,:nome,:matricula,:email,:CPF)");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Aluno>());
		return writer;
	}
	
	@Bean
	public Step step() {
		
		return stepBuilderFactory.get("step")
				.<Aluno,Aluno>chunk(10)
				.reader(readFromCsv())
				.writer(writerIntoDb())
				.build();
	
		
	}

	@Bean(name = "launcher")
	public Job job() {
		return jobBuilderFactory.get("job").flow(step()).end().build();
		
	}
}