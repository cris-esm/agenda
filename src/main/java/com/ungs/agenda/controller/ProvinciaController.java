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
import com.ungs.agenda.dto.ProvinciaDTO;
import com.ungs.agenda.service.ILocalidadService;
import com.ungs.agenda.service.IPaisService;
import com.ungs.agenda.service.IProvinciaService;

@RestController
@RequestMapping("/api/Provincias")
public class ProvinciaController {

	@Autowired
	private IPaisService paisService;
	
	@Autowired
	private IProvinciaService provinciaService;
	
	@Autowired 
	private ILocalidadService localidadService;


	@GetMapping("/{id}")
	public List<ProvinciaDTO> obtenerProvinciasPorId(@PathVariable Long id) {
		return paisService.getProvincias(id);
	}
	
	@GetMapping("/getByLocalidad/{id}")
	public ProvinciaDTO getProvinciaByLocalidad(@PathVariable Long id) {

		return localidadService.getProvinciaByLocalidad(id);
	}
	
	
	@PostMapping("/save/{id}")
	public void saveProvincia(@RequestBody ProvinciaDTO provincia, @PathVariable(value = "id")  String id) {
		if (provincia == null || provincia.getNombre() == null || provincia.getNombre().isEmpty()) {return;}
		long idLong = Long.parseLong(id);
		List<ProvinciaDTO> provincias = paisService.getProvincias(idLong);
		boolean pertenece = false;
		for (ProvinciaDTO elementoProvincia : provincias) {
			if (elementoProvincia.getNombre().equals(provincia.getNombre())) {pertenece = true;}
		}
		pertenece = pertenece ? true : guardarProvincia(provincia, idLong);
	}

	public boolean guardarProvincia(ProvinciaDTO provincia, long id) {
		PaisDTO pais = paisService.getPaisById(id);
		provincia.setPais(pais);
		provinciaService.save(provincia);
		return false;
	}

}
