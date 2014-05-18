/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.asistir.To;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hectoridarraga
 */
@Entity
@Table(name = "CIE10")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cie10.findAll", query = "SELECT c FROM Cie10 c"),
    @NamedQuery(name = "Cie10.findByCod", query = "SELECT c FROM Cie10 c WHERE c.cod = :cod"),
    @NamedQuery(name = "Cie10.findByDescripcion", query = "SELECT c FROM Cie10 c WHERE c.descripcion = :descripcion")})
public class Cie10 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod")
    private String cod;
    @Column(name = "descripcion")
    private String descripcion;

    public Cie10() {
    }

    public Cie10(String cod) {
        this.cod = cod;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cod != null ? cod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cie10)) {
            return false;
        }
        Cie10 other = (Cie10) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.asistir.To.Cie10[ cod=" + cod + " ]";
    }
    
}
