package com.sisrest.beneficiario;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisrest.model.entities.Beneficiario;
import com.sisrest.repositories.BeneficiarioRepository;
import com.sisrest.resources.BeneficiarioResource;
import com.sisrest.services.BeneficiarioService;


@RunWith(SpringRunner.class)
class TestBeneficiarioService {

	 //URL base para acesso desse controlador
    private final String BASE_URL = "/beneficiarios";

    //Instância do ObjectMapper para trabalhar com JSON
    private ObjectMapper objectMapper;

    //Controlador REST tratado por meio de injeção de dependências
    @Autowired
    private BeneficiarioResource beneficiarioResource;
    //Instância do MockMVC
    private MockMvc mockMvc;

    //Instância do mock repository
    @MockBean
    private BeneficiarioRepository repository;
    
    private BeneficiarioService service;
    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders
                .standaloneSetup(beneficiarioResource)
                .build();
    }

	@Test
	public void save_beneficiario() throws Exception {
	  Beneficiario beneficiario = new Beneficiario();
	  beneficiario.setId(1);
	  beneficiario.setAtivo(true);
	  beneficiario.setEdital(null);
	  

        when(repository.findById((long) 1)).thenReturn(Optional.of(beneficiario));

        mockMvc.perform(get(BASE_URL + "/1"))
        
                .andDo((ResultHandler) content().contentType("nn"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.ativo", is("Teste")))
                .andExpect(jsonPath("$.edital", is(10.0)));

        verify(repository, times(1)).findById((long) 1);
		
	}
	
	 @Test
	   public void atualizar() {
	      Beneficiario beneficiario = new Beneficiario();
	      beneficiario.setId(1);
	      beneficiario.setAtivo(true);
	      service.update(2, beneficiario);
	     // Mockito.verify(repository, Mockito.times(1)).atualizar(beneficiario);
	   }
	
	
}
