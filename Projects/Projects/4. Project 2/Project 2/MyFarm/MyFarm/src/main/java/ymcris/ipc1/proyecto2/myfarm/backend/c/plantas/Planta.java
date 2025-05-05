package ymcris.ipc1.proyecto2.myfarm.backend.c.plantas;

/**
 * Clase Planta es la clase abstracta padre encargada de ser quien de forma a
 * las plantas así como sus funciones dentro del juego
 *
 * @author YmCris
 * @since May 4, 2025
 */
public abstract class Planta extends Thread{

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nombre;
    private Semillas semilla;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int tiempoVivido;
    private boolean estaPodrida;
    private boolean produceFruta;
    private int semillasRequeridas;
    private int tiempoParaCosechar;
    private int tiempoParaPodrirse;
    private boolean muerteInmediata;
    private boolean desapareceAlMorir;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Planta(String nombre, boolean produceFruta, int semillasRequeridas, int precioSemillas) {
        this.nombre = nombre;
        this.produceFruta = produceFruta;
        this.semillasRequeridas = semillasRequeridas;
        this.semilla = new Semillas(nombre, precioSemillas, 0);
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
        System.out.println("Muerte Inmediata: " + muerteInmediata);
        System.out.println("Desaparece al morir: " + desapareceAlMorir);
    }

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

    public boolean isMuerteInmediata() {
        return muerteInmediata;
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

    public void setMuerteInmediata(boolean muerteInmediata) {
        this.muerteInmediata = muerteInmediata;
    }

    public void setDesapareceAlMorir(boolean desapareceAlMorir) {
        this.desapareceAlMorir = desapareceAlMorir;
    }

}
