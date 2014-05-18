/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Service.HistoriaClinica;

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
public interface RegistroHistoriaClinicaI {
    public void guardar(Cita cita);
    public boolean guardarhistoria(Cita cita,Ante antecedente, ExamenFisico examenFisico,List<DetalleExamenFisico> dt,List<Medicamento> medicamentos,List<ImpresionDiagnostica> lstimpresiones,Persona persona);
    
}
