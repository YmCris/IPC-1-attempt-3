package ymcris.ipc1.proyecto2.myfarm.backend.a.listas.ortogonal;

import java.io.Serializable;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaOrtogonalException;

/**
 * Clase ListaOrtogonal es la clase encargada de ser el "arreglo de arreglos"
 * dinámico para la creación del tablero.
 *
 * @author YmCris
 * @since Apr 27, 2025
 */
public class ListaOrtogonal implements Serializable{

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private NodoOrtogonal inicio;
    private NodoOrtogonal finFila;
    private NodoOrtogonal inicioFila;
    private NodoOrtogonal inicioColumna;
    private NodoOrtogonal finColumna;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int filas;
    private int columnas;
    private int limiteFilas;
    private int limiteColumnas;
    private boolean turnoFilas;
    private boolean turnoColumnas;

    private int nodosEnFilas;
    private int nodosEnColumnas;

    private static final long serialVersionUID = 425746024;
    
    public ListaOrtogonal() {
        this.filas = 0;
        this.columnas = 0;
        this.limiteFilas = 5;
        this.limiteColumnas = 5;
        this.turnoFilas = true;
        this.turnoColumnas = false;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public void crearTablero(NodoOrtogonal[] suelos) throws ListaOrtogonalException {
        NodoOrtogonal[][] matrizDeSuelos = new NodoOrtogonal[5][5];
        int indice = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrizDeSuelos[i][j] = suelos[indice];
                suelos[indice].getSuelo().setFila(i);
                suelos[indice].getSuelo().setColumna(j);
                indice++;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                NodoOrtogonal actual = matrizDeSuelos[i][j];
                // 1. Referencias de izquierda y derecha
                if (j < 4) {
                    actual.setNodoDerecho(matrizDeSuelos[i][j + 1]);
                }
                if (j > 0) {
                    actual.setNodoIzquierdo(matrizDeSuelos[i][j - 1]);
                }
                // 2. Referencias de arriba y abajo
                if (i < 4) {
                    actual.setNodoDeAbajo(matrizDeSuelos[i + 1][j]);
                }
                if (i > 0) {
                    actual.setNodoDeArriba(matrizDeSuelos[i - 1][j]);
                }
            }
        }
        //3. Establecer nodo inicio
        inicio = matrizDeSuelos[0][0];
        inicioFila = matrizDeSuelos[4][0];
        inicioColumna = matrizDeSuelos[0][4];
        filas = 5;
        columnas = 5;
    }

    public void agregarNodoEnFila(NodoOrtogonal nuevo) throws ListaOrtogonalException {
        if (turnoFilas) {
            //1. Referencias de izquierda y derecha
            nodosEnFilas++;
            if (nodosEnFilas == 1) {
                filas++;
                inicioFila.setNodoDeAbajo(nuevo);
                finFila = nuevo;
            } else {
                finFila.setNodoDerecho(nuevo);
                nuevo.setNodoIzquierdo(finFila);
                finFila = nuevo;
            }
            //2. Referencias de arriba
            nuevo.setNodoDeArriba(inicioFila);
            inicioFila.setNodoDeAbajo(nuevo);
            if (inicioFila.getNodoDerecho() != null) {
                inicioFila = inicioFila.getNodoDerecho();
            }
            if (nodosEnFilas == limiteFilas) {
                limiteFilas++;
                nodosEnFilas = 0;
                turnoFilas = false;
                turnoColumnas = true;
                inicioFila = obtenerNodo(filas - 1, 0);
                System.out.println("inicio fila será en " + (filas - 1) + " columna " + 0 + " elemento " + inicioFila.getSuelo().getNombre());
            }
        } else {
            System.out.println("Es turno de agregar una columna");
        }
    }

    public void agregarNodoEnColumna(NodoOrtogonal nuevo) throws ListaOrtogonalException {
        if (turnoColumnas) {
            nodosEnColumnas++;
            if (nodosEnColumnas == 1) {
                columnas++;
                finColumna = nuevo;
                inicioColumna.setNodoDerecho(nuevo);
                nuevo.setNodoIzquierdo(inicioColumna);
            } else {
                //REFERENCIAS DE ARRIBA Y ABAJO
                finColumna.setNodoDeAbajo(nuevo);
                nuevo.setNodoDeArriba(finColumna);
                finColumna = nuevo;
                //REFERENCIAS DE IZQUIERDA
                if (inicioColumna.getNodoDeAbajo() != null) {
                    inicioColumna = inicioColumna.getNodoDeAbajo();
                }
                inicioColumna.setNodoDerecho(nuevo);
                nuevo.setNodoIzquierdo(inicioColumna);
            }
            if (nodosEnColumnas == limiteColumnas) {
                limiteColumnas++;
                nodosEnColumnas = 0;
                turnoFilas = true;
                turnoColumnas = false;
                inicioColumna = obtenerNodo(0, columnas - 1);
                System.out.println("inicio columna será en " + 0 + " columna " + (columnas - 1) + " elemento " + inicioColumna.getSuelo().getNombre());
            }
        } else {
            System.out.println("Es turno de agregar una fila");
        }
    }

    public NodoOrtogonal obtenerNodo(int fila, int columna) throws ListaOrtogonalException {
        if (fila >= filas || columna >= columnas || fila < 0 || columna < 0) {
            throw new ListaOrtogonalException("No puedes obtener un nodo fuera del rango de la lista ortogonal");
        }
        if (fila == 0 && columna == 0) {
            return inicio;
        } else {
            NodoOrtogonal actual = inicio;
            for (int i = 0; i < fila; i++) {//RECORRE LA LISTA HORIZONTALMENTE LAS "FILA" VECES
                if (actual != null) {
                    actual = actual.getNodoDeAbajo();
                }
            }
            for (int j = 0; j < columna; j++) {//RECORRE LA LISTA VERTICALMENTE LAS "COLUMNAS" VECES
                if (actual != null) {
                    actual = actual.getNodoDerecho();
                }
            }
            if (actual == null) {
                throw new NullPointerException("El nodo en la posición: " + fila + ", " + columna + " es nulo");
            }

            return actual;
        }
    }

    public void mostrarTablero() {
        try {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(obtenerNodo(i, j).getSuelo().getNombre() + " ");
                }
                System.out.println("");
            }
        } catch (ListaOrtogonalException e) {
            System.out.println(" error al crear tablero porque " + e.getMessage());
        }
    }

    // GETTERS -----------------------------------------------------------------
    public int length() {
        return filas * columnas;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    private boolean estaVacio() {
        return inicio == null;
    }
}
