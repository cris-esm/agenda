package com.ungs.agenda.service;

import com.ungs.agenda.dto.LocalidadDTO;
import com.ungs.agenda.dto.ProvinciaDTO;

public interface ILocalidadService {
	
	public LocalidadDTO getById(Long id);
	
	public ProvinciaDTO getProvinciaByLocalidad(Long id);
}
