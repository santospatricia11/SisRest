package com.sisrest.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Disco {

	@Value("D:\\GitHub\\Sisrest\\sisrest\\src\\resources\\files")
	private String raiz;

	@Value("CSV")
	private String diretorioCSV;

	public void salvarCSV(MultipartFile arquivoCSV) {
		this.salvar(this.diretorioCSV, arquivoCSV);
	}

	private void salvar(String diretorio, MultipartFile arquivo) {
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
		} catch (IOException e) {
			throw new RuntimeException("Erro ao Salvar!!");
		}
	}
}
