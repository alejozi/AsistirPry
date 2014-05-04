/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Util;

import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Dany
 */
public class Utilidades {

    public static Object obtenerSessionBean(String nombreBean) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext extCtx = ctx.getExternalContext();
        Map<String, Object> sessionMap = extCtx.getSessionMap();
        return sessionMap.get(nombreBean);
    }

    public static boolean estaActivaTransaccion(EntityTransaction tx) {
        if (tx.isActive()) {
            return true;
        }
        return false;
    }
}
