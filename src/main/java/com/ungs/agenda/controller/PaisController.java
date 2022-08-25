package com.ungs.agenda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ungs.agenda.dto.PaisDTO;
import com.ungs.agenda.service.IPaisService;

@RestController
@RequestMapping("/api/paises")
public class PaisController {
	
	@Autowired
	private IPaisService paisService;
	
	@GetMapping
	public List<PaisDTO> obtenerPaises(){
		
		return paisService.getAll();
	}

}
