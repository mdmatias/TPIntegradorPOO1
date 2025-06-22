package model;

import java.time.LocalDate;

public class ParticipanteEvento {

	private LocalDate fechaInscripcion;
	private String estadoInscripcion;

	public ParticipanteEvento(Participante participante, Evento eventoe) {
		this.fechaInscripcion = LocalDate.now();
	}

}
