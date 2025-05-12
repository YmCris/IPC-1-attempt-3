package ymcris.ipc1.proyecto2.myfarm.backend.c.suelos;

/**
 * Clase Desierto es la clase encargada de representar las celdas de decierto,
 * no hacen nadota
 *
 * @author YmCris
 * @since Apr 26, 2025
 */
public class Desierto extends Suelo {

    // CONSTANTES --------------------------------------------------------------
    private static final String NOMBRE_SUELO = "Desierto";
    private static final String RUTA_IMAGEN = "/arena.png";

    private static final long serialVersionUID = 789078945;
    
    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Desierto() {
        this.nombre = NOMBRE_SUELO;
        this.rutaImagen = RUTA_IMAGEN;
        colocarImagen();
    }

}
