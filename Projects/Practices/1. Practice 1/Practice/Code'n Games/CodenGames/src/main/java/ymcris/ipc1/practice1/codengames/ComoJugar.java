package ymcris.ipc1.practice1.codengames;

import static ymcris.ipc1.practice1.codengames.CodenGames.scanner;

/**
 *
 *
 * @Date Feb 6, 2025
 * @author YmCris
 */
public class ComoJugar {

    CodenGames games = new CodenGames();

    /**
     * Método usado para mostrar como jugar a los distintos juegos.
     */
    public void mostrarComoJugar() {
        System.out.println("\n".repeat(60));
        System.out.println("Bienvenido a la ayuda de Code'n Studios, aquí podrás obtener información de como se juegan los videojuegos.");
        System.out.println("Recomendamos ampliamente leer el manual de usuario donde se detallan a profundidad cada juego.");
        System.out.println("Selecciona el juego que desees saber como se juega:");
        System.out.println("1. Juego RPG");
        System.out.println("2. Juego de carreras.");
        System.out.println("3. Regresar al menú.");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                mostrarRPG();
                break;
            case 2:
                mostrarCarreras();
                break;
            case 3:
                System.out.println("\n".repeat(30));
                games.pedirOpcionMenu();
                break;
            default:
                System.out.println("Opción no válida");
                mostrarComoJugar();
                break;
        }
    }

    /**
     * Método encargado de mostrar como jugar el juego RPG.
     */
    public void mostrarRPG() {
        System.out.println("\n".repeat(60));
        System.out.println("Hola Mundo, soy RPG");
        System.out.println("Presione enter para regresar");
        scanner.nextLine();
        scanner.nextLine();
        mostrarComoJugar();
    }

    /**
     * Método encargado de mostrar el juego de carreras.
     */
    public void mostrarCarreras() {
        System.out.println("\n".repeat(60));
        System.out.println("Hola Mundo, soy CARRERAS");
        System.out.println("Presione enter para continuar");
        scanner.nextLine();
        scanner.nextLine();
        mostrarComoJugar();
    }
}
