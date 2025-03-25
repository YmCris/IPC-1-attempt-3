package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.NEGRO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

/**
 * CasillaNormal es una clase hija encargada de crear casillas del tipo normal,
 * que no tienen ningun efecto sobre el jugador.
 *
 * @author YmCris
 * @see Casillas
 * @since Mar 15, 2025
 */
public class CasillaNormal extends Casillas {

    // MÉTODO COSNTRUCTOR ------------------------------------------------------
    /**
     * Método encargado de crear casillas normales (Pista)
     *
     * @param cantidad cantidad de casillas normales.
     */
    public CasillaNormal(int cantidad) {
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.simbolo = NEGRO + "░░" + RESETEAR;
    }

    // MÉTODOS SOBRE ESCRITOS --------------------------------------------------
    @Override
    public void aplicarEfecto(Aventurero aventurero) {
        this.puedePasar = true;
    }

    @Override
    public void mostrarMensaje() {
        //No muestra nada
    }

}
