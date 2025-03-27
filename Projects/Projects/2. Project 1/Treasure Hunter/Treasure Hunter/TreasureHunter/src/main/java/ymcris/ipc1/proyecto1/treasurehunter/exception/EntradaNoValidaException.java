/**
 * Paquete donde se implementan todos los recursos relacionados con las exceptions
 */
package ymcris.ipc1.proyecto1.treasurehunter.exception;

import java.util.Scanner;

/**
 * Clase encargada de crear la exception que se lanza cuando el usuario no
 * introduce la entrada que se espera.
 *
 * @author YmCris
 * @since Mar 13, 2025
 */
public class EntradaNoValidaException extends Exception {

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método Constructor encargado de capturar el mensaje.
     *
     * @param message - Mensaje que se mostrará cuando el usuario introduzca una
     * entrada erronea.
     */
    public EntradaNoValidaException(String message) {
        super(message);
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de informar al usuario que ha introducido un valor fuera
     * del rango esperado y espera a que el usuario introduzca un salto de línea
     * para poder continuar con la ejecución
     */
    public static void errorEncontrado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor ingresa una opción válida");
        System.out.println("Presiona enter para continuar");
        scanner.nextLine();
    }

}
