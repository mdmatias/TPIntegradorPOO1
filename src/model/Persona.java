package model;

public class Persona {

		int id;
		String nombreCompleto;
		String dni;
		String telefono;
		String correoElectronico;


		public Persona(int id, String nombreCompleto, String dni, String telefono, String correoElectronico) {
			this.id = id;
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
		
}



