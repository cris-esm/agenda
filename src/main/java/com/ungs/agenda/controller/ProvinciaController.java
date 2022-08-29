package com.ungs.agenda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ungs.agenda.dto.PaisDTO;
import com.ungs.agenda.dto.ProvinciaDTO;
import com.ungs.agenda.repository.ProvinciaRepository;
import com.ungs.agenda.service.ILocalidadService;
import com.ungs.agenda.service.IPaisService;

@RestController
@RequestMapping("/api/Provincias")
public class ProvinciaController {

	@Autowired
	private IPaisService paisService;
	
	@Autowired
	private ProvinciaRepository provinciaRepo;
	
	 @Autowired private ILocalidadService localidadService;


	@GetMapping("/{id}")
	public List<ProvinciaDTO> obtenerProvinciasPorId(@PathVariable Long id) {
		return paisService.getProvincias(id);
	}
	
	@GetMapping("/getByLocalidad/{id}")
	public ProvinciaDTO getProvinciaByLocalidad(@PathVariable Long id) {

		return localidadService.getProvinciaByLocalidad(id);
	}

}
