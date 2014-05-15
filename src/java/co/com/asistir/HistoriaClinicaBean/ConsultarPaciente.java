/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.HistoriaClinicaBean;

import co.com.asistir.Service.Paciente.PersonaServiceImplement;
import co.com.asistir.Service.Paciente.PersonaserviceI;
import co.com.asistir.To.Ante;
import co.com.asistir.To.Cita;
import co.com.asistir.To.ExamenFisico;
import co.com.asistir.To.ImpresionDiagnostica;
import co.com.asistir.To.Medicamento;
import com.sun.faces.context.flash.ELFlash;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 *
 * @author Dany
 */
@ManagedBean
@ViewScoped
public class ConsultarPaciente {
  private Integer cedulaConsulta;
    
      // <editor-fold defaultstate="collapsed" desc="Elementos Para Cargar la informacion de la Historia Clinica">
    private boolean estaPaciente = false;
    private List<ExamenFisico> lstExamenesRealizados;
    private List<Medicamento> lstMedicamentosEnviados;
    private List<ImpresionDiagnostica> lstImpresionesDiagnostricasRealizadas;
    private Ante antecentes;
    private List<String> ordenesMedicas;
    // </editor-fold> 
    
     private PersonaserviceI pacienteService;
   
    
    
    @ManagedProperty("#{historiaClinicaBean}")
    private HistoriaClinicaBean hc;

    /**
     * Creates a new instance of ConsultarPaciente
     */
    public ConsultarPaciente() {
      pacienteService = new PersonaServiceImplement();
        
    }
    
    
    public void consultarPaciente() {
        List<Cita> p = getPacienteService().buscarPaciente(cedulaConsulta);
        if (p.isEmpty()) {
            setEstaPaciente(false);
            System.out.println("no se encuentra = ");
        } else {
            setEstaPaciente(true);
            cargarExamenes(p);
            System.out.println("se encuentra");
        }
        try {
            ELFlash.getFlash().put("boolEsta",estaPaciente);
            FacesContext.getCurrentInstance().getExternalContext().redirect("HistoriaClinica.xhtml");
        } catch (IOException ex) {
            System.out.println("errror = " + ex.getMessage());
        }

    }
    
    public void cargarExamenes(List<Cita> lstCitas) {
        setLstExamenesRealizados(new ArrayList<ExamenFisico>());
        setLstMedicamentosEnviados(new ArrayList<Medicamento>());
        setLstImpresionesDiagnostricasRealizadas(new ArrayList<ImpresionDiagnostica>());
        setOrdenesMedicas(new ArrayList<String>());
        ELFlash.getFlash().put("persona",lstCitas.get(0).getFkPersona());
        hc.setPersona(lstCitas.get(0).getFkPersona());
        setAntecentes(lstCitas.get(0).getFkPersona().getFkAnte());
        
        for (Cita citaConsultada : lstCitas) {
            getLstMedicamentosEnviados().addAll(citaConsultada.getMedicamentoCollection());
            getLstImpresionesDiagnostricasRealizadas().addAll(citaConsultada.getImpresionDiagnosticaCollection());
            getLstExamenesRealizados().add(citaConsultada.getFkExamen());
            getOrdenesMedicas().add(citaConsultada.getOrdenesMedicas());
        }
        
        ELFlash.getFlash().put("lstE", lstExamenesRealizados);
        ELFlash.getFlash().put("lstI", lstImpresionesDiagnostricasRealizadas);
        ELFlash.getFlash().put("lstM", lstMedicamentosEnviados);
        ELFlash.getFlash().put("lstO",ordenesMedicas);
        
    }
    
    
       /**
     * @return the cedulaConsulta
     */
    public Integer getCedulaConsulta() {
        return cedulaConsulta;
    }

    /**
     * @param cedulaConsulta the cedulaConsulta to set
     */
    public void setCedulaConsulta(Integer cedulaConsulta) {
        this.cedulaConsulta = cedulaConsulta;
    }

    /**
     * @return the estaPaciente
     */
    public boolean isEstaPaciente() {
        return estaPaciente;
    }

    /**
     * @param estaPaciente the estaPaciente to set
     */
    public void setEstaPaciente(boolean estaPaciente) {
        this.estaPaciente = estaPaciente;
    }

    /**
     * @return the lstExamenesRealizados
     */
    public List<ExamenFisico> getLstExamenesRealizados() {
        return lstExamenesRealizados;
    }

    /**
     * @param lstExamenesRealizados the lstExamenesRealizados to set
     */
    public void setLstExamenesRealizados(List<ExamenFisico> lstExamenesRealizados) {
        this.lstExamenesRealizados = lstExamenesRealizados;
    }

    /**
     * @return the lstMedicamentosEnviados
     */
    public List<Medicamento> getLstMedicamentosEnviados() {
        return lstMedicamentosEnviados;
    }

    /**
     * @param lstMedicamentosEnviados the lstMedicamentosEnviados to set
     */
    public void setLstMedicamentosEnviados(List<Medicamento> lstMedicamentosEnviados) {
        this.lstMedicamentosEnviados = lstMedicamentosEnviados;
    }

    /**
     * @return the lstImpresionesDiagnostricasRealizadas
     */
    public List<ImpresionDiagnostica> getLstImpresionesDiagnostricasRealizadas() {
        return lstImpresionesDiagnostricasRealizadas;
    }

    /**
     * @param lstImpresionesDiagnostricasRealizadas the lstImpresionesDiagnostricasRealizadas to set
     */
    public void setLstImpresionesDiagnostricasRealizadas(List<ImpresionDiagnostica> lstImpresionesDiagnostricasRealizadas) {
        this.lstImpresionesDiagnostricasRealizadas = lstImpresionesDiagnostricasRealizadas;
    }

    /**
     * @return the antecentes
     */
    public Ante getAntecentes() {
        return antecentes;
    }

    /**
     * @param antecentes the antecentes to set
     */
    public void setAntecentes(Ante antecentes) {
        this.antecentes = antecentes;
    }

    /**
     * @return the ordenesMedicas
     */
    public List<String> getOrdenesMedicas() {
        return ordenesMedicas;
    }

    /**
     * @param ordenesMedicas the ordenesMedicas to set
     */
    public void setOrdenesMedicas(List<String> ordenesMedicas) {
        this.ordenesMedicas = ordenesMedicas;
    }

    /**
     * @return the hc
     */
    public HistoriaClinicaBean getHc() {
        return hc;
    }

    /**
     * @param hc the hc to set
     */
    public void setHc(HistoriaClinicaBean hc) {
        this.hc = hc;
    }

    /**
     * @return the pacienteService
     */
    public PersonaserviceI getPacienteService() {
        return pacienteService;
    }

    /**
     * @param pacienteService the pacienteService to set
     */
    public void setPacienteService(PersonaserviceI pacienteService) {
        this.pacienteService = pacienteService;
    }
}
