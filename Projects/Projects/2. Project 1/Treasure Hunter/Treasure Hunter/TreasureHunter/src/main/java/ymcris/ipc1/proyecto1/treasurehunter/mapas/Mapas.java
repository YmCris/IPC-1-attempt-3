package ymcris.ipc1.proyecto1.treasurehunter.mapas;

import ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.Casillas;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaNormal;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaTesoro;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaPersonaje;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.NEGRO;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import static ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaPista.pista;
import static ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaPista.pistas;

/**
 * Clase Mapas es la Clase encargada de crear los mapas, modificar los mapas y
 * moverse dentro del tablero
 *
 * @author YmCris
 * @since Mar 17, 2025
 */
public class Mapas {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nombre;
    private Casillas casillaTemporal;
    public static Casillas[][] tablero;
    public static CasillaTesoro casillaTesoro;
    public static CasillaPersonaje casillaAventurero;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int filas;
    private int columnas;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método encargado de crear un mapa inicializando sus atributos
     *
     * @param nombre - nombre del mapa
     * @param filas - filas que tendra el tablero
     * @param columnas - columnas que tendrá el tablero
     * @param tesoro - casilla tesoro
     * @param personaje - casilla que representará al jugador en el tablero
     */
    public Mapas(String nombre, int filas, int columnas, CasillaTesoro tesoro, CasillaPersonaje personaje) {
        this.filas = filas;
        this.nombre = nombre;
        this.columnas = columnas;
        Mapas.casillaTesoro = tesoro;
        Mapas.casillaAventurero = personaje;
        tablero = new Casillas[filas][columnas];
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de crear el tablero.
     *
     * @return tablero creado
     */
    public Casillas[][] crearTablero() {
        for (int i = 0; i < tablero.length; i++) {//filas
            for (int j = 0; j < tablero[i].length; j++) {//columnas
                CasillaNormal normal = new CasillaNormal(i * j);
                normal.setFila(i);
                normal.setColumna(j);
                tablero[i][j] = normal;
            }
        }
        return tablero;
    }

    /**
     * Método encargado de mostrar el mapa completo
     */
    public void mostrarMapaCompleto() {
        String A = "0";
        //Marco superior de las letras
        System.out.print("____");
        for (Casillas item : tablero[0]) {
            System.out.print("___");
        }
        System.out.print("_");
        System.out.println("");
        //Marco de las Columnas letras
        System.out.print("|:v|");
        for (int i = 0; i < tablero[0].length; i++) {
            if (i < 10) {
                System.out.print(A + (i) + "|");
            } else {
                System.out.print((i) + "|");
            }
        }
        System.out.print("|");
        System.out.println("");
        //Marco de las filas números
        for (int i = 0; i < tablero.length; i++) {
            if (i < 10) {
                System.out.print("|" + 0 + (i) + "|");
            } else if (i >= 9) {
                System.out.print("|" + (i) + "|");
            }
            for (Casillas item : tablero[i]) {
                System.out.print(item.getSimbolo());
                System.out.print(NEGRO + "░" + RESETEAR);
            }
            System.out.println("|");
        }
        System.out.print("-----");
        for (Casillas item : tablero[0]) {
            System.out.print("---");
        }
        System.out.println("");
    }

    /**
     * Método encargado de modificar el mapa
     *
     * @param fila - fila donde se implementará una casilla
     * @param columna - casilla donde se implementará una casilla
     * @param casillaAModificar casilla que se implementará en el mapa
     */
    public void modificarMapas(int fila, int columna, Casillas casillaAModificar) {
        Mapas.tablero[fila][columna] = casillaAModificar;
    }

    /**
     * Método encargado de hacer todas las acciones del jugador.
     *
     * @param opcionPartida
     */
    public void seleccionarOpcionesPartida(String opcionPartida) {
        if (opcionPartida.toLowerCase().equals("w")) {//Se mueve hacia arriba.
            moverHaciaArriba();
        } else if (opcionPartida.toLowerCase().equals("s")) {//Se mueve hacia abajo
            moverHaciaAbajo();
        } else if (opcionPartida.toLowerCase().equals("a")) {//Se mueve hacia la izquierda
            moverHaciaLaIzquierda();
        } else if (opcionPartida.toLowerCase().equals("d")) {//Se mueve hacia la derecha
            moverHaciaLaDerecha();
        } else if (opcionPartida.equals("1")) {//Ve la pista más reciente
            if (pista == null) {
                System.out.println("No has descubierto ninguna pista");
            } else {
                System.out.println(pista);
            }
        } else if (opcionPartida.equals("2")) { //Ve todas las pistas.
            for (String pista1 : pistas) {
                if (pistas[0] == null) {
                    System.out.println("No has descubierto ninguna pista");
                    break;
                }
                if (pista1 == null) {
                    break;
                } else {
                    System.out.println(pista1);
                }
            }
        } else if (opcionPartida.equals("3")) {//Ve el estado
            aventurero.mostrarEstadoAventurero();
        } else if (opcionPartida.equals("4")) {//Guarda la partida

        }
    }

    /**
     * Metodo encargado de mover al jugador hacia arriba
     */
    private void moverHaciaArriba() {
        //1. Verificar si el jugador se puede mover hacia arriba (No sale del límite de las filas del mapa)
        if (casillaAventurero.getFila() > 0) {//Se puede mover
            //2. Verificamos si arriba no hay un muro
            if (tablero[casillaAventurero.getFila() - 1][casillaAventurero.getColumna()].isPuedePasar()) {//Puede pasar.
                //2.5 Guarda la casilla a la que se movio para que no se elimine
                casillaTemporal = tablero[casillaAventurero.getFila() - 1][casillaAventurero.getColumna()];//Guarda la casilla a donde se va a mover
                aventurero.setCantidadMovimientos(aventurero.getCantidadMovimientos() + 1);
                //2.9 Aplica el efecto de la casilla
                casillaTemporal.mostrarMensaje();
                //3. casilla del personaje cambia de posición hacia arriba i+1
                tablero[casillaAventurero.getFila() - 1][casillaAventurero.getColumna()] = casillaAventurero;
                casillaAventurero.setFila(casillaAventurero.getFila() - 1);//Modifica la posición de la casilla aventurero y del jugador 
                aventurero.setFilaJugador(aventurero.getFilaJugador() - 1);
                //4. Se limpia la casilla anterior del personaje, a la casilla que era antes de que el pasará sobre ella
                tablero[casillaAventurero.getFila() + 1][casillaAventurero.getColumna()] = casillaTemporal;
            }
        }
    }

    /**
     * Metodo encargado de mover al jugador hacia abajo
     */
    private void moverHaciaAbajo() {
        //1. Verificar si el jugador se puede mover hacia abajo (No sale del límite de las filas del mapa)
        if (casillaAventurero.getFila() < this.getFilas() - 1) {//Se puede mover
            //2. Verificamos si arriba no hay un muro
            if (tablero[casillaAventurero.getFila() + 1][casillaAventurero.getColumna()].isPuedePasar()) {//Puede pasar.
                aventurero.setCantidadMovimientos(aventurero.getCantidadMovimientos() + 1);
                //2.5 Guarda la casilla a la que se movio para que no se elimine
                casillaTemporal = tablero[casillaAventurero.getFila() + 1][casillaAventurero.getColumna()];//Guarda la casilla a donde se va a mover
                //2.9 Aplica el efecto de la casilla
                casillaTemporal.mostrarMensaje();
                //3. casilla del personaje cambia de posición hacia arriba i+1
                tablero[casillaAventurero.getFila() + 1][casillaAventurero.getColumna()] = casillaAventurero;
                casillaAventurero.setFila(casillaAventurero.getFila() + 1);//Modifica la posición de la casilla del jugador
                aventurero.setFilaJugador(aventurero.getFilaJugador() + 1);
                //4. Se limpia la casilla anterior del personaje, a la casilla que era antes de que el pasará sobre ella
                tablero[casillaAventurero.getFila() - 1][casillaAventurero.getColumna()] = casillaTemporal;
            }
        }
    }

    /**
     * Metodo encargado de mover al jugador hacia la derecha
     */
    private void moverHaciaLaDerecha() {
        //1. Verificar si el jugador se puede mover hacia la derecha (No sale del límite de las columnas del mapa)
        if (casillaAventurero.getColumna() < this.getColumnas() - 1) {//Se puede mover
            //2. Verificamos si arriba no hay un muro
            if (tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() + 1].isPuedePasar()) {//Puede pasar.
                aventurero.setCantidadMovimientos(aventurero.getCantidadMovimientos() + 1);
                //2.5 Guarda la casilla a la que se movio para que no se elimine
                casillaTemporal = tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() + 1];
                casillaTemporal.mostrarMensaje();
                //3. casilla del personaje cambia de posición hacia arriba j-1
                tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() + 1] = casillaAventurero;
                casillaAventurero.setColumna(casillaAventurero.getColumna() + 1);//Modifica la posición de la casilla del jugador
                aventurero.setColumnaJugador(aventurero.getColumnaJugador() + 1);
                //4. Se limpia la casilla anterior del personaje, a la casilla que era antes de que el pasará sobre ella
                tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() - 1] = casillaTemporal;
            }
        }
    }

    /**
     * Metodo encargado de mover al jugador hacia la izquierda
     */
    private void moverHaciaLaIzquierda() {
        //1. Verificar si el jugador se puede mover hacia la izquierda (No sale del límite de las columnas del mapa)
        if (casillaAventurero.getColumna() > 0) {//Se puede mover
            //2. Verificamos si arriba no hay un muro
            if (tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() - 1].isPuedePasar()) {//Puede pasar.
                aventurero.setCantidadMovimientos(aventurero.getCantidadMovimientos() + 1);
                //2.5 Guarda la casilla a la que se movio para que no se elimine
                casillaTemporal = tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() - 1];
                casillaTemporal.mostrarMensaje();
                //3. casilla del personaje cambia de posición hacia arriba j-1
                tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() - 1] = casillaAventurero;
                casillaAventurero.setColumna(casillaAventurero.getColumna() - 1);//Modifica la posición de la casilla del jugador
                aventurero.setColumnaJugador(aventurero.getColumnaJugador() - 1);
                //4. Se limpia la casilla anterior del personaje, a la casilla que era antes de que el pasará sobre ella
                tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() + 1] = casillaTemporal;
            }
        }

    }

    // GETTERS -----------------------------------------------------------------
    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

}
