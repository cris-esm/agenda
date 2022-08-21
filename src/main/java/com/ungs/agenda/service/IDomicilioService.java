package com.ungs.agenda.service;

import com.ungs.agenda.model.Domicilio;
import com.ungs.agenda.model.Persona;

public interface IDomicilioService {
	
	public Domicilio getByPersona(Long idPersona);
	
	public Domicilio getByPersona(Persona persona);

}
