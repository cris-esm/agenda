package com.ungs.agenda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.model.Pais;
import com.ungs.agenda.model.Provincia;
import com.ungs.agenda.repository.PaisRepository;
import com.ungs.agenda.service.IPaisService;

@Service
public class PaisServiceImpl implements IPaisService {
	
	@Autowired
	private PaisRepository paisRepo;
	
	@Override
	public List<Pais> getAll(){
		return paisRepo.findAll();
	}

	@Override
	public List<Provincia> getProvincias(Long idPais) {
		Pais pais = paisRepo.getById(idPais);
		return pais.getProvincias();
	}

	@Override
	public List<Provincia> getProvincias(Pais pais) {	
		return pais.getProvincias();
	}
	
}
