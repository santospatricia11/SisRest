package com.sisrest.services.convertes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.sisrest.dto.AlunoResponse;
import com.sisrest.dto.BeneficiarioRequest;
import com.sisrest.dto.BeneficiarioResponse;
import com.sisrest.model.entities.Aluno;
import com.sisrest.model.entities.Beneficiario;

public class AlunoServiceConvert {
	
	@Autowired
	private ModelMapper mapper;

	public List<AlunoResponse> alunosToResponses(List<Aluno> alunos) {
		return alunos.stream().map(this::alunoToDTO).toList();
				
	}

	public Aluno dtoToAluno(Aluno dto) {
		Aluno aluno = mapper.map(dto, Aluno.class);
		return aluno;
	}

	public AlunoResponse alunoToDTO(Aluno aluno) {
		AlunoResponse response = mapper.map(aluno, AlunoResponse.class);
		return response;
	}

}
