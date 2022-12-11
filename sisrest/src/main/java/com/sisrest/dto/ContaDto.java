package com.sisrest.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.validator.constraints.NotBlank;

import com.sisrest.model.entities.Conta;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class ContaDto {
	@NotBlank
	@Size(min=2, max=50)
	private String nome;
	
	@NotBlank
	@Pattern(regexp="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "Enter a valid, default email: _@_._")
	private String email;

	private boolean isAdmin;
	


	public ContaDto(Conta conta) {
	
		this.nome = conta.getNome();
		

		this.email =conta.getEmail();
		this.isAdmin=conta.isAdmin();
	}

	public ContaDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public static List<ContaDto> convert(List<Conta> contas) {
		
		
		return contas.stream().map(ContaDto::new).collect(Collectors.toList());
	}


	
}
