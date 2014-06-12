/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Consulta;

import co.com.asistir.To.Ante;
import co.com.asistir.To.Cuidador;
import co.com.asistir.To.ExamenFisicoConsulta;
import co.com.asistir.To.ImpresionDiagnostica;
import co.com.asistir.To.Medicamento;
import co.com.asistir.To.PatronCognitivo;
import co.com.asistir.To.PatronDescanso;
import co.com.asistir.To.Persona;
import co.com.asistir.To.ProfesionalEncargado;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Dany
 */
public class ConsultaCita {
    private Date fecha;
    private String convenio;
    private String epicrisis;
    private String ordenesMedicas;
    private String nombreMedico;
    private String enfermeraAuxiliar;
    private List<String> consultaManejoSoporte;
    private ExamenFisicoConsulta examenFisicoConsulta;
    private List<Medicamento> lstMedicamentosEnviados;
    private List<ImpresionDiagnostica> lstImpresionesDiagnostricasRealizadas;
    private Ante antecentes;
    private Cuidador cuidador;
    private PatronCognitivo patronCognitivo;
    private PatronDescanso patrinDescanso;
    private ProfesionalEncargado profesional;
    
    
    public ConsultaCita() {
    }

    public ConsultaCita(Date fecha, String convenio, String epicrisis, String ordenesMedicas, String nombreMedico, String enfermeraAuxiliar, List<String> consultaManejoSoporte, ExamenFisicoConsulta examenFisicoConsulta, Set<Medicamento> lstMedicamentosEnviados, Set<ImpresionDiagnostica> lstImpresionesDiagnostricasRealizadas, Ante antecentes, Cuidador cuidador, PatronCognitivo patronCognitivo, PatronDescanso patrinDescanso, ProfesionalEncargado profesional) {
        this.fecha = fecha;
        this.convenio = convenio;
        this.epicrisis = epicrisis;
        this.ordenesMedicas = ordenesMedicas;
        this.nombreMedico = nombreMedico;
        this.enfermeraAuxiliar = enfermeraAuxiliar;
        this.consultaManejoSoporte = consultaManejoSoporte;
        this.examenFisicoConsulta = examenFisicoConsulta;
        this.lstMedicamentosEnviados =new ArrayList<Medicamento>(lstMedicamentosEnviados);
        this.lstImpresionesDiagnostricasRealizadas =new ArrayList<ImpresionDiagnostica>(lstImpresionesDiagnostricasRealizadas);
        this.antecentes = antecentes;
        this.cuidador = cuidador;
        this.patronCognitivo = patronCognitivo;
        this.patrinDescanso = patrinDescanso;
        this.profesional = profesional;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the convenio
     */
    public String getConvenio() {
        return convenio;
    }

    /**
     * @param convenio the convenio to set
     */
    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    /**
     * @return the epicrisis
     */
    public String getEpicrisis() {
        return epicrisis;
    }

    /**
     * @param epicrisis the epicrisis to set
     */
    public void setEpicrisis(String epicrisis) {
        this.epicrisis = epicrisis;
    }

    /**
     * @return the ordenesMedicas
     */
    public String getOrdenesMedicas() {
        return ordenesMedicas;
    }

    /**
     * @param ordenesMedicas the ordenesMedicas to set
     */
    public void setOrdenesMedicas(String ordenesMedicas) {
        this.ordenesMedicas = ordenesMedicas;
    }

    /**
     * @return the nombreMedico
     */
    public String getNombreMedico() {
        return nombreMedico;
    }

    /**
     * @param nombreMedico the nombreMedico to set
     */
    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    /**
     * @return the enfermeraAuxiliar
     */
    public String getEnfermeraAuxiliar() {
        return enfermeraAuxiliar;
    }

    /**
     * @param enfermeraAuxiliar the enfermeraAuxiliar to set
     */
    public void setEnfermeraAuxiliar(String enfermeraAuxiliar) {
        this.enfermeraAuxiliar = enfermeraAuxiliar;
    }

   
    /**
     * @return the consultaManejoSoporte
     */
    public List<String> getConsultaManejoSoporte() {
        return consultaManejoSoporte;
    }

    /**
     * @param consultaManejoSoporte the consultaManejoSoporte to set
     */
    public void setConsultaManejoSoporte(List<String> consultaManejoSoporte) {
        this.consultaManejoSoporte = consultaManejoSoporte;
    }

    /**
     * @return the examenFisicoConsulta
     */
    public ExamenFisicoConsulta getExamenFisicoConsulta() {
        return examenFisicoConsulta;
    }

    /**
     * @param examenFisicoConsulta the examenFisicoConsulta to set
     */
    public void setExamenFisicoConsulta(ExamenFisicoConsulta examenFisicoConsulta) {
        this.examenFisicoConsulta = examenFisicoConsulta;
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
    public void setLstMedicamentosEnviados(Set<Medicamento> lstMedicamentosEnviados) {
        this.lstMedicamentosEnviados = new ArrayList<Medicamento>(lstMedicamentosEnviados);
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
    public void setLstImpresionesDiagnostricasRealizadas(Set<ImpresionDiagnostica> lstImpresionesDiagnostricasRealizadas) {
        this.lstImpresionesDiagnostricasRealizadas = new ArrayList<ImpresionDiagnostica>(lstImpresionesDiagnostricasRealizadas);
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
     * @return the cuidador
     */
    public Cuidador getCuidador() {
        return cuidador;
    }

    /**
     * @param cuidador the cuidador to set
     */
    public void setCuidador(Cuidador cuidador) {
        this.cuidador = cuidador;
    }

    /**
     * @return the patronCognitivo
     */
    public PatronCognitivo getPatronCognitivo() {
        return patronCognitivo;
    }

    /**
     * @param patronCognitivo the patronCognitivo to set
     */
    public void setPatronCognitivo(PatronCognitivo patronCognitivo) {
        this.patronCognitivo = patronCognitivo;
    }

    /**
     * @return the patrinDescanso
     */
    public PatronDescanso getPatrinDescanso() {
        return patrinDescanso;
    }

    /**
     * @param patrinDescanso the patrinDescanso to set
     */
    public void setPatrinDescanso(PatronDescanso patrinDescanso) {
        this.patrinDescanso = patrinDescanso;
    }

    /**
     * @return the profesional
     */
    public ProfesionalEncargado getProfesional() {
        return profesional;
    }

    /**
     * @param profesional the profesional to set
     */
    public void setProfesional(ProfesionalEncargado profesional) {
        this.profesional = profesional;
    }
    
}
