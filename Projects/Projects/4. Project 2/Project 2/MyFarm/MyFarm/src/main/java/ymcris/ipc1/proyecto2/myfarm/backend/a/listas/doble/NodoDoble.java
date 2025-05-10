package ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble;

import java.io.Serializable;

/**
 * Clase NodoDoble es la clase encargada de crear Nodos para almacenar
 * información en la lista doble
 *
 * @author YmCris
 * @param <T> Tipo de dato a almacenar
 * @since Apr 26, 2025
 */
public class NodoDoble<T> implements Serializable {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private T contenido;
    private String nombre;
    private NodoDoble anterior;
    private NodoDoble siguiente;

    // CONSTANTES --------------------------------------------------------------
    private static final long serialVersionUID = 1404478801;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método encargado de crear un nuevo nodo doble
     *
     * @param contenido contenido que almacenará el nodo.
     * @param nombre DEBE SER EL NOMBRE DE LO QUE VAYA A GUARDAR, "CUERO",
     * "AGUACATE", no su tipo.
     */
    public NodoDoble(T contenido, String nombre) {
        this.contenido = contenido;
        this.nombre = nombre;
    }

    // GETTERS -----------------------------------------------------------------
    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public T getContenido() {
        return contenido;
    }

    public String getNombre() {
        return nombre;
    }

    // SETTERS -----------------------------------------------------------------
    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
