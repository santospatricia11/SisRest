package com.sisrest.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.sisrest.dto.AlunoResponse;
import com.sisrest.model.entities.Aluno;

public class AlunoItemProcessor implements ItemProcessor<AlunoResponse, Aluno> {

	private static final Logger log = LoggerFactory.getLogger(AlunoItemProcessor.class);

	@Override
	public Aluno process(final AlunoResponse item) throws Exception {
		final String nome = item.getNome().toUpperCase();
		final long matricula = item.getMatricula();
		final String email = item.getEmail().toUpperCase();
		final String CPF = item.getCPF().toUpperCase();
		
		final Aluno itemTransformado = new Aluno();
		
		itemTransformado.setNome(nome);
		itemTransformado.setMatricula(matricula);
		itemTransformado.setEmail(email);
		itemTransformado.setCPF(CPF);

		log.info("Convertendo (" + item + ") para  (" + itemTransformado + ")");

		return itemTransformado;
	}
}
