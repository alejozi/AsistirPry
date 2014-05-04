/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.To;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "acompanante")
@NamedQueries({
    @NamedQuery(name = "Acompanante.findAll", query = "SELECT a FROM Acompanante a"),
    @NamedQuery(name = "Acompanante.findById", query = "SELECT a FROM Acompanante a WHERE a.id = :id"),
    @NamedQuery(name = "Acompanante.findByNroDoc", query = "SELECT a FROM Acompanante a WHERE a.nroDoc = :nroDoc")})
public class Acompanante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "nombre")
    private byte[] nombre;
    @Column(name = "nro_doc")
    private Integer nroDoc;
    @Lob
    @Column(name = "parentesco")
    private byte[] parentesco;
    @JoinColumn(name = "fk_paciente", referencedColumnName = "id_persona")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona fkPaciente;

    public Acompanante() {
    }

    public Acompanante(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getNombre() {
        return nombre;
    }

    public void setNombre(byte[] nombre) {
        this.nombre = nombre;
    }

    public Integer getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(Integer nroDoc) {
        this.nroDoc = nroDoc;
    }

    public byte[] getParentesco() {
        return parentesco;
    }

    public void setParentesco(byte[] parentesco) {
        this.parentesco = parentesco;
    }

    public Persona getFkPaciente() {
        return fkPaciente;
    }

    public void setFkPaciente(Persona fkPaciente) {
        this.fkPaciente = fkPaciente;
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
        if (!(object instanceof Acompanante)) {
            return false;
        }
        Acompanante other = (Acompanante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.asistir.To.Acompanante[ id=" + id + " ]";
    }
    
}
