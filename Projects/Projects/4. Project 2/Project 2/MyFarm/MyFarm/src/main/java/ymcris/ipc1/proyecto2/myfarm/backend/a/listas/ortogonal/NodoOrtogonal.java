package ymcris.ipc1.proyecto2.myfarm.backend.a.listas.ortogonal;

import java.io.Serializable;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Suelo;

/**
 * Clase NodoOrtogonal es la clase encargada de ser la Celda de cada eslabon
 * dentro de la Cadena de cadenas "Lista ortogonal"
 *
 * @author YmCris
 * @since Apr 27, 2025
 */
public class NodoOrtogonal implements Serializable {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Suelo suelo;
    private NodoOrtogonal nodoDerecho;
    private NodoOrtogonal nodoDeAbajo;
    private NodoOrtogonal nodoDeArriba;
    private NodoOrtogonal nodoIzquierdo;

    private static final long serialVersionUID = 782104159;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public NodoOrtogonal(Suelo suelo) {
        this.suelo = suelo;
    }

    // GETTERS -----------------------------------------------------------------
    public Suelo getSuelo() {
        return suelo;
    }

    public NodoOrtogonal getNodoDerecho() {
        return nodoDerecho;
    }

    public NodoOrtogonal getNodoDeAbajo() {
        return nodoDeAbajo;
    }

    public NodoOrtogonal getNodoDeArriba() {
        return nodoDeArriba;
    }

    public NodoOrtogonal getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    // SETTERS -----------------------------------------------------------------
    public void setSuelo(Suelo suelo) {
        this.suelo = suelo;
    }

    public void setNodoDerecho(NodoOrtogonal nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }

    public void setNodoDeAbajo(NodoOrtogonal nodoDeAbajo) {
        this.nodoDeAbajo = nodoDeAbajo;
    }

    public void setNodoDeArriba(NodoOrtogonal nodoDeArriba) {
        this.nodoDeArriba = nodoDeArriba;
    }

    public void setNodoIzquierdo(NodoOrtogonal nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

}
