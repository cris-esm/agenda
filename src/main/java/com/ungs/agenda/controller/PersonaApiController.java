package com.ungs.agenda.controller;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ungs.agenda.dto.PersonaDTO;
import com.ungs.agenda.mapper.ModelMapper;
import com.ungs.agenda.service.IPersonaService;

@RestController
@RequestMapping("/api/Persona")
public class PersonaApiController {
	
	
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private ModelMapper mapper;

	 @PostMapping("/save")
	 public void savePersona(@RequestBody PersonaDTO persona) {
		 
		 
		 System.out.println(persona);
		 
		 personaService.saveOrUpdate(persona);
	  }
	 
	 
	 @PostMapping("/update")
	 public void updatePersona(@RequestBody PersonaDTO persona) {
		 
		 System.out.println(persona);

		 System.out.println(persona.getId());
		 
		
		 personaService.saveOrUpdate(persona);
	  }

}
