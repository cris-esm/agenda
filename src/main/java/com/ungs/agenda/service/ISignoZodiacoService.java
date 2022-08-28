package com.ungs.agenda.service;

import java.util.List;

import com.ungs.agenda.dto.SignoZodiacoDTO;

public interface ISignoZodiacoService {
	
	public List<SignoZodiacoDTO> getAll();
	
	public SignoZodiacoDTO getById(Long id);
}
