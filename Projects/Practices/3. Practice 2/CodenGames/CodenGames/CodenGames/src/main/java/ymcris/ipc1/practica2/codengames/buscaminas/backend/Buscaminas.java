package ymcris.ipc1.practica2.codengames.buscaminas.backend;

import ymcris.ipc1.practica2.codengames.buscaminas.backend.jugador.Jugador;
import ymcris.ipc1.practica2.codengames.buscaminas.backend.tablero.Tablero;
import static ymcris.ipc1.practica2.codengames.buscaminas.frontend.JFIniciarBuscaminas.jBuscaminas;

/**
 * Clase Buscaminas es el motor del juego del juego "Buscaminas", que se
 * comunicará con el BuscaminasController que a su vez lo comunicará con el
 * jFrame CBuscaminas.
 *
 * @author YmCris
 * @see Jugador
 * @see Tablero
 * @since Apr 3, 2025
 */
public class Buscaminas {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Tablero tablero;
    private Jugador jugador;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int opcionJuego;
    private int filaCasilla;
    private int columnaCasilla;
    private boolean seGuardaRegistro;
    public static int contadorDeMinasMarcadas;
    public static boolean partidaGanadaBuscaminas;
    public static boolean partidaTerminadaBuscaminas;

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

    /**
     * Método encargado de recibir información de una casilla presionada.
     *
     * @param filaCasilla - fila la cual se presióno
     * @param columnaCasilla - Columna la cual se presionó
     */
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
        }
    }

    /**
     * Mñetodo encargado de seleccionar la opciones (Marcar casilla o descubrir
     * casilla)
     */
    private void seleccionarOpciones() {
        switch (opcionJuego) {
            case 1 -> {
                tablero.getTablero()[filaCasilla][columnaCasilla].setEstaMarcada(true);
                System.out.println("Se MARCA la casilla fila = " + filaCasilla + " columna = " + columnaCasilla + " esta marcada : " + tablero.getTablero()[filaCasilla][columnaCasilla].EstaMarcada());
                System.out.println("Minas marcadas " + contadorDeMinasMarcadas);
            }
            case 2 ->
                tablero.descubrirCasillas(filaCasilla, columnaCasilla);
            default ->
                System.out.println("Ha habido un error en la opción que ha tomado el jugador (No debería de pasar)");
        }
    }

    /**
     * Método encargado de descubrir casilla
     */
    public void descubrirCasillas() {
        if (tablero.verificarJugadorGanador()) {
            partidaGanadaBuscaminas = true;
            System.out.println("Se ha ganado la partida, entonces se guarda el registro");
        } else if (!verificarPartidaTerminada()) {
            opcionJuego = jBuscaminas.getOpcionJuego();
            System.out.println(opcionJuego);
            seleccionarOpciones();
        }
    }

    /**
     * Método encargado de marcar una casilla.
     */
    public void marcarCasillas() {
        if (tablero.verificarJugadorGanador()) {
            partidaGanadaBuscaminas = true;
            System.out.println("Se ha ganado la partida, entonces se guarda el registro");
        } else {
            opcionJuego = jBuscaminas.getOpcionJuego();
            System.out.println(opcionJuego);
            seleccionarOpciones();
        }
    }

    // GETTERS -----------------------------------------------------------------
    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public int getFilaCasilla() {
        return filaCasilla;
    }

    public int getColumnaCasilla() {
        return columnaCasilla;
    }

}
