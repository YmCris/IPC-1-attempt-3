package ymcris.ipc1.proyecto2.myfarm.backend.a.listas;

/**
 * Clase ListaOrtogonal es la clase encargada de ser el "arreglo de arreglos"
 * dinámico para la creación del tablero.
 *
 * @author YmCris
 * @param <T>
 * @since Apr 27, 2025
 */
public class ListaOrtogonal<T> {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private NodoOrtogonal<T> fin;
    private NodoOrtogonal<T> inicioFila;
    private NodoOrtogonal<T> inicioColumna;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int filas;
    private int tamaño;
    private int columnas;
    private int limiteFilas;
    private boolean turnoFilas;
    private boolean turnoColumnas;

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public void crearTablero(NodoOrtogonal<T>[] arreglo) {
        for (int i = 0; i <= 25; i++) {
            agregarFila(arreglo[i]);
            agregarColumna(arreglo[i]);
        }
    }

    private boolean estaVacio() {
        return tamaño == 0;
    }

    private void agregarFila(NodoOrtogonal<T> nuevo) {
        if (turnoFilas) {
            if (estaVacio()) {
                fin = nuevo;
                return;
            }
            fin.setNodoDerecho(nuevo);
            nuevo.setNodoIzquierdo(fin);
            fin = nuevo;
        }
        if (filas == limiteFilas) {
            filas++;
            limiteFilas++;
            turnoFilas = false;
            turnoColumnas = true;
        }
    }

    private void agregarColumna(NodoOrtogonal<T> nuevo) {
        if (turnoColumnas) {

        }
        columnas++;
        turnoFilas = true;
        turnoColumnas = false;
    }

    private void obtenerNodo(int fila, int columna) {
    }

    // GETTERS -----------------------------------------------------------------
    public int getTamaño() {
        return filas * columnas;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}
