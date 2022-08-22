package com.ungs.agenda.commons;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericServiceImpl<T, ID extends Serializable> implements IGenericService<T, ID> {
	
	public abstract JpaRepository<T, ID> getJpa();
	
	@Override
	public void saveOrUpdate(T entity) {
		getJpa().save(entity);
	}
	
	@Override
	public void delete(T entity) {
		getJpa().delete(entity);
	}
	
	public T getById(ID id) {
		Optional<T> tObject = getJpa().findById(id);
		return tObject.isPresent() ? tObject.get() : null;
	}
	
	public List<T> getAll(){
		List<T> tList = getJpa().findAll();
		return tList;
	}
}
