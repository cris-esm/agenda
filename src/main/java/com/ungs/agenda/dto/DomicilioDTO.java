package com.ungs.agenda.dto;


import lombok.Data;

@Data
public class DomicilioDTO {
	
	private Long id;
	
	private String calle;
	
	private Integer altura;
	
	private String piso;
	
	private String departamento;
	
	private LocalidadDTO localidad;
}
