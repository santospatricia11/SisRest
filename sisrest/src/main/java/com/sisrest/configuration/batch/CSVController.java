package com.sisrest.configuration.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.jsonwebtoken.io.IOException;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/api/csv")
public class CSVController {

    @Autowired
    private CSVJobLauncher meuJobLauncher;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            meuJobLauncher.iniciarJob("C:\\Users\\gabri\\Downloads\\"+ file.getOriginalFilename());
            return ResponseEntity.ok("Job iniciado com sucesso!");

        } catch (Exception e) {
            // Tratar possíveis erros ao iniciar o Job
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao iniciar o Job: " + e.getMessage());
        }


    }
}
