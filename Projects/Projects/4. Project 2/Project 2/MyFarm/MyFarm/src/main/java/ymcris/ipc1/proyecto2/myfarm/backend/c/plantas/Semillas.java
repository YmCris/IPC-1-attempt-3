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
    private boolean produceFruta;
    private int semillasRequeridas;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Semillas(String nombre, int precio, int semillasRequeridas, boolean produceFruta) {
        this.nombre = nombre;
        this.precio = precio;
        this.produceFruta=produceFruta;
        this.semillasRequeridas=semillasRequeridas;
    }

    // GETTERS -----------------------------------------------------------------
    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isProduceFruta() {
        return produceFruta;
    }

    public int getSemillasRequeridas() {
        return semillasRequeridas;
    }
    
    // SETTERS -----------------------------------------------------------------
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
