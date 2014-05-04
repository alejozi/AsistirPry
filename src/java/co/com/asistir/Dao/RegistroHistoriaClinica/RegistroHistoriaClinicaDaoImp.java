/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Dao.RegistroHistoriaClinica;

import co.com.asistir.Helper.BaseDaoImplement;
import co.com.asistir.To.Cita;
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

    
    
}
