/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.asistir.Dao.Autenticacion;

import co.com.asistir.Helper.BaseDaoImplement;
import co.com.asistir.To.Usuario;
import co.com.asistir.Util.JpaEm;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author hectoridarraga
 */
public class AutenticacionDaoImp extends BaseDaoImplement implements AutenticacionDaoI {

    @Override
    public Usuario esUsuarioRegistrado(String sUsuario) {
        EntityManager em = JpaEm.getInstance();

        try {
            em.getTransaction().begin();
            Usuario usuario = null;
            String sQuery = "select u from Usuario u where u.usuarioLogin =:sUsuario";
            Query query = em.createQuery(sQuery);
            query.setParameter("sUsuario", sUsuario);

            List<Usuario> usuarios = query.getResultList();
            em.getTransaction().commit();

            if (usuarios != null && !usuarios.isEmpty()) {
                usuario = usuarios.get(0);

                if (usuario != null) {
                    return usuario;
                }
            }
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            System.out.println("e = " + e.getMessage());
            throw e;
        }

        return null;
    }

    @Override
    public Object guardarUsuario(Usuario usuario) {
        return guardar(usuario);
    }

    public Usuario validarExistenciaUsuario(String sUsuario, String email) {

        EntityManager em = JpaEm.getInstance();
        try {
            if(!em.getTransaction().isActive()){
                System.out.println("en esta registrada no= " );
                em.getTransaction().begin();
            }else{
             System.out.println("en esta registrada si= " );
            }
            Usuario usuario = null;
            String sQuery = "select u from Usuario u where u.usuarioLogin =:sUsuario and u.usuarioEmail=:email";
            Query query = em.createQuery(sQuery);
            query.setParameter("sUsuario", sUsuario);
            query.setParameter("email", email);

            List<Usuario> usuarios = query.getResultList();
            em.getTransaction().commit();

            if (usuarios != null && !usuarios.isEmpty()) {
                usuario = usuarios.get(0);

                if (usuario != null) {
                    return usuario;
                }
            }
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            System.out.println("e = " + e.getMessage());
            throw e;
        }

        return null;
    }
}
