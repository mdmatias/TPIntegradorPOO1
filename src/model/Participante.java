package model;

import java.time.LocalDate;
import jakarta.persistence.Entity;

@Entity
public class Participante {

	private int id;
	private String nombreCompleto;
	private String telefono;
	private String correoElectronico;
	private LocalDate fechaInscripcion;


	public Participante(String nombreCompleto, String telefono, String correoElectronico) {
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public String getTelefono() {
		return telefono;
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}

	
	

}
