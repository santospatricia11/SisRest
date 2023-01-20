package com.sisrest.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;

import com.sisrest.dto.AlunoResponse;
import com.sisrest.model.entities.Aluno;

public class AlunoProcessor implements ItemProcessor<AlunoResponse, Aluno>, StepExecutionListener {
	

	@Override
	public Aluno process(AlunoResponse item) throws Exception {
		final String firsName = item.getNome().toUpperCase();
		final String firsMatricula = item.getMatricula();
		final String firsEmail = item.getEmail().toUpperCase();
		final String firsCPF= item.getCPF().toUpperCase();
		final Aluno data = new Aluno(item.getId(),0, 0, item.getNome(),item.getMatricula(),0, item.getEmail(),firsEmail,item.getCPF());
		return data;
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
	
		return null;
	}


	
	

}
