package com.sisrest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.sisrest.batch.AlunoConfigurationBatch;

@RestController
@RequestMapping("/api/aluno")
public class AlunoResource {

	@Autowired
	private AlunoConfigurationBatch batch;

	@PostMapping(value = "/uploadCSV")
	public void uploadArquivoCSV(@RequestParam("file") MultipartFile arquivoCSV) {
		batch.salvarCSV(arquivoCSV);
		
	}
}
