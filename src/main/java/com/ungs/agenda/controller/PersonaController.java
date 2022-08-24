package com.ungs.agenda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ungs.agenda.departamento.PersonaDTO;
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
		model.addAttribute("provincias", provinciaService.getProvincias());
		model.addAttribute("localidades", localidadService.getLocalidades());
		model.addAttribute("tiposContacto", tipoContactoService.getAll());


		return "agregar";
	}
	
	@PostMapping("/adduser")
    public String addUser( @ModelAttribute("Persona") Persona persona, Model model) {
        
		if (true) {
			
		}
        
        
        return "redirect:/index";
    }
	
	

	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id,Model model) {
		Persona persona = personaService.getById(id);
		//PersonaDTO personaModelo = TransformDtoPersona(persona);
		model.addAttribute("persona", persona);

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
	public String eliminar(@PathVariable("id") Long id,Model model) {
		//Integer i = (int) (long) id;
		Persona persona = personaService.getById(id);
		//PersonaDTO personaModelo = TransformDtoPersona(persona);
		model.addAttribute("persona", persona);
		return "eliminar";
	}
	
	@RequestMapping("/eliminar/confirmacion/{id}")
	public String confirmacionEliminar(Model model) {
		
		//personaRepository.deleteById(model.)
		return "index";
	}
	
	@RequestMapping("/prueba")
	public String prueba(Model model) {
		
		/*model.addAttribute("personas", personaService.getAll());
		model.addAttribute("paises",paisService.getAll());
		model.addAttribute("provincias", provinciaService.getProvincias());
		model.addAttribute("localidades", localidadService.getLocalidades());
		model.addAttribute("tiposContacto", tipoContactoService.getAll());*/
		model.addAttribute("paises",paisService.getAll());
		model.addAttribute("provincias", provinciaService.getProvincias());

		return "prueba";
	}
	
	   @RequestMapping(value={"/sendPais"},method = RequestMethod.POST)
	    public String messageCenterHome(Model model) {

	     //   String selectedCity= request.getParameter("nameOfCity");
		   model.addAttribute("personaje","personaje");
		   
	        return "prueba"; 
	    }
	
	
	
	
}
