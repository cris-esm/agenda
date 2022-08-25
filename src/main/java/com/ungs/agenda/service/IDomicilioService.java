package com.ungs.agenda.service;

import com.ungs.agenda.dto.DomicilioDTO;
import com.ungs.agenda.model.Domicilio;
import com.ungs.agenda.model.Persona;

public interface IDomicilioService {
	
	public DomicilioDTO getById(Long id);
	
}
