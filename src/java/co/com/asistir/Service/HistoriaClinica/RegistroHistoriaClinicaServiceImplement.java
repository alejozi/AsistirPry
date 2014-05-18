/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Service.HistoriaClinica;

import co.com.asistir.Dao.RegistroHistoriaClinica.RegistroHistoriaClinicaDaoI;
import co.com.asistir.Dao.RegistroHistoriaClinica.RegistroHistoriaClinicaDaoImp;
import co.com.asistir.To.Ante;
import co.com.asistir.To.Cita;
import co.com.asistir.To.DetalleExamenFisico;
import co.com.asistir.To.ExamenFisico;
import co.com.asistir.To.ImpresionDiagnostica;
import co.com.asistir.To.Medicamento;
import co.com.asistir.To.Persona;
import java.util.List;


/**
 *
 * @author Dany
 */
public class RegistroHistoriaClinicaServiceImplement implements RegistroHistoriaClinicaI{
      RegistroHistoriaClinicaDaoI registroVentasDao;
    
    
    public RegistroHistoriaClinicaServiceImplement() {
        registroVentasDao=new RegistroHistoriaClinicaDaoImp();
    }
    
    @Override
    public void guardar(Cita cita) {
        registroVentasDao.guardarRegistroHistoriaClinica(cita);
    }
        
    @Override
     public boolean guardarhistoria(Cita cita,Ante antecedente, ExamenFisico examenFisico,List<DetalleExamenFisico> dt,List<Medicamento> medicamentos,List<ImpresionDiagnostica> lstimpresiones,Persona persona){
    return registroVentasDao.guardarhistoria(cita, antecedente, examenFisico, dt, medicamentos, lstimpresiones, persona);
    }
   

    
}
