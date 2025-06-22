package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CicloCine extends Evento {

    private List<Pelicula> peliculas;
    private boolean hayCharlasPosteriores;

    public CicloCine(String nombre, Pelicula pelicula, LocalDate fechaInicio, int duracionEstimada, boolean hayCharlasPosteriores) {
        super(nombre, fechaInicio, duracionEstimada);
        this.peliculas = new ArrayList<>();
        this.hayCharlasPosteriores = hayCharlasPosteriores;
        this.peliculas.add(pelicula); // se agrega la primera película
    }

    public CicloCine() {
        this.peliculas = new ArrayList<>();
    }

    public void agregarPelicula(Pelicula pelicula) {
        this.peliculas.add(pelicula);
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public boolean isHayCharlasPosteriores() {
        return hayCharlasPosteriores;
    }
}
