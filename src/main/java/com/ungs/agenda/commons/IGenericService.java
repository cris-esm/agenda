package com.ungs.agenda.commons;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;


public interface IGenericService<T, ID extends Serializable> {
	
	public void saveOrUpdate(T entity);
	
	public void delete(T entity);
	
	public T getById(ID id);
	
	public List<T> getAll();
	
}
