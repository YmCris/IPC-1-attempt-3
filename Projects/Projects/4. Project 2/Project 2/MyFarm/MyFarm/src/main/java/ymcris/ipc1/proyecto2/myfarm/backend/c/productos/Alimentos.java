package ymcris.ipc1.proyecto2.myfarm.backend.c.productos;

/**
 * Clase Alimentos es la clase encargada de crear alimentos para el consumo del
 * granjero y de los animales.
 *
 * @author YmCris
 * @since May 3, 2025
 */
public class Alimentos extends Productos {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    /**
     * Cantidad para utilizar en los alimentos predeterminados para los
     * animales, no para los generados durante el proceso de la granja.
     */
    private int cantidad;
    private boolean estaPodrido;
    private boolean esParaHerbivoros;
    // CONSTANTES --------------------------------------------------------------
    private static final long serialVersionUID = 540124787;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Alimentos(String nombre, int precioDeVenta, int precioDeCompra, boolean esParaHerbivoros) {
        super(nombre, precioDeVenta, precioDeCompra);
        this.esParaHerbivoros = esParaHerbivoros;
        this.seObtieneAlDestazar = false;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    
    // GETTERS -----------------------------------------------------------------
    public boolean esParaHerbivoros() {
        return esParaHerbivoros;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean estaPodrido() {
        return estaPodrido;
    }

    public void setEstaPodrido(boolean estaPodrido) {
        this.estaPodrido = estaPodrido;
    }
    
    

}
