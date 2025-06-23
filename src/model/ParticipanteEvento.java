package model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "participantes_eventos")
public class ParticipanteEvento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //JPA necesita un identificador unico para cada entidad
	private LocalDate fechaInscripcion;
	private String estadoInscripcion;
	
	@ManyToOne
	private Participante participante;
	
	@ManyToOne
	private Evento evento;

	public ParticipanteEvento() {
	}

	public ParticipanteEvento(LocalDate fechaInscripcion, String estadoInscripcion, Participante participante,Evento evento) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	

}
