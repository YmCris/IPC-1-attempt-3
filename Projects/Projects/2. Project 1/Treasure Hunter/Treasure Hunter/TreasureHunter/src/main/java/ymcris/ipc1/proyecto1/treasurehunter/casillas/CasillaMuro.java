package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.VERDE;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;

/**
 * Clase encargada de crear casillas del tipo muro, el cual impide el movimiento
 * del jugador.
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaMuro extends Casillas {

    public CasillaMuro(int fila, int columna, int cantidad) {
        this.fila = fila;
        this.columna = columna;
        this.puedePasar = false;
        this.cantidad = cantidad;
        this.simbolo = VERDE + "▓" + RESETEAR;
    }

    @Override
    protected void aplicarEfecto(Aventurero aventurero) {
        this.puedePasar = false;
    }

    @Override
    protected void mostrarMensaje() {
        // no muestra nada
    }

    protected Casillas modificarCasillas(int filaNueva, int columnaNueva) {
        this.fila = filaNueva;
        this.columna = columnaNueva;
        return this;
    }

}
