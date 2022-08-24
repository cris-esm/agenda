package com.ungs.agenda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ungs.agenda.departamento.PaisDTO;

@RestController
@RequestMapping("/api/paises")
public class PaisController {
	
	/*@Autowired
	private IPaisService paisService;*/
	
	@GetMapping
	public List<PaisDTO> obtenerPaises(){
		
		List<PaisDTO> paises = new ArrayList<PaisDTO>();
		
		long uno = 1;
		PaisDTO primero = new PaisDTO();
		primero.setId(uno);
		primero.setNombre("Argentina");
		
		long dos = 2;
		PaisDTO segundo = new PaisDTO();
		segundo.setId(dos);
		segundo.setNombre("Brasil");
		
		paises.add(primero);
		paises.add(segundo);
		
		return paises;
	}

}
