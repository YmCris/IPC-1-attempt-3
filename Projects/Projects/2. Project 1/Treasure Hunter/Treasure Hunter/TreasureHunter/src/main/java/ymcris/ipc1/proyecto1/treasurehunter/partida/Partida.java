package ymcris.ipc1.proyecto1.treasurehunter.partida;

import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoPartida.verOpcionesPartida;
import ymcris.ipc1.proyecto1.treasurehunter.mapas.Mapas;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;

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
    private Aventurero aventurero;
    private String nombrePartida;

    // VARIBLES PRIMITIVAS -----------------------------------------------------
    private boolean partidaTerminada;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Partida(Aventurero aventurero, Mapas mapa, String nombrePartida) {
        this.mapa = mapa;
        this.aventurero = aventurero;
        this.partidaTerminada = false;
        this.nombrePartida = nombrePartida;
    }

    // MÉTODOS -----------------------------------------------------------------
    public void iniciarNuevaPartida() {
        do {
            mapa.mostrarMapa();
            verOpcionesPartida();
        } while (partidaTerminada);
    }
}
