package ymcris.ipc1.practice1.codengames.carreras;

import static ymcris.ipc1.practice1.codengames.CodenGames.scanner;

/**
 *
 *
 * @Date Feb 6, 2025
 * @author YmCris
 */
public class Carreras {

    private String vehiculoEnTurno;
    private String jugador1;
    private String jugador2;
    private String jugadorActual;
    private int numeroDeDados;
    private char[] computadora;

    Pista pista = new Pista(2);

    public Carreras() {
        this.numeroDeDados = 2;
    }

    public void iniciarCarrera() {
        irAlMenuPrincipal();
        this.computadora = new char[]{'☼', '♥', '○'};
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
        int opcion = scanner.nextInt();
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
    }

    private void pedirNombres(int numeroDeJugadores) {
        if (numeroDeJugadores == 1) {
            System.out.println("Ingrese el nombre del jugador: ");
        } else if (numeroDeJugadores != 1) {
            for (int i = 0; i < numeroDeJugadores; i++) {
                System.out.println("Ingrese el número del jugador: " + (i + 1));

            }
        }
    }

    public String definirJugadorActual() {
        return jugadorActual;
    }

    private void jugarContraComputadora() {
        pista.elegirPista();
    }

    private void jugarContraRival() {
        pista.elegirPista();
    }

}
