package model;

import java.time.LocalDate;

public class Participante {

	int id;
	String nombreCompleto;
	String telefono;
	String correoElectronico;
	LocalDate fechaInscripcion;


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
