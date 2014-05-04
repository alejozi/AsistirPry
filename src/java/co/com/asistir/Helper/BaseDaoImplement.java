/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Helper;

import co.com.asistir.Util.JpaEm;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

/**
 *
 * @author Dany
 */
public class BaseDaoImplement implements BaseDaoI {

    
    @Override
    public Object guardar(Object obj) {
        Object obje=null;
        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("AsistirPryPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(obj);
           em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }return obje;
    }
}
