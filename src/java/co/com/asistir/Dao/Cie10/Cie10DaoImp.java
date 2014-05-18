/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Dao.Cie10;

import co.com.asistir.Dao.Autenticacion.*;
import co.com.asistir.Helper.BaseDaoImplement;
import co.com.asistir.To.Cie10;
import co.com.asistir.To.Usuario;
import co.com.asistir.Util.JpaEm;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author hectoridarraga
 */
public class Cie10DaoImp extends BaseDaoImplement implements Cie10DaoI {

    @Override
    public List<Cie10> consultaCie10s() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("AsistirPryPU");
        EntityManager em = emf.createEntityManager();
        List<Cie10> cie10s;
        try {
            em.getTransaction().begin();
            //Query query = em.createNamedQuery("Cie10.findAll");
            String sQuery = "select c from Cie10 c ";
            Query query = em.createQuery(sQuery);

            cie10s = query.getResultList();
            em.getTransaction().commit();

        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            System.out.println("e = " + e.getMessage());
            throw e;
        }

        return cie10s;
    }

}
