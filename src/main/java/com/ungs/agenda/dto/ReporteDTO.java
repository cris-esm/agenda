package com.ungs.agenda.dto;



import java.io.ByteArrayInputStream;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ReporteDTO {
	
	private String nombre;
	
	private ByteArrayInputStream data;
	
	private Integer length;
}