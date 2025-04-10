package ymcris.ipc1.practica2.codengames.hunting.backend;

import ymcris.ipc1.practica2.codengames.hunting.backend.jugador.Jugador;
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
    private boolean acertó;
    private int disparosFallidos;
    private int reduccionDeTiempo;
    private int aciertosParaAumentarVelocidad;
    public static final int ACIERTOS_PARA_PERDER = 5;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Hunter(String avatar, int velocidadInicial, int aciertosParaAumentarVelocidad, int reduccionDetiempo) {
        this.jugador = new Jugador(avatar, 1);
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
            if (acertó) {
                jugador.disparar();//Dispara y aumenta su puntaje
            }
        }
    }

    public void recibirDatosController() {

    }

    public boolean verificarPartidaTerminada() {
        if (disparosFallidos >= ACIERTOS_PARA_PERDER) {
            System.out.println("Has fallado, has perdido");
            return true;
        }else {
            return false;
        }
    }

    // GETTERS -----------------------------------------------------------------
    public Jugador getJugador() {
        return jugador;
    }

    public int getAciertosFallidos() {
        return disparosFallidos;
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
    public void setAcertó(boolean acertó) {
        this.acertó = acertó;
    }

    public void setDisparosFallidos(int disparosFallidos) {
        this.disparosFallidos = disparosFallidos;
    }
    
}
