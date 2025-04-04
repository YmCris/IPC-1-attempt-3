package ymcris.ipc1.practica2.codengames.buscaminas.backend.casillas;

/**
 * Clase Casillas es la clase padre encargada de proporcionar los atributos
 * necesarios a todas las casillas y los métodos aabstractos necesarios.
 *
 * @author YmCris
 * @since Apr 3, 2025
 */
public abstract class Casillas {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int filaCasilla;
    private int columnaCasilla;
    private boolean contineMina;
    private boolean estaMarcada;
    private boolean estaCubierta;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método constructor encargado de inicializar los atributos de las casillas
     *
     * @param filaCasilla - fila en la cual se posicionará dentro del tablero.
     * @param columnaCasilla-columna en la que se posicionará dentro del tablero
     * @param contineMina - true si es mina.
     * @param estaMarcada - true si el jugador la ha marcado.
     * @param estaCubierta - true si esta cubierta.
     */
    public Casillas(int filaCasilla, int columnaCasilla, boolean contineMina, boolean estaMarcada, boolean estaCubierta) {
        this.filaCasilla = filaCasilla;
        this.columnaCasilla = columnaCasilla;
        this.contineMina = contineMina;
        this.estaMarcada = estaMarcada;
        this.estaCubierta = estaCubierta;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de mostrar la información de la casilla, por si es
     * necesario para depurar.
     */
    public abstract void mostrarInformacion();

    // GETTERS -----------------------------------------------------------------
    public boolean ContineMina() {
        return contineMina;
    }

    public boolean EstaMarcada() {
        return estaMarcada;
    }

    public boolean EstaCubierta() {
        return estaCubierta;
    }

    // SETTERS -----------------------------------------------------------------
    public void setContineMina(boolean contineMina) {
        this.contineMina = contineMina;
    }

    public void setEstaMarcada(boolean estaMarcada) {
        this.estaMarcada = estaMarcada;
    }

    public void setEstaCubierta(boolean estaCubierta) {
        this.estaCubierta = estaCubierta;
    }

}
