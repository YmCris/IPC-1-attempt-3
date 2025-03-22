package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.AZUL;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

/**
 * Clase encargada de crear casillas del tipo energía la cual le brindarán al
 * aventurero una ayuda durante su travesia.
 *
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaEnergia extends Casillas {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int puntosARecuperar;
    private boolean recuperaVida;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Crea una casilla energía
     *
     * @param cantidad - cantidad de casillas energía
     * @param puntosARecuperar - puntos de vida o mana a recuperar.
     * @param recuperaVida - si recupera vida = true
     */
    public CasillaEnergia(int cantidad, int puntosARecuperar, boolean recuperaVida) {
        this.puntosARecuperar = puntosARecuperar;
        this.recuperaVida = recuperaVida;
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.simbolo = AZUL + "▒▒" + RESETEAR;
    }

    // MÉTODOS SOBRE ESCRITOS --------------------------------------------------
    @Override
    public void aplicarEfecto(Aventurero aventurero) {
        if (recuperaVida) {//recupera vida
            aventurero.setVida(aventurero.getVida() + puntosARecuperar);
            aventurero.setVidaMaxima(aventurero.getVidaMaxima() + puntosARecuperar);
            aventurero.setVidaPrevioAUnaBatalla(aventurero.getVidaPrevioAUnaBatalla() + puntosARecuperar);
            System.out.println(CYAN + "         ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " haz recuperado " + puntosARecuperar + " de vida tienes " + aventurero.getVida() + " puntos de vida" + CYAN + " ------------------------- " + RESETEAR);
        } else if (!recuperaVida) {//recupera mana
            aventurero.setMana(aventurero.getMana() + puntosARecuperar);
            aventurero.setManaMaximo(aventurero.getManaMaximo() + puntosARecuperar);
            aventurero.setManaPrevioAUnaBatalla(aventurero.getManaPrevioAUnaBatalla() + puntosARecuperar);
            System.out.println(CYAN + "         ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " haz recuperado " + puntosARecuperar + " de vida tienes " + aventurero.getMana() + " puntos de mana" + CYAN + " ------------------------- " + RESETEAR);
        }
    }

    @Override
    public void mostrarMensaje() {
        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " te haz topado con una casilla de energía" + CYAN + " ------------------------- " + RESETEAR);
        aplicarEfecto(aventurero);
    }

    // MÉTODOS -----------------------------------------------------------------
    protected Casillas modificarCasillas(int filaNueva, int columnaNueva, int puntosARecuperar, boolean recuperaVida) {
        this.fila = filaNueva;
        this.columna = columnaNueva;
        this.puntosARecuperar = puntosARecuperar;
        this.recuperaVida = recuperaVida;
        return this;
    }

}
