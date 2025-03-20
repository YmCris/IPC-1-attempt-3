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

    /**
     * Método Constructor encargado de capturar el mensaje.
     *
     * @param message - Mensaje que se mostrará cuando el usuario introduzca una
     * entrada erronea.
     */
    public EntradaNoValidaException(String message) {
        super(message);
    }

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

    /**
     * Método encargado de informar al usuario que su entrada no esta dentro del
     * rango esperado o que no es coherente.
     *
     * @param limiteInferior
     * @param valorInferior
     * @param limiteSuperior
     * @param valorSuperior
     */
    public static void validarValores(int limiteInferior, int valorInferior, int limiteSuperior, int valorSuperior) {
        if (valorInferior < limiteInferior) {
            System.out.println("El valor " + valorInferior + " debe ser mayor que " + limiteInferior);
        }
        if (valorSuperior > limiteSuperior) {
            System.out.println("El valor " + valorSuperior + " debe ser mayor que " + limiteSuperior);
        }
        if (valorInferior < limiteInferior || valorSuperior > limiteSuperior) {
            errorEncontrado();
        }
    }

}
