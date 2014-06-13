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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "manejo_soportes")
public class ManejoSoportes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "lev")
    private String lev;
    @Column(name = "lav_gastrica")
    private String lavGastrica;
    @Column(name = "rcp")
    private String rcp;
    @Column(name = "o2")
    private String o2;
    @Column(name = "curacion")
    private String curacion;
    @Column(name = "cateter")
    private String cateter;
    @Column(name = "nasogastrica")
    private String nasogastrica;
    @Column(name = "vesical")
    private String vesical;
    @Column(name = "orogastrica")
    private String orogastrica;
    @Column(name = "aspiracion")
    private String aspiracion;
    @Column(name = "intubacion")
    private String intubacion;
    @Column(name = "hood")
    private String hood;
    @Column(name = "bvm")
    private String bvm;
    @Column(name = "canula")
    private String canula;
    @Column(name = "oximetria")
    private String oximetria;
    @Column(name = "nebulizacion")
    private String nebulizacion;
    @Column(name = "venturi")
    private String venturi;
    @Column(name = "fio")
    private String fio;
    @Column(name = "volumen")
    private String volumen;
    @Column(name = "flujo")
    private String flujo;
    @Column(name = "pep")
    private String pep;
    @Column(name = "monitoreo")
    private String monitoreo;
    @Column(name = "cardioversion")
    private String cardioversion;
    @Column(name = "maniobras")
    private String maniobras;
    @Column(name = "desfibrilacion")
    private String desfibrilacion;
    @Column(name = "sutura")
    private String sutura;
    @Column(name = "control_hemorragia")
    private String controlHemorragia;
    @Column(name = "kendrick")
    private String kendrick;
    @Column(name = "tabla_rigida")
    private String tablaRigida;
    @Column(name = "collar_cervical")
    private String collarCervical;
    @Column(name = "ssn")
    private String ssn;
    @Column(name = "l_ringer")
    private String lRinger;
    @Column(name = "dad5")
    private String dad5;
    @Column(name = "dad10")
    private String dad10;
    @OneToMany(mappedBy = "fkSoporte")
    private Collection<Cita> citaCollection;
    @JoinColumn(name = "fk_cita", referencedColumnName = "id")
    @ManyToOne
    private Cita fkCita;


    public ManejoSoportes() {
    }

    public ManejoSoportes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public String getLev() {
        return lev;
    }

    public void setLev(String lev) {
        this.lev = lev;
    }

    public String getLavGastrica() {
        return lavGastrica;
    }

    public void setLavGastrica(String lavGastrica) {
        this.lavGastrica = lavGastrica;
    }

    public String getRcp() {
        return rcp;
    }

    public void setRcp(String rcp) {
        this.rcp = rcp;
    }

    public String getO2() {
        return o2;
    }

    public void setO2(String o2) {
        this.o2 = o2;
    }

    public String getCuracion() {
        return curacion;
    }

    public void setCuracion(String curacion) {
        this.curacion = curacion;
    }

    public String getCateter() {
        return cateter;
    }

    public void setCateter(String cateter) {
        this.cateter = cateter;
    }

    public String getNasogastrica() {
        return nasogastrica;
    }

    public void setNasogastrica(String nasogastrica) {
        this.nasogastrica = nasogastrica;
    }

    public String getVesical() {
        return vesical;
    }

    public void setVesical(String vesical) {
        this.vesical = vesical;
    }

    public String getOrogastrica() {
        return orogastrica;
    }

    public void setOrogastrica(String orogastrica) {
        this.orogastrica = orogastrica;
    }

    public String getAspiracion() {
        return aspiracion;
    }

    public void setAspiracion(String aspiracion) {
        this.aspiracion = aspiracion;
    }

    public String getIntubacion() {
        return intubacion;
    }

    public void setIntubacion(String intubacion) {
        this.intubacion = intubacion;
    }

    public String getHood() {
        return hood;
    }

    public void setHood(String hood) {
        this.hood = hood;
    }

    public String getBvm() {
        return bvm;
    }

    public void setBvm(String bvm) {
        this.bvm = bvm;
    }

    public String getCanula() {
        return canula;
    }

    public void setCanula(String canula) {
        this.canula = canula;
    }

    public String getOximetria() {
        return oximetria;
    }

    public void setOximetria(String oximetria) {
        this.oximetria = oximetria;
    }

    public String getNebulizacion() {
        return nebulizacion;
    }

    public void setNebulizacion(String nebulizacion) {
        this.nebulizacion = nebulizacion;
    }

    public String getVenturi() {
        return venturi;
    }

    public void setVenturi(String venturi) {
        this.venturi = venturi;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getFlujo() {
        return flujo;
    }

    public void setFlujo(String flujo) {
        this.flujo = flujo;
    }

    public String getPep() {
        return pep;
    }

    public void setPep(String pep) {
        this.pep = pep;
    }

    public String getMonitoreo() {
        return monitoreo;
    }

    public void setMonitoreo(String monitoreo) {
        this.monitoreo = monitoreo;
    }

    public String getCardioversion() {
        return cardioversion;
    }

    public void setCardioversion(String cardioversion) {
        this.cardioversion = cardioversion;
    }

    public String getManiobras() {
        return maniobras;
    }

    public void setManiobras(String maniobras) {
        this.maniobras = maniobras;
    }

    public String getDesfibrilacion() {
        return desfibrilacion;
    }

    public void setDesfibrilacion(String desfibrilacion) {
        this.desfibrilacion = desfibrilacion;
    }

    public String getSutura() {
        return sutura;
    }

    public void setSutura(String sutura) {
        this.sutura = sutura;
    }

    public String getControlHemorragia() {
        return controlHemorragia;
    }

    public void setControlHemorragia(String controlHemorragia) {
        this.controlHemorragia = controlHemorragia;
    }

    public String getKendrick() {
        return kendrick;
    }

    public void setKendrick(String kendrick) {
        this.kendrick = kendrick;
    }

    public String getTablaRigida() {
        return tablaRigida;
    }

    public void setTablaRigida(String tablaRigida) {
        this.tablaRigida = tablaRigida;
    }

    public String getCollarCervical() {
        return collarCervical;
    }

    public void setCollarCervical(String collarCervical) {
        this.collarCervical = collarCervical;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLRinger() {
        return lRinger;
    }

    public void setLRinger(String lRinger) {
        this.lRinger = lRinger;
    }

    public String getDad5() {
        return dad5;
    }

    public void setDad5(String dad5) {
        this.dad5 = dad5;
    }

    public String getDad10() {
        return dad10;
    }

    public void setDad10(String dad10) {
        this.dad10 = dad10;
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
        if (!(object instanceof ManejoSoportes)) {
            return false;
        }
        ManejoSoportes other = (ManejoSoportes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.asistir.To.ManejoSoportes[ id=" + id + " ]";
    }

    /**
     * @return the fkCita
     */
    public Cita getFkCita() {
        return fkCita;
    }

    /**
     * @param fkCita the fkCita to set
     */
    public void setFkCita(Cita fkCita) {
        this.fkCita = fkCita;
    }
    
}
