/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.To;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "patron_sueno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatronSueno.findAll", query = "SELECT p FROM PatronSueno p"),
    @NamedQuery(name = "PatronSueno.findByAltercionSueno", query = "SELECT p FROM PatronSueno p WHERE p.altercionSueno = :altercionSueno"),
    @NamedQuery(name = "PatronSueno.findByTipoAlteracion", query = "SELECT p FROM PatronSueno p WHERE p.tipoAlteracion = :tipoAlteracion"),
    @NamedQuery(name = "PatronSueno.findById", query = "SELECT p FROM PatronSueno p WHERE p.id = :id")})
public class PatronSueno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "altercion_sueno")
    private Boolean altercionSueno;
    @Column(name = "tipo_alteracion")
    private String tipoAlteracion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(mappedBy = "fkAleracionSueno")
    private Collection<Cita> citaCollection;

    public PatronSueno() {
    }

    public PatronSueno(Integer id) {
        this.id = id;
    }

    public Boolean getAltercionSueno() {
        return altercionSueno;
    }

    public void setAltercionSueno(Boolean altercionSueno) {
        this.altercionSueno = altercionSueno;
    }

    public String getTipoAlteracion() {
        return tipoAlteracion;
    }

    public void setTipoAlteracion(String tipoAlteracion) {
        this.tipoAlteracion = tipoAlteracion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    public void setCitaCollection(Collection<Cita> citaCollection) {
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
        if (!(object instanceof PatronSueno)) {
            return false;
        }
        PatronSueno other = (PatronSueno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.asistir.To.PatronSueno[ id=" + id + " ]";
    }
    
}
