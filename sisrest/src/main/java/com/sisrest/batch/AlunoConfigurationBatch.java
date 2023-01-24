
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
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.multipart.MultipartFile;

import com.sisrest.dto.AlunoResponse;
import com.sisrest.model.entities.Aluno;

@Configuration
@EnableBatchProcessing
@Import(DataSourceAutoConfiguration.class)
public class AlunoConfigurationBatch {

	@Value("D:\\GitHub\\Sisrest\\sisrest\\src\\main")
	private String raiz;

	@Value("resources")
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

//	@Bean
//	public FlatFileItemReader<AlunoResponse> reader() {
//		return new FlatFileItemReaderBuilder<AlunoResponse>().name("alunoItemReader")
//				.resource(new ClassPathResource("alunos.csv")).delimited()
//				.names(new String[] { "nome", "matricula", "email", "CPF" })
//				.fieldSetMapper(new BeanWrapperFieldSetMapper<AlunoResponse>() {
//					{
//						setTargetType(AlunoResponse.class);
//					}
//				}).build();
//	}
//
//	@Bean
//	public AlunoItemProcessor processor() {
//		return new AlunoItemProcessor();
//	}
//
//	@Bean
//	public JdbcBatchItemWriter<Aluno> writer(DataSource dataSource) {
//		return new JdbcBatchItemWriterBuilder<Aluno>()
//				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//				.sql("insert into aluno(id,nome,matricula,email,CPF)values(:id,:nome,:matricula,:email,:CPF)")
//				.dataSource(dataSource).build();
//	}
//
//	@Bean
//	public Job importUserJob(JobRepository jobRepository,
//			JobNotificacaoConclusao listener, Step step1) {
//		return new JobBuilder("importUserJob")
//			.incrementer(new RunIdIncrementer())
//			.listener(listener)
//			.flow(step1)
//			.end()
//			.build();
//	}
//
//	@Bean
//	public Step step1(JobRepository jobRepository,
//			PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Aluno> writer) {
//		return new StepBuilder("step1")
//			.<AlunoResponse, Aluno> chunk(10)
//			.reader(reader())
//			.processor(processor())
//			.writer(writer)
//			.build();
//	}
}