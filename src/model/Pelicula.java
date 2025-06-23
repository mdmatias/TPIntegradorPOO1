package model;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
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
	
	@ManyToOne(optional = true) // Permite que una película no pertenezca a un ciclo (opcional)
	@JoinColumn(name = "ciclo_cine_id", nullable = true) // FK a CicloCine
	private CicloCine cicloCine; // Relación con CicloCine

	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private int orden;
	@Column(nullable = false)
	private int duracion; // en minutos
	
	public Pelicula() {
		// Constructor por defecto
	}

	public Pelicula(String titulo, int orden, int duracion, CicloCine cicloCine) {  //Id no viene como parametro porque es autogenerado
		this.titulo = titulo;
		this.orden = orden;
		this.duracion = duracion;
		this.cicloCine = cicloCine;
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

	public void setId(int id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	
}
