package com.sisrest.configuration.batch;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sisrest.dto.AlunoResponse;

public class AlunoReader implements ItemReader<AlunoResponse> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlunoReader.class);
	private final String apiUrl;
	private final RestTemplate restTemplate;

	private int nextAlunoIndex;
	private List<AlunoResponse> alunoData;

	@Override
	public AlunoResponse read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		LOGGER.info("Reader aluno ");

		if (alunoDataIsNotInitialized()) {
			alunoData = fetchAlunoDataFromAPI();
		}

		AlunoResponse nextAluno = null;

		if (nextAlunoIndex < alunoData.size()) {
			nextAluno = alunoData.get(nextAlunoIndex);
			nextAlunoIndex++;
		} else {
			nextAlunoIndex = 0;
			alunoData = null;
		}

		LOGGER.info("alunos : {}", nextAluno);

		return nextAluno;

	}

	AlunoReader(String apiUrl, RestTemplate restTemplate) {
		this.apiUrl = apiUrl;
		this.restTemplate = restTemplate;
		nextAlunoIndex = 0;
	}

	private boolean alunoDataIsNotInitialized() {
		return this.alunoData == null;
	}

	private List<AlunoResponse> fetchAlunoDataFromAPI() {
		LOGGER.debug("alunos: {}", apiUrl);

		ResponseEntity<AlunoResponse[]> response = restTemplate.getForEntity(apiUrl, AlunoResponse[].class);
		AlunoResponse[] alunoData = response.getBody();
		LOGGER.debug("Found {} alunos", alunoData.length);

		return Arrays.asList(alunoData);
	}

}
