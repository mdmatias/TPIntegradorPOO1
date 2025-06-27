import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

import builder.ConciertoBuilder;
import model.*;
import enums.*;

public class MainTest {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eventos");
        EntityManager em = emf.createEntityManager();

        GestorEventos gestor = new GestorEventos(em);
        

        Concierto concierto = new ConciertoBuilder()
                .setNombre("Concierto de Rock")
                .setFechaInicio(LocalDate.of(2023, 11, 1))
                .setDuracionEstimada(120)
                .setTipoEntrada(TipoEntrada.GRATUITA)
                .setEstado(EstadoEvento.PLANIFICACION)
                .build();

        // Guardar el evento en la base de datos
        gestor.crearEvento(concierto);

        em.close();
        emf.close();
    }
}
