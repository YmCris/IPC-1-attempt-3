package ymcris.ipc1.proyecto1.treasurehunter.mapas;

import ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaNormal;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaPersonaje;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaTesoro;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.Casillas;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.NEGRO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

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
    public static Casillas[][] tablero;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int filas;
    private int columnas;
    public static CasillaTesoro casillaTesoro;
    public static CasillaPersonaje casillaAventurero;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Mapas(String nombre, int filas, int columnas, CasillaTesoro tesoro, CasillaPersonaje personaje) {
        this.filas = filas;
        this.nombre = nombre;
        this.columnas = columnas;
        Mapas.casillaTesoro = tesoro;
        Mapas.casillaAventurero = personaje;
        tablero = new Casillas[filas][columnas];
    }

    // MÉTODOS -----------------------------------------------------------------
    public Casillas[][] crearMapa() {
        for (int i = 0; i < tablero.length; i++) {//filas
            for (int j = 0; j < tablero[i].length; j++) {//columnas
                tablero[i][j] = new CasillaNormal(i * j);
            }
        }
        return tablero;
    }

    public void mostrarMapaCompleto() {
        String A = "0";
        //Marco superior de las letras
        System.out.print("___");
        for (int i = 0; i < tablero[0].length; i++) {
            System.out.print("___");
        }
        System.out.print("_");
        System.out.println("");
        //Marco de las Columnas letras
        System.out.print("|:v|");
        for (int i = 0; i < tablero[0].length; i++) {
            if (i < 9) {
                System.out.print(A + (i + 1) + "|");
            } else {
                System.out.print((i + 1) + "|");
            }
        }
        System.out.println("");
        //Marco de las filas números
        for (int i = 0; i < tablero.length; i++) {
            if (i < 9) {
                System.out.print("|" + 0 + (i + 1) + "|");
            } else if (i >= 9) {
                System.out.print("|" + (i + 1) + "|");
            }
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j].getSimbolo());
                System.out.print(NEGRO + "░" + RESETEAR);
            }
            System.out.println("");
        }
    }

    public void modificarMapas(int fila, int columna, Casillas casillaAModificar) {
        Mapas.tablero[fila][columna] = casillaAModificar;
    }

    public void seleccionarOpcionesPartida(String opcionPartida) {
        Casillas[] casillaAMover = new Casillas[1];
        Casillas[] casillaAnterior = new Casillas[1];
        boolean seHaMovido = false;
        if (opcionPartida.toLowerCase().equals("w")) {//Se mueve hacia arriba.
            //1. Verificar si el jugador se puede mover hacia arriba (No sale del límite de las filas del mapa)
            if (casillaAventurero.getFila() > 0) {//Se puede mover
                //2. Verificamos si arriba no hay un muro
                if (tablero[casillaAventurero.getFila() - 1][casillaAventurero.getColumna()].isPuedePasar()) {//Puede pasar.
                    //2.5 Guarda la casilla a la que se movio para que no se elimine
                    casillaAMover[0] = tablero[casillaAventurero.getFila() - 1][casillaAventurero.getColumna()];
                    casillaAMover[0].mostrarMensaje();
                    casillaAMover[0].aplicarEfecto(aventurero);
                    //3. casilla del personaje cambia de posición hacia arriba i+1
                    tablero[casillaAventurero.getFila() - 1][casillaAventurero.getColumna()] = casillaAventurero;
                    casillaAventurero.setFila(casillaAventurero.getFila() - 1);//Modifica la posición de la casilla del jugador
                    //4. Se limpia la casilla anterior del personaje, a la casilla que era antes de que el pasará sobre ella
                    if (seHaMovido == true) {//Por si ya se movió
                        tablero[casillaAventurero.getFila() + 1][casillaAventurero.getColumna()] = casillaAMover[0];
                    } else {//Por si no se ha movido nunca
                        tablero[casillaAventurero.getFila() + 1][casillaAventurero.getColumna()] = new CasillaNormal(1);
                    }
                    seHaMovido = true;
                }
            }
        } else if (opcionPartida.toLowerCase().equals("s")) {//Se mueve hacia abajo
            //1. Verificar si el jugador se puede mover hacia abajo (No sale del límite de las filas del mapa)
            if (casillaAventurero.getFila() < this.getFilas() - 1) {//Se puede mover
                //2. Verificamos si arriba no hay un muro
                if (tablero[casillaAventurero.getFila() + 1][casillaAventurero.getColumna()].isPuedePasar()) {//Puede pasar.
                    //2.5 Guarda la casilla a la que se movio para que no se elimine
                    casillaAMover[0] = tablero[casillaAventurero.getFila() + 1][casillaAventurero.getColumna()];
                    casillaAMover[0].mostrarMensaje();
                    casillaAMover[0].aplicarEfecto(aventurero);
                    //3. casilla del personaje cambia de posición hacia arriba i+1
                    tablero[casillaAventurero.getFila() + 1][casillaAventurero.getColumna()] = casillaAventurero;
                    casillaAventurero.setFila(casillaAventurero.getFila() + 1);//Modifica la posición de la casilla del jugador
                    //4. Se limpia la casilla anterior del personaje, a la casilla que era antes de que el pasará sobre ella
                    if (seHaMovido == true) {//Por si ya se movió
                        tablero[casillaAventurero.getFila() - 1][casillaAventurero.getColumna()] = casillaAMover[0];
                    } else {//Por si no se ha movido nunca
                        tablero[casillaAventurero.getFila() - 1][casillaAventurero.getColumna()] = new CasillaNormal(1);
                    }
                    seHaMovido = true;
                }
            }
        } else if (opcionPartida.toLowerCase().equals("a")) {//Se mueve hacia la izquierda
            //1. Verificar si el jugador se puede mover hacia la izquierda (No sale del límite de las columnas del mapa)
            if (casillaAventurero.getColumna() > 0) {//Se puede mover
                //2. Verificamos si arriba no hay un muro
                if (tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() - 1].isPuedePasar()) {//Puede pasar.
                    //2.5 Guarda la casilla a la que se movio para que no se elimine
                    casillaAMover[0] = tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() - 1];
                    casillaAMover[0].mostrarMensaje();
                    casillaAMover[0].aplicarEfecto(aventurero);
                    //3. casilla del personaje cambia de posición hacia arriba j-1
                    tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() - 1] = casillaAventurero;
                    casillaAventurero.setColumna(casillaAventurero.getColumna() - 1);//Modifica la posición de la casilla del jugador
                    //4. Se limpia la casilla anterior del personaje, a la casilla que era antes de que el pasará sobre ella
                    if (seHaMovido == true) {//Por si ya se movió
                        tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() + 1] = casillaAMover[0];
                    } else {//Por si no se ha movido nunca
                        tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() + 1] = new CasillaNormal(1);
                    }
                    seHaMovido = true;
                }
            }
        } else if (opcionPartida.toLowerCase().equals("d")) {//Se mueve hacia la derecha
            //1. Verificar si el jugador se puede mover hacia la derecha (No sale del límite de las columnas del mapa)
            if (casillaAventurero.getColumna() < this.getColumnas() - 1) {//Se puede mover
                //2. Verificamos si arriba no hay un muro
                if (tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() + 1].isPuedePasar()) {//Puede pasar.
                    //2.5 Guarda la casilla a la que se movio para que no se elimine
                    casillaAMover[0] = tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() + 1];
                    casillaAMover[0].mostrarMensaje();
                    casillaAMover[0].aplicarEfecto(aventurero);
                    //3. casilla del personaje cambia de posición hacia arriba j-1
                    tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() + 1] = casillaAventurero;
                    casillaAventurero.setColumna(casillaAventurero.getColumna() + 1);//Modifica la posición de la casilla del jugador
                    //4. Se limpia la casilla anterior del personaje, a la casilla que era antes de que el pasará sobre ella
                    if (seHaMovido == true) {//Por si ya se movió
                        tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() - 1] = casillaAMover[0];
                    } else {//Por si no se ha movido nunca
                        tablero[casillaAventurero.getFila()][casillaAventurero.getColumna() - 1] = new CasillaNormal(1);
                    }
                    seHaMovido = true;
                }
            }
        } else if (opcionPartida.equals("1")) {//Ve la pista más reciente

        } else if (opcionPartida.equals("2")) {//Ve todas las pistas.

        } else if (opcionPartida.equals("3")) {//Ve el estado

        } else if (opcionPartida.equals("4")) {//Guarda la partida

        } else if (opcionPartida.equals("5")) {//Regresa al menú principal
            new TreasureHunter().verMenuPrincipal();
        }
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

}
