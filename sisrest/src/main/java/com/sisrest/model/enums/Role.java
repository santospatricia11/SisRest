package com.sisrest.model.enums;

public enum Role {

	ADMIN("Admin"), ASSISTENTE_SOCIAL("Assistente Social"), NUTRICIONISTA("Nutricionista"), ESTUDANTE("Estudante");

	private final String text;

	Role(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
