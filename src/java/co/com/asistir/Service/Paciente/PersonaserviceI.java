/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Service.Paciente;

import co.com.asistir.Service.HistoriaClinica.*;
import co.com.asistir.To.Cita;
import co.com.asistir.To.Persona;
import java.util.List;


/**
 *
 * @author Dany
 */
public interface PersonaserviceI {
    public List<Cita> buscarPaciente(Integer documento);
    
}
