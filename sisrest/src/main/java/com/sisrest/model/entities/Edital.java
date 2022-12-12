package com.sisrest.model.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Edital {

	@Id
	@Column(name = "numero")
	private int numero;
	@Column(name = "ano")
	private String ano;
	@Column(name = "nome")
	private String nome;
	@Column(name = "vigente_inicio")
	private Date vigenteInicio;
	@Column(name = "vigente_final")
	private Date vigenteFinal;

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
