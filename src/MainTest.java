import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eventos");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        // Aquí podés crear y persistir alguna entidad para probar
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
