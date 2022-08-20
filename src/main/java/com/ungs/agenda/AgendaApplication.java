package com.ungs.agenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ungs.agenda.repository.PersonaRepository;

@SpringBootApplication
public class AgendaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}
	
	@Autowired
	private PersonaRepository personaRepo;

	@Override
	public void run(String... args) throws Exception {
		personaRepo.findAll().forEach(persona -> System.out.println(persona));
		
	}

}
