package com.sisrest.configuration.batch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class UploadDeArquivos {

	@Value("D:\\GitHub\\SisRest\\sisrest\\src\\main")
	private String raiz;

	@Value("resources")
	private String diretorio;

	private File file;

	public String getRaiz() {
		return raiz;
	}

	public String getDiretorio() {
		return diretorio;
	}
	
	public boolean salvarCSV(MultipartFile arquivoCSV) {
		return this.salvar(this.diretorio, arquivoCSV);
	}
	
	private boolean salvar(String diretorio, MultipartFile arquivo) {
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());
		file = arquivoPath.toFile();
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
			return true;
		} catch (IOException e) {
			throw new RuntimeException("Erro ao Salvar!!");
		}
	}
}
