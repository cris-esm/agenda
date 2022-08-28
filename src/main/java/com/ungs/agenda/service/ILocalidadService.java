package com.ungs.agenda.service;


import java.util.List;

import com.ungs.agenda.model.Localidad;

import com.ungs.agenda.dto.LocalidadDTO;


public interface ILocalidadService {
	
	public LocalidadDTO getById(Long id);
	
	public List<Localidad> getLocalidades();

	
}
