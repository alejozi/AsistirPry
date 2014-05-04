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

/**
 *
 * @author Dany
 */
@Entity
@Table(name = "ante")
@NamedQueries({
    @NamedQuery(name = "Ante.findAll", query = "SELECT a FROM Ante a"),
    @NamedQuery(name = "Ante.findByIdAntecedentes", query = "SELECT a FROM Ante a WHERE a.idAntecedentes = :idAntecedentes"),
    @NamedQuery(name = "Ante.findByPatologicos", query = "SELECT a FROM Ante a WHERE a.patologicos = :patologicos"),
    @NamedQuery(name = "Ante.findByFarmacologicos", query = "SELECT a FROM Ante a WHERE a.farmacologicos = :farmacologicos"),
    @NamedQuery(name = "Ante.findByQuirurgicos", query = "SELECT a FROM Ante a WHERE a.quirurgicos = :quirurgicos"),
    @NamedQuery(name = "Ante.findByAlergicos", query = "SELECT a FROM Ante a WHERE a.alergicos = :alergicos"),
    @NamedQuery(name = "Ante.findByFamiliares", query = "SELECT a FROM Ante a WHERE a.familiares = :familiares"),
    @NamedQuery(name = "Ante.findByMenarquia", query = "SELECT a FROM Ante a WHERE a.menarquia = :menarquia"),
    @NamedQuery(name = "Ante.findByFur", query = "SELECT a FROM Ante a WHERE a.fur = :fur"),
    @NamedQuery(name = "Ante.findByTipoFur", query = "SELECT a FROM Ante a WHERE a.tipoFur = :tipoFur")})
public class Ante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_antecedentes")
    private Integer idAntecedentes;
    @Column(name = "patologicos")
    private String patologicos;
    @Column(name = "farmacologicos")
    private String farmacologicos;
    @Column(name = "quirurgicos")
    private String quirurgicos;
    @Column(name = "alergicos")
    private String alergicos;
    @Column(name = "familiares")
    private String familiares;
    @Column(name = "menarquia")
    private String menarquia;
    @Column(name = "fur")
    private String fur;
    @Column(name = "tipo_fur")
    private String tipoFur;
    @OneToMany(mappedBy = "fkAnte")
    private Collection<Persona> personaCollection;

    public Ante() {
    }

    public Ante(Integer idAntecedentes) {
        this.idAntecedentes = idAntecedentes;
    }

    public Integer getIdAntecedentes() {
        return idAntecedentes;
    }

    public void setIdAntecedentes(Integer idAntecedentes) {
        this.idAntecedentes = idAntecedentes;
    }

    public String getPatologicos() {
        return patologicos;
    }

    public void setPatologicos(String patologicos) {
        this.patologicos = patologicos;
    }

    public String getFarmacologicos() {
        return farmacologicos;
    }

    public void setFarmacologicos(String farmacologicos) {
        this.farmacologicos = farmacologicos;
    }

    public String getQuirurgicos() {
        return quirurgicos;
    }

    public void setQuirurgicos(String quirurgicos) {
        this.quirurgicos = quirurgicos;
    }

    public String getAlergicos() {
        return alergicos;
    }

    public void setAlergicos(String alergicos) {
        this.alergicos = alergicos;
    }

    public String getFamiliares() {
        return familiares;
    }

    public void setFamiliares(String familiares) {
        this.familiares = familiares;
    }

    public String getMenarquia() {
        return menarquia;
    }

    public void setMenarquia(String menarquia) {
        this.menarquia = menarquia;
    }

    public String getFur() {
        return fur;
    }

    public void setFur(String fur) {
        this.fur = fur;
    }

    public String getTipoFur() {
        return tipoFur;
    }

    public void setTipoFur(String tipoFur) {
        this.tipoFur = tipoFur;
    }

    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAntecedentes != null ? idAntecedentes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ante)) {
            return false;
        }
        Ante other = (Ante) object;
        if ((this.idAntecedentes == null && other.idAntecedentes != null) || (this.idAntecedentes != null && !this.idAntecedentes.equals(other.idAntecedentes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.asistir.To.Ante[ idAntecedentes=" + idAntecedentes + " ]";
    }
    
}
