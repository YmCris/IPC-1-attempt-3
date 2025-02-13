package ymcris.ipc1.practice1.codengames.carreras;

import ymcris.ipc1.practice1.codengames.CodenGames;
import static ymcris.ipc1.practice1.codengames.CodenGames.scanner;

/**
 * Clase encargada de echar punta, como el motor del juego, teniendo las
 * opciones del menu y las de jugabilidad.
 *
 * @Date Feb 6, 2025
 * @author YmCris
 */
public class Carreras {

    //VARIABLES-----------------------------------------------------------------
    private int numeroDeDados;
    private String jugadorActual;
    private boolean juegoTerminado;
    protected static int opcion;
    protected static String jugadorUno;
    protected static String jugadorDos;
    protected static char[] computadora;
    protected static int cantidadDeRivales;

    //OBJETOS-------------------------------------------------------------------
    Pista pista = new Pista(2);

    //MÉTODO CONSTRUCTOR--------------------------------------------------------
    public Carreras() {
        this.juegoTerminado = false;
        this.numeroDeDados = 2;
        Carreras.computadora = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    //MÉTODOS ------------------------------------------------------------------
    public void iniciarCarrera() {
        echarPunta();
    }

    private void echarPunta() {//"Motor del juego"
        irAlMenuPrincipal();
        do {
            pista.verificarGanador();
        } while (juegoTerminado == true);
        finalizarPartida();
    }

    private void irAlMenuPrincipal() {
        System.out.println("                                        ┌------------------------------------------------┐");
        System.out.println("                                        |              ¿QUÉ DESEA REALIZAR?              |");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ¦ [1]        Jugar contra Computadora            ¦");
        System.out.println("                                        ¦ [2]            Jugar contra Rival              ¦");
        System.out.println("                                        ¦ [3]               ¿Cómo jugar?                 ¦");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦            -Seleccione una opción-             ¦");
        System.out.println("                                        └------------------------------------------------┘");
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                jugarContraComputadora();
                break;
            case 2:
                jugarContraRival();
                break;
            case 3:
                System.out.println("Hola Mundo, soy CARRERAS");
                System.out.println("Presione enter para continuar");
                scanner.nextLine();
                scanner.nextLine();
                break;
            default:

                break;
        }
        scanner.nextLine();
    }

    private void pedirNombres() {
        scanner.nextLine();
        System.out.println("Ingrese el nombre del jugador 1: ");
        jugadorUno = scanner.nextLine();
        System.out.println("Ingrese el número del jugador 2: ");
        jugadorDos = scanner.nextLine();
    }

    public String definirJugadorActual() {

        return jugadorActual;
    }

    private void jugarContraComputadora() {
        scanner.nextLine();
        System.out.println("Ingrese su nombre: ");
        jugadorUno = scanner.nextLine();
        System.out.println("¿Cuántos contrincantes desea tener? (1-8)");
        cantidadDeRivales = scanner.nextInt();
        Pista pistas = new Pista(cantidadDeRivales);
        pistas.elegirPista();
    }

    private void jugarContraRival() {
        cantidadDeRivales = 1;
        pedirNombres();
        pista.elegirPista();
    }

    private void finalizarPartida() {
        CodenGames code = new CodenGames();
        int opcion;
        System.out.println("                                        ┌------------------------------------------------┐");
        System.out.println("                                        |     JUEGO FINALIZADO ¿QUÉ DESEA REALIZAR?      |");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ¦ [1]              Volver a jugar                ¦");
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
