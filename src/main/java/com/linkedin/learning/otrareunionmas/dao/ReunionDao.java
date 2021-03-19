package com.linkedin.learning.otrareunionmas.dao;

import com.linkedin.learning.otrareunionmas.dominio.Reunion;

public class ReunionDao extends AbstractDao<Reunion>{

	public ReunionDao() {
//		Se debe notificar a la clase abstracta con que tipo de trabajará, a través del set
		setClazz(Reunion.class);
	}
}
