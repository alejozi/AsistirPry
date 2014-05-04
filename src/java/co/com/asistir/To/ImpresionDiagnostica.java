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
@Table(name = "impresion_diagnostica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImpresionDiagnostica.findAll", query = "SELECT i FROM ImpresionDiagnostica i"),
    @NamedQuery(name = "ImpresionDiagnostica.findById", query = "SELECT i FROM ImpresionDiagnostica i WHERE i.id = :id"),
    @NamedQuery(name = "ImpresionDiagnostica.findByDescripcion", query = "SELECT i FROM ImpresionDiagnostica i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "ImpresionDiagnostica.findByCodigo", query = "SELECT i FROM ImpresionDiagnostica i WHERE i.codigo = :codigo")})
public class ImpresionDiagnostica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "codigo")
    private String codigo;
    @JoinColumn(name = "fk_cita", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Cita fkCita;

    public ImpresionDiagnostica() {
    }

    public ImpresionDiagnostica(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        if (!(object instanceof ImpresionDiagnostica)) {
            return false;
        }
        ImpresionDiagnostica other = (ImpresionDiagnostica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.asistir.To.ImpresionDiagnostica[ id=" + id + " ]";
    }
    
}
