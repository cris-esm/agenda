package com.ungs.agenda.dao;

import org.springframework.data.repository.CrudRepository;

import com.ungs.agenda.model.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long> {

}
