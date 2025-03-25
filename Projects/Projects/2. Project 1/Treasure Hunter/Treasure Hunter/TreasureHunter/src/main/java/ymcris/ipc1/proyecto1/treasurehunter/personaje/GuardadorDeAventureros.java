package ymcris.ipc1.proyecto1.treasurehunter.personaje;

import java.io.File;

/**
 * Clase encargada de guardar los personajes
 *
 * @author YmCris
 * @since Mar 25, 2025
 */
public class GuardadorDeAventureros {

    // --------------------- VARIABLES DE REFERENCIA ---------------------------
    private File archivoJugador;

    // ----------------------- VARIABLES PRIMITIVAS ----------------------------
    // ---------------------------- INSTANCIAS ---------------------------------
    // ------------------------ MÉTODO CONSTRUCTOR -----------------------------
    /**
     * Cosntruye el archivo del jugador donse se guardarán sus atributos
     *
     * @param archivoJugador - archivo de texto donde se guardarán las cosas
     */
    public GuardadorDeAventureros(File archivoJugador) {
        this.archivoJugador = archivoJugador;
    }
    // ----------------------------- MÉTODOS -----------------------------------

    public void mostrarInformacionJugador() {
    }
    // ------------------------- GETTERS & SETTERS -----------------------------
}
