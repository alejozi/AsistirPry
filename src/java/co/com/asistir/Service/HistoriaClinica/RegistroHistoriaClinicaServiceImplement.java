/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Service.HistoriaClinica;

import co.com.asistir.Dao.RegistroHistoriaClinica.RegistroHistoriaClinicaDaoI;
import co.com.asistir.Dao.RegistroHistoriaClinica.RegistroHistoriaClinicaDaoImp;
import co.com.asistir.To.Ante;
import co.com.asistir.To.Cita;
import co.com.asistir.To.Cuidador;
import co.com.asistir.To.DetalleExamenFisico;
import co.com.asistir.To.ExamenFisico;
import co.com.asistir.To.ImpresionDiagnostica;
import co.com.asistir.To.ManejoSoportes;
import co.com.asistir.To.Medicamento;
import co.com.asistir.To.PatronCognitivo;
import co.com.asistir.To.PatronDescanso;
import co.com.asistir.To.Persona;
import co.com.asistir.To.ProfesionalEncargado;
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

    @Override
    public void guardarAntecedente(Ante antecenete) {
    registroVentasDao.guardarAntecedente(antecenete);
    }

    @Override
    public void guardarPersona(Persona persona) {
    registroVentasDao.guardarPersona(persona);
    }

    @Override
    public void guardarExamenFisico(ExamenFisico examenFisico) {
   registroVentasDao.guardarExamenFisico(examenFisico); 
    }

    @Override
    public void guardarDetalleExamenFisico(DetalleExamenFisico detalleExamenFisico) {
    registroVentasDao.guardarDetalleExamenFisico(detalleExamenFisico);
    }

    @Override
    public void guardarPatronDescanso(PatronDescanso patronDescanso) {
    registroVentasDao.guardarPatronDescanso(patronDescanso);
    }

    @Override
    public void guardarPatronCognitivo(PatronCognitivo patronCognitivo) {
    registroVentasDao.guardarPatronCognitivo(patronCognitivo);
    }

    @Override
    public void guardarProfesional(ProfesionalEncargado profecional) {
    registroVentasDao.guardarProfesional(profecional);
    }

    @Override
    public void guardarManejoSoporte(ManejoSoportes manejos) {
    registroVentasDao.guardarManejoSoporte(manejos);
    }

    @Override
    public void guardarCuidador(Cuidador cuidador) {
    registroVentasDao.guardarCuidador(cuidador);
    }

    @Override
    public void guardarMedicamento(Medicamento medicamento) {
    registroVentasDao.guardarMedicamento(medicamento);
    }

    @Override
    public void guardarImpresion(ImpresionDiagnostica impresion) {
    registroVentasDao.guardarImpresion(impresion);
    }
   

    
}
