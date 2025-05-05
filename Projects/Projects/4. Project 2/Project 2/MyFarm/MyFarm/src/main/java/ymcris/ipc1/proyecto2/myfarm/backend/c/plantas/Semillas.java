package ymcris.ipc1.proyecto2.myfarm.backend.c.plantas;

/**
 * Clase Semillas es la clase encargada de crear semillas
 *
 * @author YmCris
 * @since May 4, 2025
 */
public class Semillas {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nombre;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int precio;
    private int cantidad;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Semillas(String nombre, int precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // GETTERS -----------------------------------------------------------------
    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    // SETTERS -----------------------------------------------------------------
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
