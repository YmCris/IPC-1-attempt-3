package ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     * MÉTODO UNICAMENTE PENSADO PARA LA COSECHA, YA NO DOY PARA VERIFICAR SI
     * SIRVE PARA OTROS CASOS.
     *
     * @param indice posición en la cual se agregará
     * @param contenido
     * @param nombre
     * @throws
     * ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaDobleException
     */
    public void agregarEnPosicion(int indice, T contenido, String nombre) throws ListaDobleException {
        if (indice < 0 || indice > tamaño) {
            throw new ListaDobleException("El índice debe estar dentro del rango de la lista");
        }
        NodoDoble<T> nuevo = new NodoDoble<>(contenido, nombre);
        if (estaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            if (indice == 0) {
                nuevo.setSiguiente(inicio);
                inicio.setAnterior(nuevo);
                inicio = nuevo;
            } else if (indice == tamaño) {
                nuevo.setAnterior(fin);
                fin.setSiguiente(nuevo);
                fin = nuevo;
            } else {
                NodoDoble<T> nodoACambiar = obtenerNodo(indice);
                NodoDoble<T> nodoAnterior = nodoACambiar.getAnterior();
                nodoAnterior.setSiguiente(nuevo);
                nuevo.setAnterior(nodoAnterior);
                nuevo.setSiguiente(nodoACambiar);
                nodoACambiar.setAnterior(nuevo);
            }
        }
        tamaño++;
    }

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
    public void eliminarNodo(int indice) {
        try {
            if (existeNodoConContenido(obtenerNodo(indice).getNombre())) {
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
                System.out.println("Se ha eliminado el nodo: " + nodoAEliminar.getNombre());
                tamaño--;
            }
        } catch (ListaDobleException ex) {
            System.out.println(ex.getMessage());
        }
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

    public T obtenerNodo(String nombre) throws ListaDobleException {
        for (int i = 0; i < tamaño; i++) {
            NodoDoble<T> temp = obtenerNodo(i);
            if (temp.getNombre().equals(nombre)) {
                return temp.getContenido();
            }
        }
        throw new ListaDobleException("No se ha podido obtener el nodo con el nombre porque, no existe");
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
