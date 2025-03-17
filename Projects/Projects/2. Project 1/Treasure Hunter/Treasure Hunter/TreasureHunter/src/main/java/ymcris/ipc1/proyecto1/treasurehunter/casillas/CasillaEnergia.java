package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;

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
    public CasillaEnergia(int fila, int columna, int cantidad, int puntosARecuperar, boolean recuperaVida) {
        this.puntosARecuperar = puntosARecuperar;
        this.recuperaVida = recuperaVida;
        this.fila = fila;
        this.columna = columna;
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.simbolo = AZUL + "▒" + RESETEAR;
    }

    // MÉTODOS SOBRE ESCRITOS --------------------------------------------------
    @Override
    protected void aplicarEfecto(Aventurero aventurero) {
        if (recuperaVida) {//recupera vida
            aventurero.setVida(aventurero.getVida() + puntosARecuperar);
        } else if (!recuperaVida) {//recupera mana
            aventurero.setMana(aventurero.getMana() + puntosARecuperar);
        }
    }

    @Override
    protected void mostrarMensaje() {
        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + "aventurero.getName()" + " te haz topado con una casilla de energía" + CYAN + " ------------------------- " + RESETEAR);
        //aplicarEfecto(aventurero);
    }

    protected Casillas modificarCasillas(int filaNueva, int columnaNueva, int puntosARecuperar, boolean recuperaVida) {
        this.fila=filaNueva;
        this.columna=columnaNueva;
        this.puntosARecuperar=puntosARecuperar;
        this.recuperaVida=recuperaVida;
        return this;
    }

}
