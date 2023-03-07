package com.sisrest.configuration.batch;

import javax.sql.DataSource;

import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import com.sisrest.dto.AlunoResponse;

public class AlunoItemWriter extends JdbcBatchItemWriter<AlunoResponse> {

	public AlunoItemWriter(DataSource dataSource) {
		this.setDataSource(dataSource);
		this.setSql(
				"INSERT INTO aluno ( nome, matricula, email, CPF, curso,programa,modalidade,situacao,classificacao,pontuacao,renda,quantidade,percapta,cota,Nascimento,valor) "
						+ "VALUES (:nome, :matricula, :email, :CPF, :curso,:programa,:modalidade, :situacao,:classificacao,:pontuacao, :renda, :quantidade,:percapta, :cota ,:Nascimento,:valor) ");
		this.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		this.afterPropertiesSet();

	}

}
