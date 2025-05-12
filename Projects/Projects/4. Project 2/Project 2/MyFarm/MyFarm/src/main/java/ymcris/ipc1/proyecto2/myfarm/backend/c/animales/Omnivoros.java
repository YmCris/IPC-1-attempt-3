package ymcris.ipc1.proyecto2.myfarm.backend.c.animales;

import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Productos;

/**
 * Clase Omnivoros es la sub clase encargada de representar los animales
 * omnivoros así como definir los métodos de esos animales.
 *
 * @author YmCris
 * @since May 8, 2025
 */
public class Omnivoros extends Animales {

    // CONSTANTES --------------------------------------------------------------
    private static final long serialVersionUID = 471449985;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Omnivoros(String nombre, int precio, double espacio, int edadMaxima, boolean esHerbivoro, boolean esDestazable, boolean produciraProductosConDestace) {
        super(nombre, precio, espacio, edadMaxima, esHerbivoro, esDestazable, produciraProductosConDestace);
    }

    //MÉTODOS SOBREESCRITOS ----------------------------------------------------
    public Productos generarProductos() {
        return null;
    }

}
