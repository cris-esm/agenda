package com.ungs.agenda.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

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
import com.ungs.agenda.service.ISignoZodiacoService;
import com.ungs.agenda.service.ITecnologiaService;
import com.ungs.agenda.service.ITipoContactoService;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


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
		model.addAttribute("personas", personaService.getAll());
		
		

		return "index";
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

	@PostMapping("/adduser")
	public String addUser(@ModelAttribute("Persona") PersonaDTO persona, Model model) {

		System.out.println(persona);
		System.out.println(model);

		//personaService.saveOrUpdate(persona);

		return "redirect:/";
	}

	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {

		model.addAttribute("persona", personaService.getById(id));

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

		return "index";
	}
	
	@RequestMapping("/actualizar/{id}")
	public String actualizar(@PathVariable("id") Long id, Model model) {
		
		//PersonaDTO persona = personaService.getById(id);
		//persona.setDomicilio(model.)
		//personaService.saveOrUpdate(persona);

		return "/editar/{" + id + "}";
	}

	@RequestMapping("/prueba")
	public String prueba(Model model) throws SQLException, JRException {
		
		return "prueba";
	}

	@RequestMapping(value = { "/sendPais" }, method = RequestMethod.POST)
	public String messageCenterHome(Model model) {

		// String selectedCity= request.getParameter("nameOfCity");
		model.addAttribute("personaje", "personaje");
		
		

		return "prueba";
	}
	
	
	@RequestMapping("/report/ventas/download?tipo=PDF")
	public String reporte(Model model) throws SQLException, JRException {
		
		return "report/ventas/download?tipo=PDF";
	}
	
	
	
	public  void mostrarReporteTecnologiaAscendente() throws SQLException, JRException {
		// TODO Auto-generated method stub
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agenda", "postgres", "prueba");
		String sql = "select  count(idtecnologia)*100/(select count(*) from persona) as resultado, tecnologia.nombre\r\n"
				+ "from persona, tecnologia where persona.idtecnologia = tecnologia.id group by tecnologia.nombre order by\r\n"
				+ "tecnologia.nombre asc";
		JasperDesign jdesign = JRXmlLoader.load("src\\main\\java\\com\\ungs\\agenda\\reportes\\TecnologiaAscendente.jrxml");
		JRDesignQuery update = new JRDesignQuery();
		update.setText(sql);
		jdesign.setQuery(update);
		JasperReport jreport = JasperCompileManager.compileReport(jdesign);
		JasperPrint print = JasperFillManager.fillReport(jreport, null, con);
		JasperViewer.viewReport(print, false);

	}


}
