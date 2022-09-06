package com.ungs.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ungs.agenda.dto.PaisDTO;
import com.ungs.agenda.dto.PersonaDTO;
import com.ungs.agenda.model.Pais;
import com.ungs.agenda.service.IPaisService;
import com.ungs.agenda.service.IProvinciaService;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

	@Autowired
	private IPaisService paisService;

	@Autowired
	private IProvinciaService provinciaService;

	@GetMapping
	public List<PaisDTO> obtenerPaises() {

		return paisService.getAll();
	}

	@GetMapping("/{id}")
	public PaisDTO getPaisByProvincia(@PathVariable Long id) {

		return provinciaService.getPaisByProvincia(id);
	}

	@PostMapping("/save")
	public void savePais(@RequestBody PaisDTO pais) {
		if (pais == null || pais.getNombre() == null || pais.getNombre().isEmpty()) {return;}
		List<PaisDTO> paises = paisService.getAll();
		boolean pertenece = false;
		for (PaisDTO elementoPais : paises) {
			if (elementoPais.getNombre().equals(pais.getNombre())) {pertenece = true;}
		}
		pertenece = pertenece ? true : guardarPais(pais);
	}

	public boolean guardarPais(PaisDTO pais) {
		paisService.addPais(pais);
		return false;
	}

}
