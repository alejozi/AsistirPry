/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.To;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "profesional_encargado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfesionalEncargado.findAll", query = "SELECT p FROM ProfesionalEncargado p"),
    @NamedQuery(name = "ProfesionalEncargado.findById", query = "SELECT p FROM ProfesionalEncargado p WHERE p.id = :id"),
    @NamedQuery(name = "ProfesionalEncargado.findByNombre", query = "SELECT p FROM ProfesionalEncargado p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProfesionalEncargado.findByCargo", query = "SELECT p FROM ProfesionalEncargado p WHERE p.cargo = :cargo"),
    @NamedQuery(name = "ProfesionalEncargado.findByFechaInclusion", query = "SELECT p FROM ProfesionalEncargado p WHERE p.fechaInclusion = :fechaInclusion"),
    @NamedQuery(name = "ProfesionalEncargado.findByMotivoInclusion", query = "SELECT p FROM ProfesionalEncargado p WHERE p.motivoInclusion = :motivoInclusion"),
    @NamedQuery(name = "ProfesionalEncargado.findByCuidadorPrincipal", query = "SELECT p FROM ProfesionalEncargado p WHERE p.cuidadorPrincipal = :cuidadorPrincipal")})
public class ProfesionalEncargado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "fecha_inclusion")
    @Temporal(TemporalType.DATE)
    private Date fechaInclusion;
    @Column(name = "motivo_inclusion")
    private String motivoInclusion;
    @Column(name = "cuidador_principal")
    private String cuidadorPrincipal;
    @OneToMany(mappedBy = "fkProfesional")
    private Set<Cita> citaCollection;

    public ProfesionalEncargado() {
    }

    public ProfesionalEncargado(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaInclusion() {
        return fechaInclusion;
    }

    public void setFechaInclusion(Date fechaInclusion) {
        this.fechaInclusion = fechaInclusion;
    }

    public String getMotivoInclusion() {
        return motivoInclusion;
    }

    public void setMotivoInclusion(String motivoInclusion) {
        this.motivoInclusion = motivoInclusion;
    }

    public String getCuidadorPrincipal() {
        return cuidadorPrincipal;
    }

    public void setCuidadorPrincipal(String cuidadorPrincipal) {
        this.cuidadorPrincipal = cuidadorPrincipal;
    }

    @XmlTransient
    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    public void setCitaCollection(Set<Cita> citaCollection) {
        this.citaCollection = citaCollection;
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
        if (!(object instanceof ProfesionalEncargado)) {
            return false;
        }
        ProfesionalEncargado other = (ProfesionalEncargado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.asistir.To.ProfesionalEncargado[ id=" + id + " ]";
    }
    
}
