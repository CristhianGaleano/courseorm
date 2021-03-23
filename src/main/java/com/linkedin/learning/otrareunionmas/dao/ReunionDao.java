package com.linkedin.learning.otrareunionmas.dao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.Query;

import com.linkedin.learning.otrareunionmas.dominio.Reunion;


public class ReunionDao extends AbstractDao<Reunion>{

	public ReunionDao() {
//		Se debe notificar a la clase abstracta con que tipo de trabajará, a través del set
		setClazz(Reunion.class);
	}
	
	
//	business methods
	
	public Reunion proximaReunion() {
		String string = "FROM " + Reunion.class.getName() + " WHERE fecha > now() order by fecha";
		Query query = getManager().createQuery(string).setMaxResults(1);
		return (Reunion) query.getSingleResult(); 
	}
	
	public List<Reunion> reunionesMayana(){
		 String qlString = "FROM " + Reunion.class.getName() + " WHERE fecha between ?1 and ?2";
		 Query query = getManager().createQuery(qlString);
		 LocalDate mayana = LocalDate.now().plus(1, ChronoUnit.DAYS);
//		 setea la hora al principio del dia
		 query.setParameter(1, mayana.atStartOfDay());
//		 Se suma  un dia y se setea la hora al principio dle dia
		 query.setParameter(2, mayana.plus(1, ChronoUnit.DAYS).atStartOfDay());
		 return query.getResultList();
	}
}
