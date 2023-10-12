package com.sisrest.configuration.batch;

import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.BeneficiarioRaw;
import com.sisrest.model.entities.ContaEstudante;
import com.sisrest.model.entities.Edital;
import com.sisrest.repositories.BeneficiarioRepository;
import com.sisrest.repositories.ContaEstudanteRepository;
import com.sisrest.repositories.EditalRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import java.util.List;
import java.util.Optional;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ContaEstudanteRepository contaEstudanteRepository;
    @Autowired
    private BeneficiarioRepository beneficiarioRepository;
    @Autowired
    private EditalRepository editalRepository;

    private Long idEdital;

    @Bean
    @StepScope
    public FlatFileItemReader<ContaEstudante> contaEstudanteReader(@Value("#{jobParameters['arquivoEstudantesSuap']}") String arquivoEstudantesSuap) {
        FlatFileItemReader<ContaEstudante> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(arquivoEstudantesSuap));
        reader.setLineMapper(new DefaultLineMapper<ContaEstudante>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setDelimiter(",");
                setNames("numero", "matricula", "nome", "campus", "curso", "situacao", "situacaoNoUltimoPeriodo", "email");
            }});
            setFieldSetMapper(new ContaEstudanteFieldSetMapper());
        }});
        return reader;
    }

    @Bean
    @StepScope
    public FlatFileItemReader<BeneficiarioRaw> beneficiarioRawReader(@Value("#{jobParameters['arquivoBeneficiariosSuap']}") String arquivoBeneficiariosSuap) {
        FlatFileItemReader<BeneficiarioRaw> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(arquivoBeneficiariosSuap));
        reader.setLineMapper(new DefaultLineMapper<BeneficiarioRaw>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setDelimiter(",");
                setNames("numero", "nome", "matricula", "cpf", "curso", "programa", "modalidade", "situacao", "classificacao", "pontuacao",
                        "rendaBruta", "qtDePessoas", "percapta", "cota", "nascimento", "valor");
            }});
            setFieldSetMapper(new BeneficiarioRawFieldSetMapper());
        }});
        return reader;
    }

    @Bean
    public ItemWriter<ContaEstudante> contaEstudanteWriter() {
        return new ItemWriter<ContaEstudante>() {
            @Override
            public void write(List<? extends ContaEstudante> items) throws Exception {
                for (ContaEstudante contaEstudante : items) {
                    Optional<ContaEstudante> original = contaEstudanteRepository.findByMatricula(contaEstudante.getMatricula());

                    if (original.isPresent() == true) {
                        ContaEstudante atualizar = contaEstudante;
                        atualizar.setId(original.get().getId());

                        if (atualizar.getNome() == null) {
                            atualizar.setNome(original.get().getNome());
                        } else if (atualizar.getEmail() == null) {
                            atualizar.setEmail(original.get().getEmail());
                        } else if (atualizar.getCurso() == null) {
                            atualizar.setCurso(original.get().getCurso());
                        } else if (atualizar.getCampus() == null) {
                            atualizar.setCampus(original.get().getCampus());
                        }
                        contaEstudanteRepository.save(atualizar);
                    } else {
                        contaEstudanteRepository.save(contaEstudante);
                    }
                }
            }
        };
    }

    @Bean
    public ItemWriter<Beneficiario> beneficiarioWriter() {
        return new ItemWriter<Beneficiario>() {
            @Override
            public void write(List<? extends Beneficiario> items) throws Exception {
                for (Beneficiario beneficiario : items) {
                    beneficiarioRepository.save(beneficiario);
                }
            }
        };
    }

    @Bean
    @StepScope
    public ItemProcessor<BeneficiarioRaw, Beneficiario> beneficiarioProcessor(@Value("#{jobParameters['idEdital']}") Long idEdital) {
        return new ItemProcessor<BeneficiarioRaw, Beneficiario>() {
            @Override
            public Beneficiario process(BeneficiarioRaw beneficiarioRaw) throws Exception {
                String matricula = beneficiarioRaw.getMatricula();
                Optional<ContaEstudante> contaEstudante = contaEstudanteRepository.findByMatricula(Long.parseLong(matricula));
                Optional<Edital> edital = editalRepository.findById(idEdital);
                if (contaEstudante.isPresent()) {
                    Beneficiario beneficiario = new Beneficiario();
                    beneficiario.setContaEstudante(contaEstudante.get());
                    beneficiario.setEdital(edital.get());
                    beneficiario.setAtivo(true);
                    beneficiario.setCPF(Long.parseLong(beneficiarioRaw.getCpf()));
                    beneficiario.setPrograma(beneficiarioRaw.getPrograma());
                    beneficiario.setSituacao(beneficiarioRaw.getSituacao());
                    return beneficiario;
                }
                return null;
            }
        };
    }

    @Bean
    public Step contaEstudanteStep() {
        return stepBuilderFactory.get("contaEstudanteStep")
                .<ContaEstudante, ContaEstudante>chunk(100)
                .reader(contaEstudanteReader(null))
                .writer(contaEstudanteWriter())
                .build();
    }

    @Bean
    public Step beneficiarioStep() {
        return stepBuilderFactory.get("beneficiarioStep")
                .<BeneficiarioRaw, Beneficiario>chunk(100)
                .reader(beneficiarioRawReader(null))
                .processor(beneficiarioProcessor(this.idEdital))
                .writer(beneficiarioWriter())
                .build();
    }

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .flow(contaEstudanteStep())
                .on("COMPLETED").to(beneficiarioStep())
                .end()
                .build();
    }
}

