/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.To;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dany
 */
public class ExamenFisicoConsulta {
    
    private String estadoGeneral;    
    private Character conciente;
    private Character alerta;
    private Character orientado;
    private Character otro;
    private String cabezaCuello;
    private String aparatoCardiovascular;
    private String aparatoRespiratorio;
    private String abdomen;
    private String urogenital;
    private String ginecobtetrico;
    private String extremidades;   
    private String sistemaNervioso;
    private List<DetalleExamenFisico> detalleExamenFisicoCollection;

    

    public ExamenFisicoConsulta(Character eg, Character conciente, Character alerta, Character orientado, Character otro, String cabezaCuello, String aparatoCardiovascular, String aparatoRespiratorio, String abdomen, String urogenital, String ginecobtetrico, String extremidades, String sistemaNervioso) {
       if(eg!=null){
        if(eg=='b'){
        estadoGeneral="Bueno";
        }else if(eg=='r'){
        estadoGeneral="Regular";
        }else{
        estadoGeneral="Malo";
        }
       }
        this.conciente = conciente;
        this.alerta = alerta;
        this.orientado = orientado;
        this.otro = otro;
        this.cabezaCuello = cabezaCuello;
        this.aparatoCardiovascular = aparatoCardiovascular;
        this.aparatoRespiratorio = aparatoRespiratorio;
        this.abdomen = abdomen;
        this.urogenital = urogenital;
        this.ginecobtetrico = ginecobtetrico;
        this.extremidades = extremidades;
        this.sistemaNervioso = sistemaNervioso;
        
    }
    /**
     * @return the estadoGeneral
     */
    public String getEstadoGeneral() {
        return estadoGeneral;
    }

    /**
     * @param estadoGeneral the estadoGeneral to set
     */
    public void setEstadoGeneral(String estadoGeneral) {
        this.estadoGeneral = estadoGeneral;
    }

    /**
     * @return the conciente
     */
    public Character getConciente() {
        return conciente;
    }

    /**
     * @param conciente the conciente to set
     */
    public void setConciente(Character conciente) {
        this.conciente = conciente;
    }

    /**
     * @return the alerta
     */
    public Character getAlerta() {
        return alerta;
    }

    /**
     * @param alerta the alerta to set
     */
    public void setAlerta(Character alerta) {
        this.alerta = alerta;
    }

    /**
     * @return the orientado
     */
    public Character getOrientado() {
        return orientado;
    }

    /**
     * @param orientado the orientado to set
     */
    public void setOrientado(Character orientado) {
        this.orientado = orientado;
    }

    /**
     * @return the otro
     */
    public Character getOtro() {
        return otro;
    }

    /**
     * @param otro the otro to set
     */
    public void setOtro(Character otro) {
        this.otro = otro;
    }

    /**
     * @return the cabezaCuello
     */
    public String getCabezaCuello() {
        return cabezaCuello;
    }

    /**
     * @param cabezaCuello the cabezaCuello to set
     */
    public void setCabezaCuello(String cabezaCuello) {
        this.cabezaCuello = cabezaCuello;
    }

    /**
     * @return the aparatoCardiovascular
     */
    public String getAparatoCardiovascular() {
        return aparatoCardiovascular;
    }

    /**
     * @param aparatoCardiovascular the aparatoCardiovascular to set
     */
    public void setAparatoCardiovascular(String aparatoCardiovascular) {
        this.aparatoCardiovascular = aparatoCardiovascular;
    }

    /**
     * @return the aparatoRespiratorio
     */
    public String getAparatoRespiratorio() {
        return aparatoRespiratorio;
    }

    /**
     * @param aparatoRespiratorio the aparatoRespiratorio to set
     */
    public void setAparatoRespiratorio(String aparatoRespiratorio) {
        this.aparatoRespiratorio = aparatoRespiratorio;
    }

    /**
     * @return the abdomen
     */
    public String getAbdomen() {
        return abdomen;
    }

    /**
     * @param abdomen the abdomen to set
     */
    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    /**
     * @return the urogenital
     */
    public String getUrogenital() {
        return urogenital;
    }

    /**
     * @param urogenital the urogenital to set
     */
    public void setUrogenital(String urogenital) {
        this.urogenital = urogenital;
    }

    /**
     * @return the ginecobtetrico
     */
    public String getGinecobtetrico() {
        return ginecobtetrico;
    }

    /**
     * @param ginecobtetrico the ginecobtetrico to set
     */
    public void setGinecobtetrico(String ginecobtetrico) {
        this.ginecobtetrico = ginecobtetrico;
    }

    /**
     * @return the extremidades
     */
    public String getExtremidades() {
        return extremidades;
    }

    /**
     * @param extremidades the extremidades to set
     */
    public void setExtremidades(String extremidades) {
        this.extremidades = extremidades;
    }

    /**
     * @return the sistemaNervioso
     */
    public String getSistemaNervioso() {
        return sistemaNervioso;
    }

    /**
     * @param sistemaNervioso the sistemaNervioso to set
     */
    public void setSistemaNervioso(String sistemaNervioso) {
        this.sistemaNervioso = sistemaNervioso;
    }

    /**
     * @return the detalleExamenFisicoCollection
     */
    public List<DetalleExamenFisico> getDetalleExamenFisicoCollection() {
        return detalleExamenFisicoCollection;
    }

    /**
     * @param detalleExamenFisicoCollection the detalleExamenFisicoCollection to set
     */
    public void setDetalleExamenFisicoCollection(List<DetalleExamenFisico> detalleExamenFisicoCollection) {
        this.detalleExamenFisicoCollection = detalleExamenFisicoCollection;
    }
    
}
