package com.ungs.agenda.service;

import java.util.List;

import org.springframework.scheduling.annotation.Async;

import com.ungs.agenda.dto.PaisDTO;
import com.ungs.agenda.dto.ProvinciaDTO;

public interface IPaisService {
	
	public List<PaisDTO> getAll();
	
	public List<ProvinciaDTO> getProvincias(Long idPais);
	
	@Async
	public void addPais(PaisDTO pais);
	
	public PaisDTO getPaisById(Long id);

}
