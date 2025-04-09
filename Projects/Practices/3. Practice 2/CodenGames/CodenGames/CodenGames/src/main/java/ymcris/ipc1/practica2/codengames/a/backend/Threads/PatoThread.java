package ymcris.ipc1.practica2.codengames.a.backend.Threads;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import static ymcris.ipc1.practica2.codengames.hunting.frontend.JFHunter.COLUMNAS_TABLERO_PATO;
import static ymcris.ipc1.practica2.codengames.hunting.frontend.JFHunter.FILAS_TABLERO_PATO;
import static ymcris.ipc1.practica2.codengames.hunting.frontend.JFHunter.NOMBRE_IMAGEN_PATO;
import static ymcris.ipc1.practica2.codengames.hunting.frontend.JFIniciarHunter.hController;

/**
 * Clase PatoThread es la clase hilo encargada de actualizar el pato durante la
 * ejecución del juego Hunter.
 *
 * @author YmCris
 * @since Apr 9, 2025
 */
public class PatoThread extends Thread {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private JPanel panelJuego;
    private JButton[][] botones;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int velocidadInicial;
    private int reduccionDeTiempo;
    private int cantidadDeAciertos;
    private boolean partidaTerminada;

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();
    ImageIcon iconPato = new ImageIcon(getClass().getResource(NOMBRE_IMAGEN_PATO));

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public PatoThread(JPanel panelJuego, JButton[][] botones, int velocidadInicial, int reduccionDeTiempo, int cantidadDeAciertos) {
        this.panelJuego = panelJuego;
        this.botones = botones;
        this.velocidadInicial = velocidadInicial;
        this.reduccionDeTiempo = reduccionDeTiempo;
        this.cantidadDeAciertos = cantidadDeAciertos;
    }

    // MÉTODOS SOBRE ESCRITOS --------------------------------------------------
    @Override
    public void run() {
        this.partidaTerminada = hController.getHunter().verificarPartidaTerminada();
        while (!partidaTerminada) {
            try {
                Thread.sleep(velocidadInicial);
                mostrarPatoAleatoriamente();
                System.out.println("Estoy cambiando cada " + velocidadInicial);
            } catch (InterruptedException ex) {
                Logger.getLogger(PatoThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("He terminado hilo patos");
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    private void mostrarPatoAleatoriamente() {//Rango [5,5]
        //0. Limpiar todo el tablero para que no hayan muchos patos
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[0].length; j++) {
                botones[i][j].setIcon(null);
            }
        }
        //1. colocar el pato en un boton aleatorio (Visible)
        int filaRandom = random.nextInt(0, FILAS_TABLERO_PATO-1);
        int columnaRandom = random.nextInt(0, COLUMNAS_TABLERO_PATO-1);
        botones[filaRandom][columnaRandom].setIcon(iconPato);
        System.out.println("el icono tiene de height: "+iconPato.getIconHeight());
        System.out.println("el icono tiene de width: "+iconPato.getIconWidth());
        //2. Inepedendientemente si se toca desaparece despues de velociadInicial segundos
        //3. colocar el pato en un boton aleatorio (Visible)
        //(2 y 3 son 0 y 1, pero por el efecto del thread)
    }

}
