package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import enums.ModalidadTaller;
import enums.TipoRol;

public class Taller extends Evento {

	private ModalidadTaller modalidad;
	private List<PersonaEvento> personaEvento;

	
	
	public Taller(String nombre,LocalDate fechaInicio,int cupo,ModalidadTaller modalidad) {
		super(nombre, fechaInicio, cupo); // Llamar al constructor de la clase padre Evento
		this.modalidad = modalidad;
		this.personaEvento = new ArrayList<>();
	}

	public ModalidadTaller getModalidad() {
		return modalidad;
	}

	 public List<PersonaEvento> getParticipantes() {
        return personaEvento;
    }

	 // Método para obtener al instructor
    public Persona getInstructor() {
        for (PersonaEvento pe : personaEvento) {
            if (pe.getRol() == TipoRol.INSTRUCTOR) {
                return pe.getPersona();
            }
        }
        return null; // No hay instructor asignado
    }
	

}
