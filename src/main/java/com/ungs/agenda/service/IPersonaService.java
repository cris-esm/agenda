package com.ungs.agenda.service;

import java.util.List;

import com.ungs.agenda.model.Domicilio;
import com.ungs.agenda.model.Persona;

public interface IPersonaService {
	
	public List<Persona> getAll();
	
	public void saveOrUpdate(Persona persona);
	
	public void delete(Persona persona);
	
	public Domicilio getDomicilio(Long id);
	
	public Domicilio getDomicilio(Persona persona);
	
	public Persona getById(Long id);
}
