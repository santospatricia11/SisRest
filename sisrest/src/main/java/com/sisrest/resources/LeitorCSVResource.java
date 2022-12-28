package com.sisrest.resources;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@RestController
@RequestMapping("/api/lerArquivoCSV")
public class LeitorCSVResource {

	@PostMapping
	public ResponseEntity<String[]> uploadCSV(@RequestParam("file") MultipartFile arquivoCSV)
			throws IOException, CsvException {
		File file = null;
		arquivoCSV.transferTo(file);
		try (CSVReader csvReader = new CSVReader(new FileReader(file))) {
			List<String[]> linhas = csvReader.readAll();
			return new ResponseEntity(linhas, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity("Não deu certo", HttpStatus.NOT_FOUND);

	}
}
