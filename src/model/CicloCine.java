package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CicloCine {

	List<Pelicula> peliculas;
	boolean hayCharlasPosteriores;

	public CicloCine(String nombre, LocalDate fechaInicio, int duracion, boolean hayCharlasPosteriores) {
		this.peliculas = new ArrayList<>();
		this.hayCharlasPosteriores = hayCharlasPosteriores;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.duracion = duracion;
		
	}

}
