package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import java.util.Random;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.MAGENTA;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;

/**
 * Clase encargada de crear casillas del tipo teletransporte el cual le
 * permitira al aventurero moverse por donde sea en el mapa.
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaTeletransporte extends Casillas {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int filaAMover;
    private int columnaAMover;
    private boolean ubicacionAleatoria;

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();

    public CasillaTeletransporte(int fila, int columna, int cantidad, boolean ubicacionAleatoria, int filaAMover, int columnaAMover) {
        this.fila = fila;
        this.columna = columna;
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.filaAMover = filaAMover;
        this.columnaAMover = columnaAMover;
        this.simbolo = MAGENTA + "▒" + RESETEAR;
        this.ubicacionAleatoria = ubicacionAleatoria;
    }

    @Override
    protected void aplicarEfecto(Aventurero aventurero) {
        if (ubicacionAleatoria) {//la ubicación es aleatoria
            this.filaAMover = random.nextInt();
            this.columnaAMover = random.nextInt();
            //casillapersonaje.modificar(filaAMover, columnaAMover);
        } else if (!ubicacionAleatoria) {//el usuario introduce la ubicación
            //
        }
    }

    @Override
    protected void mostrarMensaje() {
        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + "aventurero.getName()" + " te haz topado con una casilla de teletransporte" + CYAN + " ------------------------- " + RESETEAR);
        //aplicarEfecto(aventurero);
    }

    protected Casillas modificarCasillas(int filaNueva, int columnaNueva, int filaAMover, int columnaAMover, boolean ubicacionAleatoria) {
        this.fila = filaNueva;
        this.columna = columnaNueva;
        this.filaAMover = filaAMover;
        this.columnaAMover = columnaAMover;
        this.ubicacionAleatoria = ubicacionAleatoria;
        return this;
    }

}
