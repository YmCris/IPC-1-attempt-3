package ymcris.ipc1.proyecto2.myfarm.backend.c.suelos;

import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;

/**
 * Clase Suelo es la clase encargada de ser la superclase de los tipos de suelos
 * que habrán en la granja.
 *
 * @author YmCris
 * @since Apr 26, 2025
 */
public abstract class Suelo {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    protected Granjero granjero;
    protected String rutaImagen;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    protected int precio;
    protected int distribucion;
    protected boolean estaSucio;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Suelo(Granjero granjero, int precio, int distribucion, boolean estaSucio) {
        this.granjero = granjero;
        this.precio = precio;
        this.distribucion = distribucion;
        this.estaSucio = estaSucio;
    }

    // GETTERS -----------------------------------------------------------------
    public Granjero getGranjero() {
        return granjero;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public int getPrecio() {
        return precio;
    }

    public boolean estaSucio() {
        return estaSucio;
    }

    public int getDistribucion() {
        return distribucion;
    }

    // SETTERS -----------------------------------------------------------------
    public void setGranjero(Granjero granjero) {
        this.granjero = granjero;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setDistribucion(int distribucion) {
        this.distribucion = distribucion;
    }

    public void sucio(boolean estaSucio) {
        this.estaSucio = estaSucio;
    }

}
