package com.ungs.agenda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.dto.LocalidadDTO;
import com.ungs.agenda.dto.PaisDTO;
import com.ungs.agenda.dto.ProvinciaDTO;
import com.ungs.agenda.mapper.ModelMapper;
import com.ungs.agenda.model.Provincia;
import com.ungs.agenda.repository.ProvinciaRepository;
import com.ungs.agenda.service.IProvinciaService;

@Service
public class ProvinciaServiceImpl implements IProvinciaService {
	
	@Autowired
	private ProvinciaRepository provinciaRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public ProvinciaDTO getById(Long id) {
		Optional<Provincia> provincia = provinciaRepo.findById(id);
		return provincia.isPresent() ? mapper.toProvinciaDTO(provincia.get()) : null;
	}
	
	@Override
	public List<LocalidadDTO> getLocalidades(Long id) {
		Optional<Provincia> provincia = provinciaRepo.findById(id);
		if(provincia.isPresent()) {
			ProvinciaDTO provinciaDTO = mapper.toProvinciaDTO(provincia.get());
			return provinciaDTO.getLocalidades();
		}
		return null;
	}

	@Override
	public PaisDTO getPaisByProvincia(Long id) {
		Optional<Provincia> provincia = provinciaRepo.findById(id);
		return provincia.isPresent() ? mapper.toPaisDTO(provincia.get().getPais()) : null;
	}
}
