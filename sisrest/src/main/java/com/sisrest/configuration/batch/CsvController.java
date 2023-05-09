package com.sisrest.configuration.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/csv")
public class CsvController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private UploadCSVService uploadService;
    @Autowired
    private Job job;

    @PostMapping("/processar")
    public ResponseEntity<String> processarCsv(@RequestParam("arquivo") MultipartFile arquivo) {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("arquivo", arquivo.getOriginalFilename())
                    .toJobParameters();
            jobLauncher.run(job, jobParameters);
            return ResponseEntity.ok("Arquivo processado com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @PostMapping("/upload")
    public void uploadCsv(@RequestParam("arquivo") MultipartFile arquivo) {
        uploadService.salvarCSV(arquivo);
    }
}

