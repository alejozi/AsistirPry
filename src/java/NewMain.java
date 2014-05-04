
import co.com.asistir.Helper.BaseDaoI;
import co.com.asistir.Helper.BaseDaoImplement;
import co.com.asistir.To.Ante;
import co.com.asistir.To.Cita;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dany
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cita cita = new Cita();
        Ante a=new  Ante();
        a.setPatologicos("hhg");
        BaseDaoI b=new BaseDaoImplement();
        b.guardar(a);
        /*EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("AsistirPryPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(cita);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }*/
    }
}
