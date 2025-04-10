package ymcris.ipc1.practica2.codengames.a.backend.Threads;

/**
 * Clase TiempoThread es la clase hilo encargada de mostrar continuamente el
 * tiempo en el eque el jugador ha estado jugando.
 *
 * @author YmCris
 * @since Apr 9, 2025
 */
public class TiempoThread extends Thread {

    /**
     * Para detener este hilo se debe usar:
     * nombreHilo.detenerTimer();
     * nombreHilo.interrumped();
     */
    
    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int tiempoTotal = 0;
    private boolean activo = true;

    // MÉTODOS CONCRETOS -------------------------------------------------------
    @Override
    public void run() {
        while (activo && !this.isInterrupted()) {
            try {
                Thread.sleep(1000);
                tiempoTotal++;
            } catch (InterruptedException e) {
                System.out.println("El hilo de tiempo se ha interrumpido");
                break;
            }
        }
        System.out.println("El hilo de tiempo ha finalizado");
    }

    // MÉTODOS CONCRECTOS ------------------------------------------------------
    public void detenerTimer() {
        this.activo = false;
    }

    // GETTERS -----------------------------------------------------------------
    public int getTiempoTotal() {
        return tiempoTotal;
    }

}
