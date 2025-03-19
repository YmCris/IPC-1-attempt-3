package ymcris.ipc1.proyecto1.treasurehunter.partida;

import ymcris.ipc1.proyecto1.treasurehunter.mapas.Mapas;
import ymcris.ipc1.proyecto1.treasurehunter.personaje.Aventurero;

/**
 * Clase partida es la Clase encargada de ser el motor del juego y realizar las
 * acciones de la partida
 *
 * @author YmCris
 * @since Mar 17, 2025
 */
public class Partida {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Mapas mapa;
    private Aventurero aventurero;

    // VARIBLES PRIMITIVAS -----------------------------------------------------
    private boolean partidaTerminada;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Partida(Aventurero aventurero, Mapas mapa) {
        this.mapa = mapa;
        this.aventurero = aventurero;
        this.partidaTerminada = false;
    }

    // MÉTODOS -----------------------------------------------------------------
    public void iniciarNuevaPartida() {
        System.out.println(" HOLA MUNDOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        mapa.crearMapa();
    }
}
