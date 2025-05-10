package ymcris.ipc1.proyecto2.myfarm.backend.c.productos;

/**
 * Clase Fertilizantes es la clase encargada de representar el concepto de los
 * fertilizantes de la tierra para poder agregarlos en archivos de texto.
 *
 * @author YmCris
 * @since May 6, 2025
 */
public class Fertilizantes {

    // VARIABLES DE REFERNCIA --------------------------------------------------
    private String nombre;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int precio;
    private int cantidad;
    private int fertilidad;

    public Fertilizantes(String nombre, int fertilidad, int precio) {
        this.nombre = nombre;
        this.fertilidad = fertilidad;
        this.precio = precio;
    }

    // GETTERS -----------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public int getFertilidad() {
        return fertilidad;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    // SETTERS -----------------------------------------------------------------
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
