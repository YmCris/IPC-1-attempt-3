package ymcris.ipc1.practica2.codengames.buscaminas.backend;

import javax.swing.Timer;
import ymcris.ipc1.practica2.codengames.buscaminas.backend.jugador.Jugador;
import ymcris.ipc1.practica2.codengames.buscaminas.backend.tablero.Tablero;
import ymcris.ipc1.practica2.codengames.buscaminas.controllers.BuscaminasController;
import static ymcris.ipc1.practica2.codengames.buscaminas.frontend.JFIniciarNuevaPartidaBuscaminas.jBuscaminas;

/**
 * Clase Buscaminas es el motor del juego del juego "Buscaminas", que se
 * comunicará con el BuscaminasController que a su vez lo comunicará con el
 * jFrame CBuscaminas.
 *
 * @author YmCris
 * @since Apr 3, 2025
 */
public class Buscaminas {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Tablero tablero;
    private Jugador jugador;
    private Timer tiempoJugado;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int opcionJuego;
    private int filaCasilla;
    private int columnaCasilla;
    private boolean partidaTerminada;
    private boolean seGuardaRegistro;
    private int contadorDeMinasMarcadas;

    // INSTANCIAS --------------------------------------------------------------
    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Buscaminas(String avatar, int filasTablero, int columnasTablero, int cantidadDeMinas) {
        this.jugador = new Jugador(avatar, 0);
        this.tablero = new Tablero(filasTablero, columnasTablero, cantidadDeMinas);
        tablero.crearTablero();
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de verificar si el usuario salio del programa o si
     * finalizó la partida.
     *
     * @return true si se ha terminado la partida
     */
    private boolean verificarPartidaTerminada() {
        terminarPartidaPorMina(filaCasilla, columnaCasilla);
        if (partidaTerminada && seGuardaRegistro) {
            //Se agrega a los reportes
            return true;
        } else {
            return partidaTerminada;
        }
    }

    public void recibirInformacionCasilla(int filaCasilla, int columnaCasilla) {
        this.filaCasilla = filaCasilla;
        this.columnaCasilla = columnaCasilla;
    }

    /**
     * Método encargado de terminar la partida porque el jugador ha seleccionado
     * una casilla con mina.
     *
     * @param fila - fila donde se encuentra la casilla que tocó.
     * @param columna - columna donde se encuentra la casilla que tocó.
     */
    private void terminarPartidaPorMina(int fila, int columna) {
        if (tablero.tieneMina(fila, columna)) {
            seGuardaRegistro = true;
            partidaTerminada = true;
        }
    }

    private void seleccionarOpciones() {
        switch (opcionJuego) {
            case 1:
                tablero.marcarMinas(filaCasilla, columnaCasilla);
                contadorDeMinasMarcadas++;
                break;
            case 2:
                tablero.descubrirCasillas(filaCasilla, columnaCasilla);
                break;
            default:
                System.out.println("Ha habido un error");
                break;
        }
    }

    public void iniciarPartida() {
        opcionJuego = jBuscaminas.getOpcionJuego();
        seleccionarOpciones();
    }

    // GETTERS -----------------------------------------------------------------
    // SETTERS -----------------------------------------------------------------
}
