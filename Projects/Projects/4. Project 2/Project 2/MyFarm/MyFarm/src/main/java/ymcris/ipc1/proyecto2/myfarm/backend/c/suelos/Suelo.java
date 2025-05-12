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
    private int fila;
    private int columna;
    protected boolean estaSucio;
    public boolean bloqueado;
    // CONSTANTES --------------------------------------------------------------
    public static final int PRECIO_DE_COMPRA = 40;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Suelo() {
        this.fila = 0;
        this.columna = 0;
        this.estaSucio = false;
        this.bloqueado = false;
        this.setSize(250, 180);
        this.setText("");
        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(CENTER);
        this.setForeground(new java.awt.Color(255, 255, 255));
    }

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    public void colocarImagen() {
        setText("");
        //this.setIcon(new javax.swing.ImageIcon(getClass().getResource(rutaImagen))); // NOI18N
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

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean estaBloqueado() {
        return bloqueado;
    }

    // SETTERS -----------------------------------------------------------------
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public void setEstaSucio(boolean estaSucio) {
        this.estaSucio = estaSucio;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    

}
