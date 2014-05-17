/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Util;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

/**
 *
 * @author Dany
 */
public class JsfUtil {
   
     public static Flash flashScope() {
        return (FacesContext.getCurrentInstance().getExternalContext().getFlash());
    }
}
