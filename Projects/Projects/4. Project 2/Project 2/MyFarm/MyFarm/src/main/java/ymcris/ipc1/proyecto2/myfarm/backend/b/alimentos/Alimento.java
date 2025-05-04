package ymcris.ipc1.proyecto2.myfarm.backend.b.alimentos;

/**
 * Clase Alimentos es la clase encargada de crear alimentos para el consumo del
 * granjero y de los animales.
 *
 * @author YmCris
 * @since May 3, 2025
 */
public class Alimento {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nombre;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int recuperacionDeVida;
    private boolean esParaHervivoros;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Alimento(String nombre, int recuperacionDeVida, boolean esParaHervivoros) {
        this.nombre = nombre;
        this.recuperacionDeVida = recuperacionDeVida;
        this.esParaHervivoros = esParaHervivoros;
    }

    // GETTERS -----------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public int getRecuperacionDeVida() {
        return recuperacionDeVida;
    }

    public boolean isEsParaHervivoros() {
        return esParaHervivoros;
    }

}
