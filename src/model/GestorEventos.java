package model;

import java.time.LocalDate;
import java.util.List;

import enums.EstadoEvento;
import enums.TipoRol;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class GestorEventos {

    private EntityManager em;

    public GestorEventos(EntityManager em) {
        this.em = em;
    }

    // Método para persistir cualquier tipo de evento
    public void crearEvento(Evento evento) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(evento);
        tx.commit();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void modificarEvento(Evento evento) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(evento);
        tx.commit();
    }

    public void eliminarEvento(Evento evento) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.contains(evento) ? evento : em.merge(evento));
        tx.commit();
    }

    public Persona crearPersona(Persona persona) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(persona);
        tx.commit();
        return persona; // Retorna la persona creada
    }

    public Persona modificarPersona(Persona persona) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(persona);
        tx.commit();
        return persona; // Retorna la persona modificada
    }

    public void eliminarPersona(Persona persona) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.contains(persona) ? persona : em.merge(persona));
        tx.commit();
    }

    public void asociarPersonaAEvento(Persona persona, Evento evento, TipoRol rol, LocalDate fechaAsignacion) {
    EntityTransaction tx = em.getTransaction();
    try {
        tx.begin();
        PersonaEvento personaEvento = new PersonaEvento(rol, fechaAsignacion, evento, persona);
        em.persist(personaEvento);
        tx.commit();
    } catch (Exception e) {
        if (tx.isActive()) tx.rollback();
        throw e;
    }
}

   public boolean inscribirParticipante(Evento evento, ParticipanteEvento participanteEvento) {
    EntityTransaction tx = em.getTransaction();
    try {
        tx.begin();
        evento.inscribirParticipante(participanteEvento);
        em.merge(evento); // Persistir cambios en evento y lista de participantes
        tx.commit();
        return true;
    } catch (Exception e) {
        if (tx.isActive()) tx.rollback();
        return false;
    }
}

    public void cambiarEstadoEvento(Evento evento, EstadoEvento nuevoEstado) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        evento.cambiarEstado(nuevoEstado);
        em.merge(evento); // Persistir cambios en el evento
        tx.commit();
    }

   public List<ParticipanteEvento> listarParticipantes(Evento evento) {
    return em.createQuery(
        "SELECT p FROM ParticipanteEvento p WHERE p.evento = :evento", ParticipanteEvento.class)
        .setParameter("evento", evento)
        .getResultList();
}


    public List<Evento> getCalendarioEventos() {
    return em.createQuery("SELECT e FROM Evento e ORDER BY e.fechaInicio", Evento.class)
             .getResultList();
}

    public boolean validarCupoMaximo(Evento evento) {
        if (evento.getCupoMaximo() <= 0) {
            return false; // No hay cupo máximo definido
        }
        long inscritos = evento.getParticipantesEventos().stream()
                .filter(pe -> pe.getEvento().equals(evento))
                .count();
        return inscritos < evento.getCupoMaximo();
    }


}
