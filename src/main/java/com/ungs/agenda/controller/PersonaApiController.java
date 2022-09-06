package com.ungs.agenda.controller;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ungs.agenda.dto.PersonaDTO;
import com.ungs.agenda.service.IPersonaService;
import java.util.regex.*;
import java.util.*;

@RestController
@RequestMapping("/api/Persona")
public class PersonaApiController {

	@Autowired
	private IPersonaService personaService;

	@PostMapping("/save")
	public void savePersona(@RequestBody PersonaDTO persona) {
		Boolean mailValido = persona.getEmail() != null && persona.getEmail().length() > 0
				? mailValido(persona.getEmail())
				: false;

		Boolean telefonoValido = persona.getTelefono() != null && persona.getTelefono().length() > 0
				? telefonoValido(persona.getTelefono())
				: false;

		if (persona.getNombre() != null && persona.getNombre().length() > 2 && telefonoValido 
				&& mailValido && persona.getDomicilio() != null && persona.getDomicilio().getCalle() != null && 
				persona.getDomicilio().getCalle().length() > 3 && persona.getDomicilio().getAltura() != null &&
				persona.getDomicilio().getLocalidad() != null && persona.getFechaNac() != null &&
				persona.getSignoZodiaco() != null && persona.getTecnologia() != null 
				&& persona.getTipoContacto() != null && persona.getDomicilio().getPiso() != null &&
				persona.getDomicilio().getPiso().length() > 0 && persona.getDomicilio().getAltura() > 0) {

			personaService.saveOrUpdate(persona);

		}

		/*
		 * if (persona.getSignoZodiaco().getId() == null) persona.setSignoZodiaco(null);
		 * if (persona.getTipoContacto().getId() == null) persona.setTipoContacto(null);
		 * if (persona.getTecnologia().getId() == null) persona.setTecnologia(null); if
		 * (persona.getDomicilio().getLocalidad().getId() == null)
		 */

	}

	public Boolean mailValido(String email) {
		String regx = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public Boolean telefonoValido(String telefono) {
		Pattern pattern = Pattern.compile("^\\d{10}$");
		Matcher matcher = pattern.matcher(telefono);
		return matcher.matches();
	}

	@PostMapping("/update")
	public void updatePersona(@RequestBody PersonaDTO persona) {

		Boolean mailValido = persona.getEmail() != null && persona.getEmail().length() > 0
				? mailValido(persona.getEmail())
				: false;

		Boolean telefonoValido = persona.getTelefono() != null && persona.getTelefono().length() > 0
				? telefonoValido(persona.getTelefono())
				: false;

		if (persona.getNombre() != null && persona.getNombre().length() > 2 && telefonoValido 
				&& mailValido && persona.getDomicilio() != null && persona.getDomicilio().getCalle() != null && 
				persona.getDomicilio().getCalle().length() > 3 && persona.getDomicilio().getAltura() != null &&
				persona.getDomicilio().getLocalidad() != null && persona.getFechaNac() != null &&
				persona.getSignoZodiaco() != null && persona.getTecnologia() != null 
				&& persona.getTipoContacto() != null && persona.getDomicilio().getPiso() != null &&
				persona.getDomicilio().getPiso().length() > 0 && persona.getDomicilio().getAltura() > 0) {

			personaService.saveOrUpdate(persona);

		}
	}

}
