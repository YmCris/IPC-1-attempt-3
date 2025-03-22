package ymcris.ipc1.proyecto1.treasurehunter.partida;

import java.util.Scanner;
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
    public Partida(Aventurero aventurero, Mapas mapa, String nombrePartida) {
        this.mapa = mapa;
        this.aventurero = aventurero;
        Partida.partidaTerminada = false;
        this.nombrePartida = nombrePartida;
    }

    // MÉTODOS -----------------------------------------------------------------
    public void iniciarNuevaPartida() {
        do {
            mapa.mostrarMapaCompleto();
            verOpcionesPartida();
            String opcionPartida = scanner.nextLine();
            mapa.seleccionarOpcionesPartida(opcionPartida);
        } while (true);
    }
}
