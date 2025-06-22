package model;

import java.time.LocalDate;

public class ParticipanteEvento {

	private LocalDate fechaInscripcion;
	private String estadoInscripcion;
	private Participante participante;
	private Evento evento;
	
	public ParticipanteEvento(LocalDate fechaInscripcion, String estadoInscripcion, Participante participante,
			Evento evento) {
		this.fechaInscripcion = fechaInscripcion;
		this.estadoInscripcion = estadoInscripcion;
		this.participante = participante;
		this.evento = evento;
	}

	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public String getEstadoInscripcion() {
		return estadoInscripcion;
	}

	public void setEstadoInscripcion(String estadoInscripcion) {
		this.estadoInscripcion = estadoInscripcion;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	
	

}
