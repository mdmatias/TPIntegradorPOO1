package model;

import java.time.LocalDate;
import java.util.List;

import enums.TipoRol;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ferias")
public class Feria extends Evento {

	@Column(nullable = false) // Aseguramos que la cantidad de stands no sea nula
	private int cantidadStands;
	@Column(nullable = false, unique = true) // Aseguramos que el nombre del evento no sea nulo y sea único
	private boolean esAlAireLibre;

	public Feria() {
		super(); // Llamar al constructor de la clase padre Evento
	}

	public Feria (String nombre, LocalDate fechaInicio, int duracionEstimada, boolean requiereInscripcion, int cantidadStands, boolean esAlAireLibre) {
		super(nombre, fechaInicio, duracionEstimada); // Llamar al constructor de la clase padre Evento
		this.cantidadStands = cantidadStands;
		this.esAlAireLibre = esAlAireLibre;
	}

	public List<Persona> getOrganizadores() {
    return getPersonasEventos().stream()
        .filter(pe -> pe.getRol() == TipoRol.ORGANIZADOR)
        .map(PersonaEvento::getPersona)
        .toList();
}

	public boolean isEsAlAireLibre() {
		return esAlAireLibre;
	}
	public int getCantidadStands() {
		return cantidadStands;
	}

	public void setCantidadStands(int cantidadStands) {
		this.cantidadStands = cantidadStands;
	}

	public void setEsAlAireLibre(boolean esAlAireLibre) {
		this.esAlAireLibre = esAlAireLibre;
	}

	
}
