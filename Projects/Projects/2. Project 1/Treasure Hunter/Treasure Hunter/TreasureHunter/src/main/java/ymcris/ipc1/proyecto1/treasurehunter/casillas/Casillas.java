package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;

/**
 * SuperClase Casillas es la Clase encargada de crear casillas para luego
 * introducirlas en el mapa y aplicar su efecto con su mensaje
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public abstract class Casillas {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    protected String simbolo;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    protected int fila;
    protected int columna;
    protected int cantidad;
    protected boolean puedePasar;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Casillas() {
        this.puedePasar = true;
    }

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    /**
     * Método encargado de aplicar el efecto de la casilla al aventurero.
     *
     * @param aventurero - el jugador
     */
    public abstract void aplicarEfecto(Aventurero aventurero);

    /**
     * Método encargado de mostrar el mensaje de lo que ha hecho la casilla al
     * jugador.
     */
    public abstract void mostrarMensaje();

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de modificar las caracteríticas de la casilla.
     *
     * @return Casilla modificada
     */
    public final Casillas modificarCasillas() {
        return this;
    }

    // GETTERS & SETTERS -------------------------------------------------------
    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isPuedePasar() {
        return puedePasar;
    }

    public void setPuedePasar(boolean puedePasar) {
        this.puedePasar = puedePasar;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

}
