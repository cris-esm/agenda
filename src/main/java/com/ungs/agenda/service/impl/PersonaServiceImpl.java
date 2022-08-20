package com.ungs.agenda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.model.Persona;
import com.ungs.agenda.repository.PersonaRepository;
import com.ungs.agenda.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {
	@Autowired
	private PersonaRepository persona;

	@Override
	public List<Persona> getPersonas() {
		return persona.findAll();
	}

}
