package ymcris.ipc1.proyecto2.myfarm.backend.c.animales;

import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.ListaDoble;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Productos;

/**
 * Clase Animales es la super clase encargada de tener todos los atributos
 * importantes que les servirán a los animales hervivoros y omnivoros.
 *
 * @author YmCris
 * @since Apr 29, 2025
 */
public abstract class Animales implements Runnable {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    protected String nombre;
    protected ListaDoble<Productos> productosDestazables;
    protected ListaDoble<Productos> productosNoDestazables;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    protected int vida;
    protected int edad;
    protected int precio;
    protected int edadMaxima;
    protected double espacio;
    protected boolean esHerbivoro;
    protected boolean esDestazable;
    protected int porcentajeDeProduccion;
    protected boolean produciraProductosConDestace;

    // CONSTANTES --------------------------------------------------------------
    public static final int TIEMPO_PARA_DISMINUIR_VIDA = 50;
    public static final int PORCENTAJE_MAXIMO_DE_PRODUCCION = 100;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Animales(String nombre, int precio, double espacio, boolean esHerbivoro, boolean esDestazable, boolean produciraProductosConDestace) {
        this.nombre = nombre;
        this.precio = precio;
        this.espacio = espacio;
        this.esHerbivoro = esHerbivoro;
        this.esDestazable = esDestazable;
        this.produciraProductosConDestace = produciraProductosConDestace;
    }

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    // MÉTODOS CONCRETOS -------------------------------------------------------
    public boolean estaVivo() {
        return vida > 0;
    }

    // GETTERS -----------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public ListaDoble<Productos> getProductosDestazables() {
        return productosDestazables;
    }

    public ListaDoble<Productos> getProductosNoDestazables() {
        return productosNoDestazables;
    }

    public int getVida() {
        return vida;
    }

    public int getEdad() {
        return edad;
    }

    public int getPrecio() {
        return precio;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public int getPorcentajeDeProduccion() {
        return porcentajeDeProduccion;
    }

    public double getEspacio() {
        return espacio;
    }

    public boolean isEsHerbivoro() {
        return esHerbivoro;
    }

    public static int getTIEMPO_PARA_DISMINUIR_VIDA() {
        return TIEMPO_PARA_DISMINUIR_VIDA;
    }

    public static int getPORCENTAJE_MAXIMO_DE_PRODUCCION() {
        return PORCENTAJE_MAXIMO_DE_PRODUCCION;
    }

    // SETTERS -----------------------------------------------------------------
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPorcentajeDeProduccion(int porcentajeDeProduccion) {
        this.porcentajeDeProduccion = porcentajeDeProduccion;
    }

}
