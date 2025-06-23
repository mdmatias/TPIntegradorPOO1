import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.CicloCine;
import model.Pelicula;

import java.time.LocalDate;

import enums.EstadoEvento;

public class MainTest {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eventos");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Crear película independiente (sin ciclo)
            Pelicula peliculaSuelta = new Pelicula("Película Independiente", 1, 100, null);
            em.persist(peliculaSuelta);

            // Crear un ciclo de cine
            CicloCine ciclo = new CicloCine();
            ciclo.setNombre("Ciclo de Acción");
            ciclo.setFechaInicio(LocalDate.of(2025, 7, 1));
            ciclo.setDuracionEstimada(180);
            ciclo.setHayCharlasPosteriores(true);
            ciclo.setEstado(EstadoEvento.EN_EJECUCION);

            // Crear películas para el ciclo (sin asignar ciclo aún)
            Pelicula p1 = new Pelicula("Die Hard", 1, 132, null);
            Pelicula p2 = new Pelicula("Mad Max", 2, 120, null);

            // Agregar películas al ciclo (esto asigna ciclo a las películas)
            ciclo.agregarPelicula(p1);
            ciclo.agregarPelicula(p2);

            // Persistir ciclo (cascade persiste las películas)
            em.persist(ciclo);

            em.getTransaction().commit();

            // Mostrar resultados para confirmar
            System.out.println("Película independiente ID: " + peliculaSuelta.getId());
            System.out.println("Ciclo de cine ID: " + ciclo.getId());
            System.out.println("Películas en ciclo:");

            for (Pelicula pel : ciclo.getPeliculas()) {
                System.out.println(" - " + pel.getTitulo() + ", ciclo ID asignado: " + (pel.getCicloCine() != null ? pel.getCicloCine().getId() : "null"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
