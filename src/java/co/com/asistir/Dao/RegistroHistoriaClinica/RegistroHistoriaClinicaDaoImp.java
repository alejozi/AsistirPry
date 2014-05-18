/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Dao.RegistroHistoriaClinica;

import co.com.asistir.Helper.BaseDaoImplement;
import co.com.asistir.To.Ante;
import co.com.asistir.To.Cita;
import co.com.asistir.To.DetalleExamenFisico;
import co.com.asistir.To.ExamenFisico;
import co.com.asistir.To.ImpresionDiagnostica;
import co.com.asistir.To.Medicamento;
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
public class RegistroHistoriaClinicaDaoImp extends BaseDaoImplement implements RegistroHistoriaClinicaDaoI {

    @Override
    public void guardarRegistroHistoriaClinica(Cita cita) {
        guardar(cita);
    }
    
    @Override
     public boolean guardarhistoria(Cita cita,Ante antecedente, ExamenFisico examenFisico,List<DetalleExamenFisico> dt,List<Medicamento> medicamentos,List<ImpresionDiagnostica> lstimpresiones,Persona persona){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("AsistirPryPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
        em.persist(antecedente);
        em.getTransaction().commit();
        persona.setFkAnte(antecedente);
        em.persist(examenFisico);
         em.getTransaction().commit();
         for (DetalleExamenFisico d : dt) {
            d.setFkExamenFisico(examenFisico);
            em.persist(d);
            em.getTransaction().commit();
        }
        cita.setFkExamen(examenFisico);
        em.persist(cita);
         em.getTransaction().commit();
         for (Medicamento medicamento : medicamentos) {
            medicamento.setFkCita(cita);
            em.persist(medicamento);
             em.getTransaction().commit();
        }
        for (ImpresionDiagnostica imp : lstimpresiones) {
            imp.setFkCita(cita);
            em.persist(imp);
             em.getTransaction().commit();
        }
        return true;
        }catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
}
        return false;
     
     }
}
