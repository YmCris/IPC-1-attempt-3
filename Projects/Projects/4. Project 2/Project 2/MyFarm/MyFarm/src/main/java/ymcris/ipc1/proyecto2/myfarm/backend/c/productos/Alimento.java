package ymcris.ipc1.proyecto2.myfarm.backend.c.productos;

/**
 * Clase Alimentos es la clase encargada de crear alimentos para el consumo del
 * granjero y de los animales.
 *
 * @author YmCris
 * @since May 3, 2025
 */
public class Alimento extends Productos {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private boolean esParaHervivoros;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Alimento(String nombre, int porcentajeDeproduccion, boolean esParaHervivoros) {
        super(nombre, porcentajeDeproduccion, false, false);
        this.esParaHervivoros = esParaHervivoros;
    }

    // GETTERS -----------------------------------------------------------------
    public boolean isEsParaHervivoros() {
        return esParaHervivoros;
    }

}
