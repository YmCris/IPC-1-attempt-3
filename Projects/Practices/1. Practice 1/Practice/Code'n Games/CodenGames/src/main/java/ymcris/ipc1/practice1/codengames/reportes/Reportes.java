package ymcris.ipc1.practice1.codengames.reportes;

import java.util.Scanner;
import ymcris.ipc1.practice1.codengames.CodenGames;

/**
 *
 *
 * @Date Feb 6, 2025
 * @author YmCris
 */
public class Reportes {

    CodenGames code = new CodenGames();
    Scanner scan = new Scanner(System.in);

    public void decirReportes() {
        System.out.println("1. VECES QUE SE HA INICIADO EL JUEGO RPG: " + code.getIniciosRpg() + " VECES QUE SE HA INICIADO EL JUEGO DE CARRERAS: " + code.getIniciosCarreras());
        System.out.println("2. VECES QUE HA PERDIDO EN UNA BATALLA DEL JUEGO RPG: ");
        System.out.println("3. VECES QUE HA ENTRADO EN UNA BATALLA DEL JUEGO RPG: ");
        System.out.println("4. VECES QUE LA COMPUTADORA HA GANADO EN EL JUEGO DE CARRERAS: ");
        System.out.println("5. VECES QUE UN JUGADOR HUMANO HA GANADO EN EL JUEGO DE CARRERAS: ");
        System.out.println("");
        System.out.println("Presione enter para regresar.");
        scan.nextLine();
        code.pedirOpcionMenu();

    }
}
