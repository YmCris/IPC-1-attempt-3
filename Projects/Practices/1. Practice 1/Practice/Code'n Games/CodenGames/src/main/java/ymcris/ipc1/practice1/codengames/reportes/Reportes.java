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

    // VARIABLES ---------------------------------------------------------------
    public static int contadorJugadorPerdedorRPG = 0;
    public static int contadorJugadorEnBatallaRPG = 0;

    CodenGames code = new CodenGames();
    Scanner scan = new Scanner(System.in);

    public void decirReportes() {
        System.out.println("1. VECES QUE SE HA INICIADO EL JUEGO RPG: " + code.getIniciosRpg() + " VECES QUE SE HA INICIADO EL JUEGO DE CARRERAS: " + code.getIniciosCarreras());
        System.out.println("2. VECES QUE HA PERDIDO EN UNA BATALLA DEL JUEGO RPG: " + getContadorJugadorPerdedorRPG());
        System.out.println("3. VECES QUE HA ENTRADO EN UNA BATALLA DEL JUEGO RPG: " + getContadorJugadorEnBatallaRPG());
        System.out.println("4. VECES QUE LA COMPUTADORA HA GANADO EN EL JUEGO DE CARRERAS: ");
        System.out.println("5. VECES QUE UN JUGADOR HUMANO HA GANADO EN EL JUEGO DE CARRERAS: ");
        System.out.println("");
        System.out.println("Presione enter para regresar.");
        scan.nextLine();
        code.pedirOpcionMenu();
    }

    public static int getContadorJugadorPerdedorRPG() {
        return contadorJugadorPerdedorRPG;
    }

    public static void setContadorJugadorPerdedorRPG(int contadorJugadorPerdedorRPG) {
        Reportes.contadorJugadorPerdedorRPG += contadorJugadorPerdedorRPG;
    }

    public static int getContadorJugadorEnBatallaRPG() {
        return contadorJugadorEnBatallaRPG;
    }

    public static void setContadorJugadorEnBatallaRPG(int contadorJugadorEnBatallaRPG) {
        Reportes.contadorJugadorEnBatallaRPG += contadorJugadorEnBatallaRPG;
    }

    public CodenGames getCode() {
        return code;
    }

    public void setCode(CodenGames code) {
        this.code = code;
    }

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

}
