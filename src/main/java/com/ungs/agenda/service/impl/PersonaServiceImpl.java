package com.ungs.agenda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.model.Domicilio;
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

	@Override
	public Domicilio getDomicilio(Long id) {
		Persona persona = personaRepo.getById(id);
		return persona.getDomicilio();
	}

	@Override
	public Domicilio getDomicilio(Persona persona) {
		return persona.getDomicilio();
	}

	@Override
	public Persona getById(Long id) {
		// TODO Auto-generated method stub
		return personaRepo.getById(id);
	}

}
