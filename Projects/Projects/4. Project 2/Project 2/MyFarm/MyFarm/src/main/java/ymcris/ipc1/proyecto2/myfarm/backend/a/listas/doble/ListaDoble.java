package ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble;

import java.io.Serializable;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaDobleException;

/**
 * Clase ListaDoble es la clase encargada de ser el "almacen" dinámico para
 * guardar referencias del tipo T
 *
 * @author YmCris
 * @param <T> Tipo de dato que guardará la lista doble
 * @see ListaDobleException
 * @since Apr 26, 2025
 */
public class ListaDoble<T> implements Serializable {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private NodoDoble<T> fin;
    private NodoDoble<T> inicio;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int tamaño;

    // CONSTANTES --------------------------------------------------------------
    private static final long serialVersionUID = 89441124;

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de agregar un nuevo nodo con una instancia nueva a la
     * lista.
     *
     * @param contenido contenido T a agregar.
     * @param nombre nombre del nodo.
     */
    public void agregar(T contenido, String nombre) {
        NodoDoble<T> nuevo = new NodoDoble<>(contenido, nombre);
        switch (tamaño) {
            case 0 -> {
                inicio = nuevo;
                fin = nuevo;
            }
            case 1 -> {
                inicio.setSiguiente(nuevo);
                nuevo.setAnterior(inicio);
                fin = nuevo;
            }
            default -> {
                nuevo.setAnterior(fin);
                fin.setSiguiente(nuevo);
                fin = nuevo;
            }
        }
        tamaño++;
    }

    /**
     * Método encargado de usar el elemento en la lista y eliminarlo.
     *
     * @param nombre nombre del contenido que se va a usar.
     * @return Contenido del nodo utilizado.
     * @throws ListaDobleException
     */
    public T usar(String nombre) throws ListaDobleException {
        NodoDoble<T> nodoAUtilizar;
        for (int i = 0; i < tamaño; i++) {
            nodoAUtilizar = obtenerNodo(i);
            if (nodoAUtilizar.getNombre().equals(nombre)) {
                eliminarNodo(i);
                System.out.println("Se ha utilizado el elemento " + nombre);
                return nodoAUtilizar.getContenido();
            }
        }
        throw new ListaDobleException("No existe el elemento con ese contenido");
    }

    /**
     * Método encaragdo de eliminar un nodo en base a un índice.
     *
     * @param indice posición de la lista para eliminar el nodo.
     */
    private void eliminarNodo(int indice) {
        try {
            System.out.println("Existe el nodo: con el nombre " + existeNodoConContenido(obtenerNodo(indice).getNombre()));
        } catch (ListaDobleException ex) {
            System.out.println("...");
        }
        NodoDoble<T> nodoAEliminar = obtenerNodo(indice);
        if (indice == 0) {
            inicio = nodoAEliminar.getSiguiente();
            if (inicio != null) {
                inicio.setAnterior(null);
            }
        } else if (indice == tamaño - 1) {
            fin = nodoAEliminar.getAnterior();
            fin.setSiguiente(null);
        } else {
            NodoDoble<T> nodoAnterior = nodoAEliminar.getAnterior();
            NodoDoble<T> nodoSiguiente = nodoAEliminar.getSiguiente();
            nodoAnterior.setSiguiente(nodoSiguiente);
            nodoSiguiente.setAnterior(nodoAnterior);
        }
        System.out.println("SE HA ELIMINADO EL NODO CON EL NOMBRE: " + nodoAEliminar.getNombre());
        nodoAEliminar.setAnterior(null);
        nodoAEliminar.setSiguiente(null);
        nodoAEliminar.setContenido(null);
        nodoAEliminar = null;
        tamaño--;
    }

    /**
     * Método encargado de obtener el nodo en base a un índice
     *
     * @param indice posición de la cadena a devolver.
     * @return nodo en el indice especificado.
     */
    public NodoDoble<T> obtenerNodo(int indice) throws NullPointerException {
        NodoDoble<T> temporal;
        if (indice <= tamaño / 2) {
            temporal = inicio;
            for (int i = 0; i < indice; i++) {
                temporal = temporal.getSiguiente();
            }
        } else {
            temporal = fin;
            for (int i = tamaño - 1; i > indice; i--) {
                temporal = temporal.getAnterior();
            }
        }
        return temporal;
    }

    /**
     * Método encargado de verificar si existe un nodo con el mismo contenido
     * (Realmente lo que hace es verificar si el nodo ya tiene un nombre con el
     * nombre que se quiere saber si existe.)
     *
     * @param nombre nombre del elemento a buscar
     * @return true si existe.
     * @throws ListaDobleException
     */
    public boolean existeNodoConContenido(String nombre) throws ListaDobleException {
        for (int i = 0; i < tamaño; i++) {
            if (obtenerNodo(i) != null) {
                if (obtenerNodo(i).getNombre().equals(nombre)) {
                    System.out.println("Existe el nodo con el nombre: " + nombre + " en la posición: " + i);
                    return true;
                }
            }
        }
        throw new ListaDobleException("No existe el nodo");
    }

    /**
     * Método encargado de obtener un arreglo de objetos, ¿para qué? quizas
     * sirva.
     *
     * @return arreglo de objetos
     */
    public Object[] obtenerArregloDeObjetos() {
        Object[] objects = new Object[tamaño];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = obtenerNodo(i).getContenido();
        }
        return objects;
    }

    /**
     * Método encargado de verificar si la lista esta vacia.
     *
     * @return true si lo está.
     */
    public boolean estaVacia() {
        return tamaño == 0;
    }

    // GETTERS -----------------------------------------------------------------
    /**
     * Devuelve el tamaño de la lísta doblemente enlazada.
     *
     * @return tamaño de la lista.
     */
    public int length() {
        return tamaño;
    }

}
