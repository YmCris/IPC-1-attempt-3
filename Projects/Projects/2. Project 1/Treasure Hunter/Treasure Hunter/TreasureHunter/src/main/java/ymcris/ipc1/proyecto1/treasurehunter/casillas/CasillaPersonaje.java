package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import ymcris.ipc1.proyecto1.treasurehunter.personaje.Personaje;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.ROJO;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

/**
 * CasillaPersonaje es una clase hija encargada de crear casillas del tipo
 * Personaje la cual es la casilla que irá moviendo al personaje durante todo el
 * mapa
 *
 * @author YmCris
 * @see Casillas
 * @since Mar 15, 2025
 */
public class CasillaPersonaje extends Casillas {

    /**
     * Método encargado de crear la casilla del personaje
     *
     * @param fila - fila en la que estará el personaje.
     * @param columna - columna en la que estará el personaje.
     * @param personaje - aventurero
     */
    public CasillaPersonaje(int fila, int columna, Personaje personaje) {
        this.fila = fila;
        aventurero.setFilaJugador(fila);
        this.columna = columna;
        aventurero.setColumnaJugador(columna);
        this.simbolo = ROJO + "░░" + RESETEAR;
    }

    //MÉTODOS SOBRE ESCRITOS ---------------------------------------------------
    @Override
    public void aplicarEfecto(Aventurero aventurero) {
        //No hace nada
    }

    @Override
    public void mostrarMensaje() {
        //No muestra nada
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de modificar la fila y columna del jugador y de la
     * casilla
     *
     * @param filaNueva - Fila a la cual se reubicará el jugador y su casilla
     * @param columnaNueva - Columna a la cual se reubicará el jugador y su
     * casilla
     * @return CasillaModificada
     */
    protected Casillas modificarCasillas(int filaNueva, int columnaNueva) {
        this.fila = filaNueva;
        aventurero.setFilaJugador(filaNueva);
        this.columna = columnaNueva;
        aventurero.setColumnaJugador(columnaNueva);
        return this;
    }

}
