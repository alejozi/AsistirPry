/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.asistir.Consulta;

import co.com.asistir.To.ManejoSoportes;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hectoridarraga
 */
public class ConsultaManejoSoportes {
    private String Medico;
    private Date fecha;
    private List<ManejoSoportes> lstManejoSoportes;

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
     * @return the lstManejoSoportes
     */
    public List<ManejoSoportes> getLstManejoSoportes() {
        return lstManejoSoportes;
    }

    /**
     * @param lstManejoSoportes the lstManejoSoportes to set
     */
    public void setLstManejoSoportes(List<ManejoSoportes> lstManejoSoportes) {
        this.lstManejoSoportes = lstManejoSoportes;
    }
    
}
