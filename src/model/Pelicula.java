package model;

public class Pelicula {

	String titulo;
	int orden;
	int duracion; // en minutos
	public Pelicula(String titulo, int orden, int duracion) {
		this.titulo = titulo;
		this.orden = orden;
		this.duracion = duracion;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public int getOrden() {
		return orden;
	}

	

}
