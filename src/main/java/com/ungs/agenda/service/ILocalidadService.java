package com.ungs.agenda.service;

import java.util.List;

import com.ungs.agenda.model.Localidad;

public interface ILocalidadService {
	
	public Localidad getById(Long id);
	
	public List<Localidad> getLocalidades();

	
}
