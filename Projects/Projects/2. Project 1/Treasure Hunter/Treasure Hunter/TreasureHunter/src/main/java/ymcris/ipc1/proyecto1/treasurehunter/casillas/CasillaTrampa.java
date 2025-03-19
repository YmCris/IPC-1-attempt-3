package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.NEGRO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;

/**
 * Clase encargada de crear casillas del tipo trampa, el cual aplica un efecto
 * negativo en el aventurero.
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaTrampa extends Casillas {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int puntosAQuitar;
    private boolean quitaVida;

    // MÉTODO COSNTRUCTOR ------------------------------------------------------
    public CasillaTrampa(int fila, int columna, int cantidad, int puntosAQuitar, boolean quitaVida) {
        this.fila = fila;
        this.columna = columna;
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.quitaVida = quitaVida;
        this.puntosAQuitar = puntosAQuitar;
        this.simbolo = NEGRO + "░" + RESETEAR;
    }

    @Override
    protected void aplicarEfecto(Aventurero aventurero) {
        if (quitaVida) {//quita vida
            aventurero.setVida(aventurero.getVida() - puntosAQuitar);
        } else if (!quitaVida) {//quita mana
            aventurero.setMana(aventurero.getMana() - puntosAQuitar);
        }
    }

    @Override
    protected void mostrarMensaje() {
        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + "aventurero.getName()" + " te haz topado con una casilla trampa" + CYAN + " ------------------------- " + RESETEAR);
        //aplicarEfecto(aventurero);
    }

    protected Casillas modificarCasillas(int filaNueva, int columnaNueva, int puntosAQuitar, boolean quitaVida) {
        this.fila = filaNueva;
        this.columna = columnaNueva;
        this.quitaVida = quitaVida;
        this.puntosAQuitar = puntosAQuitar;
        return this;
    }

}
