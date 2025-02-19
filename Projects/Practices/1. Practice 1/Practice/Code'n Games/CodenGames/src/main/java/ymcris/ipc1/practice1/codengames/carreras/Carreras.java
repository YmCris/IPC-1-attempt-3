package ymcris.ipc1.practice1.codengames.carreras;

import java.util.Scanner;
import ymcris.ipc1.practice1.codengames.CodenGames;

/**
 * Clase encargada de pedir información y mostrarla durante el transcurso del
 * juego.
 *
 * @since Feb 6, 2025
 * @author YmCris
 */
public class Carreras {

    //VARIABLES-----------------------------------------------------------------
    protected static int opcionMenu;//opcion 1 = jugar contra computadora
    protected static String jugadorUno;
    protected static String jugadorDos;
    protected static char[] computadora;

    // INSTANCIAS --------------------------------------------------------------
    CodenGames code = new CodenGames();
    Scanner scanner = new Scanner(System.in);
    MotorDelJuego motor = new MotorDelJuego();

    //MÉTODO CONSTRUCTOR--------------------------------------------------------
    /**
     * Método encargado de inicializar las variables
     */
    public Carreras() {

        Carreras.computadora = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};//"vehículos" de la computadora
    }

    //MÉTODOS ------------------------------------------------------------------
    /**
     * Método encargado de iniciar la partida.
     */
    public void iniciarCarrera() {
        irAlMenuPrincipal();
    }

    /**
     * Método encargado de mostrar las opciones al iniciar el juego.
     */
    protected void irAlMenuPrincipal() {
        System.out.println("\n".repeat(100));
        System.out.println("                                        ┌------------------------------------------------┐");
        System.out.println("                                        |              ¿QUÉ DESEA REALIZAR?              |");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ¦ [1]        Jugar contra Computadora            ¦");
        System.out.println("                                        ¦ [2]            Jugar contra Rival              ¦");
        System.out.println("                                        ¦ [3]               ¿Cómo jugar?                 ¦");
        System.out.println("                                        ¦ [4]                 Regresar                   ¦");
        System.out.println("                                        ¦ [5]             Salir del juego                ¦");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦            -Seleccione una opción-             ¦");
        System.out.println("                                        └------------------------------------------------┘");
        opcionMenu = scanner.nextInt();
        switch (opcionMenu) {
            case 1 ->
                motor.jugarContraComputadora();
            case 2 ->
                motor.jugarContraRival();
            case 3 -> {
                System.out.println("Hola, soy carreras.");
                scanner.nextLine();
            }
            case 4 -> {
                CodenGames coden = new CodenGames();
                coden.pedirOpcionMenu();
            }
            case 5 ->
                System.exit(0);
            default -> {
                scanner.nextLine();
                System.out.println("Por favor, elija una opción válida");
                irAlMenuPrincipal();
            }
        }
    }

    /**
     * Método encargado de mostrar las opciones al jugador cuando la partida
     * finaliza.
     */
    protected void finalizarPartida() {
        int opcion;
        System.out.println("                                        ┌------------------------------------------------┐");
        System.out.println("                                        |     JUEGO FINALIZADO ¿QUÉ DESEA REALIZAR?      |");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ¦ [1]               Volver a jugar               ¦");
        System.out.println("                                        ¦ [2]            Ir al menú principal            ¦");
        System.out.println("                                        ¦ [3]            Terminar el programa            ¦");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦            -Seleccione una opción-             ¦");
        System.out.println("                                        └------------------------------------------------┘");
        opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1 ->
                irAlMenuPrincipal();
            case 2 ->
                code.pedirOpcionMenu();
            case 3 ->
                System.exit(0);
            default -> {
                System.out.println("Por favor, ingresa una entrada válida");
                finalizarPartida();
            }
        }
    }

}
