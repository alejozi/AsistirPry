/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.To;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "persona")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
    @NamedQuery(name = "Persona.findByApellidos", query = "SELECT p FROM Persona p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Persona.findByAseguradora", query = "SELECT p FROM Persona p WHERE p.aseguradora = :aseguradora"),
    @NamedQuery(name = "Persona.findByCelular", query = "SELECT p FROM Persona p WHERE p.celular = :celular"),
    @NamedQuery(name = "Persona.findByCiudad", query = "SELECT p FROM Persona p WHERE p.ciudad = :ciudad"),
    @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Persona.findByEdad", query = "SELECT p FROM Persona p WHERE p.edad = :edad"),
    @NamedQuery(name = "Persona.findByEstadoCivil", query = "SELECT p FROM Persona p WHERE p.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Persona.findByFechaNac", query = "SELECT p FROM Persona p WHERE p.fechaNac = :fechaNac"),
    @NamedQuery(name = "Persona.findByNombres", query = "SELECT p FROM Persona p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Persona.findByOcupacion", query = "SELECT p FROM Persona p WHERE p.ocupacion = :ocupacion"),
    @NamedQuery(name = "Persona.findBySexo", query = "SELECT p FROM Persona p WHERE p.sexo = :sexo"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Persona.findByTipoAseguradora", query = "SELECT p FROM Persona p WHERE p.tipoAseguradora = :tipoAseguradora"),
    @NamedQuery(name = "Persona.findByTipoDocumento", query = "SELECT p FROM Persona p WHERE p.tipoDocumento = :tipoDocumento")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_persona")
    private Integer idPersona;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "aseguradora")
    private String aseguradora;
    @Column(name = "celular")
    private String celular;
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "ocupacion")
    private String ocupacion;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "tipo_aseguradora")
    private String tipoAseguradora;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @JoinColumn(name = "fk_ante", referencedColumnName = "id_antecedentes")
    @ManyToOne
    private Ante fkAnte;    
    @OneToMany(mappedBy = "fkPersona")
    private Collection<Cita> citaCollection;
    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoAseguradora() {
        return tipoAseguradora;
    }

    public void setTipoAseguradora(String tipoAseguradora) {
        this.tipoAseguradora = tipoAseguradora;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Ante getFkAnte() {
        return fkAnte;
    }

    public void setFkAnte(Ante fkAnte) {
        this.fkAnte = fkAnte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.asistir.To.Persona[ idPersona=" + idPersona + " ]";
    }

    /**
     * @return the citaCollection
     */
    public Collection<Cita> getCitaCollection() {
        return citaCollection;
    }

    /**
     * @param citaCollection the citaCollection to set
     */
    public void setCitaCollection(Collection<Cita> citaCollection) {
        this.citaCollection = citaCollection;
    }
    
}
