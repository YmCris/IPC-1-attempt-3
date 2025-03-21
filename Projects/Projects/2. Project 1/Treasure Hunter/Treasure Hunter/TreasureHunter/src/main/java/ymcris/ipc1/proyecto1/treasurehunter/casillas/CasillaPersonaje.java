package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Personaje;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.ROJO;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

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
        aventurero.setFilaJugador(fila);
        this.columna = columna;
        aventurero.setColumnaJugador(columna);
        this.simbolo = ROJO + "░" + personaje.getNombre().charAt(0) + RESETEAR;
    }

    @Override
    public void aplicarEfecto(Aventurero aventurero) {
        //No hace nada
    }

    @Override
    public void mostrarMensaje() {
        //No muestra nada
    }

    protected Casillas modificarCasillas(int filaNueva, int columnaNueva) {
        this.fila = filaNueva;
        aventurero.setFilaJugador(filaNueva);
        this.columna = columnaNueva;
        aventurero.setColumnaJugador(columnaNueva);
        return this;
    }

}
