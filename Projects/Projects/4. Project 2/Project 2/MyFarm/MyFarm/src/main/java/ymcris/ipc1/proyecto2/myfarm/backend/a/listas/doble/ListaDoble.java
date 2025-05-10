package ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble;

import java.io.Serializable;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaDobleException;

/**
 * Clase ListaDoble es la clase encargada de ser el "almacen" dinámico para
 * guardar referencias del tipo T
 *
 * @author YmCris
 * @param <T> Tipo de dato a guardar
 * @since Apr 26, 2025
 */
public class ListaDoble<T> implements Serializable {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private NodoDoble<T> fin;
    private NodoDoble<T> inicio;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int tamaño;

    private static final long serialVersionUID = 89441124;

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public void inseretar(T contenido) {
        
    }
    
    public void agregar(T contenido) {
        NodoDoble<T> nuevo = new NodoDoble<>(contenido);
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
     * @param contenido
     * @return
     * @throws ListaDobleException
     */
    public T usar(T contenido) throws ListaDobleException {
        NodoDoble<T> nodoAUtilizar;
        for (int i = 0; i < tamaño; i++) {
            nodoAUtilizar = obtenerNodo(i);
            if (nodoAUtilizar.getContenido().equals(contenido)) {
                eliminarNodo(i);
                System.out.println("Se ha utilizado el elmento " + contenido.toString());
                return nodoAUtilizar.getContenido();
            }
        }
        throw new ListaDobleException("No existe el elemento con ese contenido");
    }

    private void eliminarNodo(int indice) {
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
        tamaño--;
    }

    private NodoDoble<T> obtenerNodo(int indice) {
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
     * @deprecated ssssss
     * @param contenido
     * @return 
     */
    public boolean existeNodoConContenido(T contenido) {
        for (int i = 0; i < tamaño; i++) {
            if (obtenerNodo(i).getContenido().equals(contenido)) {
                System.out.println("Existe el nodo con el contenido "+contenido.toString());
                return true;
            }
        }
        System.out.println("NO Existe el nodo con el contenido "+contenido.toString());
        return false;
    }

    public Object[] obtenerArregloDeObjetos() {
        Object[] objects = new Object[tamaño];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = obtenerNodo(i).getContenido();
        }
        return objects;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    // GETTERS -----------------------------------------------------------------
    public int getTamaño() {
        return tamaño;
    }

}
