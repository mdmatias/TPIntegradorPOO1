package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import enums.TipoEntrada;
import enums.TipoRol;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "conciertos")
public class Concierto extends Evento {

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private TipoEntrada tipoEntrada;

    // Constructor vacío
    public Concierto() {
        super();
    }

    public Concierto(String nombre, LocalDate fechaInicio, int duracionEstimada, TipoEntrada tipoEntrada) {
        super(nombre, fechaInicio, duracionEstimada);
        this.tipoEntrada = tipoEntrada;
    }

    // Método para obtener la lista de personas con rol ARTISTA
    public List<Persona> getArtistas() {
        List<Persona> artistas = new ArrayList<>();
        for (PersonaEvento pe : getPersonasEventos()) {
            if (pe.getRol() == TipoRol.ARTISTA) {
                artistas.add(pe.getPersona());
            }
        }
        return artistas;
    }

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }


}
