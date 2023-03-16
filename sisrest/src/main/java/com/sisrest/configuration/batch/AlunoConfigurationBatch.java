
package com.sisrest.configuration.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;

import com.sisrest.dto.AlunoResponse;
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
	
	@Bean
	public FlatFileItemReader<AlunoResponse> reader() {
		return new FlatFileItemReaderBuilder<AlunoResponse>().name("alunoItemReader")
				.resource(new ClassPathResource("alunos.csv")).delimited()
				.names(new String[] { "nome", "matricula", "email", "CPF", "curso", "programa", "modalidade",
						"situacao", "classificacao", "pontuacao", "renda", "quantidade", "percapta", "cota",
						"Nascimento", "valor" })
				.linesToSkip(1)

				.fieldSetMapper(new BeanWrapperFieldSetMapper<AlunoResponse>() {
					{
						setTargetType(AlunoResponse.class);
					}
				}).build();
	}

	@Bean
	public ItemReader<AlunoResponse> itemReader() {
		LineMapper<AlunoResponse> alunoLineMapper = createAlunoLineMapper();

		return new FlatFileItemReaderBuilder<AlunoResponse>().name("alunoReader")
				.resource(new ClassPathResource("src/main/resources/alunos.csv")).linesToSkip(1)
				.lineMapper(alunoLineMapper).build();
	}

	private LineMapper<AlunoResponse> createAlunoLineMapper() {
		DefaultLineMapper<AlunoResponse> alunoLineMapper = new DefaultLineMapper<>();

		LineTokenizer alunoLineTokenizer = createAlunoLineTokenizer();
		alunoLineMapper.setLineTokenizer(alunoLineTokenizer);

		FieldSetMapper<AlunoResponse> alunoInformationMapper = createAlunoInformationMapper();
		alunoLineMapper.setFieldSetMapper(alunoInformationMapper);
		// setFieldSetMapper(alunoInformationMapper);

		return alunoLineMapper;
	}

	private LineTokenizer createAlunoLineTokenizer() {
		DelimitedLineTokenizer alunoLineTokenizer = new DelimitedLineTokenizer();
		alunoLineTokenizer.setDelimiter(",");
		alunoLineTokenizer.setNames(new String[] { "nome", "matricula", "email", "CPF", "curso", "programa",
				"modalidade", "situacao", "classificacao", "pontuacao", "renda", "quantidade", "percapta", "cota",
				"Nascimento", "valor" });
		return alunoLineTokenizer;
	}

	private FieldSetMapper<AlunoResponse> createAlunoInformationMapper() {
		BeanWrapperFieldSetMapper<AlunoResponse> alunoInformationMapper = new BeanWrapperFieldSetMapper<>();
		alunoInformationMapper.setTargetType(AlunoResponse.class);
		return alunoInformationMapper;
	}

	private static final String PROPERTY_REST_API_URL = "rest.api.url";

	@Bean
	public ItemReader<AlunoResponse> itemReader(Environment environment, RestTemplate restTemplate) {
		return new AlunoReader(environment.getRequiredProperty(PROPERTY_REST_API_URL), restTemplate);
	}

	@Bean
	public ItemWriter<AlunoResponse> itemWriter() {

		return new AlunoItemWriter(dataSource);
	}

	@Bean
	public Step exampleJobStep(ItemReader<AlunoResponse> reader, ItemWriter<AlunoResponse> writer,
			StepBuilderFactory stepBuilderFactory) {

		return stepBuilderFactory.get("exampleJobStep").<AlunoResponse, AlunoResponse>chunk(2).reader(reader)
				.writer(this.itemWriter())

				.build();
	}

	@Bean(name = "launcher")
	public Job exampleJob(Step exampleJobStep, JobBuilderFactory jobBuilderFactory) {
		return jobBuilderFactory.get("exampleJob").incrementer(new RunIdIncrementer()).flow(exampleJobStep).end()
				.build();

	}

}
