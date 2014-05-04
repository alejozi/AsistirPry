/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Service.HistoriaClinica;

import co.com.asistir.Dao.RegistroHistoriaClinica.RegistroHistoriaClinicaDaoI;
import co.com.asistir.Dao.RegistroHistoriaClinica.RegistroHistoriaClinicaDaoImp;
import co.com.asistir.To.Cita;


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

    
}
