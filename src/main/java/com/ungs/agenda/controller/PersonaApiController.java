package com.ungs.agenda.controller;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ungs.agenda.dto.PersonaDTO;
import com.ungs.agenda.service.IPersonaService;

@RestController
@RequestMapping("/api/Persona")
public class PersonaApiController {
	
	@Autowired
	private IPersonaService personaService;

	 @PostMapping("/save")
	 public String savePersona(@RequestBody PersonaDTO persona) {
		 
		 Boolean mailValido = persona.getEmail() != null && persona.getEmail().length() > 0
					? mailValido(persona.getEmail())
					: false;

		Boolean telefonoValido = persona.getTelefono() != null && persona.getTelefono().length() >= 8
				? telefonoValido(persona.getTelefono())
				: false;

		Boolean nombreValido = persona.getNombre() != null && persona.getNombre().length() > 2 ?
				true : false ;
		
		Boolean alturaValida = persona.getDomicilio().getAltura() != null && persona.getDomicilio().getAltura() > 0 ?
				isNumeric(persona.getDomicilio().getAltura().toString()) : false ;
		
		List<PersonaDTO> personas = personaService.getAll();
		Boolean existe = false;
		existe = personas.contains(persona);
		if (nombreValido && mailValido && telefonoValido) {
			for (PersonaDTO person : personas) {
				if(person.getEmail().equals(persona.getEmail()) ||
					person.getTelefono().toString().equals(persona.getTelefono().toString())) {
					existe = true;
				}
			}
		}
		
		if (nombreValido && telefonoValido && mailValido && persona.getDomicilio() != null && !existe &&
				persona.getDomicilio().getCalle() != null && alturaValida &&
				persona.getDomicilio().getCalle().length() > 3 && persona.getDomicilio().getAltura() != null &&
				persona.getDomicilio().getLocalidad() != null && persona.getFechaNac() != null &&
				persona.getSignoZodiaco() != null && persona.getTecnologia() != null 
				&& persona.getTipoContacto() != null && persona.getDomicilio().getPiso() != null &&
				persona.getDomicilio().getPiso().length() > 0 && persona.getDomicilio().getAltura() > 0) {

			personaService.saveOrUpdate(persona);
			return "redirect:/";

		}

		/*
		 * if (persona.getSignoZodiaco().getId() == null) persona.setSignoZodiaco(null);
		 * if (persona.getTipoContacto().getId() == null) persona.setTipoContacto(null);
		 * if (persona.getTecnologia().getId() == null) persona.setTecnologia(null); if
		 * (persona.getDomicilio().getLocalidad().getId() == null)
		 */
		return "/agregar";
	}

	public Boolean mailValido(String email) {
		String regx = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public Boolean telefonoValido(String telefono) {
		String expression = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{2,8}$"; 
	    return telefono.matches(expression);     
	}
	
	public static boolean isFullname(String str) {
	    String expression = "^[a-zA-Z\\s]+"; 
	    return str.matches(expression);        
	}
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}

	@PostMapping("/update")
	public String updatePersona(@RequestBody PersonaDTO persona) {
		
		Boolean mailValido = persona.getEmail() != null && persona.getEmail().length() > 0
				? mailValido(persona.getEmail())
				: false;

		Boolean telefonoValido = persona.getTelefono() != null && persona.getTelefono().length() >= 8
				? telefonoValido(persona.getTelefono())
				: false;

		Boolean nombreValido = persona.getNombre() != null && persona.getNombre().length() > 2 ?
				true : false ;
		
		Boolean alturaValida = persona.getDomicilio().getAltura() != null && persona.getDomicilio().getAltura() > 0 ?
				isNumeric(persona.getDomicilio().getAltura().toString()) : false ;
		
		List<PersonaDTO> personas = personaService.getAll();
		Boolean existe = false;
		existe = personas.contains(persona);
		if (nombreValido && mailValido && telefonoValido) {
			for (PersonaDTO person : personas) {
				if(person.getEmail().equals(persona.getEmail()) ||
					person.getTelefono().toString().equals(persona.getTelefono().toString())) {
					existe = true;
				}
			}
		}

		if (nombreValido && telefonoValido && !existe
				&& mailValido && persona.getDomicilio() != null && persona.getDomicilio().getCalle() != null && 
				alturaValida && persona.getDomicilio().getCalle().length() > 3 && persona.getDomicilio().
				getAltura() != null && persona.getDomicilio().getLocalidad() != null && persona.getFechaNac() != null &&
				persona.getSignoZodiaco() != null && persona.getTecnologia() != null 
				&& persona.getTipoContacto() != null && persona.getDomicilio().getPiso() != null &&
				persona.getDomicilio().getPiso().length() > 0 && persona.getDomicilio().getAltura() > 0) {

			personaService.saveOrUpdate(persona);
			return "redirect:/";

		}
		return "/editar/" + persona.getId() ;
	}


}
