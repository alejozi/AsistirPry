/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.asistir.Consulta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hectoridarraga
 */
public class ConsultaEpicrisis {
    private String Medico;
    private Date fecha;
    
    

    public ConsultaEpicrisis() {
        lstEpicrisis = new ArrayList<String>();
    }
    
    private List<String> lstEpicrisis;

    /**
     * @return the Medico
     */
    public String getMedico() {
        return Medico;
    }

    /**
     * @param Medico the Medico to set
     */
    public void setMedico(String Medico) {
        this.Medico = Medico;
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
     * @return the lstEpicisis
     */
    public List<String> getLstEpicrisis() {
        return lstEpicrisis;
    }

    /**
     * @param lstEpicisis the lstEpicisis to set
     */
    public void setLstEpicrisis(List<String> lstEpicisis) {
        this.lstEpicrisis = lstEpicisis;
    }
}
