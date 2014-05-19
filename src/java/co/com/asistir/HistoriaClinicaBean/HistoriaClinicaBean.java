/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.HistoriaClinicaBean;

import co.com.asistir.Helper.BaseDaoI;
import co.com.asistir.Helper.BaseDaoImplement;
import co.com.asistir.Service.Cie10.Cie10I;
import co.com.asistir.Service.Cie10.Cie10ServiceImplement;
import co.com.asistir.Service.HistoriaClinica.RegistroHistoriaClinicaI;
import co.com.asistir.Service.HistoriaClinica.RegistroHistoriaClinicaServiceImplement;
import co.com.asistir.Service.Paciente.PersonaServiceImplement;
import co.com.asistir.Service.Paciente.PersonaserviceI;
import co.com.asistir.To.Ante;
import co.com.asistir.To.Cie10;
import co.com.asistir.To.Cita;
import co.com.asistir.To.DetalleExamenFisico;
import co.com.asistir.To.ExamenFisico;
import co.com.asistir.To.ExamenFisicoConsulta;
import co.com.asistir.To.ImpresionDiagnostica;
import co.com.asistir.To.ManejoSoportes;
import co.com.asistir.To.Medicamento;
import co.com.asistir.To.Persona;
import co.com.asistir.Util.JsfUtil;
import com.sun.faces.context.flash.ELFlash;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
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
    private Ante fkAntecedente = new Ante();
    private Integer cedulaConsulta;
    private List<String> lst;
    private List<String> lst1;
    private List<String> lst2;
    private List<String> lst3;
    private List<String> lst4;
    ManejoSoportes manejoSoporte;
    // <editor-fold defaultstate="collapsed" desc="Services">
    private PersonaserviceI pacienteService;
    RegistroHistoriaClinicaI registroHistoriaClinicaService;
    // </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="Elementos Para Cargar la informacion de la Historia Clinica">
    private boolean estaPaciente = false;
    private List<ExamenFisicoConsulta> lstExamenesRealizados;
    private List<Medicamento> lstMedicamentosEnviados;
    private List<ImpresionDiagnostica> lstImpresionesDiagnostricasRealizadas;
    private Ante antecentes;
    private List<String> ordenesMedicas;
    private List<String> lstEpicrisis;
    private List<String> lstManejos;
    private List<Cie10> lstCie10;
    private Cie10I cie10Service;
    // </editor-fold>  

    public void preRender() {
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("persona") != null) {
            lstExamenesRealizados = (ArrayList<ExamenFisicoConsulta>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("lstE");
            lstImpresionesDiagnostricasRealizadas = (ArrayList<ImpresionDiagnostica>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("lstI");
            lstMedicamentosEnviados = (ArrayList<Medicamento>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("lstM");
            ordenesMedicas = (ArrayList<String>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("lstO");
            persona = (Persona) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("persona");
            lstEpicrisis = (ArrayList<String>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("lstEpi");
            lstManejos = (ArrayList<String>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("lstManejo");

        }
        estaPaciente = (Boolean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("boolEsta");

    }

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
        lstCie10 = new ArrayList<Cie10>();
        cie10Service = new Cie10ServiceImplement();
        consultarCie10();
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
        examenFisicoList.get(filaSeleccionada).setHabilitarBoton(true);
        examenFisicoList.add(new DetalleExamenFisico());
    }

    public void adicionarNuevaFilaMedicamentos(int filaSeleccionada) {
        medicamentoList.add(new Medicamento());
        medicamentoList.get(filaSeleccionada).setHabilitarBoton(true);
    }

    public void adicionarNuevaFilaImpresionDiagnostica(int filaSeleccionada) {
        impresionDiagnosticaList.add(new ImpresionDiagnostica());
        impresionDiagnosticaList.get(filaSeleccionada).setEstaActivo(true);

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
        cargarManejos();
        try{
        BaseDaoI b = new BaseDaoImplement();
        b.guardar(fkAntecedente);
        persona.setFkAnte(fkAntecedente);
        cita.setFkPersona(persona);
        b.guardar(examenFisico);
        for (DetalleExamenFisico dt : examenFisicoList) {
            if (dt.getHora() != 0) {
                dt.setFkExamenFisico(examenFisico);
                b.guardar(dt);
            }
        }
        cita.setFkExamen(examenFisico);
        b.guardar(cita);
        manejoSoporte.setFkCita(cita);
        b.guardar(manejoSoporte);
        for (Medicamento medicamento : medicamentoList) {
            if (!medicamento.getNombreMedicamento().equals("")) {
                medicamento.setFkCita(cita);
                b.guardar(medicamento);
            }
        }
        for (ImpresionDiagnostica imp : impresionDiagnosticaList) {
            if (imp.getDescripcion() != null) {
                imp.setFkCita(cita);
                b.guardar(imp);
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "La informacón se guardio con éxito", ""));
        
        }catch(Exception e){
        e.printStackTrace();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "no se pudo guardar la información, por favor intente mas tarde.", ""));
        
        }



    }

    public void cargarManejos() {
        manejoSoporte = new ManejoSoportes();
        if (lst != null) {
            for (String gral : lst) {
                if (gral.equals("LEV")) {
                    manejoSoporte.setLev(gral);
                } else if (gral.equals("Lav. Gástrico")) {
                    manejoSoporte.setLavGastrica(gral);
                } else if (gral.equals("RCP")) {
                    manejoSoporte.setRcp(gral);
                } else if (gral.equals("O2")) {
                    manejoSoporte.setO2(gral);
                } else if (gral.equals("Curación")) {
                    manejoSoporte.setCuracion(gral);
                } else if (gral.equals("Cateter Ctral")) {
                    manejoSoporte.setCateter(gral);
                } else if (gral.equals("Nasogastrica")) {
                    manejoSoporte.setNasogastrica(gral);
                } else if (gral.equals("Vesical")) {
                    manejoSoporte.setVesical(gral);
                } else if (gral.equals("Orogastrica")) {
                    manejoSoporte.setOrogastrica(gral);
                }
            }
        }
        if (lst1 != null) {
            for (String respiratorio : lst1) {
                if (respiratorio.equals("Aspiración")) {
                    manejoSoporte.setAspiracion(respiratorio);
                } else if (respiratorio.equals("Intubación")) {
                    manejoSoporte.setIntubacion(respiratorio);
                } else if (respiratorio.equals("Hood")) {
                    manejoSoporte.setHood(respiratorio);
                } else if (respiratorio.equals("BVM")) {
                    manejoSoporte.setBvm(respiratorio);
                } else if (respiratorio.equals("Cánula")) {
                    manejoSoporte.setCanula(respiratorio);
                } else if (respiratorio.equals("Oximetria")) {
                    manejoSoporte.setOximetria(respiratorio);
                } else if (respiratorio.equals("Nebulización")) {
                    manejoSoporte.setNebulizacion(respiratorio);
                } else if (respiratorio.equals("Ventury")) {
                    manejoSoporte.setVenturi(respiratorio);
                } else if (respiratorio.equals("FiO2")) {
                    manejoSoporte.setFio(respiratorio);
                } else if (respiratorio.equals("Volumen")) {
                    manejoSoporte.setVolumen(respiratorio);
                } else if (respiratorio.equals("Flujo")) {
                    manejoSoporte.setFlujo(respiratorio);
                } else if (respiratorio.equals("Peep")) {
                    manejoSoporte.setPep(respiratorio);
                }
            }
        }
        if (lst2 != null) {
            for (String cardio : lst2) {
                if (cardio.equals("Monitoreo")) {
                    manejoSoporte.setMonitoreo(cardio);
                } else if (cardio.equals("Cardioversión")) {
                    manejoSoporte.setCardioversion(cardio);
                } else if (cardio.equals("Maniobras Vag")) {
                    manejoSoporte.setManiobras(cardio);
                } else if (cardio.equals("Desfibrilación")) {
                    manejoSoporte.setDesfibrilacion(cardio);
                }
            }
        }
        if (lst3 != null) {
            for (String trauma : lst3) {
                if (trauma.equals("Kendrick")) {
                    manejoSoporte.setKendrick(trauma);
                } else if (trauma.equals("Sutura")) {
                    manejoSoporte.setSutura(trauma);
                } else if (trauma.equals("Control hemorragia")) {
                    manejoSoporte.setControlHemorragia(trauma);
                } else if (trauma.equals("Tabla rígida")) {
                    manejoSoporte.setTablaRigida(trauma);
//                } else if (trauma.equals("Inmovilización")) {
//                    manejoSoporte.setI(trauma);
                } else if (trauma.equals("Collar cervical")) {
                    manejoSoporte.setCollarCervical(trauma);
                }
            }
        }

        if (lst4 != null) {
            for (String liquido : lst4) {
                if (liquido.equals("S.S.N")) {
                    manejoSoporte.setSsn(liquido);
                } else if (liquido.equals("DAD 10%")) {
                    manejoSoporte.setDad10(liquido);
                } else if (liquido.equals("L.Ringer")) {
                    manejoSoporte.setLRinger(liquido);
                } else if (liquido.equals("D.A.D.5%")) {
                    manejoSoporte.setDad5(liquido);
                }
            }
        }
    }

    public void editarDatosPersonales() {
        pacienteService.actualizarDatosPersonales(persona);
        System.out.println("Editar ");
    }

    public void consultarCie10() {
        lstCie10 = cie10Service.listarCie10();
    }

    /**
     * @return the lstCie10
     */
    public List<Cie10> getLstCie10() {
        return lstCie10;
    }

    /**
     * @param lstCie10 the lstCie10 to set
     */
    public void setLstCie10(List<Cie10> lstCie10) {
        this.lstCie10 = lstCie10;
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
    public List<ExamenFisicoConsulta> getLstExamenesRealizados() {
        return lstExamenesRealizados;
    }

    /**
     * @param lstExamenesRealizados the lstExamenesRealizados to set
     */
    public void setLstExamenesRealizados(List<ExamenFisicoConsulta> lstExamenesRealizados) {
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
     * @param lstImpresionesDiagnostricasRealizadas the
     * lstImpresionesDiagnostricasRealizadas to set
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
     * @return the lst
     */
    public List<String> getLst() {
        return lst;
    }

    /**
     * @param lst the lst to set
     */
    public void setLst(List<String> lst) {
        this.lst = lst;
    }

    public void p() {
        if (lst != null) {
            for (String pi : lst) {
                System.out.println(pi);
            }
        }

        if (lst1 != null) {
            for (String pi1 : lst1) {
                System.out.println(pi1);
            }
        }
        if (lst2 != null) {
            for (String pi2 : lst) {
                System.out.println(pi2);
            }
        }
        if (lst3 != null) {
            for (String pi3 : lst3) {
                System.out.println(pi3);
            }
        }
        if (lst4 != null) {
            for (String pi4 : lst4) {
                System.out.println(pi4);
            }
        }

    }

    /**
     * @return the lst1
     */
    public List<String> getLst1() {
        return lst1;
    }

    /**
     * @param lst1 the lst1 to set
     */
    public void setLst1(List<String> lst1) {
        this.lst1 = lst1;
    }

    /**
     * @return the lst2
     */
    public List<String> getLst2() {
        return lst2;
    }

    /**
     * @param lst2 the lst2 to set
     */
    public void setLst2(List<String> lst2) {
        this.lst2 = lst2;
    }

    /**
     * @return the lst3
     */
    public List<String> getLst3() {
        return lst3;
    }

    /**
     * @param lst3 the lst3 to set
     */
    public void setLst3(List<String> lst3) {
        this.lst3 = lst3;
    }

    /**
     * @return the lst4
     */
    public List<String> getLst4() {
        return lst4;
    }

    /**
     * @param lst4 the lst4 to set
     */
    public void setLst4(List<String> lst4) {
        this.lst4 = lst4;
    }

    /**
     * @return the lstEpicrisis
     */
    public List<String> getLstEpicrisis() {
        return lstEpicrisis;
    }

    /**
     * @param lstEpicrisis the lstEpicrisis to set
     */
    public void setLstEpicrisis(List<String> lstEpicrisis) {
        this.lstEpicrisis = lstEpicrisis;
    }

    /**
     * @return the lstManejos
     */
    public List<String> getLstManejos() {
        return lstManejos;
    }

    /**
     * @param lstManejos the lstManejos to set
     */
    public void setLstManejos(List<String> lstManejos) {
        this.lstManejos = lstManejos;
    }
    
    
    public void salir(){
     FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
       try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("Inicio.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ConsultarPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
