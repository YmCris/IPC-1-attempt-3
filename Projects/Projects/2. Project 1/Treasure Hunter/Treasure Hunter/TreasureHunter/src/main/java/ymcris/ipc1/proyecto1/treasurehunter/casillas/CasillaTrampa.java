package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.NEGRO;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

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
    /**
     * Crea una casilla trampa
     *
     * @param cantidad - cantidad de casillas trampa
     * @param puntosAQuitar - puntos que quitará la casilla.
     * @param quitaVida - si la casilla quita vida o mana.
     */
    public CasillaTrampa(int cantidad, int puntosAQuitar, boolean quitaVida) {
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.quitaVida = quitaVida;
        this.puntosAQuitar = puntosAQuitar;
        this.simbolo = NEGRO + "░░" + RESETEAR;
    }

    @Override
    public void aplicarEfecto(Aventurero aventurero) {
        if (quitaVida) {//quita vida
            aventurero.setVida(aventurero.getVida() - puntosAQuitar);
            System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " haz perdido " + puntosAQuitar + " de vida tienes " + aventurero.getVida() + " puntos de vida" + CYAN + " ------------------------- " + RESETEAR);
        } else if (!quitaVida) {//quita mana
            aventurero.setMana(aventurero.getMana() - puntosAQuitar);
            System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " haz perdido " + puntosAQuitar + " de mana tienes " + aventurero.getMana() + " puntos de mana" + CYAN + " ------------------------- " + RESETEAR);
        }
    }

    @Override
    public void mostrarMensaje() {
        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " te haz topado con una casilla trampa" + CYAN + " ------------------------- " + RESETEAR);
        aplicarEfecto(aventurero);
    }

    protected Casillas modificarCasillas(int filaNueva, int columnaNueva, int puntosAQuitar, boolean quitaVida) {
        this.fila = filaNueva;
        this.columna = columnaNueva;
        this.quitaVida = quitaVida;
        this.puntosAQuitar = puntosAQuitar;
        return this;
    }

}
