package ymcris.ipc1.practica2.codengames.buscaminas.backend;

/**
 * Clase Buscaminas es el motor del juego del juego "Buscaminas", que se
 * comunicará con el BuscaminasController que a su vez lo comunicará con el
 * jFrame CBuscaminas.
 *
 * @author YmCris
 * @since Apr 3, 2025
 */
public class Buscaminas {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String avatar;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int filasTablero;
    private int columnasTablero;
    private int cantidadDeMinas;

    // INSTANCIAS --------------------------------------------------------------
    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Buscaminas(String avatar, int filasTablero, int columnasTablero, int cantidadDeMinas) {
        this.avatar = avatar;
        this.filasTablero = filasTablero;
        this.columnasTablero = columnasTablero;
        this.cantidadDeMinas = cantidadDeMinas;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public void crearTablero() {

    }

    // GETTERS -----------------------------------------------------------------
    // SETTERS -----------------------------------------------------------------
}
