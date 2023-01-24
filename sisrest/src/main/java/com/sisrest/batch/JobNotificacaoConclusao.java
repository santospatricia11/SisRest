package com.sisrest.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sisrest.model.entities.Aluno;

public class JobNotificacaoConclusao {
	private static final Logger log = LoggerFactory.getLogger(JobNotificacaoConclusao.class);

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JobNotificacaoConclusao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB Finalizado !!!");

			jdbcTemplate.query("SELECT nome, matricula FROM aluno", (rs, row) -> new Aluno(rs.getString(1),
					rs.getLong(2), rs.getLong(3), rs.getString(4), rs.getString(5))

			).forEach(person -> log.info("Found <" + person + "> in the database."));
		}
	}
}
