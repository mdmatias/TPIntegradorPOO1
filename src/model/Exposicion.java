package model;

import java.time.LocalDate;

import enums.EstadoEvento;
import enums.TipoRol;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Exposicion extends Evento {

	@Column(nullable = false) // Aseguramos que el tipo de arte no sea nulo
    private String tipoArte;
	

	// Constructor vacio
	public Exposicion() {
		super();
	}

	public Exposicion(String nombre, LocalDate fechaInicio, int duracion, String tipoArte,EstadoEvento estado) {
        super(nombre, fechaInicio, duracion,estado);
        this.tipoArte = tipoArte;
    }

	 // Método para obtener el curador desde PersonaEvento
    public Persona getCurador() {
        if (getPersonasEventos() == null) return null;
        return getPersonasEventos().stream()
                .filter(pe -> pe.getRol() == TipoRol.CURADOR)
                .map(pe -> pe.getPersona())
                .findFirst()
                .orElse(null);
    }

	public String getTipoArte() {
		return tipoArte;
	}
	

}
