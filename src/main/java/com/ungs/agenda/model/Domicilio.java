package com.ungs.agenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="domicilio")
public class Domicilio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String calle;
	
	@Column
	private Integer altura;
	
	@Column
	private String piso;
	
	@Column
	private String departamento;
	
	@OneToOne(mappedBy = "domicilio")
	private Persona persona;
	
    @ManyToOne
    @JoinColumn(name="idlocalidad")
	private Localidad localidad;
}
