package com.sisrest.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sisrest.dto.AlunoRequest;
import com.sisrest.dto.edital.EditalRequest;
import com.sisrest.dto.edital.EditalResponse;
import com.sisrest.dto.inativacao.InativacaoRequest;
import com.sisrest.dto.inativacao.InativacaoResponse;
import com.sisrest.exception.EmailEmUsoException;
import com.sisrest.model.entities.Aluno;
import com.sisrest.model.entities.Conta;
import com.sisrest.model.entities.Edital;
import com.sisrest.model.entities.Inativacao;
import com.sisrest.repositories.AlunoRepository;
import com.sisrest.repositories.InativacaoRepository;
import com.sisrest.services.convertes.InativacaoServiceConvert;

@Service
public class InativacaoService {
	
	/*
	 * @Autowired private InativacaoRepository inativacaoRepository;
	 * 
	 * @Autowired private InativacaoServiceConvert inativacaoServiceConvert;
	 * 
	 * @Autowired private ModelMapper mapper;
	 * 
	 * public Inativacao save(Inativacao inativacao) { return
	 * inativacaoRepository.save(inativacao); }
	 * 
	 * 
	 * public Inativacao deleteById(long id) { Optional<Inativacao> inativacao =
	 * inativacaoRepository.findById(id); inativacaoRepository.deleteById(id);
	 * return inativacao.get(); }
	 * 
	 * public Inativacao findById(long id) { Optional<Inativacao> aluno =
	 * inativacaoRepository.findById(id); return aluno.get();
	 * 
	 * }
	 * 
	 * public List<Inativacao> findAll() { return (List<Inativacao>)
	 * inativacaoRepository.findAll(); }
	 * 
	 * public Inativacao update(long id, InativacaoResponse inativacaoDto) throws
	 * BeneficiariAtivoUsoException { Optional<Inativacao> inativacao =
	 * inativacaoRepository.findById(id); return null;
	 * 
	 * 
	 * }
	 */

}
