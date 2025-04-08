package ymcris.ipc1.practica2.codengames.buscaminas.backend;

import javax.swing.Timer;
import ymcris.ipc1.practica2.codengames.buscaminas.backend.jugador.Jugador;
import ymcris.ipc1.practica2.codengames.buscaminas.backend.tablero.Tablero;
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
    private boolean seGuardaRegistro;
    public static boolean partidaTerminadaBuscaminas;
    public static int contadorDeMinasMarcadas;

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
        if (partidaTerminadaBuscaminas && seGuardaRegistro) {
            System.out.println("Se ha perdido la partida por mina, entonces se guarda el registro");
            return true;
        } else {
            return partidaTerminadaBuscaminas;
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
            partidaTerminadaBuscaminas = true;
            contadorDeMinasMarcadas=0;
        }
    }

    private void seleccionarOpciones() {
        switch (opcionJuego) {
            case 1:
                System.out.println("Se MARCA la casilla fila = " + filaCasilla + " columna = " + columnaCasilla);
                tablero.getTablero()[filaCasilla][columnaCasilla].setEstaMarcada(true);
                contadorDeMinasMarcadas++;
                System.out.println("Minas marcadas " + contadorDeMinasMarcadas);
                break;
            case 2:
                tablero.descubrirCasillas(filaCasilla, columnaCasilla);
                break;
            default:
                System.out.println("Ha habido un error en la opción que ha tomado el jugador (No debería de pasar)");
                break;
        }
    }

    public void descubrirCasillas() {
        if (!verificarPartidaTerminada()) {
            opcionJuego = jBuscaminas.getOpcionJuego();
            System.out.println(opcionJuego);
            seleccionarOpciones();
        }
    }

    public void marcarCasillas() {
        opcionJuego = jBuscaminas.getOpcionJuego();
        System.out.println(opcionJuego);
        seleccionarOpciones();
    }
    
}
