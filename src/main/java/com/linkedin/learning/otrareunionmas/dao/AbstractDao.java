package com.linkedin.learning.otrareunionmas.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional.TxType;

import com.linkedin.learning.otrareunionmas.utiles.EntityManagerUtil;

public  abstract class AbstractDao<T> implements Dao<T> {
//	la clase con la que de trabajar en su momento, no se inicializa ya que no se sabe que valor utilizará 
	private Class<T> clazz;
	
//	Lo usaremos en todos los metodos
	private EntityManager manager = EntityManagerUtil.getEntitymanager();

	
	@Override
	public Optional<T> get(long id) {
//		le pasamos la clase de la entidad para que sepa en que clase buscar, Optional para en caso de que no encuentre nada
		return Optional.ofNullable(manager.find(clazz, id)); 
	}

	@Override
	public List<T> getAll() {
		String qlString = "FROM" + clazz.getName();	 
		Query query = manager.createQuery(qlString);
		return query.getResultList();
	}

	@Override
	public void save(T t) {
		executeInsideTransaction(manager -> manager.persist(t));
	}

	@Override
	public void update(T t) {
		executeInsideTransaction(manager -> manager.merge(t));
	}

	@Override
	public void delete(T t) {
		executeInsideTransaction(manager -> manager.remove(t));
	}

	public Class<T> getClazz() {
		return clazz;
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	
	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction tx = manager.getTransaction();
		try {
			tx.begin();
			action.accept(manager);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}
	}
	
	
	

}
