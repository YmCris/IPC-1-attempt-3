package ymcris.ipc1.proyecto1.treasurehunter.ayuda;

import java.util.Scanner;
import ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter;

/**
 * CómoJugar es la clase encargada de brindar al usuario los conocimientos
 * básicos para jugar Treasure Hunter.
 *
 * @author YmCris
 * @since Mar 14, 2025
 */
public class ComoJugar {

    Scanner scanner = new Scanner(System.in);

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de mostrar como se juega el videojuego de Treasure
     * Hunter al jugador.
     */
    public void enseñarAJugar() {
        System.out.println("\n".repeat(100));
        System.out.println("                ┌---------------------------------------------------------------------------------------------┐");
        System.out.println("                |                                         TREASURE HUNTER                                     |");
        System.out.println("                ├---------------------------------------------------------------------------------------------┤");
        System.out.println("                |[1] ¿Qué es Treasure Hunter?                                                                 |");
        System.out.println("                |    Treasuhe Hunter es un juego de emoción en el que podrá jugar un gran juego de aventuras  |");
        System.out.println("                |[2] ¿Qué puedo hacer en Treasure Hunter?                                                     |");
        System.out.println("                |    Crear mapas, cargar partidas y encontrar tesoros                                         |");
        System.out.println("                |[3] ¿Cómo Juego Treasure Hunter?                                                             |");
        System.out.println("                |    Iniciando una nueva partida y eligiendo un mapa o creando uno nuevo                      |");
        System.out.println("                |[4] ¿Cómo Gano en Treasure Hunter?                                                           |");
        System.out.println("                |    Encuentra el tesoro escondido en el mapa                                                 |");
        System.out.println("                |[5] ¿Cómo Pierdo en Treasure Hunter?                                                         |");
        System.out.println("                |    Quédate sin puntos de vida en el transcurso de la partida                                |");
        System.out.println("                └---------------------------------------------------------------------------------------------┘");
        System.out.println("");
        System.out.println("");
        System.out.println("Presione enter para regresar al menú principal...");
        scanner.nextLine();
        new TreasureHunter().verMenuPrincipal();
    }
}
