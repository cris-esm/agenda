package com.ungs.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ungs.agenda.model.Persona;
import com.ungs.agenda.repository.DomicilioRepository;
import com.ungs.agenda.repository.PersonaRepository;
import com.ungs.agenda.service.IPersonaService;

@SpringBootApplication
public class AgendaApplication implements CommandLineRunner {
	
	@Autowired
	IPersonaService personaService;
	
	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}
	
	@Autowired
	private PersonaRepository personaRepo;
	
	@Autowired
	private DomicilioRepository domicilioRepo;

	@Override
	public void run(String... args) throws Exception {
		//personaRepo.findAll().forEach(persona -> System.out.println(persona));
		System.out.println(personaRepo.findAll());
		domicilioRepo.findAll().forEach(domicilio -> System.out.println(domicilio));
	}

}
