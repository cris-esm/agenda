package com.ungs.agenda.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ungs.agenda.dto.DomicilioDTO;
import com.ungs.agenda.dto.PersonaDTO;

public interface IPersonaService {
	
	public List<PersonaDTO> getAll();
	
	public void saveOrUpdate(PersonaDTO persona);
	
	public void delete(PersonaDTO persona);
	
	public DomicilioDTO getDomicilio(Long id);
	
	public PersonaDTO getById(Long id);
	
	public Page<PersonaDTO> getPaginated(Integer pageNum, Integer pageSize);

}
