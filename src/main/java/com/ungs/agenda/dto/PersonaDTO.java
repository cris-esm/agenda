package com.ungs.agenda.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PersonaDTO {
	
	private Long id;
	
	private String nombre;
	
	private String telefono;
	
	private String email;
	
	private LocalDate fechaNac;
	
	private DomicilioDTO domicilio;
	
	private TipoContactoDTO tipoContacto;
}
