package model;

import java.time.LocalDate;
import jakarta.persistence.Entity;

@Entity
public class Exposicion extends Evento {

	private String tipoArte;
	private Persona curador;
	
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
