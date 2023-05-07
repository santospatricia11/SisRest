package com.sisrest.configuration.batch;

import io.jsonwebtoken.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api/csv")
public class CSVController {

    @Autowired
    private CSVJobLauncher meuJobLauncher;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            String originalFileName = file.getOriginalFilename();
            String tempFilePath = System.getProperty("java.io.tmpdir") + originalFileName;
            File tempFile = new File(tempFilePath);
            file.transferTo(tempFile);
            String originalFilePath = tempFile.getAbsolutePath();

            System.out.println(originalFilePath);
            meuJobLauncher.iniciarJob(file.getOriginalFilename());
            return ResponseEntity.ok("Job iniciado com sucesso!");

        } catch (Exception e) {
            // Tratar possíveis erros ao iniciar o Job
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao iniciar o Job: " + e.getMessage());
        }


    }
}
