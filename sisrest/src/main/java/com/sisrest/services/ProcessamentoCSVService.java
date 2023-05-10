package com.sisrest.services;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProcessamentoCSVService {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    public boolean processarCsv(@RequestParam("arquivoEstudantesSuap") MultipartFile arquivoEstudantesSuap,
                                @RequestParam("arquivoBeneficiariosSuap") MultipartFile arquivoBeneficiariosSuap,
                                @RequestParam("idEdital") long idEdital) {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("arquivoEstudantesSuap", arquivoEstudantesSuap.getOriginalFilename())
                    .addString("arquivoBeneficiariosSuap", arquivoBeneficiariosSuap.getOriginalFilename())
                    .addLong("idEdital", idEdital)
                    .toJobParameters();
            jobLauncher.run(job, jobParameters);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
