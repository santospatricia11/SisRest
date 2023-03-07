package com.sisrest.configuration.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;

import com.sisrest.dto.AlunoResponse;
import com.sisrest.model.entities.Aluno;

public class AlunoItemProcessor implements ItemProcessor<AlunoResponse, Aluno>, StepExecutionListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(AlunoItemProcessor.class);

	@Override
	public void beforeStep(StepExecution stepExecution) {
		LOGGER.info("Iniciando o PROCESSOR...");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		LOGGER.info("Finalizando o PROCESSOR...");
		return ExitStatus.COMPLETED;

	}

	@Override
	public Aluno process(AlunoResponse item) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

/*
 * Optional<Aluno> opt = alunoRepository.findById(item.getId());
 * 
 * if (opt.isPresent()) { String nome = item.getNome().toUpperCase(); long
 * matricula = item.getMatricula(); String email =
 * item.getEmail().toUpperCase(); long CPF = item.getCPF(); item.setId(0) ;
 * 
 * }
 */
