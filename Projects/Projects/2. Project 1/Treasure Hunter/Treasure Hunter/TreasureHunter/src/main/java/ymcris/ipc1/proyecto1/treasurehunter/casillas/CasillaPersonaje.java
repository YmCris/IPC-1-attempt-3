package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.NEGRO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Personaje;

/**
 * Clase encargada de crear casillas del tipo Personaje la cual es la casilla
 * que irá moviendo al personaje durante todo el mapa
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaPersonaje extends Casillas {

    public CasillaPersonaje(int fila, int columna, Personaje personaje) {
        this.fila = fila;
        this.columna = columna;
        this.simbolo = NEGRO + personaje.getNombre().charAt(0) + RESETEAR;
    }

    @Override
    protected void aplicarEfecto(Aventurero aventurero) {
        //No hace nada
    }

    @Override
    protected void mostrarMensaje() {
        //No muestra nada
    }

    protected Casillas modificarCasillas(int filaNueva, int columnaNueva) {
        this.fila = filaNueva;
        this.columna = columnaNueva;
        return this;
    }

}
