package ymcris.ipc1.proyecto2.myfarm.backend.c.animales;

/**
 * Clase Animales es la super clase encargada de tener todos los atributos
 * importantes que les servirán a los animales hervivoros y omnivoros
 *
 * @author YmCris
 * @since Apr 29, 2025
 */
public abstract class Animales {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nombre;
    //private ListaDoble<Productos> productos;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int vida;
    private int precio;
    private double espacio;
    private int vidaMaxima;
    private int produccion;
    private boolean esJoven;
    private boolean esAdulto;
    private boolean estaVivo;
    private boolean estaLleno;
    private int comidaConsumida;
    private int cantidadDeProductos;
    private double produccionRestante;

    // CONSTANTES --------------------------------------------------------------
    public static final int PORCENTAJE_MAXIMO = 100;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Animales(String nombre, int precio, double espacio, int produccion, int cantidadDeProductos, double produccionRestante) {
        this.nombre = nombre;
        this.precio = precio;
        this.espacio = espacio;
        this.produccion = produccion;
        this.cantidadDeProductos = cantidadDeProductos;
        this.produccionRestante = produccionRestante;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    //public abstract void comer(Alimentos alimento);
    // GETTERS -----------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getPrecio() {
        return precio;
    }

    public double getEspacio() {
        return espacio;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getProduccion() {
        return produccion;
    }

    public boolean isEsJoven() {
        return esJoven;
    }

    public boolean isEsAdulto() {
        return esAdulto;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public boolean isEstaLleno() {
        return estaLleno;
    }

    public int getComidaConsumida() {
        return comidaConsumida;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public double getProduccionRestante() {
        return produccionRestante;
    }

    public static int getPORCENTAJE_MAXIMO() {
        return PORCENTAJE_MAXIMO;
    }

    // SETTERS -----------------------------------------------------------------
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setEspacio(double espacio) {
        this.espacio = espacio;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public void setProduccion(int produccion) {
        this.produccion = produccion;
    }

    public void setEsJoven(boolean esJoven) {
        this.esJoven = esJoven;
    }

    public void setEsAdulto(boolean esAdulto) {
        this.esAdulto = esAdulto;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    public void setEstaLleno(boolean estaLleno) {
        this.estaLleno = estaLleno;
    }

    public void setComidaConsumida(int comidaConsumida) {
        this.comidaConsumida = comidaConsumida;
    }

    public void setCantidadDeProductos(int cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    public void setProduccionRestante(double produccionRestante) {
        this.produccionRestante = produccionRestante;
    }

}
