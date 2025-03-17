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
    protected final String AZUL;// casilla energía
    protected final String CYAN;// casilla enemigos
    protected final String VERDE;// casilla muro
    protected final String NEGRO;// casilla tesoro, casilla trampa y casilla normal
    protected final String BLANCO;// casilla personaje
    protected final String MAGENTA;// casilla de teletransporte
    protected final String RESETEAR;// para resetear los colores
    protected final String AMARILLO;//casilla pista

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    protected int cantidad;
    protected int fila;
    protected int columna;
    protected boolean puedePasar;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Casillas() {
        this.CYAN = "\u001B[96m";
        this.AZUL = "\u001B[94m";
        this.VERDE = "\u001B[92m";
        this.NEGRO = "\u001B[90m";
        this.MAGENTA = "\u001B[95m";
        this.BLANCO = "\u001B[97m";
        this.RESETEAR = "\u001B[0m";
        this.AMARILLO = "\u001B[93m";
        this.puedePasar = true;
    }

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    /**
     * Método encargado de aplicar el efecto de la casilla al aventurero.
     *
     * @param aventurero - el jugador
     */
    protected abstract void aplicarEfecto(Aventurero aventurero);

    /**
     * Método encargado de mostrar el mensaje de lo que ha hecho la casilla al
     * jugador.
     */
    protected abstract void mostrarMensaje();

    /**
     * Método encargado de modificar las caracteríticas de la casilla.
     *
     * @return Casilla modificada
     */
    protected Casillas modificarCasillas() {
        return this;
    }

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

}
