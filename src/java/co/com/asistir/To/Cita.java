/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.To;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cita.findAll", query = "SELECT c FROM Cita c"),
    @NamedQuery(name = "Cita.findById", query = "SELECT c FROM Cita c WHERE c.id = :id"),
    @NamedQuery(name = "Cita.findByFecha", query = "SELECT c FROM Cita c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Cita.findByConvenio", query = "SELECT c FROM Cita c WHERE c.convenio = :convenio"),
    @NamedQuery(name = "Cita.findByCodServicio", query = "SELECT c FROM Cita c WHERE c.codServicio = :codServicio"),
    @NamedQuery(name = "Cita.findByMovil", query = "SELECT c FROM Cita c WHERE c.movil = :movil"),
    @NamedQuery(name = "Cita.findByEpicrisis", query = "SELECT c FROM Cita c WHERE c.epicrisis = :epicrisis"),
    @NamedQuery(name = "Cita.findByOrdenesMedicas", query = "SELECT c FROM Cita c WHERE c.ordenesMedicas = :ordenesMedicas"),
    @NamedQuery(name = "Cita.findByNombreMedico", query = "SELECT c FROM Cita c WHERE c.nombreMedico = :nombreMedico"),
    @NamedQuery(name = "Cita.findByEnfermeraAuxiliar", query = "SELECT c FROM Cita c WHERE c.enfermeraAuxiliar = :enfermeraAuxiliar")})
public class Cita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "convenio")
    private String convenio;
    @Column(name = "cod_servicio")
    private String codServicio;
    @Column(name = "movil")
    private String movil;
    @Column(name = "epicrisis")
    private String epicrisis;
    @Column(name = "ordenes_medicas")
    private String ordenesMedicas;
    @Column(name = "nombre_medico")
    private String nombreMedico;
    @Column(name = "enfermera_auxiliar")
    private String enfermeraAuxiliar;
    @JoinColumn(name = "fk_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona fkPersona;
    @JoinColumn(name = "fk_soporte", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    private ManejoSoportes fkSoporte;
    @JoinColumn(name = "fk_examen", referencedColumnName = "id_estado_fisico")
    @ManyToOne
    private ExamenFisico fkExamen;
    @JoinColumn(name = "fk_profesional", referencedColumnName = "id")
    @ManyToOne
    private ProfesionalEncargado fkProfesional;
    @JoinColumn(name = "fk_aleracion_sueno", referencedColumnName = "id")
    @ManyToOne
    private PatronSueno fkAleracionSueno;
    @JoinColumn(name = "fk_patron_cognitivo", referencedColumnName = "id")
    @ManyToOne
    private PatronCognitivo fkPatronCognitivo;
     @JoinColumn(name = "fk_cuidador", referencedColumnName = "ids")
    @ManyToOne
    private Cuidador fkCuidador;
    @OneToMany(mappedBy = "fkCita",fetch = FetchType.EAGER)
    private Set<ImpresionDiagnostica> impresionDiagnosticaCollection;
    @OneToMany(mappedBy = "fkCita", fetch = FetchType.EAGER)
    private Set<Medicamento> medicamentoCollection;
    @OneToMany(mappedBy = "fkCita", fetch = FetchType.EAGER)
    private Set<ManejoSoportes> manejoSoportesSet;

    public Cita() {
    }

    public Cita(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) {
        this.codServicio = codServicio;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEpicrisis() {
        return epicrisis;
    }

    public void setEpicrisis(String epicrisis) {
        this.epicrisis = epicrisis;
    }

    public String getOrdenesMedicas() {
        return ordenesMedicas;
    }

    public void setOrdenesMedicas(String ordenesMedicas) {
        this.ordenesMedicas = ordenesMedicas;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getEnfermeraAuxiliar() {
        return enfermeraAuxiliar;
    }

    public void setEnfermeraAuxiliar(String enfermeraAuxiliar) {
        this.enfermeraAuxiliar = enfermeraAuxiliar;
    }

    public Persona getFkPersona() {
        return fkPersona;
    }

    public void setFkPersona(Persona fkPersona) {
        this.fkPersona = fkPersona;
    }

    public ManejoSoportes getFkSoporte() {
        return fkSoporte;
    }

    public void setFkSoporte(ManejoSoportes fkSoporte) {
        this.fkSoporte = fkSoporte;
    }

    public ExamenFisico getFkExamen() {
        return fkExamen;
    }

    public void setFkExamen(ExamenFisico fkExamen) {
        this.fkExamen = fkExamen;
    }

    @XmlTransient
    public Set<ImpresionDiagnostica> getImpresionDiagnosticaCollection() {
        return impresionDiagnosticaCollection;
    }

    public void setImpresionDiagnosticaCollection(Set<ImpresionDiagnostica> impresionDiagnosticaCollection) {
        this.impresionDiagnosticaCollection = impresionDiagnosticaCollection;
    }

    @XmlTransient
    public Set<Medicamento> getMedicamentoCollection() {
        return medicamentoCollection;
    }

    public void setMedicamentoCollection(Set<Medicamento> medicamentoCollection) {
        this.medicamentoCollection = medicamentoCollection;
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
        if (!(object instanceof Cita)) {
            return false;
        }
        Cita other = (Cita) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.asistir.To.Cita[ id=" + id + " ]";
    }

    /**
     * @return the manejoSoportesSet
     */
    public Set<ManejoSoportes> getManejoSoportesSet() {
        return manejoSoportesSet;
    }

    /**
     * @param manejoSoportesSet the manejoSoportesSet to set
     */
    public void setManejoSoportesSet(Set<ManejoSoportes> manejoSoportesSet) {
        this.manejoSoportesSet = manejoSoportesSet;
    }

    /**
     * @return the fkProfesional
     */
    public ProfesionalEncargado getFkProfesional() {
        return fkProfesional;
    }

    /**
     * @param fkProfesional the fkProfesional to set
     */
    public void setFkProfesional(ProfesionalEncargado fkProfesional) {
        this.fkProfesional = fkProfesional;
    }

    /**
     * @return the fkAleracionSueno
     */
    public PatronSueno getFkAleracionSueno() {
        return fkAleracionSueno;
    }

    /**
     * @param fkAleracionSueno the fkAleracionSueno to set
     */
    public void setFkAleracionSueno(PatronSueno fkAleracionSueno) {
        this.fkAleracionSueno = fkAleracionSueno;
    }

    /**
     * @return the fkPatronCognitivo
     */
    public PatronCognitivo getFkPatronCognitivo() {
        return fkPatronCognitivo;
    }

    /**
     * @param fkPatronCognitivo the fkPatronCognitivo to set
     */
    public void setFkPatronCognitivo(PatronCognitivo fkPatronCognitivo) {
        this.fkPatronCognitivo = fkPatronCognitivo;
    }

    /**
     * @return the fkCuidador
     */
    public Cuidador getFkCuidador() {
        return fkCuidador;
    }

    /**
     * @param fkCuidador the fkCuidador to set
     */
    public void setFkCuidador(Cuidador fkCuidador) {
        this.fkCuidador = fkCuidador;
    }
    
}
