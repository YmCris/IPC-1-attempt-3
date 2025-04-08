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
    private int cantidadDeCasillasMina;
    private int cantidadDeCasillasNormales;

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
        this.cantidadDeCasillasMina = cantidadDeMinas;
        this.cantidadDeCasillasNormales = (filasTablero * columnasTablero) - cantidadDeMinas;
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
        System.out.println("Se crea el tablero backend de tamaño filas = " + tablero.length + " columnas = " + tablero[0].length);
        agregarMinas();
        System.out.println("Se han agregado las " + cantidadDeCasillasMina + " minas");
    }

    /**
     * Método encargado de agregar minas al tablero y de asignarles el valor
     * true a las a sus casillas normales aledañas.
     */
    private void agregarMinas() {
        int minasColocadas = 0;
        while (minasColocadas < cantidadDeCasillasMina) {
            int fila = random.nextInt(tablero.length);
            int columna = random.nextInt(tablero[0].length);
            if (!tablero[fila][columna].ContineMina()) {
                tablero[fila][columna] = new CasillasMina(fila, columna, true, false, true);
                marcarCasillasAdyacentes(fila, columna);
                minasColocadas++;
            }
        }
    }

    private void marcarCasillasAdyacentes(int fila, int columna) {
        for (int i = -1; i <= 1; i++) {//Filas 
            for (int j = -1; j <= 1; j++) {// Columnas 
                if (i == 0 && j == 0) {//Posición de la casilla
                    continue;//Salta la mina, ya que no se quiere hacer nada con está
                }
                int filaAdyacente = fila + i;
                int columnaAdyacente = columna + j;
                if (filaAdyacente >= 0 && filaAdyacente < tablero.length && columnaAdyacente >= 0 && columnaAdyacente < tablero[0].length) {//Para que no se marquen fuera del tablero
                    if (tablero[filaAdyacente][columnaAdyacente] instanceof CasillasNormales normal) {
                        normal.setContieneMinaAdyacente(true);
                        normal.setCantidadDeMinasAdyacentes(normal.getCantidadDeMinasAdyacentes() + 1);
                    }
                }
            }
        }
    }

    // MÉTODOS DURANTE EL JUEGO ------------------------------------------------
    public void descubrirCasillas(int filaCasilla, int columnaCasilla) {
        Casillas casilla = tablero[filaCasilla][columnaCasilla];
        casilla.setEstaCubierta(false);
        generarEfectoDomino(casilla);
        System.out.println("Se descubre la casilla fila = " + filaCasilla + " columna = " + columnaCasilla);
        System.out.println("Tiene mina " + casilla.ContineMina() + " esta cubierta: " + casilla.EstaCubierta());
    }

    /**
     * Método encargado de generar el efecto domino basado en una casilla.
     *
     * @param casilla - Casilla sobre la cual se va a generar el efecto domino.
     */
    private void generarEfectoDomino(Casillas casilla) {
        if (!casilla.ContineMina()) {//No se generá un efecto domino sobre una mina, ya que se termina el juego
            //1. Obtener la posición de la casilla.
            try {
                CasillasNormales casillaNormal = (CasillasNormales) casilla;//Casteamos la casilla para verificar el efecto domino
                if (!casillaNormal.ContieneMinaAdyacente()) {//No hay minas adyacentes por lo tanto esta libre para hacer el efecto domino
                    System.out.println("Se genera el efecto Domino");
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
                } else {
                    descubrirCasillasAdyacentes(casillaNormal);
                }
            } catch (ClassCastException e) {
            }
        }
    }

    public String descubrirCasillasAdyacentes(CasillasNormales casilla) {
        int cantidadDeMinasAdyacentes = casilla.getCantidadDeMinasAdyacentes();
        return String.valueOf(cantidadDeMinasAdyacentes);
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

    public boolean verificarJugadorGanador() {
        int contadorCasillasMina = 0;
        int contadorCasillasNormales = 0;
        for (Casillas[] tablero1 : tablero) {
            for (int j = 0; j < tablero1.length; j++) {
                if (tablero1[j] instanceof CasillasNormales) {
                    if (!tablero1[j].EstaCubierta()) {//La casilla normal está descubierta
                        contadorCasillasNormales++;
                    }
                }
                if (tablero1[j] instanceof CasillasMina) {
                    if (tablero1[j].EstaMarcada()) {//La casilla mina está marcada
                        contadorCasillasMina++;
                    }
                }
            }
        }
        return contadorCasillasMina == cantidadDeCasillasMina && contadorCasillasNormales == cantidadDeCasillasNormales;
    }

    // GETTERS -----------------------------------------------------------------
    public int getFilasTablero() {
        return filasTablero;
    }

    public int getColumnasTablero() {
        return columnasTablero;
    }

    public int getCantidadDeMinas() {
        return cantidadDeCasillasMina;
    }

    public Casillas[][] getTablero() {
        return tablero;
    }

}
