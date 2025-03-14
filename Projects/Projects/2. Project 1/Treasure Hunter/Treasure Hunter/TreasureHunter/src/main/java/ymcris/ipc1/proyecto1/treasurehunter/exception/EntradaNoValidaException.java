package ymcris.ipc1.proyecto1.treasurehunter.exception;

/**
 * Clase encargada de crear la exception que se lanza cuando el usuario no
 * introduce la entrada que se espera.
 *
 * @author YmCris
 * @since Mar 13, 2025
 */
public class EntradaNoValidaException extends Exception {

    /**
     * Método Constructor encargado de capturar el mensaje.
     *
     * @param message - Mensaje que se mostrará cuando el usuario introduzca una
     * entrada erronea.
     */
    public EntradaNoValidaException(String message) {
        super(message);
    }

}
