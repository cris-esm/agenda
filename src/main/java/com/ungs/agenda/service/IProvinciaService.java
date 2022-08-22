package com.ungs.agenda.service;

import java.util.List;

import com.ungs.agenda.model.Localidad;
import com.ungs.agenda.model.Provincia;

public interface IProvinciaService {
	
	public Provincia getById(Long id);
	
	public List<Localidad> getLocalidades(Long idProvincia);
	
	public List<Localidad> getLocalidades(Provincia provincia);
	
	public List<Provincia> getProvincias();

}
