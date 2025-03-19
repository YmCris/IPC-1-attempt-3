package ymcris.ipc1.proyecto1.treasurehunter.mapas;

import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaNormal;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaPersonaje;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaTesoro;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.Casillas;

/**
 * Clase Mapas es la Clase encargada de crear los mapas, modificar los mapas y
 * moverse dentro del mapa
 *
 * @author YmCris
 * @since Mar 17, 2025
 */
public class Mapas {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nombre;
    public static Casillas[][] mapa;

    /**
     *     // VARIABLES PRIMITIVAS
     * ---------------------------------------------------- private int filas;
     * private int columnas; private int posicionTesoro[][]; private int
     * posicionInicialJugador[][];
     *
     * // MÉTODO CONSTRUCTOR
     * ------------------------------------------------------ public
     * Mapas(String nombre, int filas, int columnas, int[][] posicionTesoro,
     * int[][] posicionInicialJugador) { this.filas = filas; this.nombre =
     * nombre; this.columnas = columnas; this.posicionTesoro = posicionTesoro;
     * this.posicionInicialJugador = posicionInicialJugador; }
     *///con posicionTesoro[][];   posicionInicialJugador[][];
    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int filas;
    private int columnas;
    private CasillaTesoro tesoro;
    private CasillaPersonaje personaje;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Mapas(String nombre, int filas, int columnas, CasillaTesoro tesoro, CasillaPersonaje personaje) {
        this.filas = filas;
        this.nombre = nombre;
        this.columnas = columnas;
        this.tesoro = tesoro;
        this.personaje = personaje;
        mapa = new Casillas[filas][columnas];
    }

    // MÉTODOS -----------------------------------------------------------------
    public Mapas modificarMapas(int fila, int columna, Casillas casillaAModificar) {
        return this;
    }

    private void moverEnELMapa() {

    }

    public Casillas[][] crearMapa() {
        for (int i = 0; i < mapa.length; i++) {//filas
            for (int j = 0; j < mapa[i].length; j++) {//columnas
                mapa[i][j] = new CasillaNormal(i, j, i * j);
                System.out.print(mapa[i][j].getSimbolo());
            }
            System.out.println("");
        }
        return mapa;
    }

    private void mostrarMapa(Mapas mapa) {

    }
}
