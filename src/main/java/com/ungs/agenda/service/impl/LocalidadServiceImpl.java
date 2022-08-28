package com.ungs.agenda.service.impl;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.dto.LocalidadDTO;
import com.ungs.agenda.mapper.ModelMapper;
import com.ungs.agenda.model.Localidad;
import com.ungs.agenda.repository.LocalidadRepository;
import com.ungs.agenda.service.ILocalidadService;

@Service
public class LocalidadServiceImpl implements ILocalidadService {
	
	@Autowired
	private LocalidadRepository localidadRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public LocalidadDTO getById(Long id) {		
		Optional<Localidad> localidad = localidadRepo.findById(id);
		return localidad.isPresent() ? mapper.toLocalidadDTO(localidad.get()) : null;
	}

	@Override
	public List<Localidad> getLocalidades() {
		// TODO Auto-generated method stub
		return localidadRepo.findAll();
	}

}
