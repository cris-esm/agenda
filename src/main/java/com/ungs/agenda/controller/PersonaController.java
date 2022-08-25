package com.ungs.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ungs.agenda.dto.PersonaDTO;
import com.ungs.agenda.model.Persona;
import com.ungs.agenda.service.ILocalidadService;
import com.ungs.agenda.service.IPaisService;
import com.ungs.agenda.service.IPersonaService;
import com.ungs.agenda.service.IProvinciaService;
import com.ungs.agenda.service.ITipoContactoService;

@Controller
@RequestMapping("/")
public class PersonaController {
	
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private IPaisService paisService;
	
	@Autowired
	private IProvinciaService provinciaService;
	
	@Autowired
	private ILocalidadService localidadService;
	
	@Autowired
	private ITipoContactoService tipoContactoService;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("personas", personaService.getAll());
		return "index";
	}
	
	@RequestMapping("/agregar")
	public String agregar(Model model) {
		
		model.addAttribute("personas", personaService.getAll());
		model.addAttribute("paises",paisService.getAll());
		model.addAttribute("localidades", localidadService.getLocalidades());
		model.addAttribute("tiposContacto", tipoContactoService.getAll());


		return "agregar";
	}
	
	@RequestMapping("/adduser")
    public String addUser( @ModelAttribute("Persona") PersonaDTO persona, Model model) {
        
	System.out.println(persona);
	System.out.println(model);

		personaService.saveOrUpdate(persona);
        
        return "redirect:/";
    }
	
	

	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id,Model model) {
	
		model.addAttribute("persona", personaService.getById(id));

		return "editar";
	}
	
	

	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id,Model model) {
		
	
		model.addAttribute("persona", personaService.getById(id));
		return "eliminar";
	}
	
	@RequestMapping("/eliminar/confirmacion/{id}")
	public String confirmacionEliminar(Model model) {
		
		//personaRepository.deleteById(personaService.getById(model.g))
		return "index";
	}
	
	@RequestMapping("/prueba")
	public String prueba(Model model) {
	

		return "prueba";
	}
	
	   @RequestMapping(value={"/sendPais"},method = RequestMethod.POST)
	    public String messageCenterHome(Model model) {

	     //   String selectedCity= request.getParameter("nameOfCity");
		   model.addAttribute("personaje","personaje");
		   
	        return "prueba"; 
	    }
	
	
	
	
}
