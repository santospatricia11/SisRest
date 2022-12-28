package com.sisrest.storage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@Component
public class StorageCSV {

	private static final StorageCSV INSTANCIA_DISCO = new StorageCSV();

	private StorageCSV() {
	}

	public StorageCSV getInstancia() {
		return INSTANCIA_DISCO;
	}

	@Value("D:\\GitHub\\Sisrest\\sisrest\\src\\resources\\files")
	private String raiz;

	@Value("CSV")
	private String diretorioCSV;

	private File file;

	public void salvarCSV(MultipartFile arquivoCSV) {
		this.salvar(this.diretorioCSV, arquivoCSV);
	}

	private void salvar(String diretorio, MultipartFile arquivo) {
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
		file = arquivoPath.toFile();
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());

		} catch (IOException e) {
			throw new RuntimeException("Erro ao Salvar!!");
		}
	}

	public List<String[]> recuperarCSV() throws CsvException {

		try (CSVReader csvReader = new CSVReader(new FileReader(this.file))) {
			List<String[]> linhas = csvReader.readAll();
			return linhas;
		} catch (IOException e) {
			throw new RuntimeException("Erro ao Recuperar!");
		}

	}
}
