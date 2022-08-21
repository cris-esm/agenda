package com.ungs.agenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ungs.agenda.model.Persona;
import com.ungs.agenda.model.Provincia;
import com.ungs.agenda.repository.DomicilioRepository;
import com.ungs.agenda.repository.LocalidadRepository;
import com.ungs.agenda.repository.PaisRepository;
import com.ungs.agenda.repository.PersonaRepository;
import com.ungs.agenda.repository.ProvinciaRepository;
import com.ungs.agenda.service.IDomicilioService;
import com.ungs.agenda.service.IPaisService;
import com.ungs.agenda.service.IPersonaService;

@SpringBootApplication
public class AgendaApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}
	
	@Autowired
	private PersonaRepository personaRepo;
	
	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private IDomicilioService domicilioService;
	
	@Autowired 
	private ProvinciaRepository provinciaRepo;
	
	@Autowired
	private LocalidadRepository localidadRepo;
	
	@Autowired
	private PaisRepository paisRepo;
	
	@Autowired
	private IPaisService paisService;
	@Override
	public void run(String... args) throws Exception {
		//personaRepo.findAll().forEach(persona -> System.out.println(persona));
		//System.out.println(personaRepo.findAll());
		//System.out.println(personaService.getAll().get(0));
		//System.out.println(personaRepo.findAll().get(0).getTipoContacto());
		//System.out.println(paisService.getAll());
		//System.out.println(paisRepo.findById(1L));
		List<Provincia> provincias = paisService.getProvincias(1L);
		//paisService.getProvincias(1L).forEach(pais -> System.out.println(pais));
		//localidadRepo.findAll().forEach(loc -> System.out.println(loc));
		//provinciaRepo.findAll().forEach(prov -> System.out.println(prov));
		
		
	}

}
