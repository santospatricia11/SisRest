package com.sisrest.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.validator.constraints.NotBlank;

import com.sisrest.model.entities.Conta;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class ContaDto {
	
	@Size(min = 2, max = 50)

	@Column(name = "user_name")
	private String nome;
	@Id
	
	@Column(name= "email")

	private String email;


	@Column(name = "Admin")
	private boolean isAdmin;

	


}
