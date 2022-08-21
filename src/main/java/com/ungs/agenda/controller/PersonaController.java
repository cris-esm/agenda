package com.ungs.agenda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ungs.agenda.departamento.PersonaDTO;
import com.ungs.agenda.model.Persona;
import com.ungs.agenda.repository.PersonaRepository;

@Controller
@RequestMapping("/")
public class PersonaController {
	@Autowired
	private PersonaRepository personaRepository;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		
		model.addAttribute("list", personaRepository.findAll());
		return "index";
	}
	
	@RequestMapping("/agregar")
	public String agregar(Model model) {
		
		//model.addAttribute("list", personaRepository.findAll());
		return "agregar";
	}
	
	
	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable("id") long id,Model model) {
		Integer i = (int) (long) id;
		Optional<Persona> persona = personaRepository.findById(i);
		PersonaDTO personaModelo = TransformDtoPersona(persona);
		model.addAttribute("persona", personaModelo);
		return "editar";
	}
	
	private PersonaDTO TransformDtoPersona(Optional<Persona> persona) {
		PersonaDTO personaDto = new PersonaDTO();
		
		personaDto.setEmail(persona.get().getEmail());
		personaDto.setNombre(persona.get().getNombre().toUpperCase());
		personaDto.setTelefono(persona.get().getTelefono());
		personaDto.setFechaNac(persona.get().getFechaNac());
		personaDto.setFechaNac(persona.get().getFechaNac());

		return personaDto;
	}

	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") long id,Model model) {
		Integer i = (int) (long) id;
		Optional<Persona> persona = personaRepository.findById(i);
		PersonaDTO personaModelo = TransformDtoPersona(persona);
		model.addAttribute("persona", personaModelo);
		return "eliminar";
	}
	
	@RequestMapping("/eliminar/confirmacion/{id}")
	public String confirmacionEliminar(Model model) {
		
		//personaRepository.deleteById(model.)
		return "index";
	}
}
