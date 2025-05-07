package ymcris.ipc1.proyecto2.myfarm.backend.c.productos;

/**
 * Clase Productos es la clase encargada de crear productos.
 *
 * @author YmCris
 * @since May 4, 2025
 */
public class Productos {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    protected String nombre;
    
    // VARIABLES PRIMITIVAS ----------------------------------------------------
    protected int precioDeVenta;
    protected int precioDeCompra;
    protected boolean esMateriaPrima;
    protected boolean seObtieneAlDestazar;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Productos(String nombre, int precioDeVenta, int precioDeCompra) {
        this.nombre = nombre;
        this.precioDeVenta = precioDeVenta;
        this.precioDeCompra = precioDeCompra;
    }

    // GETTERS -----------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public boolean seObtieneAlDestazar() {
        return seObtieneAlDestazar;
    }

    public boolean esMateriaPrima() {
        return esMateriaPrima;
    }

    public int getPrecioDeVenta() {
        return precioDeVenta;
    }

    public int getPrecioDeCompra() {
        return precioDeCompra;
    }

}
