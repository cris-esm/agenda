package com.ungs.agenda.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.dto.DomicilioDTO;
import com.ungs.agenda.mapper.ModelMapper;
import com.ungs.agenda.model.Domicilio;
import com.ungs.agenda.repository.DomicilioRepository;
import com.ungs.agenda.service.IDomicilioService;

@Service
public class DomicilioServiceImpl implements IDomicilioService {
	
	@Autowired
	private DomicilioRepository domicilioRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public DomicilioDTO getById(Long id) {
		Optional<Domicilio> domicilio = domicilioRepo.findById(id);
		return domicilio.isPresent() ? mapper.toDomicilioDTO(domicilio.get()) : null;
	}
	
}
