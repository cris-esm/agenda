package com.ungs.agenda.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.ungs.agenda.dto.DomicilioDTO;
import com.ungs.agenda.dto.LocalidadDTO;
import com.ungs.agenda.dto.PaisDTO;
import com.ungs.agenda.dto.PersonaDTO;
import com.ungs.agenda.dto.ProvinciaDTO;
import com.ungs.agenda.dto.TipoContactoDTO;
import com.ungs.agenda.model.Domicilio;
import com.ungs.agenda.model.Localidad;
import com.ungs.agenda.model.Pais;
import com.ungs.agenda.model.Persona;
import com.ungs.agenda.model.Provincia;
import com.ungs.agenda.model.TipoContacto;

@Mapper(componentModel = "spring")
public interface ModelMapper {
	
	public PersonaDTO toPersonaDTO(Persona persona);
	
	public List<PersonaDTO> toPersonasDTO(List<Persona> persona);
	
	public Persona toPersona(PersonaDTO personaDTO);
	
	public DomicilioDTO toDomicilioDTO(Domicilio domicilio);
	
	@Mapping(target="persona", ignore=true)
	public Domicilio toDomicilio(DomicilioDTO domicilioDTO);
	
	public PaisDTO toPaisDTO(Pais pais);
	
	public ProvinciaDTO toProvinciaDTO(Provincia provincia);
	
	@Mapping(target="pais", ignore=true)
	public Provincia toProvincia(ProvinciaDTO provinciaDTO);
	
	public LocalidadDTO toLocalidadDTO(Localidad localidad);
	
	@Mappings({
		@Mapping(target="domicilios", ignore=true),
		@Mapping(target="provincia", ignore=true)
	})
	public Localidad toLocalidad(LocalidadDTO localidadDTO);
	
	public TipoContactoDTO toTipoContactoDTO(TipoContacto tipoContacto);
	
	@Mapping(target="personas", ignore=true)
	public TipoContacto toTipoContacto(TipoContactoDTO tipoContactoDTO);
}
