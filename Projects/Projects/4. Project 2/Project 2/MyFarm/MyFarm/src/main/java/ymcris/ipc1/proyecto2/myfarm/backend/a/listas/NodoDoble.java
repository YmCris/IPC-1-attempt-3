package ymcris.ipc1.proyecto2.myfarm.backend.a.listas;

/**
 * Clase NodoDoble es la clase encargada de crear Nodos para almacenar
 * información en la lista doble
 *
 * @author YmCris
 * @param <T> Tipo de dato a almacenar
 * @since Apr 26, 2025
 */
public class NodoDoble<T> {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private T contenido;
    private NodoDoble anterior;
    private NodoDoble siguiente;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public NodoDoble(T contenido) {
        this.contenido = contenido;
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

}
