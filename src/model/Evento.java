package model;

import java.time.LocalDate;
import enums.EstadoEvento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String nombre;
	LocalDate fechaInicio;
	int duracionEstimada;
	EstadoEvento estado;
	boolean requiereInscripcion;
	int cupoMaximo;
	boolean esAbierto;

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

	
}
