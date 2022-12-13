package com.sisrest.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.sisrest.model.entities.Beneficiario;
import com.sisrest.model.entities.Conta;

import jakarta.persistence.MappedSuperclass;
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
public class BeneficiarioDto {
private Long matricula;
	
	

	
	
}
