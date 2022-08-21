package com.ungs.agenda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.model.Localidad;
import com.ungs.agenda.repository.LocalidadRepository;
import com.ungs.agenda.service.ILocalidadService;

@Service
public class LocalidadServiceImpl implements ILocalidadService {
	
	@Autowired
	private LocalidadRepository localidadRepo;

	@Override
	public Localidad getById(Long id) {		
		return localidadRepo.getById(id);
	}

}
