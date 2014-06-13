/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Dao.RegistroHistoriaClinica;


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
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dany
 */
public interface RegistroHistoriaClinicaDaoI {
    
    public void guardarRegistroHistoriaClinica(Cita cita);
    public void guardarAntecedente(Ante antecenete);
    public void guardarPersona(Persona persona);
    public void guardarExamenFisico(ExamenFisico examenFisico);
    public void guardarDetalleExamenFisico(DetalleExamenFisico detalleExamenFisico);
    public void guardarPatronDescanso(PatronDescanso patronDescanso);
    public void guardarPatronCognitivo(PatronCognitivo patronCognitivo);
    public void guardarProfesional(ProfesionalEncargado profecional);
    public void guardarManejoSoporte(ManejoSoportes manejos);
    public void guardarCuidador(Cuidador cuidador);
    public void guardarMedicamento(Medicamento medicamento);
    public void guardarImpresion(ImpresionDiagnostica impresion);
    
    public boolean guardarhistoria(Cita cita,Ante antecedente, ExamenFisico examenFisico,List<DetalleExamenFisico> dt,List<Medicamento> medicamentos,List<ImpresionDiagnostica> lstimpresiones, Persona persona);
   
}
