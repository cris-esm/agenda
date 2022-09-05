package com.ungs.agenda.service;


import java.util.List;

import com.ungs.agenda.model.Localidad;

import com.ungs.agenda.dto.LocalidadDTO;
import com.ungs.agenda.dto.PaisDTO;
import com.ungs.agenda.dto.ProvinciaDTO;


public interface ILocalidadService {
	
	public LocalidadDTO getById(Long id);
	
	public List<Localidad> getLocalidades();

	public ProvinciaDTO getProvinciaByLocalidad(Long id);
	
	public void save(LocalidadDTO localidad,ProvinciaDTO provincia);

}
