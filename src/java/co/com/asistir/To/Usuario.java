/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.To;


import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId"),
    @NamedQuery(name = "Usuario.findByUsuarioLogin", query = "SELECT u FROM Usuario u WHERE u.usuarioLogin = :usuarioLogin"),
    @NamedQuery(name = "Usuario.findByUsuarioPass", query = "SELECT u FROM Usuario u WHERE u.usuarioPass = :usuarioPass"),
    @NamedQuery(name = "Usuario.findByUsuarioEstado", query = "SELECT u FROM Usuario u WHERE u.usuarioEstado = :usuarioEstado"),
    @NamedQuery(name = "Usuario.findByUsuarioNombre", query = "SELECT u FROM Usuario u WHERE u.usuarioNombre = :usuarioNombre"),
    @NamedQuery(name = "Usuario.findByUsuarioApellido", query = "SELECT u FROM Usuario u WHERE u.usuarioApellido = :usuarioApellido"),
    @NamedQuery(name = "Usuario.findByUsuarioCedula", query = "SELECT u FROM Usuario u WHERE u.usuarioCedula = :usuarioCedula")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @Column(name = "usuario_login")
    private String usuarioLogin;
    @Column(name = "usuario_pass")
    private String usuarioPass;
    @Column(name = "usuario_estado")
    private Boolean usuarioEstado;
    @Column(name = "usuario_nombre")
    private String usuarioNombre;
    @Column(name = "usuario_apellido")
    private String usuarioApellido;
    @Column(name = "usuario_cedula")
    private BigInteger usuarioCedula;
    //@OneToMany(mappedBy = "fkVentaResponsable")
    //private List<Venta> ventaList;
    @Column(name = "usuario_email")
    private String usuarioEmail;

    public Usuario() {
    }

    public Usuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getUsuarioPass() {
        return usuarioPass;
    }

    public void setUsuarioPass(String usuarioPass) {
        this.usuarioPass = usuarioPass;
    }

    public Boolean getUsuarioEstado() {
        return usuarioEstado;
    }

    public void setUsuarioEstado(Boolean usuarioEstado) {
        this.usuarioEstado = usuarioEstado;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioApellido() {
        return usuarioApellido;
    }

    public void setUsuarioApellido(String usuarioApellido) {
        this.usuarioApellido = usuarioApellido;
    }

    public BigInteger getUsuarioCedula() {
        return usuarioCedula;
    }

    public void setUsuarioCedula(BigInteger usuarioCedula) {
        this.usuarioCedula = usuarioCedula;
    }

   /*
    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.venecia.To.Usuario[ usuarioId=" + usuarioId + " ]";
    }

    /**
     * @return the usuarioEmail
     */
    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    /**
     * @param usuarioEmail the usuarioEmail to set
     */
    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }
    
}
