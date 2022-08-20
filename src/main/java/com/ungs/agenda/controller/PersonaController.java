package com.ungs.agenda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
		model.addAttribute("list", personaRepository.findAll());
		return "agregar";
	}
	
	
	@RequestMapping("/editar")
	public String editar(Model model) {
		
		model.addAttribute("list", personaRepository.findAll());
		return "editar";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(Model model) {
		
		//model.addAttribute("list", personaRepository.findAll());
		return "eliminar";
	}
	
	@RequestMapping("/eliminar/confirmacion/{id}")
	public String confirmacionEliminar(Model model) {
		
		//personaRepository.deleteById(model.)
		return "index";
	}
}
