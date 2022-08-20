package com.ungs.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ungs.agenda.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

}
