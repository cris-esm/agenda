package com.ungs.agenda.service;

import java.util.List;

import com.ungs.agenda.dto.TecnologiaDTO;

public interface ITecnologiaService {
	
	public List<TecnologiaDTO> getAll();
	
	public TecnologiaDTO getById(Long id);
}
