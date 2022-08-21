package com.ungs.agenda.service;

import java.util.List;

import com.ungs.agenda.model.Pais;
import com.ungs.agenda.model.Provincia;

public interface IPaisService {
	
	public List<Pais> getAll();
	
	public List<Provincia> getProvincias(Long idPais);
	
	public List<Provincia> getProvincias(Pais pais);
}
