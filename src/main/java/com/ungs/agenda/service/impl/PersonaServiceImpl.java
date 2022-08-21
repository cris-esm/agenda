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
	private PersonaRepository personaRepo;

	@Override
	public List<Persona> getAll() {
		return personaRepo.findAll();
	}

	@Override
	public void saveOrUpdate(Persona persona) {
		personaRepo.save(persona);
	}

	@Override
	public void delete(Persona persona) {
		personaRepo.delete(persona);
	}

}
