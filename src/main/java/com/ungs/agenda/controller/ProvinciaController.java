package com.ungs.agenda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ungs.agenda.departamento.PaisDTO;
import com.ungs.agenda.departamento.ProvinciaDTO;

@RestController
@RequestMapping("/api/Provincias")
public class ProvinciaController {

	/*
	 * @Autowired private IPaisService paisService;
	 */

	@GetMapping
	public List<ProvinciaDTO> obtenerProvincias() {

		List<ProvinciaDTO> provincias = new ArrayList<ProvinciaDTO>();

		long uno = 1;
		ProvinciaDTO primero = new ProvinciaDTO();
		primero.setId(uno);
		primero.setNombre("buenos aires");

		long dos = 2;
		ProvinciaDTO segundo = new ProvinciaDTO();
		segundo.setId(dos);
		segundo.setNombre("cordoba");

		provincias.add(primero);
		provincias.add(segundo);

		return provincias;
	}

	@GetMapping("/{id}")
	public List<ProvinciaDTO> obtenerProvinciasPorId(@PathVariable Long id) {

		List<ProvinciaDTO> provincias = new ArrayList<ProvinciaDTO>();

		long uno = 1;
		ProvinciaDTO primero = new ProvinciaDTO();
		primero.setId(uno);
		primero.setNombre("buenos aires");

		long dos = 2;
		ProvinciaDTO segundo = new ProvinciaDTO();
		segundo.setId(dos);
		segundo.setNombre("cordoba");

		provincias.add(primero);
		provincias.add(segundo);

		if (id == 1) {

			provincias.remove(0);
		} if (id == 2) {
			provincias.remove(1);

		}

		return provincias;
	}

}
