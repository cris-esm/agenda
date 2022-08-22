package com.ungs.agenda.repository;

import org.springframework.stereotype.Repository;

import com.ungs.agenda.model.Persona;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
	
}
