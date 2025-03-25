package ymcris.ipc1.proyecto1.treasurehunter.casillas;

import java.util.Random;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.MAGENTA;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.Mapas;

/**
 * Clase encargada de crear casillas del tipo teletransporte el cual le
 * permitira al aventurero moverse por donde sea en el mapa.
 *
 * @author YmCris
 * @since Mar 15, 2025
 */
public class CasillaTeletransporte extends Casillas {

    private CasillaPersonaje casillaAventurero;
    private CasillaTesoro casillaTesoro;
    private Mapas mapa;
    private Casillas[][] tablero;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int filasMapa;
    private int filaAMover;
    private int columnasMapa;
    private int columnaAMover;
    private boolean ubicacionAleatoria;

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método encargado de crear casillas de teletransporte
     *
     * @param cantidad - cantidad de casillas
     * @param ubicacionAleatoria - true si lo es
     * @param filaAMover - fila a donde se va a teletransportar
     * @param columnaAMover - columna a donde se va a teletransportar
     * @param filasMapa - filas que posee el mapa
     * @param columnasMapa - columnas que posee el mapa
     * @param casillaAventurero
     * @param casillaTesoro
     * @param mapa
     * @param tablero
     */
    public CasillaTeletransporte(int cantidad, boolean ubicacionAleatoria, int filaAMover, int columnaAMover, int filasMapa, int columnasMapa, CasillaPersonaje casillaAventurero, CasillaTesoro casillaTesoro, Mapas mapa, Casillas[][] tablero) {
        this.puedePasar = true;
        this.cantidad = cantidad;
        this.filasMapa = filasMapa;
        this.filaAMover = filaAMover;
        this.columnasMapa = columnasMapa;
        this.columnaAMover = columnaAMover;
        this.simbolo = MAGENTA + "▒▒" + RESETEAR;
        this.ubicacionAleatoria = ubicacionAleatoria;
        this.casillaAventurero = casillaAventurero;
        this.casillaTesoro = casillaTesoro;
        this.mapa = mapa;
        this.tablero = tablero;
    }

    // MÉTODOS SOBREESCRITO ----------------------------------------------------
    @Override
    public void aplicarEfecto(Aventurero aventurero) {
        if (ubicacionAleatoria) {//la ubicación es aleatoria
            this.filaAMover = random.nextInt(0, filasMapa - 1);
            this.columnaAMover = random.nextInt(0, columnasMapa - 1);
            if (filaAMover == casillaTesoro.getFila() && columnaAMover == casillaTesoro.getColumna()) {
                this.filaAMover = random.nextInt(0, filasMapa - 1);
                this.columnaAMover = random.nextInt(0, columnasMapa - 1);
            }
            CasillaNormal normal = new CasillaNormal(1);
            mapa.modificarMapas(casillaAventurero.getFila(), casillaAventurero.getColumna(), normal);
            casillaAventurero.modificarCasillas(filaAMover, columnaAMover);
            mapa.modificarMapas(filaAMover, columnaAMover, casillaAventurero);
            System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " te haz teletransportado a la casilla [" + (filaAMover + 1) + "][" + (columnaAMover + 1) + CYAN + "] ------------------------- " + RESETEAR);
        } else if (!ubicacionAleatoria) {//el usuario introduce la ubicación
            tablero[casillaAventurero.getFila()][casillaAventurero.getColumna()] = new CasillaNormal(1);//Quita la casilla del aventurero y pone una normal
            casillaAventurero.modificarCasillas(filaAMover, columnaAMover);
            mapa.modificarMapas(filaAMover, columnaAMover, casillaAventurero);
            System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " te haz teletransportado a la casilla [" + (filaAMover) + "][" + (columnaAMover) + CYAN + "] ------------------------- " + RESETEAR);
        }
    }

    @Override
    public void mostrarMensaje() {
        System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + aventurero.getNombre() + " te haz topado con una casilla de teletransporte" + CYAN + " ------------------------- " + RESETEAR);
        aplicarEfecto(aventurero);
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    protected Casillas modificarCasillas(int filaNueva, int columnaNueva, int filaAMover, int columnaAMover, boolean ubicacionAleatoria) {
        this.fila = filaNueva;
        this.columna = columnaNueva;
        this.filaAMover = filaAMover;
        this.columnaAMover = columnaAMover;
        this.ubicacionAleatoria = ubicacionAleatoria;
        return this;
    }

}
