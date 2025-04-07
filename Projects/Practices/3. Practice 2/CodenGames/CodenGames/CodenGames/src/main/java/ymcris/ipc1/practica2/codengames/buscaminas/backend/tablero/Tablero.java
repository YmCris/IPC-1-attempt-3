package ymcris.ipc1.practica2.codengames.buscaminas.backend.tablero;

import java.util.Random;
import ymcris.ipc1.practica2.codengames.buscaminas.backend.casillas.Casillas;
import ymcris.ipc1.practica2.codengames.buscaminas.backend.casillas.CasillasMina;
import ymcris.ipc1.practica2.codengames.buscaminas.backend.casillas.CasillasNormales;

/**
 * Clase Tablero es la clase encargada de crear el tablero de tipo Casillas[][]
 * y de implementar todos sus métodos relacionados al tablero.
 *
 * @author YmCris
 * @see Casillas
 * @since Apr 3, 2025
 */
public class Tablero {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Casillas[][] tablero;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int filasTablero;
    private int columnasTablero;
    private int cantidadDeMinas;

    // INSTANCIAS --------------------------------------------------------------
    private Random random = new Random();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método encargado de inicializar los atributos necesarios para crear un
     * tablero.
     *
     * @param filasTablero - filas que tendrá el tablero.
     * @param columnasTablero - columnas que tendrá el tablero.
     * @param cantidadDeMinas - cantidad de minas que habrá en el tablero.
     */
    public Tablero(int filasTablero, int columnasTablero, int cantidadDeMinas) {
        this.filasTablero = filasTablero;
        this.columnasTablero = columnasTablero;
        this.cantidadDeMinas = cantidadDeMinas;
        this.tablero = new Casillas[filasTablero][columnasTablero];
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de crear el tablero.
     */
    public void crearTablero() {
        for (int i = 0; i < tablero.length; i++) {//filas
            for (int j = 0; j < tablero[0].length; j++) {//columnas
                tablero[i][j] = new CasillasNormales(false, 0, i, j, false, false, true);
            }
        }
        System.out.println("Se crea el tablero backend");
        agregarMinas();
        System.out.println("Se han agregado las minas");
    }

    /**
     * Método encargado de agregar minas al tablero y de asignarles el valor
     * true a las a sus casillas normales aledañas.
     */
    private void agregarMinas() {
        for (int i = 0; i < cantidadDeMinas; i++) {
            int filaRandom = random.nextInt(1, tablero.length);
            int columnaRandom = random.nextInt(1, tablero[0].length);
            //1. Agregar las minas al tablero.
            tablero[filaRandom][columnaRandom] = new CasillasMina(filaRandom, columnaRandom, true, false, true);
            //2. Marcar las adyacentes a estas como casillasMinaAdyacentes = true;
            try {
                //marco superior
                if (tablero[filaRandom - 1][columnaRandom - 1] instanceof CasillasNormales normal) {
                    normal.setContieneMinaAdyacente(true);
                    normal.setCantidadDeMinasAdyacentes(normal.getCantidadDeMinasAdyacentes() + 1);
                }
                if (tablero[filaRandom - 1][columnaRandom] instanceof CasillasNormales normal) {
                    normal.setContieneMinaAdyacente(true);
                    normal.setCantidadDeMinasAdyacentes(normal.getCantidadDeMinasAdyacentes() + 1);
                }
                if (tablero[filaRandom - 1][columnaRandom + 1] instanceof CasillasNormales normal) {
                    normal.setContieneMinaAdyacente(true);
                    normal.setCantidadDeMinasAdyacentes(normal.getCantidadDeMinasAdyacentes() + 1);
                }
                //marco inferior
                if (tablero[filaRandom + 1][columnaRandom - 1] instanceof CasillasNormales normal) {
                    normal.setContieneMinaAdyacente(true);
                    normal.setCantidadDeMinasAdyacentes(normal.getCantidadDeMinasAdyacentes() + 1);
                }
                if (tablero[filaRandom + 1][columnaRandom] instanceof CasillasNormales normal) {
                    normal.setContieneMinaAdyacente(true);
                    normal.setCantidadDeMinasAdyacentes(normal.getCantidadDeMinasAdyacentes() + 1);
                }
                if (tablero[filaRandom + 1][columnaRandom + 1] instanceof CasillasNormales normal) {
                    normal.setContieneMinaAdyacente(true);
                    normal.setCantidadDeMinasAdyacentes(normal.getCantidadDeMinasAdyacentes() + 1);
                }
                //Marco izquierdo
                if (tablero[filaRandom][columnaRandom - 1] instanceof CasillasNormales normal) {
                    normal.setContieneMinaAdyacente(true);
                    normal.setCantidadDeMinasAdyacentes(normal.getCantidadDeMinasAdyacentes() + 1);
                }
                //Marco Derecho
                if (tablero[filaRandom][columnaRandom + 1] instanceof CasillasNormales normal) {
                    normal.setContieneMinaAdyacente(true);
                    normal.setCantidadDeMinasAdyacentes(normal.getCantidadDeMinasAdyacentes() + 1);
                }
            } catch (ArrayIndexOutOfBoundsException | ClassCastException e) {//No es lo mejor, pero de lo contrarío habrían muchos ifs
            }
        }
        
    }

    // MÉTODOS DURANTE EL JUEGO ------------------------------------------------
    public void descubrirCasillas(int filaCasilla, int columnaCasilla) {
        Casillas casilla = tablero[filaCasilla][columnaCasilla];
        System.out.println("genero el efecto domino");
        generarEfectoDomino(casilla);
    }

    /**
     * Método encargado de generar el efecto domino basado en una casilla.
     *
     * @param casilla - Casilla sobre la cual se va a generar el efecto domino.
     */
    private void generarEfectoDomino(Casillas casilla) {
        if (!casilla.ContineMina()) {//No se generá un efecto domino sobre una mina, ya que se termina el juego
            //1. Obtener la posición de la casilla.
            int filaCasilla = casilla.getFilaCasilla();
            int columnaCasilla = casilla.getColumnaCasilla();
            //2. Recorrer todas las casillas que esten a su alrededor (fila por fila) (columna por columna)y verificar si tienen mina.
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[0].length; j++) {
                    
                }
            }
            //2.1 Lo que hay que hacer es una especie de marco sobre la mina y descubrirla (El marco termina cuando hay minas)
            //2.1.1 Encontrar la altura del marco.
            //3. Se descubren las minas.
        }
    }

    // FUNCIONES ---------------------------------------------------------------
    /**
     * Método encargado de verificar si la casilla es del tipo mina.
     *
     * @param fila - fila donde se evaluará si la casilla es mina.
     * @param columna - columna donde se evaluará si la casilla es mina.
     * @return true si la casilla es del tipo mina.
     */
    public boolean tieneMina(int fila, int columna) {
        return tablero[fila][columna].ContineMina();
    }

    // GETTERS -----------------------------------------------------------------
    public int getFilasTablero() {
        return filasTablero;
    }
    
    public int getColumnasTablero() {
        return columnasTablero;
    }
    
    public int getCantidadDeMinas() {
        return cantidadDeMinas;
    }

    public Casillas[][] getTablero() {
        return tablero;
    }
    
}
