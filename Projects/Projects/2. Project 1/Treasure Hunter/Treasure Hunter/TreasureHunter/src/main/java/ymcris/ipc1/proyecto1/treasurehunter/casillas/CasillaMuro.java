package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.VERDE;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

/**
 * Clase encargada de crear casillas del tipo muro, el cual impide el movimiento
 * del jugador.
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaMuro extends Casillas {

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método encargado de crear muros
     *
     * @param cantidad cantidad muros
     */
    public CasillaMuro(int cantidad) {
        this.puedePasar = false;
        this.cantidad = cantidad;
        this.simbolo = VERDE + "▓▓" + RESETEAR;
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public void aplicarEfecto(Aventurero aventurero) {
        this.puedePasar = false;
    }

    @Override
    public void mostrarMensaje() {
        // no muestra nada
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    protected Casillas modificarCasillas(int filaNueva, int columnaNueva) {
        this.fila = filaNueva;
        this.columna = columnaNueva;
        return this;
    }

}
