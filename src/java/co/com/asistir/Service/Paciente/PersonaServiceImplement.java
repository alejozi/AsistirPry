/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Service.Paciente;


import co.com.asistir.Dao.Paciente.PacienteDaoI;
import co.com.asistir.Dao.Paciente.PacienteDaoImp;
import co.com.asistir.To.Cita;
import co.com.asistir.To.Persona;
import java.util.List;


/**
 *
 * @author Dany
 */
public class PersonaServiceImplement implements PersonaserviceI{
      PacienteDaoI pacienteDao;
    
    
    public PersonaServiceImplement() {
        pacienteDao=new PacienteDaoImp();
    }
    
   
    @Override
    public List<Cita> buscarPaciente(Integer documento) {
        return pacienteDao.buscarPaciente(documento);
     }

    
}
