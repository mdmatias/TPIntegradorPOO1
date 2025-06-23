package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ciclo_cine")
public class CicloCine extends Evento {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ciclo_cine_id") // FK en la tabla Pelicula
    private List<Pelicula> peliculas = new ArrayList<>();

    @Column(name = "hay_charlas_posteriores")
    private boolean hayCharlasPosteriores;

    public CicloCine() {
        super();
    }

    public CicloCine(String nombre, Pelicula pelicula, LocalDate fechaInicio, int duracionEstimada, boolean hayCharlasPosteriores) {
        super(nombre, fechaInicio, duracionEstimada);
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
}
