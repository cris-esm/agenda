package com.ungs.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ungs.agenda.repository.PersonaRepository;
import com.ungs.agenda.service.IPersonaService;

@Controller
@RequestMapping("/")
public class PersonaController {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private IPersonaService personaService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", personaService.getAll());
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
