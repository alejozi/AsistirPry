/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.To;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "cuidador")
@XmlRootElement
public class Cuidador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ids")
    private Integer ids;
    @Column(name = "higiene")
    private Boolean higiene;
    @Column(name = "alimentacion")
    private Boolean alimentacion;
    @Column(name = "movilizacion")
    private Boolean movilizacion;
    @Column(name = "admin_medicamento")
    private Boolean adminMedicamento;
    @Column(name = "carga_cuidador")
    private BigInteger cargaCuidador;
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "fkCuidador")
    private Set<Cita> citaCollection;

    public Cuidador() {
    }

    public Cuidador(Integer ids) {
        this.ids = ids;
    }

    public Integer getIds() {
        return ids;
    }

    public void setIds(Integer ids) {
        this.ids = ids;
    }

    public Boolean getHigiene() {
        return higiene;
    }

    public void setHigiene(Boolean higiene) {
        this.higiene = higiene;
    }

    public Boolean getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(Boolean alimentacion) {
        this.alimentacion = alimentacion;
    }

    public Boolean getMovilizacion() {
        return movilizacion;
    }

    public void setMovilizacion(Boolean movilizacion) {
        this.movilizacion = movilizacion;
    }

    public Boolean getAdminMedicamento() {
        return adminMedicamento;
    }

    public void setAdminMedicamento(Boolean adminMedicamento) {
        this.adminMedicamento = adminMedicamento;
    }

    public BigInteger getCargaCuidador() {
        return cargaCuidador;
    }

    public void setCargaCuidador(BigInteger cargaCuidador) {
        this.cargaCuidador = cargaCuidador;
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
        hash += (ids != null ? ids.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuidador)) {
            return false;
        }
        Cuidador other = (Cuidador) object;
        if ((this.ids == null && other.ids != null) || (this.ids != null && !this.ids.equals(other.ids))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.asistir.To.Cuidador[ ids=" + ids + " ]";
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}
