package com.sisrest.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.dto.beneficiario.BeneficiarioRequest;
import com.sisrest.dto.beneficiario.BeneficiarioResponse;
import com.sisrest.exception.ResourceNotFoundException;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.ContaBeneficiario;
import com.sisrest.model.entities.Edital;
import com.sisrest.repositories.BeneficiarioRepository;
import com.sisrest.repositories.EditalRepository;
import com.sisrest.repositories.InativacaoRepository;
@Service
public class BeneficiarioService {
	@Autowired
	private BeneficiarioRepository beneficiarioRepository;
	
    @Autowired
    private EditalRepository editalRepository;
    
    @Autowired
    private InativacaoRepository inativacaoRepository;

	@Autowired
	private ModelMapper mapper;


    public BeneficiarioResponse save(BeneficiarioResponse beneficiarioDTO, Edital edital, ContaBeneficiario contaBeneficiario) {

        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setAtivo(beneficiarioDTO.isAtivo());
        beneficiario.setEdital(edital);
        beneficiario.setContaBeneficiario(contaBeneficiario);

        beneficiario = beneficiarioRepository.save(beneficiario);

        BeneficiarioResponse   novoBeneficiarioDTO = new BeneficiarioResponse();
        novoBeneficiarioDTO.setId(beneficiario.getId());
        novoBeneficiarioDTO.setAtivo(beneficiario.isAtivo());
        novoBeneficiarioDTO.setEdital(beneficiario.getEdital());
        novoBeneficiarioDTO.setContaBeneficiario(beneficiario.getContaBeneficiario());

        return novoBeneficiarioDTO;
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

	public Beneficiario update(long id, Beneficiario beneficiarioDto)  {
		Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);

		Beneficiario original = beneficiario.get();
		Beneficiario atualizar = mapper.map(beneficiarioDto,Beneficiario.class);
		

		atualizar.setId(beneficiario.get().getId());
		if (atualizar.isAtivo() == false) {
			atualizar.setAtivo(true);
		} 
		return beneficiarioRepository.save(atualizar);
	}

	public BeneficiarioResponse getById(Long id) {
		
			Optional<Beneficiario> beneficiarioOptional = beneficiarioRepository.findById(id);
			
			if (beneficiarioOptional.isPresent()) {
				BeneficiarioResponse beneficiarioDTO = new BeneficiarioResponse();
				Beneficiario beneficiario = beneficiarioOptional.get();
				
				beneficiarioDTO.setId(beneficiario.getId());
				beneficiarioDTO.setAtivo(beneficiario.isAtivo());
				beneficiarioDTO.setEdital(beneficiario.getEdital());
				beneficiarioDTO.setContaBeneficiario(beneficiario.getContaBeneficiario());
				
				return beneficiarioDTO;
			} else {
				throw new ResourceNotFoundException("Beneficiário não encontrado com o ID: ", + id);
			}
		}
	}


