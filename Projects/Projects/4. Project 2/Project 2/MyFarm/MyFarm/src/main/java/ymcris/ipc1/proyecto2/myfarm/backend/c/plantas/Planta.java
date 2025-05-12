package ymcris.ipc1.proyecto2.myfarm.backend.c.plantas;

import java.io.Serializable;
import java.util.Random;
import javax.swing.JButton;
import ymcris.ipc1.proyecto2.myfarm.backend.a.cola.Cola;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Grama;

/**
 * Clase Planta es la clase abstracta padre encargada de ser quien de forma a
 * las plantas así como sus funciones dentro del juego
 *
 * @author YmCris
 * @since May 4, 2025
 */
public abstract class Planta implements Runnable, Serializable {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    protected Grama grama;
    protected String nombre;
    protected JButton boton;
    protected Semillas semilla;
    protected Cola<Alimentos> ordenDeProduccionAlimentos;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    protected int fertilidadSuelo;
    protected int tiempoVivido;
    protected boolean cosechaRecogida;
    protected boolean estaPodrida;//cuando muere para el hilo
    protected boolean cosechaLista;
    protected int tiempoParaCosechar;//depende de cada planta
    protected int tiempoParaPodrirse;//depende de cada planta

    // CONSTANTES --------------------------------------------------------------
    private static final long serialVersionUID = 798877127;
    private static final int TIEMPO_MAXIMO_PARA_DAR_COSECHA = 18;//segundos 420   6
    private static final int TIEMPO_MAXIMO_PARA_PODRIRSE = 20;//segundos 120   4

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Planta(String nombre, Semillas semilla, int fertilidadSuelo, Cola<Alimentos> ordenDeProduccionAlimentos, Grama grama, JButton boton) {
        this.boton=boton;
        this.grama = grama;
        this.nombre = nombre;
        this.semilla = semilla;
        this.fertilidadSuelo = fertilidadSuelo;
        this.tiempoVivido = 0;
        this.estaPodrida = false;
        this.cosechaRecogida = false;
        this.cosechaLista = false;
        this.ordenDeProduccionAlimentos = ordenDeProduccionAlimentos;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public void obtenerInformación() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Tiempo Vivido: " + tiempoVivido);
        System.out.println("Esta Podrida: " + estaPodrida);
        System.out.println("Tiempo para Cosechar: " + tiempoParaCosechar);
        System.out.println("Tiempo para Podrirse: " + tiempoParaPodrirse);
    }

    protected int tiempoCosecha() {
        return random.nextInt((int) (TIEMPO_MAXIMO_PARA_DAR_COSECHA / 2), TIEMPO_MAXIMO_PARA_DAR_COSECHA + 1);
    }

    protected int tiempoPodrirse() {
        return random.nextInt((int) (TIEMPO_MAXIMO_PARA_PODRIRSE / 2), TIEMPO_MAXIMO_PARA_PODRIRSE + 1);
    }

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    public abstract Alimentos darCosecha();

    // GETTERS -----------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public int getTiempoParaCosechar() {
        return tiempoParaCosechar;
    }

    public int getTiempoParaPodrirse() {
        return tiempoParaPodrirse;
    }

    public boolean isEstaPodrida() {
        return estaPodrida;
    }

    public int getTiempoVivido() {
        return tiempoVivido;
    }

    public Semillas getSemilla() {
        return semilla;
    }

    public boolean estaLaCosechaLista() {
        return cosechaLista;
    }

    public Cola<Alimentos> getOrdenDeProduccionAlimentos() {
        return ordenDeProduccionAlimentos;
    }

    public int getFertilidadSuelo() {
        return fertilidadSuelo;
    }

    public boolean isCosechaLista() {
        return cosechaLista;
    }

    public Grama getGrama() {
        return grama;
    }

    public boolean isCosechaRecogida() {
        return cosechaRecogida;
    }

    public void setCosechaRecogida(boolean cosechaRecogida) {
        this.cosechaRecogida = cosechaRecogida;
    }

    // SETTTERS ----------------------------------------------------------------
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTiempoVivido(int tiempoVivido) {
        this.tiempoVivido = tiempoVivido;
    }

    public void setEstaPodrida(boolean estaPodrida) {
        this.estaPodrida = estaPodrida;
    }

    public void setTiempoParaCosechar(int tiempoParaCosechar) {
        this.tiempoParaCosechar = tiempoParaCosechar;
    }

    public void setTiempoParaPodrirse(int tiempoParaPodrirse) {
        this.tiempoParaPodrirse = tiempoParaPodrirse;
    }

    public void setSemilla(Semillas semilla) {
        this.semilla = semilla;
    }

    public void cosechaLista(boolean cosechaLista) {
        this.cosechaLista = cosechaLista;
    }

    public void setGrama(Grama grama) {
        this.grama = grama;
    }

    public void setFertilidadSuelo(int fertilidadSuelo) {
        this.fertilidadSuelo = fertilidadSuelo;
    }

    public void setCosechaLista(boolean cosechaLista) {
        this.cosechaLista = cosechaLista;
    }

}
