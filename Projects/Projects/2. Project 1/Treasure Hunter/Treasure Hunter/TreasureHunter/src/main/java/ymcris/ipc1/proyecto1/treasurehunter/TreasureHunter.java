package ymcris.ipc1.proyecto1.treasurehunter;

import java.util.InputMismatchException;
import ymcris.ipc1.proyecto1.treasurehunter.ayuda.ComoJugar;
import java.util.Scanner;
import ymcris.ipc1.proyecto1.treasurehunter.batalla.Batalla;
import ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;

/**
 * Clase Main, encargada de dar inicio al programa.
 *
 * @author YmCris
 * @version 21.0.5
 * @since 03/09/2025
 */
public class TreasureHunter {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    int opcion = 0;

    // INSTANCIAS --------------------------------------------------------------
    Scanner scanner = new Scanner(System.in);

    // MÉTODO MAIN -------------------------------------------------------------
    /**
     * Método main encargado de iniciar el programa.
     *
     * @param args - paramétros para iniciar directamente en el jar
     */
    public static void main(String[] args) {
        new DiseñoMenus().mostrarBienvenida();
        Aventurero aventurero = new Aventurero(100, 10, 50, 15, "cristian");
        Batalla batalla = new Batalla(aventurero);
        batalla.pelear();
        do {//Para que nunca acabe el juego
            new TreasureHunter().mostrarMenuPrincipal();
        } while (true);
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de mostrar el menú principal y evitar los errores que
     * esté pueda cometer
     */
    private void mostrarMenuPrincipal() {
        scanner.nextLine();
        do {//Por si introduce un número que no es
            new DiseñoMenus().mostrarMenuPrincipal();
            try {//por si introduce un string
                opcion = scanner.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println("Debes ingresar un número entre 1 y 6");
                System.out.println("Presiona enter para continuar:");
                scanner.nextLine();
                opcion = 7;
            }
            switch (opcion) {//Opciones dentro del juego
                case 1 ->
                    new ComoJugar().enseñarAJugar();
                case 2 ->
                    new ComoJugar().enseñarAJugar();//new Partida().iniciarNuevaPartida();
                case 3 ->
                    new ComoJugar().enseñarAJugar();//new Archivo().cargarPartida();
                case 4 ->
                    diseñarMapas();
                case 5 ->
                    new ComoJugar().enseñarAJugar();//new Reportes().mostrarReportes();
                case 6 ->
                    System.exit(0);
                case 7 ->
                    mostrarMenuPrincipal();
                default -> {
                    System.out.println("Ingresa una opción válida [1-6]");
                    System.out.println("Presiona enter para continuar:");
                    scanner.nextLine();
                }
            }
        } while (opcion < 1 || opcion > 6);
    }

    /**
     * Método encargado de crear un nuevo mapa
     */
    private void diseñarMapas() {
    }
}
