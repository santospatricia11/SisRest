package com.sisrest.resources;

import com.sisrest.services.ProcessamentoCSVService;
import com.sisrest.services.UploadCSVService;
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
public class UploadEProcessamentoCsvResource {

    @Autowired
    private UploadCSVService uploadService;
    @Autowired
    private ProcessamentoCSVService processamentoCSVService;

    @PostMapping("/processar")
    public ResponseEntity processarCsv(@RequestParam("arquivoEstudantesSuap") MultipartFile arquivoEstudantesSuap,
                                       @RequestParam("arquivoBeneficiariosSuap") MultipartFile arquivoBeneficiariosSuap,
                                       @RequestParam("idEdital") long idEdital) {
        if(this.upload(arquivoEstudantesSuap,arquivoBeneficiariosSuap)){
            processamentoCSVService.processarCsv(arquivoEstudantesSuap, arquivoBeneficiariosSuap, idEdital);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    public boolean upload(@RequestParam("arquivoEstudantesSuap") MultipartFile arquivoEstudantesSuap,
                          @RequestParam("arquivoBeneficiariosSuap") MultipartFile arquivoBeneficiariosSuap) {
        boolean arquivoEstudantes = uploadService.salvarCSV(arquivoEstudantesSuap);
        boolean arquivoBeneficiarios = uploadService.salvarCSV(arquivoBeneficiariosSuap);
        if (arquivoEstudantes == true && arquivoBeneficiarios == true) {
            return true;
        }
        return false;
    }
}

