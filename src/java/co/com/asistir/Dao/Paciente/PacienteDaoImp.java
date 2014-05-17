/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Dao.Paciente;

import co.com.asistir.Dao.RegistroHistoriaClinica.*;
import co.com.asistir.Helper.BaseDaoImplement;
import co.com.asistir.To.Cita;
import co.com.asistir.To.Persona;
import co.com.asistir.Util.JpaEm;
import co.com.asistir.Util.Utilidades;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Dany
 */
public class PacienteDaoImp extends BaseDaoImplement implements PacienteDaoI {

    @Override
    public List<Cita> buscarPaciente(Integer documento) {
        List<Cita> lstPacientes=null;
        Persona paciente = new Persona(documento);
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("AsistirPryPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            String q="SELECT c FROM Cita c WHERE c.fkPersona = :persona";
            Query query=em.createQuery(q);
            query.setParameter("persona", paciente);
            lstPacientes=query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return lstPacientes;

    }
    
    
    @Override
      public void actualizarDatosPersonales(Persona persona){
      EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("AsistirPryPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
        em.merge(persona);
        em.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
}
      }
}
