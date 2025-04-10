package ymcris.ipc1.practica2.codengames.a.backend.Threads;

import java.util.Random;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import static ymcris.ipc1.practica2.codengames.hunting.frontend.JFHunter.FILAS_TABLERO_PATO;
import static ymcris.ipc1.practica2.codengames.hunting.frontend.JFHunter.NOMBRE_IMAGEN_PATO;
import static ymcris.ipc1.practica2.codengames.hunting.frontend.JFIniciarHunter.hController;
import static ymcris.ipc1.practica2.codengames.hunting.frontend.JFHunter.COLUMNAS_TABLERO_PATO;

/**
 * Clase PatoThread es la clase hilo encargada de actualizar el pato durante la
 * ejecución del juego Hunter.
 *
 * @author YmCris
 * @since Apr 9, 2025
 */
public class PatoThread extends Thread {

    /**
     * Para detener este hilo se debe usar:
     * haberTerminadolapartida
     * nombreHilo.interrumped();
     */
    
    // VARIABLES DE REFERENCIA -------------------------------------------------
    private JButton[][] botones;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int velocidadInicial;
    private int reduccionDeTiempo;
    private boolean partidaTerminada;

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();
    ImageIcon iconPato = new ImageIcon(getClass().getResource(NOMBRE_IMAGEN_PATO));

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public PatoThread(JButton[][] botones, int velocidadInicial, int reduccionDeTiempo) {
        this.botones = botones;
        this.velocidadInicial = velocidadInicial;
        this.reduccionDeTiempo = reduccionDeTiempo;
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public void run() {
        this.partidaTerminada = hController.getHunter().partidaTerminada();
        while (!partidaTerminada && !this.isInterrupted()) {
            if (hController.getHunter().getAciertosParaAumentarVelocidad() >= hController.getHunter().getJugador().getPuntaje()) {//Con velocidad inicial
                try {
                    Thread.sleep(velocidadInicial);
                    mostrarPatoAleatoriamente();
                    System.out.println("Estoy cambiando cada " + velocidadInicial);
                } catch (InterruptedException ex) {
                    System.out.println("Se ha interrumpido el hilo de patos");
                    break;
                }
            } else {//El tiempo de los patos se reduce
                int nuevoTiempo = velocidadInicial - reduccionDeTiempo;
                try {
                    Thread.sleep(nuevoTiempo);
                    mostrarPatoAleatoriamente();
                    System.out.println("Estoy cambiando cada " + nuevoTiempo);
                } catch (InterruptedException ex) {
                    System.out.println("Se ha interrumpido el hilo de patos");
                    break;
                }
            }
        }
        System.out.println("Se ha terminado el hilo de los patos");
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de mostrar el pato de forma aleatoria en los botones,
     * limpiando su icono y luego eligiendo una posición aleatoria entre los 
     * límites del "tablero".
     */
    private void mostrarPatoAleatoriamente() { //Rango [5,5]
        //0. Limpiar todo el tablero para que no hayan muchos patos
        for (JButton[] botone : botones) {
            for (int j = 0; j < botones[0].length; j++) {
                botone[j].setIcon(null);
            }
        }
        //1. colocar el pato en un boton aleatorio (Visible)
        int filaRandom = random.nextInt(0, FILAS_TABLERO_PATO - 1);
        int columnaRandom = random.nextInt(0, COLUMNAS_TABLERO_PATO - 1);
        botones[filaRandom][columnaRandom].setIcon(iconPato);
        //2. Inepedendientemente si se toca desaparece despues de velociadInicial segundos
        //3. colocar el pato en un boton aleatorio (Visible)
        //(2 y 3 son 0 y 1, pero por el efecto del thread)
    }

}
