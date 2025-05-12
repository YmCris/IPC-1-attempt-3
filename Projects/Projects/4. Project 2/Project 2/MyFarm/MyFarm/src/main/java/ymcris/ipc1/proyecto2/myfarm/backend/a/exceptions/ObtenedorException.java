package ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions;

/**
 * Clase ObtenedorException es la clase encargada de capturar las exceptions que
 * puedan surgir al intentar obtener algún elemento y no obtenerlo.
 *
 * @author YmCris
 * @since May 10, 2025
 */
public class ObtenedorException extends Exception {

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public ObtenedorException(String message) {
        super(message);
    }

}
