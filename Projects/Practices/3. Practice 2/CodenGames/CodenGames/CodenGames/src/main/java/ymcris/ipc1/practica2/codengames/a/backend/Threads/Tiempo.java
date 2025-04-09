package ymcris.ipc1.practica2.codengames.a.backend.Threads;

/**
 * Clase Tiempo es la clase hilo encargada de mostrar continuamente el tiempo en
 * el eque el jugador ha estado jugando.
 *
 * @author YmCris
 * @since Apr 9, 2025
 */
public class Tiempo extends Thread {

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int tiempoTotal = 0;
    private boolean activo = true;

    // MÉTODOS CONCRETOS -------------------------------------------------------
    @Override
    public void run() {
        while (activo) {
            try {
                Thread.sleep(1000);
                tiempoTotal++;
            } catch (InterruptedException e) {
            }
        }
        System.out.println("El hilo ha terminado");
        this.stop();
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
