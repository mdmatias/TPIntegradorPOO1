package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enums.TipoEntrada;

public class Concierto extends Evento {

	private List<String> artistas = new ArrayList<>();
	TipoEntrada tipoEntrada;

	//Constructor vacio
	public Concierto() {
		super();
	}

	public Concierto( String nombre, LocalDate fechaInicio, int duracionEstimada, List<String> artistas, TipoEntrada tipoEntrada) {
		this.artistas = artistas;
		this.tipoEntrada = tipoEntrada;
		this.nombre = nombre; // Hay que llamar al constructor de la clase padre Evento
		this.fechaInicio = fechaInicio;
		this.duracionEstimada = duracionEstimada;
	}

}
