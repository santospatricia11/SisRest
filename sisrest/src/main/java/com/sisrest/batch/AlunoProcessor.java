package com.sisrest.batch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;

import com.sisrest.dto.AlunoResponse;
import com.sisrest.model.entities.Aluno;
@Configuration
public class AlunoProcessor implements ItemProcessor<AlunoResponse, Aluno>, StepExecutionListener{
	

		@Override
		public Aluno process(AlunoResponse item) throws Exception {
			final String firsName = item.getNome().toUpperCase();
		
			final String firsMatricula = item.getMatricula().toUpperCase();
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


	 
		
		
		
		
		

		/*
		 * private static final Logger LOGGER =
		 * LoggerFactory.getLogger(AlunoItemProcessor.class);
		 * 
		 * @Override public void beforeStep(StepExecution stepExecution) {
		 * LOGGER.info("Iniciando o PROCESSOR..."); }
		 * 
		 * 
		 * 
		 * @Override public ExitStatus afterStep(StepExecution stepExecution) {
		 * LOGGER.info("Finalizando o PROCESSOR..."); return ExitStatus.COMPLETED; }
		 * 
		 * //private static final Logger log =
		 * LoggerFactory.getLogger(AlunoItemProcessor.class);
		 * 
		 * 
		 * 
		 * 
		 * @Override public Aluno process(AlunoResponse item) throws Exception {
		 * System.out.println("Inserting employee : " + item); return null;
		 * 
		 * 
		 * }
		 */

	}



