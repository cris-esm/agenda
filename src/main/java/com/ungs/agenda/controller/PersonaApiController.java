package com.ungs.agenda.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ungs.agenda.dto.PersonaDTO;
import com.ungs.agenda.service.IPersonaService;

@RestController
@RequestMapping("/api/Persona")
public class PersonaApiController {
	
	
	@Autowired
	private IPersonaService personaService;

	 @PostMapping("/save")
	 public void savePersona(@RequestBody PersonaDTO persona) {
		 
		 
		 System.out.println(persona);
		 
		 personaService.saveOrUpdate(persona);
	  }
	 
	 
	 @PostMapping("/update")
	 public void updatePersona(@RequestBody PersonaDTO persona, Long id) {
		 
		 PersonaDTO personaExistente = personaService.getById(id);
		 
		 personaExistente.setNombre(persona.getNombre());
		 
		 personaService.saveOrUpdate(personaExistente);
	  }

}
