package com.ungs.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ungs.agenda.dto.PersonaDTO;
import com.ungs.agenda.service.IPaisService;
import com.ungs.agenda.service.IPersonaService;
import com.ungs.agenda.service.ISignoZodiacoService;
import com.ungs.agenda.service.ITecnologiaService;
import com.ungs.agenda.service.ITipoContactoService;


@Controller
@RequestMapping("/")
public class PersonaController {

	@Autowired
	private IPersonaService personaService;

	@Autowired
	private IPaisService paisService;

	@Autowired
	private ITipoContactoService tipoContactoService;
	
	@Autowired
	private ITecnologiaService tecnologiaService;
	
	@Autowired
	private ISignoZodiacoService signoZodiacoService;


	@RequestMapping("/")
	public String index(Model model)  {
		return getPaginated(1, model);
	}
	
	@RequestMapping("/agregar")
	public String agregar(Model model) {

		model.addAttribute("personas", personaService.getAll());
		model.addAttribute("paises", paisService.getAll());
		model.addAttribute("tiposContacto", tipoContactoService.getAll());
		model.addAttribute("tecnologias", tecnologiaService.getAll());
		model.addAttribute("signos", signoZodiacoService.getAll());

		return "agregar";
	}

	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {

		PersonaDTO persona = personaService.getById(id);
		paisService.getProvincias(id);
		//provinciaService.getById(id)
	//	persona.getDomicilio().getLocalidad().get
		model.addAttribute("paises", paisService.getAll());
		model.addAttribute("tiposContacto", tipoContactoService.getAll());
		model.addAttribute("tecnologias", tecnologiaService.getAll());
		model.addAttribute("signos", signoZodiacoService.getAll());
		model.addAttribute("persona", persona);

		return "editar";
	}

	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id, Model model) {

		model.addAttribute("persona", personaService.getById(id));
		return "eliminar";
	}

	@RequestMapping("/eliminar/confirmacion/{id}")
	public String confirmacionEliminar(@PathVariable("id") Long id, Model model) {
		
		PersonaDTO persona = personaService.getById(id);
		personaService.delete(persona);

		return "redirect:/";
	}
	
	@RequestMapping("/actualizar/{id}")
	public String actualizar(@PathVariable("id") Long id, Model model) {
		return "/editar/{" + id + "}";
	}

	@RequestMapping(value = { "/sendPais" }, method = RequestMethod.POST)
	public String messageCenterHome(Model model) {
		
		// String selectedCity= request.getParameter("nameOfCity");
		model.addAttribute("personaje", "personaje");

		return "prueba";
	}
	
	@RequestMapping("/Reportes")
	public String reportes(Model model)  {
		
		return "Reportes";
	}
	
	@GetMapping("/page/{pageNumber}")
	public String getPaginated(@PathVariable (value = "pageNumber") Integer pageNumber, Model model) {
		Integer pageSize = 4;
		Page<PersonaDTO> pagina = personaService.getPaginated(pageNumber, pageSize);
		List<PersonaDTO> listaPersonasDTO = pagina.getContent();
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("totalPages", pagina.getTotalPages());
		model.addAttribute("totalItems", pagina.getTotalElements());
		model.addAttribute("listPersonas", listaPersonasDTO);
		return "index";
	}
	


}
