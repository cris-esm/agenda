package com.ungs.agenda.dto;

import com.ungs.agenda.model.Localidad;

import lombok.Data;

@Data
public class DomicilioDTO {
	
	private Long id;
	
	private String calle;
	
	private Integer altura;
	
	private String piso;
	
	private String departamento;
	
	private Localidad localidad;
}
