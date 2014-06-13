/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.To;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "patron_cognitivo")
@XmlRootElement
public class PatronCognitivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "alteracion_visual")
    private Boolean alteracionVisual;
    @Column(name = "tipo_alteracion_visual")
    private String tipoAlteracionVisual;
    @Column(name = "alteracion_auditiva")
    private Boolean alteracionAuditiva;
    @Column(name = "tipo_alteracion_auditiva")
    private String tipoAlteracionAuditiva;
    @OneToMany(mappedBy = "fkPatronCognitivo")
    private Set<Cita> citaCollection;

    public PatronCognitivo() {
    }

    public PatronCognitivo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAlteracionVisual() {
        return alteracionVisual;
    }

    public void setAlteracionVisual(Boolean alteracionVisual) {
        this.alteracionVisual = alteracionVisual;
    }

    public String getTipoAlteracionVisual() {
        return tipoAlteracionVisual;
    }

    public void setTipoAlteracionVisual(String tipoAlteracionVisual) {
        this.tipoAlteracionVisual = tipoAlteracionVisual;
    }

    public Boolean getAlteracionAuditiva() {
        return alteracionAuditiva;
    }

    public void setAlteracionAuditiva(Boolean alteracionAuditiva) {
        this.alteracionAuditiva = alteracionAuditiva;
    }

    public String getTipoAlteracionAuditiva() {
        return tipoAlteracionAuditiva;
    }

    public void setTipoAlteracionAuditiva(String tipoAlteracionAuditiva) {
        this.tipoAlteracionAuditiva = tipoAlteracionAuditiva;
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
        if (!(object instanceof PatronCognitivo)) {
            return false;
        }
        PatronCognitivo other = (PatronCognitivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.asistir.To.PatronCognitivo[ id=" + id + " ]";
    }
    
}
