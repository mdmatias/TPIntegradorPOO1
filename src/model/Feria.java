package model;

import java.time.LocalDate;

public class Feria extends Evento {

	int cantidadStands;
	boolean esAlAireLibre;

	public Feria (String nombre, LocalDate fechaInicio, int duracionEstimada, int cantidadStands, boolean esAlAireLibre) {
		this.nombre = nombre; 
		this.fechaInicio = fechaInicio;
		this.duracionEstimada = duracionEstimada;
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
