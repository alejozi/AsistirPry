/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.beans;

import co.com.asistir.Service.Autenticacion.AutenticacionI;
import co.com.asistir.Service.Autenticacion.AutenticacionServiceImplement;
import co.com.asistir.To.Usuario;
import co.com.asistir.Util.Tools;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author hectoridarraga
 */
@ManagedBean
@SessionScoped
public class AutenticacionManagedBean implements Serializable {

    AutenticacionI autenticacion;

    public  static String USER_KEY;

    public static Usuario usuario;

    public AutenticacionManagedBean() {
        usuario = new Usuario();
        USER_KEY=null;
        autenticacion = new AutenticacionServiceImplement();
        }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void doLogin() {
        Usuario usuarioBD = autenticacion.esUsuarioRegistradoServiceImplement(usuario.getUsuarioLogin());
        String huella = Tools.generateMD5Signature(usuario.getUsuarioPass());
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extContext = context.getExternalContext();
        String url = "";

        if (usuarioBD != null) {
            if (huella.equals(usuarioBD.getUsuarioPass())) {
                usuario=usuarioBD;
                USER_KEY= "auth_user";
                url = extContext.encodeActionURL(
                        context.getApplication().getViewHandler().getActionURL(context, "/Inicio.xhtml"));
                extContext.getSessionMap().put(USER_KEY, usuario);
                try {
                    extContext.redirect(url);
                } catch (IOException ex) {
                    Logger.getLogger(AutenticacionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El usuario no existe", ""));

        }
    }

    public void guardarUsuario() {
        if (autenticacion.validarExistenciaUsuario(usuario.getUsuarioLogin(), usuario.getUsuarioEmail()) == null) {
            usuario.setUsuarioPass(Tools.generateMD5Signature(usuario.getUsuarioPass()));
            if (autenticacion.GuardarUsuario(usuario) != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El usuario se registró con éxito", ""));

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "por favor verifique, el usuario no se pudo guardar.", ""));

            }
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El nombre de usuario e e-mail ya están registrados", ""));
        }
    }
}
