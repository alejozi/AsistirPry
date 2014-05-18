/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.asistir.Consulta;

import java.util.Date;
import java.util.List;

/**
 *
 * @author hectoridarraga
 */
public class ConsultaOrdenesMedicas {
    private String Medico;
    private Date fecha;
    
    private List<String> lstOrdenesMededicas;

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
     * @return the lstOrdenesMededicas
     */
    public List<String> getLstOrdenesMededicas() {
        return lstOrdenesMededicas;
    }

    /**
     * @param lstOrdenesMededicas the lstOrdenesMededicas to set
     */
    public void setLstOrdenesMededicas(List<String> lstOrdenesMededicas) {
        this.lstOrdenesMededicas = lstOrdenesMededicas;
    }
}
