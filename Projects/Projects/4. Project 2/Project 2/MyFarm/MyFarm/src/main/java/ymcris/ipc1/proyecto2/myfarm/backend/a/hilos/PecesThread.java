package ymcris.ipc1.proyecto2.myfarm.backend.a.hilos;

import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Agua;

/**
 * Clase PecesThread es la clase encargada de desaparecer los peces y volver a
 * ponerlos
 *
 * @author YmCris
 * @since Apr 27, 2025
 */
public class PecesThread extends Thread {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Agua agua;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private boolean estaActivo;
    private boolean tienePeces;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public PecesThread(Agua agua) {
        this.agua = agua;
    }
    // MÉTODOS CONCRETOS -------------------------------------------------------

    @Override
    public void run() {

    }

    // GETTERS -----------------------------------------------------------------
    public boolean isEstaActivo() {
        return estaActivo;
    }

    public boolean isTienePeces() {
        return tienePeces;
    }

    // SETTERS -----------------------------------------------------------------
    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public void setTienePeces(boolean tienePeces) {
        this.tienePeces = tienePeces;
    }

}
