package model;

import java.time.LocalDate;

import enums.TipoRol;

public class PersonaEvento {

	TipoRol rol;
	LocalDate fechaAsignacion;

	public PersonaEvento(TipoRol rol, LocalDate fechaAsignacion, Evento evento) {
		this.rol = rol;
		this.fechaAsignacion = fechaAsignacion;
		this.evento = evento;
	}

}
