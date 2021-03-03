package com.linkedin.learning.otrareunionmas.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.linkedin.learning.otrareunionmas.utiles.EntityManagerUtil;

public  abstract class AbstractDao<T> implements Dao<T> {
	
	private Class<T> clazz;
	private EntityManager manager = EntityManagerUtil.getEntitymanager();

	@Override
	public Optional<T> get(long id) {
		return Optional.ofNullable(manager.find(clazz, id));
	}

	@Override
	public List<T> getAll() {
		String qlString = "FROM" + clazz.getName();
		Query query = manager.createQuery(qlString);
		return query.getResultList();
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	
	

}
