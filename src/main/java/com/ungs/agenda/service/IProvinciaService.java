package com.ungs.agenda.service;

import java.util.List;

import com.ungs.agenda.dto.LocalidadDTO;
import com.ungs.agenda.dto.ProvinciaDTO;

public interface IProvinciaService {
	
	public ProvinciaDTO getById(Long id);
	
	public List<LocalidadDTO> getLocalidades(Long idProvincia);
	

}
