/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.To;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "examen_fisico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamenFisico.findAll", query = "SELECT e FROM ExamenFisico e"),
    @NamedQuery(name = "ExamenFisico.findByIdEstadoFisico", query = "SELECT e FROM ExamenFisico e WHERE e.idEstadoFisico = :idEstadoFisico"),
    @NamedQuery(name = "ExamenFisico.findByEstadoGeneral", query = "SELECT e FROM ExamenFisico e WHERE e.estadoGeneral = :estadoGeneral"),
    @NamedQuery(name = "ExamenFisico.findByConciente", query = "SELECT e FROM ExamenFisico e WHERE e.conciente = :conciente"),
    @NamedQuery(name = "ExamenFisico.findByAlerta", query = "SELECT e FROM ExamenFisico e WHERE e.alerta = :alerta"),
    @NamedQuery(name = "ExamenFisico.findByOrientado", query = "SELECT e FROM ExamenFisico e WHERE e.orientado = :orientado"),
    @NamedQuery(name = "ExamenFisico.findByOtro", query = "SELECT e FROM ExamenFisico e WHERE e.otro = :otro"),
    @NamedQuery(name = "ExamenFisico.findByCabezaCuello", query = "SELECT e FROM ExamenFisico e WHERE e.cabezaCuello = :cabezaCuello"),
    @NamedQuery(name = "ExamenFisico.findByAparatoCardiovascular", query = "SELECT e FROM ExamenFisico e WHERE e.aparatoCardiovascular = :aparatoCardiovascular"),
    @NamedQuery(name = "ExamenFisico.findByAparatoRespiratorio", query = "SELECT e FROM ExamenFisico e WHERE e.aparatoRespiratorio = :aparatoRespiratorio"),
    @NamedQuery(name = "ExamenFisico.findByAbdomen", query = "SELECT e FROM ExamenFisico e WHERE e.abdomen = :abdomen"),
    @NamedQuery(name = "ExamenFisico.findByUrogenital", query = "SELECT e FROM ExamenFisico e WHERE e.urogenital = :urogenital"),
    @NamedQuery(name = "ExamenFisico.findByGinecobtetrico", query = "SELECT e FROM ExamenFisico e WHERE e.ginecobtetrico = :ginecobtetrico"),
    @NamedQuery(name = "ExamenFisico.findByExtremidades", query = "SELECT e FROM ExamenFisico e WHERE e.extremidades = :extremidades"),
    @NamedQuery(name = "ExamenFisico.findBySistemaNervioso", query = "SELECT e FROM ExamenFisico e WHERE e.sistemaNervioso = :sistemaNervioso")})
public class ExamenFisico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_fisico")
    private Integer idEstadoFisico;
    @Column(name = "estado_general")
    private Character estadoGeneral;
    @Column(name = "conciente")
    private Character conciente;
    @Column(name = "alerta")
    private Character alerta;
    @Column(name = "orientado")
    private Character orientado;
    @Column(name = "otro")
    private Character otro;
    @Column(name = "cabeza_cuello")
    private String cabezaCuello;
    @Column(name = "aparato_cardiovascular")
    private String aparatoCardiovascular;
    @Column(name = "aparato_respiratorio")
    private String aparatoRespiratorio;
    @Column(name = "abdomen")
    private String abdomen;
    @Column(name = "urogenital")
    private String urogenital;
    @Column(name = "ginecobtetrico")
    private String ginecobtetrico;
    @Column(name = "extremidades")
    private String extremidades;
    @Column(name = "sistema_nervioso")
    private String sistemaNervioso;
    @OneToMany(mappedBy = "fkExamenFisico",fetch = FetchType.EAGER)
    @Cascade({CascadeType.SAVE_UPDATE})
    private Set<DetalleExamenFisico> detalleExamenFisicoCollection;
    @OneToMany(mappedBy = "fkExamen")
    private Collection<Cita> citaCollection;
    @Transient
     private List<String> estadosFisicos2; 	

    public ExamenFisico() {
         estadosFisicos2 = new ArrayList<String>();
    }

    public ExamenFisico(Integer idEstadoFisico) {
        this.idEstadoFisico = idEstadoFisico;
    }

    public Integer getIdEstadoFisico() {
        return idEstadoFisico;
    }

    public void setIdEstadoFisico(Integer idEstadoFisico) {
        this.idEstadoFisico = idEstadoFisico;
    }

    public Character getEstadoGeneral() {
        return estadoGeneral;
    }

    public void setEstadoGeneral(Character estadoGeneral) {
        this.estadoGeneral = estadoGeneral;
    }

    public Character getConciente() {
        return conciente;
    }

    public void setConciente(Character conciente) {
        this.conciente = conciente;
    }

    public Character getAlerta() {
        return alerta;
    }

    public void setAlerta(Character alerta) {
        this.alerta = alerta;
    }

    public Character getOrientado() {
        return orientado;
    }

    public void setOrientado(Character orientado) {
        this.orientado = orientado;
    }

    public Character getOtro() {
        return otro;
    }

    public void setOtro(Character otro) {
        this.otro = otro;
    }

    public String getCabezaCuello() {
        return cabezaCuello;
    }

    public void setCabezaCuello(String cabezaCuello) {
        this.cabezaCuello = cabezaCuello;
    }

    public String getAparatoCardiovascular() {
        return aparatoCardiovascular;
    }

    public void setAparatoCardiovascular(String aparatoCardiovascular) {
        this.aparatoCardiovascular = aparatoCardiovascular;
    }

    public String getAparatoRespiratorio() {
        return aparatoRespiratorio;
    }

    public void setAparatoRespiratorio(String aparatoRespiratorio) {
        this.aparatoRespiratorio = aparatoRespiratorio;
    }

    public String getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    public String getUrogenital() {
        return urogenital;
    }

    public void setUrogenital(String urogenital) {
        this.urogenital = urogenital;
    }

    public String getGinecobtetrico() {
        return ginecobtetrico;
    }

    public void setGinecobtetrico(String ginecobtetrico) {
        this.ginecobtetrico = ginecobtetrico;
    }

    public String getExtremidades() {
        return extremidades;
    }

    public void setExtremidades(String extremidades) {
        this.extremidades = extremidades;
    }

    public String getSistemaNervioso() {
        return sistemaNervioso;
    }

    public void setSistemaNervioso(String sistemaNervioso) {
        this.sistemaNervioso = sistemaNervioso;
    }

    @XmlTransient
    public Set<DetalleExamenFisico> getDetalleExamenFisicoCollection() {
        return detalleExamenFisicoCollection;
    }

    public void setDetalleExamenFisicoCollection(Set<DetalleExamenFisico> detalleExamenFisicoCollection) {
        this.detalleExamenFisicoCollection = detalleExamenFisicoCollection;
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
        hash += (idEstadoFisico != null ? idEstadoFisico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExamenFisico)) {
            return false;
        }
        ExamenFisico other = (ExamenFisico) object;
        if ((this.idEstadoFisico == null && other.idEstadoFisico != null) || (this.idEstadoFisico != null && !this.idEstadoFisico.equals(other.idEstadoFisico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.asistir.To.ExamenFisico[ idEstadoFisico=" + idEstadoFisico + " ]";
    }

    /**
     * @return the estadosFisicos2
     */
    public List<String> getEstadosFisicos2() {
        return estadosFisicos2;
    }

    /**
     * @param estadosFisicos2 the estadosFisicos2 to set
     */
    public void setEstadosFisicos2(List<String> estadosFisicos2) {
        this.estadosFisicos2 = estadosFisicos2;
    }
    
}
