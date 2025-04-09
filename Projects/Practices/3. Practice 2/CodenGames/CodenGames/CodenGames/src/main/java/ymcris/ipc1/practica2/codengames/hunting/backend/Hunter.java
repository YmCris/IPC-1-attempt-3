package ymcris.ipc1.practica2.codengames.hunting.backend;

import ymcris.ipc1.practica2.codengames.buscaminas.backend.jugador.Jugador;
import ymcris.ipc1.practica2.codengames.hunting.backend.pato.Pato;

/**
 * Clase Hunter es la clase "Motor del juego" encargada de realizar la parte
 * lógica "Modelo" del juego Hunter.
 *
 * @author YmCris
 * @since Apr 8, 2025
 */
public class Hunter {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Pato pato;
    private Jugador jugador;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int aciertos;
    private boolean acertó;
    private int aciertosFallidos;
    private boolean partidaTerminada;
    private int aciertosParaAumentarVelocidad;
    private int reduccionDeTiempo;
    private static final int ACIERTOS_PARA_PERDER = 5;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Hunter(String avatar, int velocidadInicial, int aciertosParaAumentarVelocidad, int reduccionDetiempo) {
        this.jugador = new Jugador(avatar, 0);
        this.pato = new Pato(velocidadInicial, false);
        this.reduccionDeTiempo = reduccionDetiempo;
        this.aciertosParaAumentarVelocidad = aciertosParaAumentarVelocidad;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public void crearPartida() {
        pato.oculto(false);
    }

    public void jugar() {
        if (!verificarPartidaTerminada()) {
            System.out.println("Jugamos");
        }
    }

    public void recibirDatosController() {

    }

    public boolean verificarPartidaTerminada() {
        return aciertosFallidos >= ACIERTOS_PARA_PERDER;
    }

    // GETTERS -----------------------------------------------------------------
    public int getAciertos() {
        return aciertos;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public int getAciertosFallidos() {
        return aciertosFallidos;
    }

    public int getAciertosParaAumentarVelocidad() {
        return aciertosParaAumentarVelocidad;
    }

    public boolean isAcertó() {
        return acertó;
    }

    public int getReduccionDeTiempo() {
        return reduccionDeTiempo;
    }

    public Pato getPato() {
        return pato;
    }

    // SETTERS -----------------------------------------------------------------
    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public void setAcertó(boolean acertó) {
        this.acertó = acertó;
    }

    public void setPartidaTerminada(boolean partidaTerminada) {
        this.partidaTerminada = partidaTerminada;
    }

}
