package com.ungs.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ungs.agenda.model.Localidad;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Long> {

}
