package ymcris.ipc1.proyecto2.myfarm.backend.c.plantas;

import java.io.Serializable;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;

/**
 * Clase Semillas es la clase encargada de crear semillas
 *
 * @author YmCris
 * @since May 4, 2025
 */
public class Semillas implements Serializable {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nombre;
    private Alimentos alimento;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int precio;
    private int cantidad;
    private int semillasAdquiridas;
    private int celdasDeTerrenoSembradas;
    private int cantidadDeSemillasRequerida;
    private boolean produceFruta;

    // CONSTANTES --------------------------------------------------------------
    private static final long serialVersionUID = 22222222;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Semillas(String nombre, int precio, boolean produceFruta, int cantidadDeSemillasRequerida, Alimentos alimento) {
        this.nombre = nombre;
        this.precio = precio;
        this.produceFruta = produceFruta;
        this.cantidadDeSemillasRequerida = cantidadDeSemillasRequerida;
        this.alimento = alimento;
    }

    // GETTERS -----------------------------------------------------------------
    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean produceFruta() {
        return produceFruta;
    }

    public Alimentos getAlimento() {
        return alimento;
    }

    public int getCantidadDeSemillasRequerida() {
        return cantidadDeSemillasRequerida;
    }

    // SETTERS -----------------------------------------------------------------
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setAlimento(Alimentos alimento) {
        this.alimento = alimento;
    }

    public int getSemillasAdquiridas() {
        return semillasAdquiridas;
    }

    public void setSemillasAdquiridas(int semillasAdquiridas) {
        this.semillasAdquiridas = semillasAdquiridas;
    }

    public int getCeldasDeTerrenoSembradas() {
        return celdasDeTerrenoSembradas;
    }

    public void setCeldasDeTerrenoSembradas(int celdasDeTerrenoSembradas) {
        this.celdasDeTerrenoSembradas = celdasDeTerrenoSembradas;
    }

}
