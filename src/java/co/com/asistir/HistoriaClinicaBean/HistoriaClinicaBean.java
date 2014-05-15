/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.HistoriaClinicaBean;

import co.com.asistir.Helper.BaseDaoI;
import co.com.asistir.Helper.BaseDaoImplement;
import co.com.asistir.Service.HistoriaClinica.RegistroHistoriaClinicaI;
import co.com.asistir.Service.HistoriaClinica.RegistroHistoriaClinicaServiceImplement;
import co.com.asistir.Service.Paciente.PersonaServiceImplement;
import co.com.asistir.Service.Paciente.PersonaserviceI;
import co.com.asistir.To.Ante;
import co.com.asistir.To.Cita;
import co.com.asistir.To.DetalleExamenFisico;
import co.com.asistir.To.ExamenFisico;
import co.com.asistir.To.ImpresionDiagnostica;
import co.com.asistir.To.Medicamento;
import co.com.asistir.To.Persona;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dany
 */
@ManagedBean
@ViewScoped
public class HistoriaClinicaBean {
    
    private Cita cita;
    private Persona persona;
    private List<DetalleExamenFisico> examenFisicoList;
    private List<ImpresionDiagnostica> impresionDiagnosticaList;
    private List<Medicamento> medicamentoList;
    private List<String> manejoSoportesGralesList;
    private List<String> manejoSoportesRespiratoriasList;
    private List<String> manejoSoportesCardioList;
    private List<String> manejoSoportesTraumaList;
    private List<String> manejoSoportesLiquidosList;
    private ExamenFisico examenFisico;
    private Set<String> lst = new TreeSet<String>();
    private Ante fkAntecedente = new Ante();
    private Integer cedulaConsulta;
    // <editor-fold defaultstate="collapsed" desc="Services">
    private PersonaserviceI pacienteService;
    RegistroHistoriaClinicaI registroHistoriaClinicaService;
    // </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="Elementos Para Cargar la informacion de la Historia Clinica">
    private boolean estaPaciente = false;
    private List<ExamenFisico> lstExamenesRealizados;
    private List<Medicamento> lstMedicamentosEnviados;
    private List<ImpresionDiagnostica> lstImpresionesDiagnostricasRealizadas;
    private Ante antecentes;
    private List<String> ordenesMedicas;
    // </editor-fold>  

    /**
     * Creates a new instance of HistoriaClinicaBean
     */
    public HistoriaClinicaBean() {
        cita = new Cita();
        persona = new Persona();
        examenFisico = new ExamenFisico();
        examenFisicoList = new ArrayList<DetalleExamenFisico>();
        medicamentoList = new ArrayList<Medicamento>();
        impresionDiagnosticaList = new ArrayList<ImpresionDiagnostica>();
        registroHistoriaClinicaService = new RegistroHistoriaClinicaServiceImplement();
        fkAntecedente = new Ante();
        pacienteService = new PersonaServiceImplement();
        inicializarListas();
    }

    /**
     * @return the cita
     */
    public Cita getCita() {
        return cita;
    }

    /**
     * @param cita the cita to set
     */
    public void setCita(Cita cita) {
        this.cita = cita;
    }

    /**
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * @return the examenFisicoList
     */
    public List<DetalleExamenFisico> getExamenFisicoList() {
        return examenFisicoList;
    }

    /**
     * @param examenFisicoList the examenFisicoList to set
     */
    public void setExamenFisicoList(List<DetalleExamenFisico> examenFisicoList) {
        this.examenFisicoList = examenFisicoList;
    }

    /**
     * @return the impresionDiagnosticaList
     */
    public List<ImpresionDiagnostica> getImpresionDiagnosticaList() {
        return impresionDiagnosticaList;
    }

    /**
     * @param impresionDiagnosticaList the impresionDiagnosticaList to set
     */
    public void setImpresionDiagnosticaList(List<ImpresionDiagnostica> impresionDiagnosticaList) {
        this.impresionDiagnosticaList = impresionDiagnosticaList;
    }

    /**
     * @return the medicamentoList
     */
    public List<Medicamento> getMedicamentoList() {
        return medicamentoList;
    }

    /**
     * @param medicamentoList the medicamentoList to set
     */
    public void setMedicamentoList(List<Medicamento> medicamentoList) {
        this.medicamentoList = medicamentoList;
    }

    /**
     * @return the examenFisico
     */
    public ExamenFisico getExamenFisico() {
        return examenFisico;
    }

    /**
     * @param examenFisico the examenFisico to set
     */
    public void setExamenFisico(ExamenFisico examenFisico) {
        this.examenFisico = examenFisico;
    }
    
    public void inicializarListas() {
        examenFisicoList.add(new DetalleExamenFisico());
        medicamentoList.add(new Medicamento());
        impresionDiagnosticaList.add(new ImpresionDiagnostica());
    }
    
    public void adicionarNuevaFilaDetalleExamenFisico(int filaSeleccionada) {
        //examenFisicoList.get(filaSeleccionada).setHabilitarBoton(true);
        examenFisicoList.add(new DetalleExamenFisico());
    }
    
    public void adicionarNuevaFilaMedicamentos() {
        medicamentoList.add(new Medicamento());
    }
    
    public void adicionarNuevaFilaImpresionDiagnostica() {
        impresionDiagnosticaList.add(new ImpresionDiagnostica());
    }

    /**
     * @return the manejoSoportesGralesList
     */
    public List<String> getManejoSoportesGralesList() {
        return manejoSoportesGralesList;
    }

    /**
     * @param manejoSoportesGralesList the manejoSoportesGralesList to set
     */
    public void setManejoSoportesGralesList(List<String> manejoSoportesGralesList) {
        this.manejoSoportesGralesList = manejoSoportesGralesList;
    }

    /**
     * @return the manejoSoportesRespiratoriasList
     */
    public List<String> getManejoSoportesRespiratoriasList() {
        return manejoSoportesRespiratoriasList;
    }

    /**
     * @param manejoSoportesRespiratoriasList the
     * manejoSoportesRespiratoriasList to set
     */
    public void setManejoSoportesRespiratoriasList(List<String> manejoSoportesRespiratoriasList) {
        this.manejoSoportesRespiratoriasList = manejoSoportesRespiratoriasList;
    }

    /**
     * @return the manejoSoportesCardioList
     */
    public List<String> getManejoSoportesCardioList() {
        return manejoSoportesCardioList;
    }

    /**
     * @param manejoSoportesCardioList the manejoSoportesCardioList to set
     */
    public void setManejoSoportesCardioList(List<String> manejoSoportesCardioList) {
        this.manejoSoportesCardioList = manejoSoportesCardioList;
    }

    /**
     * @return the manejoSoportesTraumaList
     */
    public List<String> getManejoSoportesTraumaList() {
        return manejoSoportesTraumaList;
    }

    /**
     * @param manejoSoportesTraumaList the manejoSoportesTraumaList to set
     */
    public void setManejoSoportesTraumaList(List<String> manejoSoportesTraumaList) {
        this.manejoSoportesTraumaList = manejoSoportesTraumaList;
    }

    /**
     * @return the manejoSoportesLiquidosList
     */
    public List<String> getManejoSoportesLiquidosList() {
        return manejoSoportesLiquidosList;
    }

    /**
     * @param manejoSoportesLiquidosList the manejoSoportesLiquidosList to set
     */
    public void setManejoSoportesLiquidosList(List<String> manejoSoportesLiquidosList) {
        this.manejoSoportesLiquidosList = manejoSoportesLiquidosList;
    }
    
    public void registrarHistoriaClinica() {
        BaseDaoI b = new BaseDaoImplement();
        b.guardar(fkAntecedente);
        persona.setFkAnte(fkAntecedente);
        cita.setFkPersona(persona);
        b.guardar(examenFisico);        
        for (DetalleExamenFisico dt : examenFisicoList) {
            dt.setFkExamenFisico(examenFisico);
            b.guardar(dt);
        }
        cita.setFkExamen(examenFisico);
        b.guardar(cita);
        for (Medicamento medicamento : medicamentoList) {
            medicamento.setFkCita(cita);
            b.guardar(medicamento);
        }
        for (ImpresionDiagnostica imp : impresionDiagnosticaList) {
            imp.setFkCita(cita);
            b.guardar(imp);
        }




//        cita.setImpresionDiagnosticaCollection(impresionDiagnosticaList);
//        cita.setMedicamentoCollection(medicamentoList);
//        persona.setFkAnte(fkAntecedente);
//   examenFisico.setDetalleExamenFisicoCollection(examenFisicoList);
//        cita.setFkPersona(persona);
//        cita.setFkExamen(examenFisico);
//        //BaseDaoI b=new BaseDaoImplement();*/
//
//        registroHistoriaClinicaService.guardar(cita);
//        // b.guardar(new Medicamento());
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
        persona= lstCitas.get(0).getFkPersona();
        setAntecentes(persona.getFkAnte());
        
        for (Cita citaConsultada : lstCitas) {
            getLstMedicamentosEnviados().addAll(citaConsultada.getMedicamentoCollection());
            getLstImpresionesDiagnostricasRealizadas().addAll(citaConsultada.getImpresionDiagnosticaCollection());
            getLstExamenesRealizados().add(cita.getFkExamen());
            getOrdenesMedicas().add(citaConsultada.getOrdenesMedicas());
        }
    }

    /**
     * @return the lst
     */
    public Set<String> getLst() {
        return lst;
    }

    /**
     * @param lst the lst to set
     */
    public void setLst(Set<String> lst) {
        this.lst = lst;
    }

    /**
     * @return the fkAntecedente
     */
    public Ante getFkAntecedente() {
        return fkAntecedente;
    }

    /**
     * @param fkAntecedente the fkAntecedente to set
     */
    public void setFkAntecedente(Ante fkAntecedente) {
        this.fkAntecedente = fkAntecedente;
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
}
