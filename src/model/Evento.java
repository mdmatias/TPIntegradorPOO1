package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enums.EstadoEvento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Estrategia de herencia para eventos, permite que las subclases hereden de Evento
public abstract class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true) // Aseguramos que el nombre del evento no sea nulo y sea único
	private String nombre;
	@Column(nullable = false) // Aseguramos que el nombre del evento no sea nulo y sea único
	private LocalDate fechaInicio;
	@Column(nullable = false) // Aseguramos que el nombre del evento no sea nulo y sea único
	private int duracionEstimada;
	@Enumerated(EnumType.STRING) // EnumType.STRING almacena el nombre del enum como cadena
	@Column(nullable = false) // Aseguramos que el nombre del evento no sea nulo y sea único
	private EstadoEvento estado;
	@Column(nullable = false) // Aseguramos que el nombre del evento no sea nulo y sea único
	private boolean requiereInscripcion;
	@Column(nullable = false) // Aseguramos que el nombre del evento no sea nulo y sea único
	private int cupoMaximo;
	@Column(nullable = false) // Aseguramos que el nombre del evento no sea nulo y sea único
	private boolean esAbierto;


	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL) // Relación con PersonaEvento
	private List<PersonaEvento> personasEventos; // Lista de personas asociadas al evento

	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL) // Relación con ParticipanteEvento
	private List<ParticipanteEvento> participantesEventos; // Lista de participantes asociados al evento

	// Constructor vacio
	public Evento() {
	this.personasEventos = new ArrayList<>();
	this.participantesEventos = new ArrayList<>();
}


	public Evento(String nombre, LocalDate fechaInicio, int duracionEstimada,EstadoEvento estado) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.duracionEstimada = duracionEstimada;
		this.estado = estado;
	}

	public void cambiarEstado(EstadoEvento nuevoEvento) {
		this.estado = nuevoEvento;
	}

	public void agregarResponsable(Persona persona){
		if (persona != null && !this.personasEventos.stream().anyMatch(pe -> pe.getPersona().equals(persona))) {
			PersonaEvento personaEvento = new PersonaEvento(this, persona);
			this.personasEventos.add(personaEvento);
			persona.getPersonaEventos().add(personaEvento); // Aseguramos que la relación sea bidireccional
		}
	}
	
	public void removerResponsable(Persona persona){
		if (persona != null) {
			this.personasEventos.removeIf(pe -> pe.getPersona().equals(persona));
			persona.getPersonaEventos().removeIf(pe -> pe.getEvento().equals(this)); // Aseguramos que la relación sea bidireccional
		}
	}

	public void inscribirParticipante(ParticipanteEvento participanteEvento) {
    if (participanteEvento != null && !participantesEventos.contains(participanteEvento)) {
        participantesEventos.add(participanteEvento);
        participanteEvento.setEvento(this); // Mantener relación bidireccional
    }
}


	public boolean puedeInscribirse() {
		return this.estado == EstadoEvento.PLANIFICACION && this.requiereInscripcion && this.cupoMaximo > 0;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public int getDuracionEstimada() {
		return duracionEstimada;
	}

	public EstadoEvento getEstado() {
		return estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setDuracionEstimada(int duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
	}

	public void setEstado(EstadoEvento estado) {
		this.estado = estado;
	}

	public boolean isRequiereInscripcion() {
		return requiereInscripcion;
	}

	public void setRequiereInscripcion(boolean requiereInscripcion) {
		this.requiereInscripcion = requiereInscripcion;
	}

	public int getCupoMaximo() {
		return cupoMaximo;
	}

	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	public boolean isEsAbierto() {
		return esAbierto;
	}

	public void setEsAbierto(boolean esAbierto) {
		this.esAbierto = esAbierto;
	}

	public List<PersonaEvento> getPersonasEventos() {
		return personasEventos;
	}

	public void setPersonasEventos(List<PersonaEvento> personasEventos) {
		this.personasEventos = personasEventos;
	}

	public List<ParticipanteEvento> getParticipantesEventos() {
		return participantesEventos;
	}

	public void setParticipantesEventos(List<ParticipanteEvento> participantesEventos) {
		this.participantesEventos = participantesEventos;
	}

	
}
