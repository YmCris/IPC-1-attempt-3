package ymcris.ipc1.proyecto2.myfarm.backend.a.cola;

import java.io.Serializable;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ColaException;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaDobleException;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble.ListaDoble;

/**
 * Clase Cola es la clase encargada de representar unicamente la cosecha dentro
 * del juego.
 *
 * @author YmCris
 * @param <T> Tipo de dato que tendrá el contenedor.
 * @since May 5, 2025
 */
public class Cola<T> implements Serializable{

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private ListaDoble<T> contenedor;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int indice;
    
    private static final long serialVersionUID = 528210342;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Cola() {
        this.contenedor = new ListaDoble<>();
        this.indice = 0;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public void agregarElemento(T elemento, String nombre) {
        System.out.println("Se ha agregado el elemento " + nombre + " en la posición " + indice);
        contenedor.agregar(elemento, nombre);
        indice++;
    }

    public T sacarElemento() throws ColaException, ListaDobleException {
        if (!estaVacio()) {
            T temp = contenedor.obtenerNodo(0).getContenido();
            contenedor.eliminarNodo(0);
            System.out.println("Cola");
            indice--;
            return temp;
        }
        throw new ColaException("No se pudo sacar el elemento, porque la cola esta vacia");
    }

    public void mostrarContenido() {
        for (int i = 0; i < indice; i++) {
            System.out.println(contenedor.obtenerNodo(i).getContenido().toString());
        }
    }

    public T darVistazo() throws ColaException {
        if (!estaVacio()) {
            return contenedor.obtenerNodo(0).getContenido();
        }
        throw new ColaException("La cola está vacia");
    }

    public boolean estaVacio() {
        return indice == 0;
    }

    public ListaDoble<T> getContenedor() {
        return contenedor;
    }

    public int getIndice() {
        return indice;
    }
    
}
