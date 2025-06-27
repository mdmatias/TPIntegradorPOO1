package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import enums.EstadoEvento;

@Entity
@Table(name = "ciclo_cine")
public class CicloCine extends Evento {

    @OneToMany(mappedBy = "cicloCine", cascade = CascadeType.ALL)
    private List<Pelicula> peliculas = new ArrayList<>();

    @Column(name = "hay_charlas_posteriores", nullable = false)
    private boolean hayCharlasPosteriores;

    public CicloCine() {
        super();
    }

    public CicloCine(String nombre, Pelicula pelicula, LocalDate fechaInicio, int duracionEstimada, boolean hayCharlasPosteriores,EstadoEvento estado) {
        super(nombre, fechaInicio, duracionEstimada,estado);
        this.hayCharlasPosteriores = hayCharlasPosteriores;
        this.peliculas.add(pelicula);
    }

    public void agregarPelicula(Pelicula pelicula) {
        pelicula.setCicloCine(this);  // asignar el ciclo desde el lado de Java
        this.peliculas.add(pelicula);
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public boolean isHayCharlasPosteriores() {
        return hayCharlasPosteriores;
    }

    public void setHayCharlasPosteriores(boolean hayCharlasPosteriores) {
        this.hayCharlasPosteriores = hayCharlasPosteriores;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

}


