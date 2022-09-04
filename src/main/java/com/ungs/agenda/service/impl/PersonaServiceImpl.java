package com.ungs.agenda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ungs.agenda.dto.DomicilioDTO;
import com.ungs.agenda.dto.PersonaDTO;
import com.ungs.agenda.mapper.ModelMapper;
import com.ungs.agenda.model.Persona;
import com.ungs.agenda.repository.PersonaRepository;
import com.ungs.agenda.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private PersonaRepository personaRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<PersonaDTO> getAll() {
		List <Persona> personas = personaRepo.findAll();
		return mapper.toPersonasDTO(personas);
	}

	@Override
	public void saveOrUpdate(PersonaDTO persona) {
		personaRepo.save(mapper.toPersona(persona));
	}

	@Override
	public void delete(PersonaDTO persona) {
		personaRepo.delete(mapper.toPersona(persona));
	}

	@Override
	public DomicilioDTO getDomicilio(Long id) {
		Optional<Persona> persona = personaRepo.findById(id);
		return persona.isPresent() ? mapper.toDomicilioDTO(persona.get().getDomicilio()) : null;
	}

	@Override
	public PersonaDTO getById(Long id) {
		Optional<Persona> persona = personaRepo.findById(id);
		return persona.isPresent() ? mapper.toPersonaDTO(persona.get()) : null;
	}

	@Override
	public Page<PersonaDTO> getPaginated(Integer pageNum, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize); 
		Page<Persona> pagePersonas = this.personaRepo.findAll(pageable);
		Page<PersonaDTO> pagePersonasDTO = pagePersonas.map(new Function<Persona, PersonaDTO>() {
		    @Override
		    public PersonaDTO apply(Persona persona) {
		        return mapper.toPersonaDTO(persona);
		    }
		});
		return pagePersonasDTO;
	}

}
