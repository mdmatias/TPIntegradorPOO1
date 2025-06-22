package gestor;

import java.time.LocalDate;
import java.util.List;

import enums.ModalidadTaller;
import enums.TipoEvento;
import model.*;
public class GestorEventos {

	private List<Evento> eventos;
	private List<Persona> personas;
	private List<ParticipanteEvento> participanteEventos;
	private ModalidadTaller modalidad;

	public GestorEventos(List<Evento> eventos, List<Persona> personas, List<ParticipanteEvento> participanteEventos) {
		this.eventos = eventos;
		this.personas = personas;
		this.participanteEventos = participanteEventos;
	}


}
