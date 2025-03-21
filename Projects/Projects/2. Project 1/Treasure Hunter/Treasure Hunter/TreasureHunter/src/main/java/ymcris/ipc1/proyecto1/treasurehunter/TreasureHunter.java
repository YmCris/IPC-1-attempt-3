package ymcris.ipc1.proyecto1.treasurehunter;

import java.util.Scanner;
import java.util.InputMismatchException;
import ymcris.ipc1.proyecto1.treasurehunter.ayuda.ComoJugar;
import ymcris.ipc1.proyecto1.treasurehunter.partida.Partida;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.DiseñarMapas;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.ROJO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.mostrarBienvenida;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.mostrarMenuPrincipal;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.mostrarOpcionesIniciarPartida;
import static ymcris.ipc1.proyecto1.treasurehunter.exception.EntradaNoValidaException.errorEncontrado;

/**
 * Clase Treasure Hunter es la clase Main, encargada de dar inicio al programa y
 * proporcionar las opciones del programa.
 *
 * @author YmCris
 * @version 21.0.5
 * @since 03/09/2025
 */
public class TreasureHunter {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    public static Aventurero aventurero;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int opcionMenu = 0;
    private int opcionMapas = 0;

    // INSTANCIAS --------------------------------------------------------------
    Scanner scanner = new Scanner(System.in);

    // MÉTODO MAIN -------------------------------------------------------------
    /**
     * Método main encargado de iniciar el programa.
     *
     * @param args - paramétros para iniciar directamente en el jar
     */
    public static void main(String[] args) {
        mostrarBienvenida();
        do {//Para que nunca acabe el juego
            new TreasureHunter().verMenuPrincipal();
        } while (true);
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de mostrar el menú principal y evitar los errores que
     * esté pueda cometer
     */
    public void verMenuPrincipal() {
        scanner.nextLine();
        do {//Por si introduce un número que no es
            mostrarMenuPrincipal();
            try {//por si introduce un string
                opcionMenu = scanner.nextInt();
            } catch (InputMismatchException exception) {
                opcionMenu = 8;
            }
            switch (opcionMenu) {//Opciones dentro del juego
                case 1 ->//Muestra como jugar el juego
                    new ComoJugar().enseñarAJugar();
                case 2 ->//Inicia una nueva partida
                    iniciarNuevaPartida();
                case 3 ->//Carga una partida ya existente
                    new ComoJugar().enseñarAJugar();//new Archivo().cargarPartida();
                case 4 -> {//Modifica un mapa ya existente
                    //new DiseñarMapas().diseñarMapas();
                }
                case 5 ->//Muestra los reportes del juego
                    new ComoJugar().enseñarAJugar();//new Reportes().mostrarReportes();
                case 6 ->//Sale del programa
                    System.exit(0);
                default -> {
                    errorEncontrado();
                    scanner.nextLine();
                }
            }
        } while (opcionMenu < 1 || opcionMenu > 6);
    }

    /**
     * Método encargado de crear el jugador que estará activo durante la
     * partida, ya sea con un mapa previamente cargado o con uno nuevo.
     *
     * @return Aventurero - Personaje del jugador.
     */
    private Aventurero crearJugador() {
        System.out.println("\n".repeat(100));
        System.out.println(ROJO + "AVENTURERO" + RESETEAR);
        System.out.println("· INGRESE EL NOMBRE DEL NUEVO AVENTURERO:");
        String nombreAventurero = scanner.nextLine();
        if (nombreAventurero.isBlank()) {
            System.out.println("No puedes tener un nombre vacío");
            errorEncontrado();
            crearJugador();
        } else {
            aventurero = new Aventurero(250, 15, 100, 20, nombreAventurero);//Se crea el aventurero del jugador.
            return aventurero;
        }
        return null;
    }

    /**
     * Método encargado de iniciar una nueva partida preguntando si juega con un
     * mapa ya existente o desea crear uno.
     */
    private void iniciarNuevaPartida() {
        do {//por si pone un número que no es
            mostrarOpcionesIniciarPartida();
            try {//En dado caso ponga un string
                opcionMapas = scanner.nextInt();
            } catch (InputMismatchException e) {
                opcionMapas = 9;
            }
            switch (opcionMapas) {//Opciones al iniciar una nueva partida.
                case 1 -> {//Juega con un mapa ya existente.
                    //Archivo archivo = new Archivo();
                    //archivo.elegirMapaExistente();
                }
                case 2 -> {//Juega con un nuevo mapa.
                    scanner.nextLine();
                    System.out.println("\n".repeat(100));
                    System.out.println(ROJO + "PARTIDA" + RESETEAR);
                    System.out.println("· INGRESE EL NOMBRE DE LA PARTIDA:");
                    String nombrePartida = scanner.nextLine();
                    if (nombrePartida.isBlank()) {
                        System.out.println("El nombre de la partida no puede estar en blanco");
                        errorEncontrado();
                        iniciarNuevaPartida();
                    } else {
                        Aventurero aventurero = crearJugador();
                        DiseñarMapas nuevoMapa = new DiseñarMapas();
                        Partida partida = new Partida(aventurero, nuevoMapa.crearMapa(), nombrePartida);
                        partida.iniciarNuevaPartida();//Inicia una nueva partida
                    }
                }
                case 3 ->//vuelve al menu
                    mostrarMenuPrincipal();
                case 4 ->//sale del programa
                    System.exit(0);
                default -> {
                    errorEncontrado();
                    scanner.nextLine();
                }
            }
        } while (opcionMapas < 0 || opcionMapas >= 5);
    }

}
