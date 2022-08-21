package com.ungs.agenda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.model.Localidad;
import com.ungs.agenda.model.Provincia;
import com.ungs.agenda.repository.ProvinciaRepository;
import com.ungs.agenda.service.IProvinciaService;

@Service
public class ProvinciaServiceImpl implements IProvinciaService{
	
	@Autowired
	private ProvinciaRepository provinciaRepo;

	@Override
	public Provincia getById(Long id) {
		return provinciaRepo.getById(id);
	}
	
	@Override
	public List<Localidad> getLocalidades(Long idProvincia) {
		Provincia provincia = provinciaRepo.getById(idProvincia);
		return provincia.getLocalidades();
	}

	@Override
	public List<Localidad> getLocalidades(Provincia provincia) {
		return provincia.getLocalidades();
	}
	
}
