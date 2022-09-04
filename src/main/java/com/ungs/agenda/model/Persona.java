package com.ungs.agenda.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
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
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String telefono;
	
	@Column
	private String email;
	
	@Column(name="fechanac")
	private LocalDate fechaNac;
	
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "iddomicilio", referencedColumnName = "id")
	private Domicilio domicilio;

    @ManyToOne
    @JoinColumn(name="idtipocontacto")
	private TipoContacto tipoContacto;

    @ManyToOne
    @JoinColumn(name="idsignozodiaco")
	private SignoZodiaco signoZodiaco;
    
    @ManyToOne
    @JoinColumn(name="idtecnologia")
	private Tecnologia tecnologia;

}
