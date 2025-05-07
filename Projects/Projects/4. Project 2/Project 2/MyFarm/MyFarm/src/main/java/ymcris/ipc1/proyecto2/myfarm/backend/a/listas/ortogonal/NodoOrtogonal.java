package ymcris.ipc1.proyecto2.myfarm.backend.a.listas.ortogonal;

/**
 * Clase NodoOrtogonal es la clase encargada de ser la Celda de cada eslabon
 * dentro de la Cadena de cadenas "Lista ortogonal"
 *
 * @author YmCris
 * @param <T>
 * @since Apr 27, 2025
 */
public class NodoOrtogonal<T> {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private T contenido;
    private NodoOrtogonal<T> nodoDerecho;
    private NodoOrtogonal<T> nodoDeAbajo;
    private NodoOrtogonal<T> nodoDeArriba;
    private NodoOrtogonal<T> nodoIzquierdo;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public NodoOrtogonal(T contenido) {
        this.contenido = contenido;
    }

    // GETTERS -----------------------------------------------------------------
    public T getContenido() {
        return contenido;
    }

    public NodoOrtogonal<T> getNodoDerecho() {
        return nodoDerecho;
    }

    public NodoOrtogonal<T> getNodoDeAbajo() {
        return nodoDeAbajo;
    }

    public NodoOrtogonal<T> getNodoDeArriba() {
        return nodoDeArriba;
    }

    public NodoOrtogonal<T> getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    // SETTERS -----------------------------------------------------------------
    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public void setNodoDerecho(NodoOrtogonal<T> nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }

    public void setNodoDeAbajo(NodoOrtogonal<T> nodoDeAbajo) {
        this.nodoDeAbajo = nodoDeAbajo;
    }

    public void setNodoDeArriba(NodoOrtogonal<T> nodoDeArriba) {
        this.nodoDeArriba = nodoDeArriba;
    }

    public void setNodoIzquierdo(NodoOrtogonal<T> nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

}
