/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Dao.Paciente;


import co.com.asistir.Dao.RegistroHistoriaClinica.*;
import co.com.asistir.To.Cita;
import co.com.asistir.To.Persona;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dany
 */
public interface PacienteDaoI {
    
 
    public List<Cita> buscarPaciente(Integer documento);
}
