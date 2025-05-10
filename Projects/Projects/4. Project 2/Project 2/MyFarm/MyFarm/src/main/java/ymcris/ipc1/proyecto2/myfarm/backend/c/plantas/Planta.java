package ymcris.ipc1.proyecto2.myfarm.backend.c.plantas;

import java.io.Serializable;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;

/**
 * Clase Planta es la clase abstracta padre encargada de ser quien de forma a
 * las plantas así como sus funciones dentro del juego
 *
 * @author YmCris
 * @since May 4, 2025
 */
public abstract class Planta implements Runnable, Serializable{

    // VARIABLES DE REFERENCIA -------------------------------------------------
    protected String nombre;
    protected Semillas semilla;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    protected int tiempoVivido;//varia
    protected boolean estaPodrida;//cuando muere para el hilo
    protected boolean produceFruta;
    protected int semillasRequeridas;
    protected int tiempoParaCosechar;//depende de cada planta
    protected int tiempoParaPodrirse;//depende de cada planta
    protected boolean desapareceAlMorir;

    // CONSTANTES --------------------------------------------------------------
    private static final long serialVersionUID = 798877127;
    
    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Planta(String nombre, Semillas semilla, int semillasRequeridas) {
        this.nombre = nombre;
        this.semilla = semilla;
        this.produceFruta = semilla.isProduceFruta();
        this.semillasRequeridas = semillasRequeridas;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public void obtenerInformación() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Produce Fruta: " + produceFruta);
        System.out.println("Tiempo Vivido: " + tiempoVivido);
        System.out.println("Esta Podrida: " + estaPodrida);
        System.out.println("Semillas Requeridas: " + semillasRequeridas);
        System.out.println("Tiempo para Cosechar: " + tiempoParaCosechar);
        System.out.println("Tiempo para Podrirse: " + tiempoParaPodrirse);
        System.out.println("Desaparece al morir: " + desapareceAlMorir);
    }

    // MÉTODOS ABSTRACTOS ------------------------------------------------------
    public abstract Alimentos darCosecha();

    // GETTERS -----------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public int getSemillasRequeridas() {
        return semillasRequeridas;
    }

    public int getTiempoParaCosechar() {
        return tiempoParaCosechar;
    }

    public int getTiempoParaPodrirse() {
        return tiempoParaPodrirse;
    }

    public boolean isProduceFruta() {
        return produceFruta;
    }

    public boolean isEstaPodrida() {
        return estaPodrida;
    }

    public boolean isDesapareceAlMorir() {
        return desapareceAlMorir;
    }

    public int getTiempoVivido() {
        return tiempoVivido;
    }

    public Semillas getSemilla() {
        return semilla;
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

    public void setProduceFruta(boolean produceFruta) {
        this.produceFruta = produceFruta;
    }

    public void setSemillasRequeridas(int semillasRequeridas) {
        this.semillasRequeridas = semillasRequeridas;
    }

    public void setTiempoParaCosechar(int tiempoParaCosechar) {
        this.tiempoParaCosechar = tiempoParaCosechar;
    }

    public void setTiempoParaPodrirse(int tiempoParaPodrirse) {
        this.tiempoParaPodrirse = tiempoParaPodrirse;
    }

    public void setDesapareceAlMorir(boolean desapareceAlMorir) {
        this.desapareceAlMorir = desapareceAlMorir;
    }

    public void setSemilla(Semillas semilla) {
        this.semilla = semilla;
    }

}
