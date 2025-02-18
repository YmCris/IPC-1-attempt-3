package ymcris.ipc1.practice1.codengames.reportes;

import java.util.Scanner;
import ymcris.ipc1.practice1.codengames.CodenGames;

/**
 * Método encargado de mostrar los reportes que tiene el juego.
 *
 * @since Feb 6, 2025
 * @author YmCris
 */
public class Reportes {

    // VARIABLES ---------------------------------------------------------------
    public static int contadorJugadorPerdedorRPG = 0;//reporte 2
    public static int contadorJugadorEnBatallaRPG = 0;//reporte 3
    public static int contadorComputadoraGanadoraCarreras = 0;//reporte 4
    public static int contadorHumanoGanadorCarreras = 0;//reporte 5

    // INSTANCIAS --------------------------------------------------------------
    CodenGames code = new CodenGames();
    Scanner scan = new Scanner(System.in);

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de "decir" los reportes.
     */
    public void decirReportes() {
        System.out.println(" ------------------------------ REPORTES ------------------------------ ");
        System.out.println("1| VECES QUE SE HA INICIADO EL JUEGO RPG: " + code.getIniciosRpg() + " VECES QUE SE HA INICIADO EL JUEGO DE CARRERAS: " + code.getIniciosCarreras());
        System.out.println("2| VECES QUE HA PERDIDO EN UNA BATALLA DEL JUEGO RPG: " + getContadorJugadorPerdedorRPG());
        System.out.println("3| VECES QUE HA ENTRADO EN UNA BATALLA DEL JUEGO RPG: " + getContadorJugadorEnBatallaRPG());
        System.out.println("4| VECES QUE LA COMPUTADORA HA GANADO EN EL JUEGO DE CARRERAS: " + getContadorComputadoraGanadoraCarreras());
        System.out.println("5| VECES QUE UN JUGADOR HUMANO HA GANADO EN EL JUEGO DE CARRERAS: " + getContadorHumanoGanadorCarreras());
        System.out.println("");
        System.out.println("Presione enter para regresar.");
        scan.nextLine();
        code.pedirOpcionMenu();
    }

    // GETTERS & SETTERS -------------------------------------------------------
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

    public static int getContadorComputadoraGanadoraCarreras() {
        return contadorComputadoraGanadoraCarreras;
    }

    public static void setContadorComputadoraGanadoraCarreras(int contadorComputadoraGanadoraCarreras) {
        Reportes.contadorComputadoraGanadoraCarreras += contadorComputadoraGanadoraCarreras;
    }

    public static int getContadorHumanoGanadorCarreras() {
        return contadorHumanoGanadorCarreras;
    }

    public static void setContadorHumanoGanadorCarreras(int contadorHumanoGanadorCarreras) {
        Reportes.contadorHumanoGanadorCarreras += contadorHumanoGanadorCarreras;
    }

}
