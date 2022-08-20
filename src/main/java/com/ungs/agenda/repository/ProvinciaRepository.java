package com.ungs.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ungs.agenda.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

}
