package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "participantes")
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	@Column(nullable = false)
	private String nombreCompleto;
	@Column(nullable = false)
	private String telefono;
	@Column(nullable = false, unique = true)
	private String correoElectronico;
	@Column(name = "fecha_inscripcion", nullable = false)
	private LocalDate fechaInscripcion;

	@OneToMany(mappedBy = "participante", cascade = CascadeType.ALL)
	private List<ParticipanteEvento> participanteEvento = new ArrayList<>();


	public Participante() {
	}


	public Participante(String nombreCompleto, String telefono, String correoElectronico) {
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public String getTelefono() {
		return telefono;
	}


	public String getCorreoElectronico() {
		return correoElectronico;
	}


	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public void setParticipanteEvento(List<ParticipanteEvento> participanteEvento) {
		this.participanteEvento = participanteEvento;
	}

	
	

}
