package ymcris.ipc1.proyecto2.myfarm.backend.c.productos;

/**
 * Clase Productos es la clase encargada de crear productos.
 *
 * @author YmCris
 * @since May 4, 2025
 */
public class Productos {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nombre;
    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private boolean esMateriaPrima;
    private int porcentajeDeproduccion;
    private boolean seObtieneAlDestazar;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Productos(String nombre, int porcentajeDeproduccion, boolean seObtieneAlDestazar, boolean esMateriaPrima) {
        this.nombre = nombre;
        this.porcentajeDeproduccion = porcentajeDeproduccion;
        this.seObtieneAlDestazar = seObtieneAlDestazar;
        this.esMateriaPrima = esMateriaPrima;
    }

    // GETTERS -----------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public int getPorcentajeDeproduccion() {
        return porcentajeDeproduccion;
    }

    public boolean isSeObtieneAlDestazar() {
        return seObtieneAlDestazar;
    }

    public boolean isEsMateriaPrima() {
        return esMateriaPrima;
    }

}
