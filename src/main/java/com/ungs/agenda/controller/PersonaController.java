package com.ungs.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ungs.agenda.repository.PersonaRepository;

@Controller
public class PersonaController {
	@Autowired
	private PersonaRepository personaRepository;
	
	
}
