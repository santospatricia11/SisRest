package com.sisrest.resources;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.exceptions.CsvException;
import com.sisrest.storage.Disco;

@RestController
@RequestMapping("/api/aluno")
public class AlunoResource {

	@Autowired
	private Disco disco;

	@PostMapping(value = "/uploadCSV")
	public void uploadCSV(@RequestParam("file") MultipartFile arquivoCSV) throws IOException, CsvException {
		disco.salvarCSV(arquivoCSV);
		
	}
	
	@GetMapping(value = "/recuperarCSV")
	public List<String[]> recuperarCSV() throws CsvException{
		return disco.recuperarCSV();
	}
		

}
