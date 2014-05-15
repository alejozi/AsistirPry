/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.To;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "medicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m"),
    @NamedQuery(name = "Medicamento.findById", query = "SELECT m FROM Medicamento m WHERE m.id = :id"),
    @NamedQuery(name = "Medicamento.findByNombreMedicamento", query = "SELECT m FROM Medicamento m WHERE m.nombreMedicamento = :nombreMedicamento"),
    @NamedQuery(name = "Medicamento.findByVia", query = "SELECT m FROM Medicamento m WHERE m.via = :via"),
    @NamedQuery(name = "Medicamento.findByCantidad", query = "SELECT m FROM Medicamento m WHERE m.cantidad = :cantidad")})
public class Medicamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre_medicamento")
    private String nombreMedicamento;
    @Column(name = "via")
    private String via;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "fk_cita", referencedColumnName = "id")
    @ManyToOne
    private Cita fkCita;

    public Medicamento() {
    }

    public Medicamento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Cita getFkCita() {
        return fkCita;
    }

    public void setFkCita(Cita fkCita) {
        this.fkCita = fkCita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.asistir.To.Medicamento[ id=" + id + " ]";
    }
    
}
