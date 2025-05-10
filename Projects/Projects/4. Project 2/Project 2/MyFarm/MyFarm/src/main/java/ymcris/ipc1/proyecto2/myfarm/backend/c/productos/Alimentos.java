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

}
