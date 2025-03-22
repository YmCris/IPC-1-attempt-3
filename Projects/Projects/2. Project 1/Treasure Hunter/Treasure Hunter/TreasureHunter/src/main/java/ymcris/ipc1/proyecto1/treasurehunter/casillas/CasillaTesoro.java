package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.NEGRO;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.MAGENTA;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import static ymcris.ipc1.proyecto1.treasurehunter.partida.Partida.partidaTerminada;

/**
 * Clase encargada de crear casillas del tipo tesoro las cuales representan el
 * tesoro unico del juego
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaTesoro extends Casillas {

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Crea el tesoro
     *
     * @param fila - fila donde estará el tesoro
     * @param columna - columna donde estará el tesoro
     */
    public CasillaTesoro(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.puedePasar = true;
        this.simbolo = NEGRO + "░░" + RESETEAR;
    }

    @Override
    public void aplicarEfecto(Aventurero aventurero) {
        //No tiene efecto
    }

    @Override
    public void mostrarMensaje() {
        System.out.println(MAGENTA + "                                        AVENTURERO " + aventurero.getNombre() + " has hallado el tesoro más grande de todos" + RESETEAR);
        System.out.println(MAGENTA + "                             Luego de incanzables recorridos, batallas, y frustraciones, tu travesia ha llegado a su fin" + RESETEAR);
        partidaTerminada = true;
    }

    protected Casillas modificarCasillas(int filaNueva, int columnaNueva) {
        this.fila = filaNueva;
        this.columna = columnaNueva;
        return this;
    }

}
