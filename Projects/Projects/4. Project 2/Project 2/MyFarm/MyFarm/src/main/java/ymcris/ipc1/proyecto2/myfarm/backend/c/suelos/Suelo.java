package ymcris.ipc1.proyecto2.myfarm.backend.c.suelos;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Clase Suelo es la clase encargada de ser la superclase de los tipos de suelos
 * que habrán en la granja.
 *
 * @author YmCris
 * @since Apr 26, 2025
 */
public abstract class Suelo extends JButton {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    protected String nombre;
    protected String rutaImagen;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    protected boolean estaSucio;

    // CONSTANTES --------------------------------------------------------------
    public static final int PRECIO_DE_COMPRA = 40;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Suelo() {
        this.estaSucio = false;
        this.setSize(90, 90);
    }

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    public void colocarImagen() {
        ImageIcon icon = new ImageIcon(getClass().getResource(rutaImagen));
        int ancho = this.getWidth();
        int alto = this.getHeight();
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        this.setIcon(icono);
    }

    // GETTERS -----------------------------------------------------------------
    public String getRutaImagen() {
        return rutaImagen;
    }

    public boolean estaSucio() {
        return estaSucio;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isEstaSucio() {
        return estaSucio;
    }

    public static int getPRECIO_DE_COMPRA() {
        return PRECIO_DE_COMPRA;
    }

    // SETTERS -----------------------------------------------------------------
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public void estaSucio(boolean estaSucio) {
        this.estaSucio = estaSucio;
    }

    public void setEstaSucio(boolean estaSucio) {
        this.estaSucio = estaSucio;
    }

}
