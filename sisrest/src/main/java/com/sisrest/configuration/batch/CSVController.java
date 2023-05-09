package com.sisrest.configuration.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/csv")
public class CSVController {
    @Autowired
    private UploadCSVService csvService;

    @Autowired
    private JobLauncherService jobService;

    @PostMapping("/upload")
    public ResponseEntity<String> lerEGravarDadosDoCSV(@RequestParam("file") MultipartFile file) throws Exception {
        boolean resultado = csvService.salvarCSV(file);
        if (resultado) {
            jobService.runJob(file.getOriginalFilename());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
