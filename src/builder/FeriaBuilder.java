package builder;

import java.time.LocalDate;
import enums.EstadoEvento;
import model.Feria;

public class FeriaBuilder {
	
	private String nombre;
	private LocalDate fechaInicio;
	private int duracionEstimada;
	private boolean requiereInscripcion;
	private int cantidadStands;
	private boolean esAlAireLibre;
	private EstadoEvento estado;

	public FeriaBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public FeriaBuilder setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
		return this;
	}

	public FeriaBuilder setDuracionEstimada(int duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
		return this;
	}


	public FeriaBuilder setRequiereInscripcion(boolean requiereInscripcion) {
		this.requiereInscripcion = requiereInscripcion;
		return this;
	}

	public FeriaBuilder setCantidadStands(int cantidadStands) {
		this.cantidadStands = cantidadStands;
		return this;
	}

	public FeriaBuilder setEsAlAireLibre(boolean esAlAireLibre) {
		this.esAlAireLibre = esAlAireLibre;
		return this;
	}

	public FeriaBuilder setEstado(EstadoEvento estado) {
		this.estado = estado;
		return this;
	}


	public Feria build() {
		if (nombre == null || fechaInicio == null || duracionEstimada <= 0 || cantidadStands <= 0 || estado == null) {
			throw new IllegalArgumentException("Todos los campos deben ser proporcionados y válidos.");
		}
		return new Feria(nombre, fechaInicio, duracionEstimada, requiereInscripcion, cantidadStands, esAlAireLibre, estado);
	}
}
