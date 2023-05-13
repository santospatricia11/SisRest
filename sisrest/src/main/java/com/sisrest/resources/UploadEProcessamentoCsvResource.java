package com.sisrest.resources;

import com.sisrest.services.ProcessamentoCSVService;
import com.sisrest.services.UploadCSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/csv")
public class UploadEProcessamentoCsvResource {

    @Autowired
    private UploadCSVService uploadService;
    @Autowired
    private ProcessamentoCSVService processamentoCSVService;

    @PostMapping("/processar")
    public void processarCsv(@RequestParam("arquivoEstudantesSuap") MultipartFile arquivoEstudantesSuap,
                             @RequestParam("arquivoBeneficiariosSuap") MultipartFile arquivoBeneficiariosSuap,
                             @RequestParam("idEdital") long idEdital) {
        processamentoCSVService.processarCsv(arquivoEstudantesSuap, arquivoBeneficiariosSuap, idEdital);
    }

    @PostMapping("/upload")
    public void uploadCsv(@RequestParam("arquivoEstudantesSuap") MultipartFile arquivoEstudantesSuap,
                          @RequestParam("arquivoBeneficiariosSuap") MultipartFile arquivoBeneficiariosSuap) {
        uploadService.salvarCSV(arquivoEstudantesSuap);
        uploadService.salvarCSV(arquivoBeneficiariosSuap);
    }
}

