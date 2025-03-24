package ymcris.ipc1.proyecto1.treasurehunter.partida;

import java.util.Scanner;
import ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.MAGENTA;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.Mapas;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoPartida.verOpcionesPartida;

/**
 * Clase partida es la Clase encargada de ser el motor del juego y realizar las
 * acciones de la partida así como guardarlas en un archivo.
 *
 * @author YmCris
 * @see Mapas
 * @see Aventurero
 * @since Mar 17, 2025
 */
public class Partida {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Mapas mapa;
    private String nombrePartida;
    private Aventurero aventurero;

    // VARIBLES PRIMITIVAS -----------------------------------------------------
    public static boolean partidaTerminada;

    // INSTANCIAS --------------------------------------------------------------
    Scanner scanner = new Scanner(System.in);

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método encargado de crear una partida
     *
     * @param aventurero - aventurero que va a jugar
     * @param mapa - mapa en el que se va a desarrollar la batalla
     * @param nombrePartida - nombre de la partida para guardarla
     */
    public Partida(Aventurero aventurero, Mapas mapa, String nombrePartida) {
        this.mapa = mapa;
        this.aventurero = aventurero;
        Partida.partidaTerminada = false;
        this.nombrePartida = nombrePartida;
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de iniciar una nueva partida
     */
    public void iniciarNuevaPartida() {
        do {
            mapa.mostrarMapaCompleto();
            verOpcionesPartida();
            String opcionPartida = scanner.nextLine();
            mapa.seleccionarOpcionesPartida(opcionPartida);
            if (aventurero.getVidaPrevioAUnaBatalla() == 0) {
                System.out.println(MAGENTA + "                                AVENTURERO " + aventurero.getNombre() + " has fallado en tu misión de encontrar el tesoro más grande de todos" + RESETEAR);
                System.out.println(MAGENTA + "            No te preocupes, Varios aventurero de gran renombre tampoco lo han conseguido hasta el momento, sigue intentando y algún día lo encontrarás" + RESETEAR);
                partidaTerminada = true;
                break;
            }
            if (opcionPartida.equals("5")) {
                partidaTerminada = true;
                break;
            }
        } while (partidaTerminada == false);
        System.out.println("");
        System.out.println("");
        System.out.println("Presiona enter para volver al menú principal");
        scanner.nextLine();
        new TreasureHunter().verMenuPrincipal();

    }
}
