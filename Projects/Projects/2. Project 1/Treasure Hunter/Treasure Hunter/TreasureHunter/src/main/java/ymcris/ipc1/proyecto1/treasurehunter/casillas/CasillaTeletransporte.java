package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import java.util.Random;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.MAGENTA;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import static ymcris.ipc1.proyecto1.treasurehunter.mapas.Mapas.casillaAventurero;

/**
 * Clase encargada de crear casillas del tipo teletransporte el cual le
 * permitira al aventurero moverse por donde sea en el mapa.
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaTeletransporte extends Casillas {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int filasMapa;
    private int filaAMover;
    private int columnasMapa;
    private int columnaAMover;
    private boolean ubicacionAleatoria;

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public CasillaTeletransporte(int cantidad, boolean ubicacionAleatoria, int filaAMover, int columnaAMover, int filasMapa, int columnasMapa) {
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.filasMapa = filasMapa;
        this.filaAMover = filaAMover;
        this.columnasMapa = columnasMapa;
        this.columnaAMover = columnaAMover;
        this.simbolo = MAGENTA + "▒▒" + RESETEAR;
        this.ubicacionAleatoria = ubicacionAleatoria;
    }

    @Override
    public void aplicarEfecto(Aventurero aventurero) {
        if (ubicacionAleatoria) {//la ubicación es aleatoria
            this.filaAMover = random.nextInt(0, filasMapa - 1);
            this.columnaAMover = random.nextInt(0, columnasMapa - 1);
            casillaAventurero.modificarCasillas(filaAMover, columnaAMover);
        } else if (!ubicacionAleatoria) {//el usuario introduce la ubicación
            casillaAventurero.modificarCasillas(filaAMover, columnaAMover);
        }
    }

    @Override
    public void mostrarMensaje() {
        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " te haz topado con una casilla de teletransporte" + CYAN + " ------------------------- " + RESETEAR);
        aplicarEfecto(aventurero);
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
