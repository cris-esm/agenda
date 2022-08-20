package com.ungs.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ungs.agenda.model.Persona;
import com.ungs.agenda.repository.DomicilioRepository;
import com.ungs.agenda.repository.LocalidadRepository;
import com.ungs.agenda.repository.PersonaRepository;
import com.ungs.agenda.repository.ProvinciaRepository;
import com.ungs.agenda.service.IPersonaService;

@SpringBootApplication
public class AgendaApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}
	
	@Autowired
	private PersonaRepository personaRepo;
	
	@Autowired
	private DomicilioRepository domicilioRepo;
	
	@Autowired 
	private ProvinciaRepository provinciaRepo;
	
	@Autowired
	private LocalidadRepository localidadRepo;
	@Override
	public void run(String... args) throws Exception {
		//personaRepo.findAll().forEach(persona -> System.out.println(persona));
		//System.out.println(personaRepo.findAll());
		//domicilioRepo.findAll().forEach(domicilio -> System.out.println(domicilio));
		System.out.println(personaRepo.findAll().get(0).getTipoContacto());
		//localidadRepo.findAll().forEach(loc -> System.out.println(loc));
		//provinciaRepo.findAll().forEach(prov -> System.out.println(prov));
	}

}
