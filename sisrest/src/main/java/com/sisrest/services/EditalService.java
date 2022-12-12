package com.sisrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisrest.model.entities.Edital;
import com.sisrest.repositories.EditalRepository;

@Service
public class EditalService {

	@Autowired
	private EditalRepository editalRepository;

	public EditalRepository save(Edital edital) {
		return editalRepository.save(editalRepository);
	}

}
