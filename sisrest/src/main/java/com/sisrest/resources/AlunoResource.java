package com.sisrest.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sisrest.model.entities.Aluno;

@RequestMapping("/api/arquivo")
public class AlunoResource {
	

	private Aluno aluno;
	
	@PostMapping("/arquivo")
	public void upload(@RequestParam MultipartFile file) {
		aluno.salvarCSV(file);
	}
	

}
