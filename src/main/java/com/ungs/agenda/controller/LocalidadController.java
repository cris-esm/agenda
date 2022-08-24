package com.ungs.agenda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ungs.agenda.departamento.LocalidadDTO;
import com.ungs.agenda.departamento.PaisDTO;
import com.ungs.agenda.departamento.ProvinciaDTO;

@RestController
@RequestMapping("/api/Localidades")
public class LocalidadController {

	/*
	 * @Autowired private IPaisService paisService;
	 */

	@GetMapping
	public List<LocalidadDTO> obtenerLocalidades() {

		List<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();

		long uno = 1;
		LocalidadDTO primero = new LocalidadDTO();
		primero.setId(uno);
		primero.setNombre("burzaco");

		long dos = 2;
		LocalidadDTO segundo = new LocalidadDTO();
		segundo.setId(dos);
		segundo.setNombre("San Miguel");

		localidades.add(primero);
		localidades.add(segundo);

		return localidades;
	}

	@GetMapping("/{id}")
	public List<LocalidadDTO> obtenerLocalidadesId(@PathVariable Long id) {

		List<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();

		long uno = 1;
		LocalidadDTO primero = new LocalidadDTO();
		primero.setId(uno);
		primero.setNombre("burzaco");

		long dos = 2;
		LocalidadDTO segundo = new LocalidadDTO();
		segundo.setId(dos);
		segundo.setNombre("San Miguel");

		localidades.add(primero);
		localidades.add(segundo);

		if (id == 1) {

			localidades.remove(0);
		} if (id == 2) {
			localidades.remove(1);

		}

		return localidades;
	}

}
