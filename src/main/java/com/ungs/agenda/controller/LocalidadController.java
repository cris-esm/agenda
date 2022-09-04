package com.ungs.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ungs.agenda.dto.LocalidadDTO;
import com.ungs.agenda.service.IProvinciaService;


@RestController
@RequestMapping("/api/Localidades")
public class LocalidadController {

	
	@Autowired 
	private IProvinciaService provinciService;

	@GetMapping("/{id}")
	public List<LocalidadDTO> obtenerLocalidadesId(@PathVariable Long id) {

		return provinciService.getLocalidades(id);
	}
	
}
