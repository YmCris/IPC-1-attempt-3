package ymcris.ipc1.practica2.codengames.hunting.backend.jugador;

/**
 * Interface Predatorable Es la interface capaz de hacer al jugador un
 * depredador.
 *
 * @author YmCris
 * @since Apr 8, 2025
 */
public interface Predatorable {

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    /**
     * Método encargado de disparar a un objetivo.
     */
    public abstract void disparar();
}
