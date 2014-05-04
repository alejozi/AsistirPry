/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.asistir.Util;

import co.com.asistir.Helper.HelperJpa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author hectoridarraga
 */
public class JpaEm {
    
    static EntityManagerFactory factoriaSession = HelperJpa.getJPAFactory();
 
    
    public static EntityManager getInstance(){
    return factoriaSession.createEntityManager();
    }
}
