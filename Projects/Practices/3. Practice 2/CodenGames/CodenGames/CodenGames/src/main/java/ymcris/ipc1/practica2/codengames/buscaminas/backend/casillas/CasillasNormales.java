package ymcris.ipc1.practica2.codengames.buscaminas.backend.casillas;

/**
 * Clase CasillasNormales
 *
 * @author YmCris
 * @see Casillas
 * @since Apr 3, 2025
 */
public class CasillasNormales extends Casillas {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private boolean hayMinasAdyacentes;
    private int cantidadDeMinasAdyacentes;
    private boolean contieneMinaAdyacente;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método constructor encargado de inicializar los atributos de las casillas
     * Mina
     *
     * @param hayMinasAdyacentes - true si hay minas cerca de la casilla normal.
     * @param cantidadDeMinasAdyacentes - cantidad de minas alrededor de la CN.
     * @param filaCasilla - fila en la cual se posicionará dentro del tablero.
     * @param columnaCasilla-columna en la que se posicionará dentro del tablero
     * @param contineMina - true si es mina.
     * @param estaMarcada - true si el jugador la ha marcado.
     * @param estaCubierta - true si esta cubierta.
     */
    public CasillasNormales(boolean hayMinasAdyacentes, int cantidadDeMinasAdyacentes, int filaCasilla, int columnaCasilla, boolean contineMina, boolean estaMarcada, boolean estaCubierta) {
        super(filaCasilla, columnaCasilla, contineMina, estaMarcada, estaCubierta);
        this.hayMinasAdyacentes = hayMinasAdyacentes;
        this.cantidadDeMinasAdyacentes = cantidadDeMinasAdyacentes;

    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    @Override
    public void mostrarInformacion() {
    }

    // GETTERS -----------------------------------------------------------------
    public boolean HayMinasAdyacentes() {
        return hayMinasAdyacentes;
    }

    public int getCantidadDeMinasAdyacentes() {
        return cantidadDeMinasAdyacentes;
    }

    public boolean ContieneMinaAdyacente() {
        return contieneMinaAdyacente;
    }

    // SETTERS -----------------------------------------------------------------
    public void setHayMinasAdyacentes(boolean hayMinasAdyacentes) {
        this.hayMinasAdyacentes = hayMinasAdyacentes;
    }

    public void setCantidadDeMinasAdyacentes(int cantidadDeMinasAdyacentes) {
        this.cantidadDeMinasAdyacentes = cantidadDeMinasAdyacentes;
    }

    public void setContieneMinaAdyacente(boolean contieneMinaAdyacente) {
        this.contieneMinaAdyacente = contieneMinaAdyacente;
    }

}
