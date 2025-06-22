package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enums.TipoEntrada;

public class Concierto extends Evento {

	private List<String> artistas = new ArrayList<>();
	private TipoEntrada tipoEntrada;

	//Constructor vacio
	public Concierto() {
		super();
	}

	public Concierto( String nombre, LocalDate fechaInicio, int duracionEstimada, List<String> artistas, TipoEntrada tipoEntrada) {
		super(nombre, fechaInicio, duracionEstimada); // Llamar al constructor de la clase padre Evento	
		this.artistas = artistas;
		this.tipoEntrada = tipoEntrada;
		
	}

}
