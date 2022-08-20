package com.ungs.agenda.model;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name="localidad")
public class Localidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name="idprovincia")
	private Provincia provincia;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "localidad", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Domicilio> domicilios;
}
