package ymcris.ipc1.proyecto2.myfarm.backend.c.suelos;

import ymcris.ipc1.proyecto2.myfarm.backend.a.interfaces.Pescable;

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
    private static final String NOMBRE_SUELO = "Agua";
    private static final String RUTA_IMAGEN = "/agua.png";
    private static final int TIEMPO_DE_RECUPERACION = 300;//Segundos

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private boolean hayPeces;
    private boolean hayBarcoPesquero;
    private int cantidadDePecesExistentes;
    
    private static final long serialVersionUID = 144700858;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Agua() {
        this.hayPeces = true;
        this.hayBarcoPesquero = false;
        this.cantidadDePecesExistentes = PECES_TOTALES;
        this.nombre = NOMBRE_SUELO;
        this.rutaImagen = RUTA_IMAGEN;
        colocarImagen();
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public void colocarBarco() {
    }

    @Override
    public void quitarBarco() {
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

    public boolean isHayPeces() {
        return hayPeces;
    }

    public int getCantidadDePecesExistentes() {
        return cantidadDePecesExistentes;
    }

    // SETTERS -----------------------------------------------------------------
    public void setHayBarcoPesquero(boolean hayBarcoPesquero) {
        this.hayBarcoPesquero = hayBarcoPesquero;
    }

    public void setCantidadDePeces(int cantidadDePeces) {
        this.cantidadDePecesExistentes = cantidadDePeces;
    }

    public void setHayPeces(boolean hayPeces) {
        this.hayPeces = hayPeces;
    }

    public void setCantidadDePecesExistentes(int cantidadDePecesExistentes) {
        this.cantidadDePecesExistentes = cantidadDePecesExistentes;
    }

}
