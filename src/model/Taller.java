package model;

import java.time.LocalDate;

import enums.ModalidadTaller;

public class Taller extends Evento {
	ModalidadTaller modalidad;
	
	
	public Taller(String nombre,LocalDate fechaInicio,int cupo,Persona instructor, ModalidadTaller modalidad) {
		this.instructor = instructor;
		this.modalidad = modalidad;
		this.nombre = nombre;  //Hay que llamar al constructor de la clase padre Evento
		this.fechaInicio = fechaInicio;
		this.cupoMaximo = cupo;
	}


	public Persona getInstructor() {
		return instructor;
	}


	public ModalidadTaller getModalidad() {
		return modalidad;
	}

	

}
