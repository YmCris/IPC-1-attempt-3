package ymcris.ipc1.proyecto2.myfarm.backend.b.granja;

import java.io.Serializable;
import ymcris.ipc1.proyecto2.myfarm.backend.b.terreno.Terreno;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;

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
    private String nombre;
    private Bodega bodega;
    private Terreno terreno;
    private Mercado mercado;
    private Granjero granjero;
    private int oroGenerado;
    private int alimentoGenerado;
    private int alimentoConsumido;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int tiempoJugado;
    private int contador = 0;

    // CONSTANTES --------------------------------------------------------------
    public static final long serialVersionUID = 12345678;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Granja(Granjero granjero) {
        this.granjero = granjero;
        this.nombre = granjero.getNombre();
        this.bodega = new Bodega(granjero);
        this.terreno = new Terreno(granjero);
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
            alimentoConsumido++;
            this.setOroGenerado(granjero.getOro());
            this.setAlimentoGenerado(granjero.getAlimentos().length());
            contador = 0;
            if (granjero.haComidoLoSuficiente()) {
                granjero.setVida(granjero.getVida() + 1);
                granjero.setAlimento(0);
            }
        } else {//Si no ha comido durante 100 segundos se resta vida
            contador++;
            if (contador == granjero.getTIEMPO_PARA_DISMINUIR_VIDA()) {
                granjero.setVida(granjero.getVida() - 1);
                System.out.println("Granjero has perdido 1 punto de vida, tienes " + granjero.getVida() + " puntos de vida");
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

    public String getNombre() {
        return nombre;
    }

    public int getOroGenerado() {
        return oroGenerado;
    }

    public void setOroGenerado(int oroGenerado) {
        this.oroGenerado = oroGenerado;
    }

    public int getAlimentoGenerado() {
        return alimentoGenerado;
    }

    public void setAlimentoGenerado(int alimentoGenerado) {
        this.alimentoGenerado = alimentoGenerado;
    }

    public int getAlimentoConsumido() {
        return alimentoConsumido;
    }

}
