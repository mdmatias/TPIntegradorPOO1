import java.time.LocalDate;

import enums.EstadoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.CicloCine;
import model.Pelicula;

public class MainTest {
    public static void main(String[] args) {
        // Crear factory y entity manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eventos");
        EntityManager em = emf.createEntityManager();

        // Crear un ciclo cine
        CicloCine ciclo = new CicloCine();
        ciclo.setNombre("Ciclo de Cine de Acción");
        ciclo.setFechaInicio(LocalDate.of(2025, 7, 1));
        ciclo.setDuracionEstimada(180);
        ciclo.setHayCharlasPosteriores(true);
        ciclo.setEstado(EstadoEvento.EN_EJECUCION);

        // Crear película asociada
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo("Die Hard");
        pelicula.setOrden(1);
        pelicula.setDuracion(132);

        // Asociar película con ciclo
        ciclo.agregarPelicula(pelicula);

        // Persistir ciclo (películas se persistirán en cascada)
        em.getTransaction().begin();
        em.persist(ciclo);
        em.getTransaction().commit();

        // Cerrar EntityManager y factory
        em.close();
        emf.close();
    }
}
