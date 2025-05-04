package ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions;

/**
 * Clase ArchivoException es la clase Exception encargada de notificar sobre
 * excepciones ocurridas al realizar algo con archivos ya sean de texto o
 * binarios.
 *
 * @author YmCris
 * @since May 3, 2025
 */
public class ArchivoException extends Exception {

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public ArchivoException(String message) {
        super(message);
    }

}
