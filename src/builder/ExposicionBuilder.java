package builder;

import java.time.LocalDate;
import enums.EstadoEvento;
import model.Exposicion;

public class ExposicionBuilder {
	
	private String nombre;
	private LocalDate fechaInicio;
	private int duracion;
	private String tipoArte;
	private EstadoEvento estado;

	public ExposicionBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ExposicionBuilder setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
		return this;
	}

	public ExposicionBuilder setDuracion(int duracion) {
		this.duracion = duracion;
		return this;
	}

	public ExposicionBuilder setTipoArte(String tipoArte) {
		this.tipoArte = tipoArte;
		return this;
	}

	public ExposicionBuilder setEstado(EstadoEvento estado) {
		this.estado = estado;
		return this;
	}

	public Exposicion build() {
		if (nombre == null || fechaInicio == null || duracion <= 0 || tipoArte == null || estado == null) {
			throw new IllegalArgumentException("Todos los campos deben ser proporcionados y válidos.");
		}
		return new Exposicion(nombre, fechaInicio, duracion, tipoArte, estado);
	}
	
}
