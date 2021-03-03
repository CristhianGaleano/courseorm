package com.linkedin.learning.otrareunionmas.utiles;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.jandex.Main;

public class EntityManagerUtil {

	/**
	 * 	Method return Entitymanager Object
	 * @return Object entitymanager
	 */
	public static EntityManager getEntitymanager() {
		 EntityManagerFactory factory = Persistence.createEntityManagerFactory("OtraReunionMas");
//		 Ahora le pedimos al entitymanager... el gestor de entidades (EntityManagar)
		 EntityManager manager = factory.createEntityManager();
		 return manager;
	}
	
	
	public static void main(String[] args) {
		
		EntityManager manager = EntityManagerUtil.getEntitymanager();
		System.out.println("Entity Manager class ===> " + manager.getClass().getCanonicalName());
	}
	
}
