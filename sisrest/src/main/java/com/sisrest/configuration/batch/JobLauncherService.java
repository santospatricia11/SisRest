package com.sisrest.configuration.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobLauncherService {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    public void runJob(String nomeArquivo) throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("nomeArquivo", nomeArquivo)
                .toJobParameters();
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        System.out.println("JobExecution: " + jobExecution.getStatus());
    }
}
