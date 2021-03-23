package com.linkedin.learning.otrareunionmas;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import com.linkedin.learning.otrareunionmas.dao.ReunionDao;
import com.linkedin.learning.otrareunionmas.dominio.Reunion;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ReunionDao dao = new ReunionDao();
        List<Reunion> reuniones = dao.getAll();
        System.out.println(" **** " + reuniones);
        
        
        Reunion r = new Reunion(LocalDateTime.now().plus(2, ChronoUnit.DAYS), "Reunión de pasado mañana");
        System.out.println(r);
        dao.save(r);  
        
        
        try {
        	System.out.println("Proxima reunión:" + dao.proximaReunion());
		} catch (NoResultException nre) {
			System.out.println("No tienes ninguna reunión a la vista");
		}
        
        
        Reunion r3 = new Reunion(LocalDateTime.now().plus(2, ChronoUnit.DAYS), "Reunión de mañana");
        System.out.println(r3);
        dao.save(r3);  
        
        List<Reunion> reunionesayana = dao.reunionesMayana();
        System.out.println("Para mañana: " + reunionesayana);
    }
}
