package ymcris.ipc1.proyecto2.myfarm.backend.c.animales;

import java.io.Serializable;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Productos;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble.ListaDoble;

/**
 * Clase Animales es la super clase encargada de tener todos los atributos
 * importantes que les servirán a los animales hervivoros y omnivoros.
 *
 * @author YmCris
 * @since Apr 29, 2025
 */
public class Animales implements Runnable, Serializable {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    protected String nombre;
    protected ListaDoble<Productos> productosDestazables = new ListaDoble<>();
    protected ListaDoble<Productos> productosNoDestazables = new ListaDoble<>();

    // CONSTANTES --------------------------------------------------------------
    private static final long serialVersionUID = 7894124;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    protected int vida;
    protected int edad;
    protected int precio;
    protected int edadMaxima;
    protected double espacio;
    protected int precioLimpieza;
    protected boolean esHerbivoro;
    protected boolean esDestazable;
    protected int porcentajeDeProduccionConDestaze;
    protected int porcentajeDeProduccionSinDestaze;
    protected boolean produciraProductosConDestace;

    // CONSTANTES --------------------------------------------------------------
    public static final int TIEMPO_PARA_DISMINUIR_VIDA = 60;
    public static final int PORCENTAJE_MAXIMO_DE_PRODUCCION = 100;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Animales(String nombre, int precio, double espacio, int edadMaxima, boolean esHerbivoro, boolean esDestazable, boolean produciraProductosConDestace) {
        this.nombre = nombre;
        this.precio = precio;
        this.espacio = espacio;
        this.edadMaxima = edadMaxima;
        this.esHerbivoro = esHerbivoro;
        this.esDestazable = esDestazable;
        this.produciraProductosConDestace = produciraProductosConDestace;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public boolean esAdulto() {
        return ((int) (edadMaxima / 2)) <= edad || edad <= ((int) (edadMaxima / 1.3));
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

    public int getPorcentajeDeProduccionConDestaze() {
        return porcentajeDeProduccionConDestaze;
    }

    public double getEspacio() {
        return espacio;
    }

    public boolean esHerbivoro() {
        return esHerbivoro;
    }

    public static int getTIEMPO_PARA_DISMINUIR_VIDA() {
        return TIEMPO_PARA_DISMINUIR_VIDA;
    }

    public static int getPORCENTAJE_MAXIMO_DE_PRODUCCION() {
        return PORCENTAJE_MAXIMO_DE_PRODUCCION;
    }

    public int getPorcentajeDeProduccionSinDestaze() {
        return porcentajeDeProduccionSinDestaze;
    }

    public boolean esDestazable() {
        return esDestazable;
    }

    public boolean produciraProductosConDestace() {
        return produciraProductosConDestace;
    }

    // SETTERS -----------------------------------------------------------------
    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPorcentajeDeProduccionConDestaze(int porcentajeDeProduccionConDestaze) {
        this.porcentajeDeProduccionConDestaze = porcentajeDeProduccionConDestaze;
    }

    public void setPorcentajeDeProduccionSinDestaze(int porcentajeDeProduccionSinDestaze) {
        this.porcentajeDeProduccionSinDestaze = porcentajeDeProduccionSinDestaze;
    }

}
