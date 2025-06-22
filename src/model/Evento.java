package model;

import java.time.LocalDate;
import enums.EstadoEvento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	private String nombre;
	private LocalDate fechaInicio;
	private int duracionEstimada;
	private EstadoEvento estado;
	private boolean requiereInscripcion;
	private int cupoMaximo;
	private boolean esAbierto;

	// Constructor vacio
	public Evento(){}

	public Evento(String nombre, LocalDate fechaInicio, int duracionEstimada) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.duracionEstimada = duracionEstimada;
	}

	public void cambiarEstado(EstadoEvento nuevoEvento) {
		this.estado = nuevoEvento;
	}

	public void agregarResponsable(Persona persona){
		
	}
	
	public void removerResponsable(Persona persona){
		
	}

	public boolean puedeInscribirse() {
		return this.estado == EstadoEvento.PLANIFICACION && this.requiereInscripcion && this.cupoMaximo > 0;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public int getDuracionEstimada() {
		return duracionEstimada;
	}

	public EstadoEvento getEstado() {
		return estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setDuracionEstimada(int duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
	}

	public void setEstado(EstadoEvento estado) {
		this.estado = estado;
	}

	public boolean isRequiereInscripcion() {
		return requiereInscripcion;
	}

	public void setRequiereInscripcion(boolean requiereInscripcion) {
		this.requiereInscripcion = requiereInscripcion;
	}

	public int getCupoMaximo() {
		return cupoMaximo;
	}

	public void setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	public boolean isEsAbierto() {
		return esAbierto;
	}

	public void setEsAbierto(boolean esAbierto) {
		this.esAbierto = esAbierto;
	}

	
}
