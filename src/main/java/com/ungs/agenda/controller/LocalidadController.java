package com.ungs.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ungs.agenda.dto.LocalidadDTO;
import com.ungs.agenda.dto.PaisDTO;
import com.ungs.agenda.dto.ProvinciaDTO;
import com.ungs.agenda.service.ILocalidadService;
import com.ungs.agenda.service.IProvinciaService;


@RestController
@RequestMapping("/api/Localidades")
public class LocalidadController {

	
	@Autowired 
	private IProvinciaService provinciService;
	
	@Autowired 
	private ILocalidadService localidadService;

	@GetMapping("/{id}")
	public List<LocalidadDTO> obtenerLocalidadesId(@PathVariable Long id) {

		return provinciService.getLocalidades(id);
	}
	
	@PostMapping("/save/{id}")
	public void saveProvincia(@RequestBody LocalidadDTO localidad, @PathVariable(value = "id")  String id) {
		if (localidad == null || localidad.getNombre() == null || localidad.getNombre().isEmpty()) {return;}
		long idLong = Long.parseLong(id);
		List<LocalidadDTO> localidades = provinciService.getLocalidades(idLong);
		boolean pertenece = false;
		for (LocalidadDTO elementolocalidades : localidades) {
			if (elementolocalidades.getNombre().equals(localidad.getNombre())) {pertenece = true;}
		}
		pertenece = pertenece ? true : guardarLocalidad(localidad, idLong);
	}

	public boolean guardarLocalidad(LocalidadDTO localidad, long id) {
		ProvinciaDTO provincia = provinciService.getById(id);
		localidadService.save(localidad,provincia);
		return false;
	}
	
}
