package com.ungs.agenda.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nombre;
	
	
	@Column
	private String telefono;
	
	@Column
	private String email;
	
	@Column(name="fechanac")
	private LocalDate fechaNac;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "iddomicilio", referencedColumnName = "id")
	private Domicilio domicilio;
}
