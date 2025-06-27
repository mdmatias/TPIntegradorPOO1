package builder;

import java.time.LocalDate;
import enums.EstadoEvento;
import model.CicloCine;
import model.Pelicula;

public class CicloCineBuilder {
    private String nombre;
    private LocalDate fechaInicio;
    private int duracionEstimada;
    private boolean hayCharlasPosteriores;
    private EstadoEvento estado;
    private Pelicula pelicula;

    public CicloCineBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public CicloCineBuilder setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    public CicloCineBuilder setDuracionEstimada(int duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
        return this;
    }

    public CicloCineBuilder setHayCharlasPosteriores(boolean hayCharlasPosteriores) {
        this.hayCharlasPosteriores = hayCharlasPosteriores;
        return this;
    }

    public CicloCineBuilder setEstado(EstadoEvento estado) {
        this.estado = estado;
        return this;
    }

    public CicloCineBuilder setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
        return this;
    }

   public CicloCine build() {
        if (nombre == null || fechaInicio == null || duracionEstimada <= 0 || estado == null) {
            throw new IllegalArgumentException("Todos los campos deben ser proporcionados y válidos.");
        }
        CicloCine cicloCine = new CicloCine(nombre, pelicula, fechaInicio, duracionEstimada, hayCharlasPosteriores, estado);
        if (pelicula != null) {
            cicloCine.agregarPelicula(pelicula);
        }
        return cicloCine;

   }
}
