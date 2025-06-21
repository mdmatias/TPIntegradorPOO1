package model;

import java.time.LocalDate;

public class Exposicion {

	String tipoArte;
	Persona curador;
	public Exposicion(String nombre,LocalDate fechaInicio,int duracion,String tipoArte, Persona curador) {
		this.tipoArte = tipoArte;
		this.curador = curador;
	}

	public String getTipoArte() {
		return tipoArte;
	}
	public Persona getCurador() {
		return curador;
	}

	

}
