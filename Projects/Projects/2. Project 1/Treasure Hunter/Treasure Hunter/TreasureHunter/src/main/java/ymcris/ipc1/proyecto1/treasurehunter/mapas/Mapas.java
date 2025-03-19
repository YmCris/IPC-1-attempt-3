package ymcris.ipc1.proyecto1.treasurehunter.mapas;

import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaNormal;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaPersonaje;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaTesoro;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.Casillas;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.NEGRO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

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
    private char[] simbolosColumnas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z'};
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
    public Casillas[][] crearMapa() {
        for (int i = 0; i < mapa.length; i++) {//filas
            for (int j = 0; j < mapa[i].length; j++) {//columnas
                mapa[i][j] = new CasillaNormal(i, j, i * j);
            }
        }
        return mapa;
    }

    public void mostrarMapa() {
        //Marco superior de las letras
        System.out.print("___");
        for (int i = 0; i < mapa[0].length; i++) {
            System.out.print("__");
        }
        System.out.print("_");
        System.out.println("");
        //Marco de las Columnas letras
        System.out.print("|:v|");
        for (int i = 0; i < mapa[0].length; i++) {
            System.out.print(simbolosColumnas[i] + "|");
        }
        System.out.println("");
        //Marco de las filas números
        for (int i = 0; i < mapa.length; i++) {
            if (i < 9) {
                System.out.print("|" + 0 + (i + 1) + "|");
            } else if (i >= 9) {
                System.out.print("|" + (i + 1) + "|");
            }
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print(mapa[i][j].getSimbolo());
                System.out.print(NEGRO + "|" + RESETEAR);
            }
            System.out.println("");
        }
    }

    public void diseñarMapa() {

    }

    public Mapas modificarMapas(int fila, int columna, Casillas casillaAModificar) {
        return this;
    }

    private void moverEnELMapa() {

    }

}
