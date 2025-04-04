package ymcris.ipc1.practica2.codengames.buscaminas.backend.casillas;

/**
 * Clase CasillasMina es una clase hija encargada de crear Casillas del tipo
 * mina.
 *
 * @author YmCris
 * @see Casillas
 * @since Apr 3, 2025
 */
public class CasillasMina extends Casillas {

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método constructor encargado de inicializar los atributos de las casillas
     * Mina
     *
     * @param filaCasilla - fila en la cual se posicionará dentro del tablero.
     * @param columnaCasilla-columna en la que se posicionará dentro del tablero
     * @param contineMina - true si es mina.
     * @param estaMarcada - true si el jugador la ha marcado.
     * @param estaCubierta - true si esta cubierta.
     */
    public CasillasMina(int filaCasilla, int columnaCasilla, boolean contineMina, boolean estaMarcada, boolean estaCubierta) {
        super(filaCasilla, columnaCasilla, contineMina, estaMarcada, estaCubierta);
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public void mostrarInformacion() {
    }
}
