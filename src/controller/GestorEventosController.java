package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.GestorEventos;

public class GestorEventosController {

    private GestorEventos gestor;

    // Conexión a los nodos definidos en el FXML
    @FXML
    private Label tituloLabel;

    @FXML
    private Button btnListarEventos;

    @FXML
    private Button btnCrearEvento;

    @FXML
    private Button btnAsociarPersonaEvento;

    @FXML
    private Button btnInscribirParticipante;

    @FXML
    private Button btnModificarEvento;

    @FXML
    private Button btnEliminarEvento;

    // Método llamado automáticamente por JavaFX después de cargar el FXML
    @FXML
    public void initialize() {
        // Aquí deberías crear o recibir tu EntityManager y luego instanciar GestorEventos
        // Por ejemplo (debes reemplazar con tu EntityManager real):
        // EntityManager em = ...;
        // gestor = new GestorEventos(em);

        // Por ahora, dejalo nulo o un mock para que no falle:
        gestor = null;
    }

    @FXML
    private void listarEventos() {
        System.out.println("Listar eventos clickeado");
        // Lógica para listar eventos, por ejemplo:
        // List<Evento> eventos = gestor.getCalendarioEventos();
        // Mostrar en consola o en una tabla (a implementar)
    }

    @FXML
    private void crearEvento() {
        System.out.println("Crear evento clickeado");
        // Aquí iría la lógica para crear evento o abrir una ventana para crearlo
    }

    @FXML
    private void asociarPersonaEvento() {
        System.out.println("Asociar persona a evento clickeado");
        // Lógica para asociar persona a evento
    }

    @FXML
    private void inscribirParticipante() {
        System.out.println("Inscribir participante clickeado");
        // Lógica para inscribir participante
    }

    @FXML
    private void modificarEvento() {
        System.out.println("Modificar evento clickeado");
        // Lógica para modificar evento
    }

    @FXML
    private void eliminarEvento() {
        System.out.println("Eliminar evento clickeado");
        // Lógica para eliminar evento
    }
}
