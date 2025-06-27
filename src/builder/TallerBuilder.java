package builder;

import java.time.LocalDate;
import enums.ModalidadTaller;
import enums.EstadoEvento;

public class TallerBuilder {

	private String nombre;
	private LocalDate fechaInicio;
	private int cupoMaximo;
	private ModalidadTaller modalidad;
	private boolean requiereInscripcion;
	private boolean esAbierto;
	private EstadoEvento estado;

	public TallerBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public TallerBuilder setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
		return this;
	}

	public TallerBuilder setCupoMaximo(int cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
		return this;
	}

	public TallerBuilder setModalidad(ModalidadTaller modalidad) {
		this.modalidad = modalidad;
		return this;
	}

	public TallerBuilder setRequiereInscripcion(boolean requiereInscripcion) {
		this.requiereInscripcion = requiereInscripcion;
		return this;
	}

	public TallerBuilder setEsAbierto(boolean esAbierto) {
		this.esAbierto = esAbierto;
		return this;
	}

	public TallerBuilder setEstado(EstadoEvento estado) {
		this.estado = estado;
		return this;
	}

	public model.Taller build() {
		if (nombre == null || fechaInicio == null || cupoMaximo <= 0 || modalidad == null || estado == null) {
			throw new IllegalArgumentException("Todos los campos deben ser proporcionados y válidos.");
		}
		return new model.Taller(nombre, fechaInicio, modalidad, requiereInscripcion, cupoMaximo, esAbierto, estado);
	}

}
