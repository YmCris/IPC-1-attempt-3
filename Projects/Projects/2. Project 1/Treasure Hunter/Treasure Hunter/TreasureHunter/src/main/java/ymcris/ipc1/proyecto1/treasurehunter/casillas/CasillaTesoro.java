package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.NEGRO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;

/**
 * Clase encargada de crear casillas del tipo tesoro las cuales representan el
 * tesoro unico del juego
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaTesoro extends Casillas {

    public CasillaTesoro(int fila, int columna, int cantidad) {
        this.fila = fila;
        this.columna = columna;
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.simbolo = NEGRO + "░" + RESETEAR;
    }

    @Override
    protected void aplicarEfecto(Aventurero aventurero) {
    }

    @Override
    protected void mostrarMensaje() {
        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "" + CYAN + " ------------------------- " + RESETEAR);
        //partidaTerminada = true;
    }

    protected Casillas modificarCasillas(int filaNueva, int columnaNueva) {
        this.fila = filaNueva;
        this.columna = columnaNueva;
        return this;
    }

}
