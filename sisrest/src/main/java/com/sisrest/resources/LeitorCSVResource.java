package com.sisrest.resources;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.exceptions.CsvException;
import com.sisrest.storage.Disco;

@RestController
@RequestMapping("/api/lerArquivoCSV")
public class LeitorCSVResource {

	@Autowired
	private Disco disco;

	@PostMapping
	public void uploadCSV(@RequestParam("file") MultipartFile arquivoCSV) throws IOException, CsvException {

		disco.salvarCSV(arquivoCSV);

//		File file = new File("D:\\GitHub\\Sisrest\\sisrest");
//		arquivoCSV.transferTo(file);
//		try (CSVReader csvReader = new CSVReader(new FileReader(file))) {
//			List<String[]> linhas = csvReader.readAll();
//			return new ResponseEntity(linhas, HttpStatus.OK);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return new ResponseEntity("Não deu certo", HttpStatus.NOT_FOUND);
//
	}
}
