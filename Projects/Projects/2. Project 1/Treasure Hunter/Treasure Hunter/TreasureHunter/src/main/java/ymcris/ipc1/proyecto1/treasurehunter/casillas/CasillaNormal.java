package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.NEGRO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;

/**
 * Clase encargada de crear casillas del tipo normal, que no tienen ningun
 * efecto sobre el jugador.
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaNormal extends Casillas {

    public CasillaNormal(int fila, int columna, int cantidad) {
        this.fila = fila;
        this.columna = columna;
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.simbolo = NEGRO + "░" + RESETEAR;
    }

    @Override
    protected void aplicarEfecto(Aventurero aventurero) {
        this.puedePasar = true;
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
