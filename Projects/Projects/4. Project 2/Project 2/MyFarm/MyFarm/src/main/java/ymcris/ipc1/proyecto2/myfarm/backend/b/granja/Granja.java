package ymcris.ipc1.proyecto2.myfarm.backend.b.granja;

import java.io.Serializable;
import ymcris.ipc1.proyecto2.myfarm.backend.a.pila.Pila;
import ymcris.ipc1.proyecto2.myfarm.backend.b.terreno.Terreno;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble.ListaDoble;

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
    private Pila<Alimentos> pila;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int tiempoJugado;

    // CONSTANTES --------------------------------------------------------------
    public static final long serialVersionUID = 12345678;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Granja(Granjero granjero) {
        ListaDoble<Alimentos> alimentos = new ListaDoble<>();
        ListaDoble<MateriasPrimas> materiaPrima = new ListaDoble<>();
        this.granjero = granjero;
        this.bodega = new Bodega(alimentos, materiaPrima);
        this.terreno = new Terreno();
        this.mercado = new Mercado(alimentos, materiaPrima);
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    private boolean partidaTerminada() {
        return granjero.getVida() == 0;
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public void run() {
        while (!partidaTerminada()) {
            try {
                Thread.sleep(1000);
                tiempoJugado++;
            } catch (InterruptedException ex) {
                System.out.println("Hilo partida interrumpido por: " + ex.getMessage());
            }
        }
        System.out.println("La partida ha terminado");
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
