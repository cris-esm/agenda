package com.ungs.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ungs.agenda.model.SignoZodiaco;

@Repository
public interface SignoZodiacoRepository extends JpaRepository<SignoZodiaco, Long> {

}
