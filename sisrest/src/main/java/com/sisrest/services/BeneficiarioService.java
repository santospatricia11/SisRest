package com.sisrest.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.BeneficiarioRequest;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.repositories.BeneficiarioRepository;

@Service
public class BeneficiarioService {

	@Autowired
	private BeneficiarioRepository beneficiarioRepository;

	@Autowired
	private ModelMapper mapper;

	public Beneficiario save(BeneficiarioRequest beneficiarioDto) {
		Beneficiario beneficiario = mapper.map(beneficiarioDto, Beneficiario.class);
		return beneficiarioRepository.save(beneficiario);
	}

	public Beneficiario deleteById(long id) {
		Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);
		beneficiarioRepository.deleteById(id);
		return beneficiario.get();
	}

	public Beneficiario findById(long id) {
		Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);
		return beneficiario.get();

	}

	public List<Beneficiario> findAll() {
		return (List<Beneficiario>) beneficiarioRepository.findAll();
	}

	public Beneficiario update(long id, Beneficiario beneficiarioDto) {
		Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);

		Beneficiario original = beneficiario.get();
		Beneficiario atualizar = mapper.map(beneficiarioDto, Beneficiario.class);

		atualizar.setId(beneficiario.get().getId());
		if (atualizar.getEmail() == null) {
			atualizar.setEmail(original.getEmail());
		}else if(atualizar.getMatricula() == 0) {
			atualizar.setMatricula(original.getMatricula());
		}else if (atualizar.getNome() == null) {
			atualizar.setNome(original.getNome());
		}else if (atualizar.getSenha() == null) {
			atualizar.setSenha(original.getSenha());
		}else if (atualizar.getTipo() == null) {
			atualizar.setTipo(original.getTipo());
		}
		return beneficiarioRepository.save(atualizar);
	}

}
