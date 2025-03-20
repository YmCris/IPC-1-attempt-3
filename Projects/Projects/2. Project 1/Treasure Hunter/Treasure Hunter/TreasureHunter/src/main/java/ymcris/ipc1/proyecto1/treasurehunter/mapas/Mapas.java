package ymcris.ipc1.proyecto1.treasurehunter.mapas;

import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaNormal;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaPersonaje;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaTesoro;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.Casillas;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.NEGRO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

/**
 * Clase Mapas es la Clase encargada de crear los mapas, modificar los mapas y
 * moverse dentro del tablero
 *
 * @author YmCris
 * @since Mar 17, 2025
 */
public class Mapas {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nombre;
    public static Casillas[][] tablero;

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
        tablero = new Casillas[filas][columnas];
    }

    // MÉTODOS -----------------------------------------------------------------
    public Casillas[][] crearMapa() {
        for (int i = 0; i < tablero.length; i++) {//filas
            for (int j = 0; j < tablero[i].length; j++) {//columnas
                tablero[i][j] = new CasillaNormal( i * j);
            }
        }
        return tablero;
    }

    public void mostrarMapa() {
        String A = "0";
        //Marco superior de las letras
        System.out.print("___");
        for (int i = 0; i < tablero[0].length; i++) {
            System.out.print("___");
        }
        System.out.print("_");
        System.out.println("");
        //Marco de las Columnas letras
        System.out.print("|:v|");
        for (int i = 0; i < tablero[0].length; i++) {
            if (i < 9) {
                System.out.print(A + (i + 1) + "|");
            } else {
                System.out.print((i + 1) + "|");
            }
        }
        System.out.println("");
        //Marco de las filas números
        for (int i = 0; i < tablero.length; i++) {
            if (i < 9) {
                System.out.print("|" + 0 + (i + 1) + "|");
            } else if (i >= 9) {
                System.out.print("|" + (i + 1) + "|");
            }
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j].getSimbolo());
                System.out.print(NEGRO + "░" + RESETEAR);
            }
            System.out.println("");
        }
    }

    public void modificarMapas(int fila, int columna, Casillas casillaAModificar) {
        Mapas.tablero[fila][columna] = casillaAModificar;
    }

    private void moverEnELMapa() {

    }

}
