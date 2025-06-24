package model;

import java.time.LocalDate;
import java.util.List;

import enums.ModalidadTaller;
import enums.TipoEntrada;
import enums.TipoEvento;
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

	public void crearEvento(String nombre, LocalDate fechaInicio, int duracionEstimada, TipoEvento tipoEvento,
                        ModalidadTaller modalidad, boolean requiereInscripcion, int cupoMaximo, boolean esAbierto,
						int cantidadStands, boolean esAlAireLibre, boolean hayCharlasPosteriores,TipoEntrada tipoEntrada,
						Pelicula pelicula,String tipoArte) {
    
    Evento evento;

    switch (tipoEvento) {
        case TALLER:
            evento = new Taller(nombre, fechaInicio, duracionEstimada, modalidad, requiereInscripcion, cupoMaximo, esAbierto);
            break;
        case FERIA:
            evento = new Feria(nombre, fechaInicio, duracionEstimada, requiereInscripcion,cantidadStands,esAlAireLibre); // cantidadStands y esAlAireLibre se pueden ajustar según sea necesario
            break;
        case CICLOCINE:
            evento = new CicloCine(nombre, pelicula, fechaInicio, duracionEstimada, hayCharlasPosteriores);
            break;
	case CONCIERTO:
			evento = new Concierto(nombre, fechaInicio, duracionEstimada, tipoEntrada);
			break;
	case EXPOSICION:
			evento = new Exposicion(nombre, fechaInicio, duracionEstimada,tipoArte);
			break;
        default:
            throw new IllegalArgumentException("Tipo de evento no soportado.");
    }

    eventos.add(evento);
}



}
