/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.To;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dany
 */
public class HelperJpa {

    private static final EntityManagerFactory em = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            return Persistence.createEntityManagerFactory("AsistirPryPU");
        } catch (Throwable ex) {
            throw new RuntimeException("Error al crear la factoria de JPA"+ex.getMessage());
        }
    }

    public static EntityManagerFactory getJPAFactory() {
        return em;
    }
}
