package com.ungs.agenda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungs.agenda.dto.TipoContactoDTO;
import com.ungs.agenda.mapper.ModelMapper;
import com.ungs.agenda.model.TipoContacto;
import com.ungs.agenda.repository.TipoContactoRepository;
import com.ungs.agenda.service.ITipoContactoService;

@Service
public class TipoContactoServiceImpl implements ITipoContactoService {
	
	@Autowired
	private TipoContactoRepository tipoContactoRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<TipoContactoDTO> getAll() {
		List<TipoContacto> tiposContacto = tipoContactoRepo.findAll();
		return mapper.toTiposContactoDTO(tiposContacto);
	}
}
