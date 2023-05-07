package com.sisrest.configuration.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CSVJobLauncher {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    public void iniciarJob(String caminhoArquivo) throws Exception {
        JobParameters jobParameters = new JobParametersBuilder().addString("caminhoArquivo", caminhoArquivo)
                .toJobParameters();
        jobLauncher.run(job, jobParameters);
    }

}
