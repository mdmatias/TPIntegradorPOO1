package builder;

import java.time.LocalDate;
import enums.*;
import model.Concierto;

public class ConciertoBuilder {
	
	private String nombre;
	private LocalDate fechaInicio;
	private int duracionEstimada;
	private TipoEntrada tipoEntrada;
	private EstadoEvento estado;

	public ConciertoBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ConciertoBuilder setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
		return this;
	}

	public ConciertoBuilder setDuracionEstimada(int duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
		return this;
	}

	public ConciertoBuilder setTipoEntrada(TipoEntrada tipoEntrada) {
		this.tipoEntrada = tipoEntrada;
		return this;
	}

	public ConciertoBuilder setEstado(EstadoEvento estado) {
		this.estado = estado;
		return this;
	}

	public Concierto build() {
		return new Concierto(nombre, fechaInicio, duracionEstimada, tipoEntrada, estado);
	}
}
