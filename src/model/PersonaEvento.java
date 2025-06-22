package model;

import java.time.LocalDate;
import enums.TipoRol;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona_eventos")
public class PersonaEvento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING) // EnumType.STRING almacena el nombre del enum como cadena
	@Column(nullable = false) // Aseguramos que el rol no sea nulo
	private TipoRol rol;
	private LocalDate fechaAsignacion;
	
	@ManyToOne
	@JoinColumn(name = "evento_id", nullable = false) //JoinColumn establece la relación con la entidad Evento
	private Evento evento;
   
	@ManyToOne
	@JoinColumn(name = "persona_id", nullable = false) //JoinColumn establece la relación con la entidad Persona
	private Persona persona;


	public PersonaEvento() {
		// Constructor por defecto
	}

	public PersonaEvento(TipoRol rol, LocalDate fechaAsignacion, Evento evento, Persona persona) {
		this.persona = persona;
		this.rol = rol;
		this.fechaAsignacion = fechaAsignacion;
		this.evento = evento;
	}


	public TipoRol getRol() {
		return rol;
	}


	public LocalDate getFechaAsignacion() {
		return fechaAsignacion;
	}


	public Evento getEvento() {
		return evento;
	}


	public Persona getPersona() {
		return persona;
	}


	
}
