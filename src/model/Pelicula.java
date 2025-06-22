package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //Se agrego el id para que tenga una clave primaria (no puede ser titulo)
	
	@ManyToOne
	@JoinColumn(name = "ciclo_cine_id", nullable = false) // FK a CicloCine
	private CicloCine cicloCine; // Relación con CicloCine

	private String titulo;
	private int orden;
	private int duracion; // en minutos
	
	public Pelicula() {
		// Constructor por defecto
	}

	public Pelicula(String titulo, int orden, int duracion) {  //Id no viene como parametro porque es autogenerado
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

	public int getDuracion() {
		return duracion;
	}

	public int getId() {
		return id;
	}

	public CicloCine getCicloCine() {
		return cicloCine;
	}

	public void setCicloCine(CicloCine cicloCine) {
		this.cicloCine = cicloCine;
	}

	
}
