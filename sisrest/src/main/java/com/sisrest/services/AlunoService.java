package com.sisrest.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.AlunoRequest;
import com.sisrest.dto.BeneficiarioRequest;
import com.sisrest.exception.EmailEmUsoException;
import com.sisrest.model.entities.Aluno;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.repositories.AlunoRepository;
import com.sisrest.repositories.BeneficiarioRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private ModelMapper mapper;

	public Aluno save(AlunoRequest alunoDto) throws EmailEmUsoException {
		Aluno aluno = mapper.map(alunoDto, Aluno.class);
		boolean verificado = alunoRepository.existsByEmail(alunoDto.getEmail());

		if (verificado)
			throw new EmailEmUsoException(alunoDto.getEmail());

		return alunoRepository.save(aluno);
	}

	public Aluno deleteById(long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		alunoRepository.deleteById(id);
		return aluno.get();
	}

	public Aluno findById(long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.get();

	}

	public List<Aluno> findAll() {
		return (List<Aluno>) alunoRepository.findAll();
	}

	public Aluno update(long id, Aluno alunoDto) throws EmailEmUsoException {
		Optional<Aluno> aluno = alunoRepository.findById(id);

		Aluno original = aluno.get();
		Aluno atualizar = mapper.map(alunoDto, Aluno.class);
		boolean verificado = alunoRepository.existsByEmail(alunoDto.getEmail());

		if (verificado)
			throw new EmailEmUsoException(alunoDto.getEmail());

		atualizar.setId(aluno.get().getId());
		if (atualizar.getEmail() == null) {
			atualizar.setEmail(original.getEmail());
		} else if (atualizar.getMatricula() == 0) {
			atualizar.setMatricula(original.getMatricula());
		} else if (atualizar.getNome() == null) {
			atualizar.setNome(original.getNome());
		} else if (atualizar.getCurso() == null) {
			atualizar.setCurso(original.getCurso());
		} else if (atualizar.getCPF() == 0) {
			atualizar.setCPF(original.getCPF());
		} else if (atualizar.getPrograma() == null) {
			atualizar.setPrograma(original.getPrograma());

		}
		return alunoRepository.save(atualizar);
	}
}
