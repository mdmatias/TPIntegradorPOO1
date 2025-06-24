package model;

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
@Table(name = "personas")
public class Persona {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(nullable = false) // Aseguramos que el nombre completo no sea nulo
		private String nombreCompleto;
		
		@Column(nullable = false, unique = true) // Aseguramos que el DNI sea único y no nulo
		private String dni;
		
		@Column(nullable = false) // Aseguramos que el teléfono no sea nulo
		private String telefono;
		
		@Column(nullable = false, unique = true) // Aseguramos que el correo electrónico sea único y no nulo
		private String correoElectronico;

		@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL) // Relación con PersonaEvento
		private List<PersonaEvento> personasEventos = new ArrayList<>(); // Lista de eventos asociados a la persona

		public Persona() {
			// Constructor por defecto
		}

		public Persona(String nombreCompleto, String dni, String telefono, String correoElectronico) {
			this.nombreCompleto = nombreCompleto;
			this.dni = dni;
			this.telefono = telefono;
			this.correoElectronico = correoElectronico;
		}


		public int getId() {
			return id;
		}


		public String getNombreCompleto() {
			return nombreCompleto;
		}


		public String getDni() {
			return dni;
		}


		public String getTelefono() {
			return telefono;
		}


		public String getCorreoElectronico() {
			return correoElectronico;
		}

		public void actualizarDatos(String telefono, String correoElectronico) {
			this.telefono = telefono;
			this.correoElectronico = correoElectronico;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setNombreCompleto(String nombreCompleto) {
			this.nombreCompleto = nombreCompleto;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public void setCorreoElectronico(String correoElectronico) {
			this.correoElectronico = correoElectronico;
		}

		public List<PersonaEvento> getPersonaEventos() {
			return personasEventos;
		}
		
		
}



