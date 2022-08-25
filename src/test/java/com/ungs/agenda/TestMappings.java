package com.ungs.agenda;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.ungs.agenda.dto.PaisDTO;
import com.ungs.agenda.dto.PersonaDTO;
import com.ungs.agenda.mapper.ModelMapper;
import com.ungs.agenda.model.Pais;
import com.ungs.agenda.model.Persona;
import com.ungs.agenda.model.Provincia;

class TestMappings {
	
	private ModelMapper mapper = Mappers.getMapper(ModelMapper.class);

	@Test
	void personaToPersonaDTO() {
		Persona persona = new Persona();
		persona.setId(2L);
		persona.setNombre("Persona Prueba");
		persona.setEmail("test@gmail.com");
		persona.setTelefono("1122334455");
		System.out.println(persona);
		PersonaDTO personaDTO = mapper.toPersonaDTO(persona);
		assertEquals(persona.getId(), personaDTO.getId());
	}
	
	@Test
	void paisToDTO() {
		Pais pais = new Pais();
		pais.setId(2L);
		pais.setNombre("Uruguay");
		List<Provincia> provincias = new ArrayList<Provincia>();
		Provincia provincia = new Provincia();
		provincia.setId(1L);
		provincia.setNombre("Montevideo");
		provincias.add(provincia);
		pais.setProvincias(provincias);
		System.out.println(pais);
		PaisDTO paisDTO = mapper.toPaisDTO(pais);
		assertEquals(pais.getId(), paisDTO.getId());
	}
}
