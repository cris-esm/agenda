package com.ungs.agenda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.dto.TecnologiaDTO;
import com.ungs.agenda.mapper.ModelMapper;
import com.ungs.agenda.model.Tecnologia;
import com.ungs.agenda.repository.TecnologiaRepository;
import com.ungs.agenda.service.ITecnologiaService;

@Service
public class TecnologiaServiceImpl implements ITecnologiaService {
	
	@Autowired
	private TecnologiaRepository tecnologiaRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<TecnologiaDTO> getAll() {
		List<Tecnologia> tecnologias = tecnologiaRepo.findAll();
		return mapper.toTecnologiasDTO(tecnologias);
	}

	@Override
	public TecnologiaDTO getById(Long id) {
		Optional<Tecnologia> tecnologia = tecnologiaRepo.findById(id);
		return tecnologia.isPresent() ? mapper.toTecnologiaDTO(tecnologia.get()) : null;
	}

}
