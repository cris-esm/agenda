package com.ungs.agenda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.model.TipoContacto;
import com.ungs.agenda.repository.TipoContactoRepository;
import com.ungs.agenda.service.ITipoContactoService;

@Service
public class TipoContactoServiceImpl implements ITipoContactoService {
	
	@Autowired
	private TipoContactoRepository tipoContactoRepo; 
	
	@Override
	public List<TipoContacto> getAll() {
		return tipoContactoRepo.findAll();
	}
}
