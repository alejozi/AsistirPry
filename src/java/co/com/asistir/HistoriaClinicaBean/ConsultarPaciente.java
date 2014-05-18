/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.HistoriaClinicaBean;

import co.com.asistir.Service.Paciente.PersonaServiceImplement;
import co.com.asistir.Service.Paciente.PersonaserviceI;
import co.com.asistir.To.Ante;
import co.com.asistir.To.Cita;
import co.com.asistir.To.DetalleExamenFisico;
import co.com.asistir.To.ExamenFisico;
import co.com.asistir.To.ExamenFisicoConsulta;
import co.com.asistir.To.ImpresionDiagnostica;
import co.com.asistir.To.ManejoSoportes;
import co.com.asistir.To.Medicamento;
import co.com.asistir.Util.JsfUtil;
import com.sun.faces.context.flash.ELFlash;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
    private List<ExamenFisicoConsulta> lstExamenesRealizados;
    private List<Medicamento> lstMedicamentosEnviados;
    private List<ImpresionDiagnostica> lstImpresionesDiagnostricasRealizadas;
    private Ante antecentes;
    private List<String> ordenesMedicas;
    private List<String> epicrisis;
    private List<String> lstManejos;
    // </editor-fold> 
    private PersonaserviceI pacienteService;

    /**
     * Creates a new instance of ConsultarPaciente
     */
    public ConsultarPaciente() {
        pacienteService = new PersonaServiceImplement();
        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("persona") != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("persona");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("lstI");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("lstM");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("lstO");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("boolEsta");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("lstEpi");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("lstManejo");

        }
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
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("boolEsta", estaPaciente);
            FacesContext.getCurrentInstance().getExternalContext().redirect("HistoriaClinica.xhtml");
        } catch (IOException ex) {
            System.out.println("errror = " + ex.getMessage());
        }

    }

    public void cargarExamenes(List<Cita> lstCitas) {
        setLstExamenesRealizados(new ArrayList<ExamenFisicoConsulta>());
        setLstMedicamentosEnviados(new ArrayList<Medicamento>());
        setLstImpresionesDiagnostricasRealizadas(new ArrayList<ImpresionDiagnostica>());
        setOrdenesMedicas(new ArrayList<String>());
        setEpicrisis(new ArrayList<String>());
        setLstManejos(new ArrayList<String>());


        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("persona", lstCitas.get(0).getFkPersona());
        setAntecentes(lstCitas.get(0).getFkPersona().getFkAnte());

        for (Cita citaConsultada : lstCitas) {
            getLstMedicamentosEnviados().addAll(citaConsultada.getMedicamentoCollection());
            getLstImpresionesDiagnostricasRealizadas().addAll(citaConsultada.getImpresionDiagnosticaCollection());
            getLstExamenesRealizados().add(cargarE(citaConsultada.getFkExamen()));
            getOrdenesMedicas().add(citaConsultada.getOrdenesMedicas());
            getEpicrisis().add(citaConsultada.getEpicrisis());
            getLstManejos().addAll(cargarM(new ArrayList<ManejoSoportes>(citaConsultada.getManejoSoportesSet())));
        }

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lstE", lstExamenesRealizados);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lstI", lstImpresionesDiagnostricasRealizadas);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lstM", lstMedicamentosEnviados);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lstO", ordenesMedicas);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lstEpi", epicrisis);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("lstManejo", lstManejos);


    }

    public List<String> cargarM(List<ManejoSoportes> lstMane) {
        List<String> manejos = new ArrayList<String>();

        for (ManejoSoportes manejoSoporte : lstMane) {
            StringBuilder ms = new StringBuilder();
          
            if (manejoSoporte.getLev()!=null) {
                ms.append(manejoSoporte.getLev());
                ms.append(",");
            }
            if (manejoSoporte.getLavGastrica()!=null) {
                ms.append(manejoSoporte.getLavGastrica());
                ms.append(",");
            }
            if (manejoSoporte.getRcp()!=null) {
                ms.append(manejoSoporte.getRcp());
                ms.append(",");
            }
            if (manejoSoporte.getO2()!=null) {
                ms.append(manejoSoporte.getO2());
                ms.append(",");
            }
            if (manejoSoporte.getCuracion()!=null) {
                ms.append(manejoSoporte.getCuracion());
                ms.append(",");
            }
            if (manejoSoporte.getCateter()!=null) {
                ms.append(manejoSoporte.getCateter());
                ms.append(",");
            }
            if (manejoSoporte.getNasogastrica()!=null) {
                ms.append(manejoSoporte.getNasogastrica());
                ms.append(",");
            }
            if (manejoSoporte.getVesical()!=null) {
                ms.append(manejoSoporte.getVesical());
                ms.append(",");
            }
            if (manejoSoporte.getOrogastrica()!=null) {
                ms.append(manejoSoporte.getOrogastrica());
                ms.append(",");
            }
            if (manejoSoporte.getAspiracion()!=null) {
                ms.append(manejoSoporte.getAspiracion());
                ms.append(",");
            }
            if (manejoSoporte.getIntubacion()!=null) {
                ms.append(manejoSoporte.getIntubacion());
                ms.append(",");
            }
            if (manejoSoporte.getHood()!=null) {
                ms.append(manejoSoporte.getHood());
                ms.append(",");
            }
            if (manejoSoporte.getBvm()!=null) {
                ms.append(manejoSoporte.getBvm());
                ms.append(",");
            }
            if (manejoSoporte.getCanula()!=null) {
                ms.append(manejoSoporte.getCanula());
                ms.append(",");
            }
            if (manejoSoporte.getOximetria()!=null) {
                ms.append(manejoSoporte.getOximetria());
                ms.append(",");
            }
            if (manejoSoporte.getNebulizacion()!=null) {
                ms.append(manejoSoporte.getNebulizacion());
                ms.append(",");
            }
            if (manejoSoporte.getVenturi()!=null) {
                ms.append(manejoSoporte.getVenturi());
                ms.append(",");
            }
            if (manejoSoporte.getFio()!=null) {
                ms.append(manejoSoporte.getFio());
                ms.append(",");
            }
            if (manejoSoporte.getVolumen()!=null) {
                ms.append(manejoSoporte.getVolumen());
                ms.append(",");
            }
            if (manejoSoporte.getFlujo()!=null) {
                ms.append(manejoSoporte.getFlujo());
                ms.append(",");
            }
            if (manejoSoporte.getPep()!=null) {
                ms.append(manejoSoporte.getPep());
                ms.append(",");
            }
            if (manejoSoporte.getMonitoreo()!=null) {
                ms.append(manejoSoporte.getMonitoreo());
                ms.append(",");
            }
            if (manejoSoporte.getCardioversion()!=null) {
                ms.append(manejoSoporte.getCardioversion());
                ms.append(",");
            }
            if (manejoSoporte.getManiobras()!=null) {
                ms.append(manejoSoporte.getManiobras());
                ms.append(",");
            }
            if (manejoSoporte.getDesfibrilacion()!=null) {
                ms.append(manejoSoporte.getDesfibrilacion());
                ms.append(",");
            }
            if (manejoSoporte.getKendrick()!=null) {
                ms.append(manejoSoporte.getKendrick());
                ms.append(",");
            }
            if (manejoSoporte.getSutura()!=null) {
                ms.append(manejoSoporte.getSutura());
                ms.append(",");
            }
            if (manejoSoporte.getControlHemorragia()!=null) {
                ms.append(manejoSoporte.getControlHemorragia());
                ms.append(",");
            }
            if (manejoSoporte.getTablaRigida()!=null) {
                ms.append(manejoSoporte.getTablaRigida());
                ms.append(",");
            }
//            if (!manejoSoporte.getInmovilizacion().isEmpty()) {
//                ms.append(manejoSoporte.getInmovilizacion()
//                ());
//             ms.append(",");
//            }
            if (manejoSoporte.getCollarCervical()!=null) {
                ms.append(manejoSoporte.getCollarCervical());
                ms.append(",");
            }
            if (manejoSoporte.getSsn()!=null) {
                ms.append(manejoSoporte.getSsn());
                ms.append(",");
            }
            if (manejoSoporte.getDad10()!=null) {
                ms.append(manejoSoporte.getDad10());
                ms.append(",");
            }
            if (manejoSoporte.getLRinger()!=null) {
                ms.append(manejoSoporte.getLRinger());
                ms.append(",");
            }
            if (manejoSoporte.getDad5()!=null) {
                ms.append(manejoSoporte.getDad5());
                ms.append(",");
            }
            manejos.add(ms.toString());
        }
 return  manejos;
    }

    public ExamenFisicoConsulta cargarE(ExamenFisico examenFisico) {
        ExamenFisicoConsulta efc = new ExamenFisicoConsulta(examenFisico.getEstadoGeneral(), examenFisico.getConciente(), examenFisico.getAlerta(), examenFisico.getOrientado(), examenFisico.getOtro(), examenFisico.getCabezaCuello(), examenFisico.getAparatoCardiovascular(), examenFisico.getAparatoRespiratorio(), examenFisico.getAbdomen(), examenFisico.getUrogenital(), examenFisico.getGinecobtetrico(), examenFisico.getExtremidades(), examenFisico.getSistemaNervioso());
        efc.setDetalleExamenFisicoCollection(new ArrayList<DetalleExamenFisico>(examenFisico.getDetalleExamenFisicoCollection()));
        return efc;
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
     * @return the epicrisis
     */
    public List<String> getEpicrisis() {
        return epicrisis;
    }

    /**
     * @param epicrisis the epicrisis to set
     */
    public void setEpicrisis(List<String> epicrisis) {
        this.epicrisis = epicrisis;
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
}
