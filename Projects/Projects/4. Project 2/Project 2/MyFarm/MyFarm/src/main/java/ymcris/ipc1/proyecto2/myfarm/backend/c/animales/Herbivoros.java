package ymcris.ipc1.proyecto2.myfarm.backend.c.animales;

import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Productos;

/**
 * Clase Herbivoros es la sub clase encargada de representar los animales
 * herbivoros así como definir los métodos de esos animales.
 *
 * @author YmCris
 * @since May 8, 2025
 */
public class Herbivoros extends Animales {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    // VARIABLES PRIMITIVAS ----------------------------------------------------
    // CONSTANTES --------------------------------------------------------------
    private static final long serialVersionUID = 98130415;
    // INSTANCIAS --------------------------------------------------------------
    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Herbivoros(String nombre, int precio, double espacio, int edadMaxima, boolean esHerbivoro, boolean esDestazable, boolean produciraProductosConDestace) {
        super(nombre, precio, espacio, edadMaxima, esHerbivoro, esDestazable, produciraProductosConDestace);
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    public Productos generarProductos() {
        return null;
    }

    @Override
    public void run() {

    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    // GETTERS -----------------------------------------------------------------
    // SETTERS -----------------------------------------------------------------
}
