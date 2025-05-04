package ymcris.ipc1.proyecto2.myfarm.backend.c.suelos;

import ymcris.ipc1.proyecto2.myfarm.backend.a.interfaces.Pescable;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;

/**
 * Clase Agua es una clase hija de suelo encargada de representar una celda del
 * tipo agua
 *
 * @author YmCris
 * @since Apr 26, 2025
 */
public class Agua extends Suelo implements Pescable {

    // CONSTANTES --------------------------------------------------------------
    private static final int PECES_TOTALES = 15;
    private static final int TIEMPO_DE_RECUPERACION = 3000;
    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private boolean hayBarcoPesquero;
    private int cantidadDePecesExistentes;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Agua(Granjero granjero, int precio, int distribucion, boolean estaSucio) {
        super(granjero, precio, distribucion, estaSucio);
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public void colocarBarco(int oroGranjero) {
    }

    @Override
    public void quitarBarco(int oroGranjero) {
    }

    @Override
    public void pescar() {
    }

    // GETTERS -----------------------------------------------------------------
    public boolean isHayBarcoPesquero() {
        return hayBarcoPesquero;
    }

    public int getCantidadDePeces() {
        return cantidadDePecesExistentes;
    }

    public static int getTIEMPO_DE_RECUPERACION() {
        return TIEMPO_DE_RECUPERACION;
    }

    // SETTERS -----------------------------------------------------------------
    public void setHayBarcoPesquero(boolean hayBarcoPesquero) {
        this.hayBarcoPesquero = hayBarcoPesquero;
    }

    public void setCantidadDePeces(int cantidadDePeces) {
        this.cantidadDePecesExistentes = cantidadDePeces;
    }

}
