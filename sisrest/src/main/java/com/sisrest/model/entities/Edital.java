package com.sisrest.model.entities;

import java.sql.Date;

public class Edital {
	private int numero;
	private String ano;
	private String nome; 
	private Date vigenteInicio;
	private Date  vigenteFinal;
	
	
	public Edital(int numero, String ano, String nome, Date vigenteInicio, Date vigenteFinal) {
		super();
		this.numero = numero;
		this.ano = ano;
		this.nome = nome;
		this.vigenteInicio = vigenteInicio;
		this.vigenteFinal = vigenteFinal;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getVigenteInicio() {
		return vigenteInicio;
	}


	public void setVigenteInicio(Date vigenteInicio) {
		this.vigenteInicio = vigenteInicio;
	}


	public Date getVigenteFinal() {
		return vigenteFinal;
	}


	public void setVigenteFinal(Date vigenteFinal) {
		this.vigenteFinal = vigenteFinal;
	}
	
	
	
	

}
