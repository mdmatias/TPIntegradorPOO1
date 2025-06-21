package model;

import java.time.LocalDate;

public class ParticipanteEvento {

	LocalDate fechaInscripcion;
	String estadoInscripcion;

	public ParticipanteEvento(Participante participante, Evento eventoe) {
		this.fechaInscripcion = LocalDate.now();

		
	}

}
