/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.To;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "detalle_examen_fisico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleExamenFisico.findAll", query = "SELECT d FROM DetalleExamenFisico d"),
    @NamedQuery(name = "DetalleExamenFisico.findByIdDetalle", query = "SELECT d FROM DetalleExamenFisico d WHERE d.idDetalle = :idDetalle"),
    @NamedQuery(name = "DetalleExamenFisico.findByHora", query = "SELECT d FROM DetalleExamenFisico d WHERE d.hora = :hora"),
    @NamedQuery(name = "DetalleExamenFisico.findByTensionArterial", query = "SELECT d FROM DetalleExamenFisico d WHERE d.tensionArterial = :tensionArterial"),
    @NamedQuery(name = "DetalleExamenFisico.findByFc", query = "SELECT d FROM DetalleExamenFisico d WHERE d.fc = :fc"),
    @NamedQuery(name = "DetalleExamenFisico.findByFr", query = "SELECT d FROM DetalleExamenFisico d WHERE d.fr = :fr"),
    @NamedQuery(name = "DetalleExamenFisico.findByT", query = "SELECT d FROM DetalleExamenFisico d WHERE d.t = :t"),
    @NamedQuery(name = "DetalleExamenFisico.findBySpo2", query = "SELECT d FROM DetalleExamenFisico d WHERE d.spo2 = :spo2"),
    @NamedQuery(name = "DetalleExamenFisico.findByPeso", query = "SELECT d FROM DetalleExamenFisico d WHERE d.peso = :peso"),
    @NamedQuery(name = "DetalleExamenFisico.findByGlasgow", query = "SELECT d FROM DetalleExamenFisico d WHERE d.glasgow = :glasgow")})
public class DetalleExamenFisico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle")
    private Integer idDetalle;
    @Column(name = "hora")
    private Integer hora;
    @Column(name = "tension_arterial")
    private BigInteger tensionArterial;
    @Column(name = "fc")
    private BigInteger fc;
    @Column(name = "fr")
    private BigInteger fr;
    @Column(name = "t")
    private BigInteger t;
    @Column(name = "spo2")
    private BigInteger spo2;
    @Column(name = "peso")
    private BigInteger peso;
    @Column(name = "glasgow")
    private BigInteger glasgow;
    @JoinColumn(name = "fk_examen_fisico", referencedColumnName = "id_estado_fisico")
    @ManyToOne
    private ExamenFisico fkExamenFisico;
    @Transient
    private boolean habilitarBoton;

    public DetalleExamenFisico() {
    }

    public DetalleExamenFisico(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public BigInteger getTensionArterial() {
        return tensionArterial;
    }

    public void setTensionArterial(BigInteger tensionArterial) {
        this.tensionArterial = tensionArterial;
    }

    public BigInteger getFc() {
        return fc;
    }

    public void setFc(BigInteger fc) {
        this.fc = fc;
    }

    public BigInteger getFr() {
        return fr;
    }

    public void setFr(BigInteger fr) {
        this.fr = fr;
    }

    public BigInteger getT() {
        return t;
    }

    public void setT(BigInteger t) {
        this.t = t;
    }

    public BigInteger getSpo2() {
        return spo2;
    }

    public void setSpo2(BigInteger spo2) {
        this.spo2 = spo2;
    }

    public BigInteger getPeso() {
        return peso;
    }

    public void setPeso(BigInteger peso) {
        this.peso = peso;
    }

    public BigInteger getGlasgow() {
        return glasgow;
    }

    public void setGlasgow(BigInteger glasgow) {
        this.glasgow = glasgow;
    }

    public ExamenFisico getFkExamenFisico() {
        return fkExamenFisico;
    }

    public void setFkExamenFisico(ExamenFisico fkExamenFisico) {
        this.fkExamenFisico = fkExamenFisico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleExamenFisico)) {
            return false;
        }
        DetalleExamenFisico other = (DetalleExamenFisico) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.asistir.To.DetalleExamenFisico[ idDetalle=" + idDetalle + " ]";
    }

    /**
     * @return the habilitarBoton
     */
    public boolean isHabilitarBoton() {
        return habilitarBoton;
    }

    /**
     * @param habilitarBoton the habilitarBoton to set
     */
    public void setHabilitarBoton(boolean habilitarBoton) {
        this.habilitarBoton = habilitarBoton;
    }
    
}
