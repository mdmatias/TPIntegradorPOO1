package model;

import java.time.LocalDate;
import enums.ModalidadTaller;
import enums.TipoRol;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;


@Entity
@Table(name = "talleres")
public class Taller extends Evento {

	@Enumerated(EnumType.STRING) // EnumType.STRING almacena el nombre del enum como cadena
	@Column(nullable = false) // Aseguramos que la modalidad no sea nula
	private ModalidadTaller modalidad;
	
	// Constructor vacío
	public Taller() {
		super(); // Llama al constructor de la clase padre Evento
	}
	
	public Taller(String nombre,LocalDate fechaInicio,int cupo,ModalidadTaller modalidad, boolean requiereInscripcion, int cupoMaximo, boolean esAbierto) {
		super(nombre, fechaInicio, cupo); // Llama al constructor de la clase padre Evento
		this.modalidad = modalidad;
	}

	public ModalidadTaller getModalidad() {
		return modalidad;
	}

	 // Método para obtener al instructor
    public Persona getInstructor() {
        for (PersonaEvento pe : getPersonasEventos()) {
            if (pe.getRol() == TipoRol.INSTRUCTOR) {
                return pe.getPersona();
            }
        }
        return null; // No hay instructor asignado
    }

	public void setModalidad(ModalidadTaller modalidad) {
		this.modalidad = modalidad;
	}
	
	

}
