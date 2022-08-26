package com.ungs.agenda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.dto.SignoZodiacoDTO;
import com.ungs.agenda.mapper.ModelMapper;
import com.ungs.agenda.model.SignoZodiaco;
import com.ungs.agenda.repository.SignoZodiacoRepository;
import com.ungs.agenda.service.ISignoZodiacoService;

@Service
public class SignoZodiacoServiceImpl implements ISignoZodiacoService {
	
	@Autowired
	private SignoZodiacoRepository signoZodiacoRepo; 
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<SignoZodiacoDTO> getAll() {
		List<SignoZodiaco> signosZodiaco = signoZodiacoRepo.findAll();
		return mapper.toSignosZodiacoDTO(signosZodiaco);
	}

	@Override
	public SignoZodiacoDTO getById(Long id) {
		Optional<SignoZodiaco> signoZodiaco = signoZodiacoRepo.findById(id);
		return signoZodiaco.isPresent() ? mapper.toSignoZodiacoDTO(signoZodiaco.get()) : null;
	}

}
