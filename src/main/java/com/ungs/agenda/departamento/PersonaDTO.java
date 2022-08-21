package com.ungs.agenda.departamento;

import java.time.LocalDate;
import com.ungs.agenda.model.Domicilio;
import com.ungs.agenda.model.TipoContacto;



public class PersonaDTO {
	
	
	private Integer id;
	

	private String nombre;
	
	
	
	private String telefono;
	

	private String email;
	
	
	private LocalDate fechaNac;
	
	
	private Domicilio domicilio;

	private TipoContacto tipoContacto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public TipoContacto getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}
	
	

}
