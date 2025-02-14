package ymcris.ipc1.practice1.codengames.RPG;

import java.util.Scanner;

/**
 *
 *
 * @Date Feb 6, 2025
 * @author YmCris
 */
public class RPG {

    // VARIBLES ----------------------------------------------------------------
    public static Personaje jugador;
    private String nombreJugador;

    // INSTANCIAS --------------------------------------------------------------
    Scanner scanner = new Scanner(System.in);

    // MÉTODOS -----------------------------------------------------------------
    public void decirHola() {
        System.out.println("Hola soy RPG");
        pedirInformacion();
    }

    private void pedirInformacion() {
        System.out.println("Introduzca su nombre: ");
        nombreJugador = scanner.nextLine();
        jugador = new Personaje(100, 100, 0, 0, nombreJugador, 0, true, 0);

    }
}
