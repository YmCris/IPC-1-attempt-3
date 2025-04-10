package ymcris.ipc1.practica2.codengames.hunting.backend.pato;

/**
 * Clase Pato es la clase encargada de referinciar a un pato dentro del juego
 * hunter, que será "depredado" por el jugador.
 *
 * @author YmCris
 * @since Apr 8, 2025
 */
public class Pato {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int velocidad;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Pato(int velocidad) {
        this.velocidad = velocidad;
    }

    // GETTERS -----------------------------------------------------------------
    public int getVelocidad() {
        return velocidad;
    }

    // SETTERS -----------------------------------------------------------------
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

}
