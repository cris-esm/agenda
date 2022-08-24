package com.ungs.agenda.dto;

import java.util.List;

import lombok.Data;

@Data
public class PaisDTO {
	
	private Long id;
	
	private String nombre;
	
	private List<ProvinciaDTO> provincias;

}
