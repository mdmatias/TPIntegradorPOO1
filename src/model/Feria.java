package model;

import java.time.LocalDate;

public class Feria extends Evento {

	private int cantidadStands;
	private boolean esAlAireLibre;

	public Feria (String nombre, LocalDate fechaInicio, int duracionEstimada, int cantidadStands, boolean esAlAireLibre) {
		super(nombre, fechaInicio, duracionEstimada); // Llamar al constructor de la clase padre Evento
		this.cantidadStands = cantidadStands;
		this.esAlAireLibre = esAlAireLibre;
	}

	public boolean isEsAlAireLibre() {
		return esAlAireLibre;
	}
	public int getCantidadStands() {
		return cantidadStands;
	}
}
