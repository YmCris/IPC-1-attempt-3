package ymcris.ipc1.practica2.codengames.hunting.backend;

import ymcris.ipc1.practica2.codengames.hunting.backend.pato.Pato;
import ymcris.ipc1.practica2.codengames.hunting.backend.jugador.Jugador;

/**
 * Clase Hunter es la clase "Motor del juego" encargada de realizar la parte
 * lógica "Modelo" del juego Hunter.
 *
 * @author YmCris
 * @see Pato
 * @see Jugador
 * @since Apr 8, 2025
 */
public class Hunter {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Pato pato;
    private Jugador jugador;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private boolean acertó;
    private int disparosFallidos;
    private int reduccionDeTiempo;
    private int aciertosParaAumentarVelocidad;
    public static final int ACIERTOS_PARA_PERDER = 5;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Hunter(String avatar, int velocidadInicial, int aciertosParaAumentarVelocidad, int reduccionDetiempo) {
        this.jugador = new Jugador(avatar, 1);
        this.pato = new Pato(velocidadInicial);
        this.reduccionDeTiempo = reduccionDetiempo;
        this.aciertosParaAumentarVelocidad = aciertosParaAumentarVelocidad;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de jugar (Se ve que no hace nada, pero literalmente lo
     * único que le comunica el frontend es si acertó xd)
     */
    public void jugar() {
        if (!partidaTerminada()) {//No ha sobrepasado el límite de fallos.
            if (acertó) {//Si le dió al pato
                jugador.disparar();//Dispara y aumenta su puntaje
            }
        }
    }

    /**
     * Método encargado de verificar si la partida ha terminado por fallar.
     *
     * @return true si ha fallado ACIERTOS_PARA_PERDER veces.
     */
    public boolean partidaTerminada() {
        return disparosFallidos >= ACIERTOS_PARA_PERDER;
    }

    // GETTERS -----------------------------------------------------------------
    public Jugador getJugador() {
        return jugador;
    }

    public Pato getPato() {
        return pato;
    }

    public int getAciertosParaAumentarVelocidad() {
        return aciertosParaAumentarVelocidad;
    }

    public int getReduccionDeTiempo() {
        return reduccionDeTiempo;
    }

    public int getDisparosFallidos() {
        return disparosFallidos;
    }
    

    // SETTERS -----------------------------------------------------------------
    public void setAcertó(boolean acertó) {
        this.acertó = acertó;
    }

    public void setDisparosFallidos(int disparosFallidos) {
        this.disparosFallidos = disparosFallidos;
    }

}
