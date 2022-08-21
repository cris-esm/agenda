package com.ungs.agenda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.model.Domicilio;
import com.ungs.agenda.model.Persona;
import com.ungs.agenda.repository.DomicilioRepository;
import com.ungs.agenda.repository.PersonaRepository;
import com.ungs.agenda.service.IDomicilioService;

@Service
public class DomicilioServiceImpl implements IDomicilioService {
	
	@SuppressWarnings("unused")
	@Autowired
	private DomicilioRepository domicilioRepo;
	
	@Autowired
	private PersonaRepository personaRepo;
	
	public Domicilio getByPersona(Long IdPersona) {
		Persona persona = personaRepo.getById(IdPersona);
		return persona.getDomicilio();
	}
	
	public Domicilio getByPersona(Persona persona) {
		return persona.getDomicilio();
	}
}
