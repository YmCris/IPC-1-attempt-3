package ymcris.ipc1.proyecto2.myfarm.backend.c.animales;

import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Productos;

/**
 * Clase hola 
 *
 * @author YmCris
 * @since May 7, 2025
 */
public class hola extends Animales{

    public hola(String nombre, int precio, double espacio, int edadMaxima, boolean esHerbivoro, boolean esDestazable, boolean produciraProductosConDestace) {
        super(nombre, precio, espacio, edadMaxima, esHerbivoro, esDestazable, produciraProductosConDestace);
    }

    @Override
    public Productos generarProductos() {
        return null;
    }

    @Override
    public void run() {
    }
    
    // VARIABLES DE REFERENCIA -------------------------------------------------
    

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    

    // INSTANCIAS --------------------------------------------------------------
    

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    

    // MÉTODOS CONCRETOS -------------------------------------------------------
    

    // GETTERS -----------------------------------------------------------------
    

    // SETTERS -----------------------------------------------------------------
    


}
