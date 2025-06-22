package model;

import java.time.LocalDate;

import enums.TipoRol;

public class PersonaEvento {

	private TipoRol rol;
	private LocalDate fechaAsignacion;
	private Evento evento;
    private Persona persona;


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
