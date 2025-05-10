package ymcris.ipc1.proyecto2.myfarm.backend.b.granja;

import java.io.Serializable;
import ymcris.ipc1.proyecto2.myfarm.backend.a.pila.Cola;
import ymcris.ipc1.proyecto2.myfarm.backend.b.terreno.Terreno;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;

/**
 * Clase Granja es la clase "Partida" encargada de reunir todos los elementos
 * del bakcend y hacerlos funcionar y mostrarselos al frontend.
 *
 * @see Bodega
 * @see Terreno
 * @see Mercado
 * @see Granjero
 * @author YmCris
 * @since May 3, 2025
 */
public class Granja implements Serializable, Runnable {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Bodega bodega;
    private Terreno terreno;
    private Mercado mercado;
    private Granjero granjero;
    private Cola<Alimentos> cola;
    private Alimentos[] alimentos;
    private MateriasPrimas[] materias;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int tiempoJugado;
    private int contador = 0;

    // CONSTANTES --------------------------------------------------------------
    public static final long serialVersionUID = 12345678;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Granja(Granjero granjero) {
        this.granjero = granjero;
        this.bodega = new Bodega(granjero);
        this.terreno = new Terreno();
        this.mercado = new Mercado(granjero);
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public void run() {
        while (!partidaTerminada()) {
            try {
                Thread.sleep(1000);
                jugar();
                tiempoJugado++;
            } catch (InterruptedException ex) {
                System.out.println("Hilo partida interrumpido por: " + ex.getMessage());
            }
        }
        System.out.println("Juego Terminado");
    }

    public void jugar() {
        if (granjero.haComido()) {//Si ha comido se reinicia el contador
            System.out.println("ha comido");
            contador = 0;
            granjero.setVida(granjero.getVida() + 1);
        } else {//Si no ha comido durante 100 segundos se resta vida
            contador++;
            if (contador == granjero.getTIEMPO_PARA_DISMINUIR_VIDA()) {
                System.out.println("Granjero ha perdido 1 punto de vida, tiene " + granjero.getVida() + " puntos de vida");
                granjero.setVida(granjero.getVida() - 1);
                contador = 0;
            }
        }
        granjero.setHaComido(false);
    }

    /**
     * Método encargado de verificar si una partida ha terminado
     *
     * @return true si la vida del granjero es cero.
     */
    public boolean partidaTerminada() {
        return granjero.getVida() == 0;
    }

    // GETTERS -----------------------------------------------------------------
    public Bodega getBodega() {
        return bodega;
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public Mercado getMercado() {
        return mercado;
    }

    public Granjero getGranjero() {
        return granjero;
    }

    public int getTiempoJugado() {
        return tiempoJugado;
    }

}
