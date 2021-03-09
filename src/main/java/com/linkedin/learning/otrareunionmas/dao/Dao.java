package com.linkedin.learning.otrareunionmas.dao;

import java.util.List;
import java.util.Optional;

// Una interface define operaciones comunes para cualquier entidad; CRUD

//Como van a tratar distintos tipos de datos, entidades en cada dato, se parametriza esta interface
public interface Dao<T> {
	
	/**
	 * 
	 * @param id
	 * @return A object class if exits
	 */
	Optional<T> get(long id);
	
	/**
	 * 
	 * @return listado generico
	 */
	List<T> getAll();
	
	void save(T t);
	
	void update(T t);
	
	void delete(T t);
	 

}
