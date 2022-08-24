package com.ungs.agenda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.dto.PaisDTO;
import com.ungs.agenda.dto.ProvinciaDTO;
import com.ungs.agenda.mapper.ModelMapper;
import com.ungs.agenda.model.Pais;
import com.ungs.agenda.repository.PaisRepository;
import com.ungs.agenda.service.IPaisService;

@Service
public class PaisServiceImpl implements IPaisService {
	
	@Autowired
	private PaisRepository paisRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<PaisDTO> getAll(){
		List<Pais> paises = paisRepo.findAll();
		return mapper.toPaisesDTO(paises);
	}

	@Override
	public List<ProvinciaDTO> getProvincias(Long idPais) {
		Optional<Pais> pais = paisRepo.findById(idPais);
		if(pais.isPresent()) {
			PaisDTO paisDTO = mapper.toPaisDTO(pais.get());
			return paisDTO.getProvincias();
		}
		return null;
	}
	
}
