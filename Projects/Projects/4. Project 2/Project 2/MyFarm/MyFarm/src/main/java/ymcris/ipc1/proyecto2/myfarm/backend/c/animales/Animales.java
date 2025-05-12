package ymcris.ipc1.proyecto2.myfarm.backend.c.animales;

import java.io.Serializable;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble.ListaDoble;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Productos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Grama;

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
    protected Grama grama;
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
    protected boolean haComido;
    protected boolean esHerbivoro;
    protected boolean esDestazable;
    protected int cantidadDeAlimentoConsumido;
    protected int porcentajeDeProduccionConDestaze;
    protected int porcentajeDeProduccionSinDestaze;
    protected boolean produciraProductosConDestace;

    // CONSTANTES --------------------------------------------------------------
    public static final int TIEMPO_PARA_DISMINUIR_VIDA = 60;//segundos
    public static final int PORCENTAJE_MAXIMO_DE_PRODUCCION = 100;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Animales(String nombre, int precio, double espacio, int edadMaxima, boolean esHerbivoro, boolean esDestazable, boolean produciraProductosConDestace) {
        this.nombre = nombre;
        this.vida = 30;//
        this.edad = 0;
        this.precio = precio;
        this.espacio = espacio;
        this.edadMaxima = edadMaxima;
        this.esHerbivoro = esHerbivoro;
        this.haComido = false;
        this.esDestazable = esDestazable;
        this.produciraProductosConDestace = produciraProductosConDestace;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public MateriasPrimas[] producirMateriaPrima() {
        /*
        MateriasPrimas[] materias = new MateriasPrimas[productosNoDestazables.length()];
        for (int i = 0; i < materias.length; i++) {
            materias[i] = productosDestazables.usar(nombre);
        }
*/
        return null;
    }

    @Override
    public void run() {
        int contador = 0;
        while (!haMuertoPorHambre() && !haMuertoPorVejez()) {
            System.out.println("Vida: " + vida + " Edad " + edad + " EdadMaxima: " + edadMaxima);
            try {
                Thread.sleep(1000);
                contador++;
                if (contador == 5) {
                    haComido = false;
                    contador = 0;
                }
                if (haComido == false) {
                    vida--;
                    grama.setText("Vida " + vida + " Edad " + edad);
                }
                edad++;
                if (vida <= 0) {
                    grama.setText("Muerto por no comer");
                    grama.setEstaSucio(true);
                    grama.setBloqueado(true);
                    grama.setTieneAnimales(false);
                }
                if (edad >= edadMaxima) {
                    grama.setText("Muerto por vejez");
                    grama.setBloqueado(true);
                    grama.setEstaSucio(true);
                    grama.setTieneAnimales(false);
                }
            } catch (InterruptedException ex) {
                System.out.println("Hubo un error en el hilo del animal herbivoro porque " + ex.getMessage());
            }
        }
        System.out.println("Se ha terminado el hilo del animal herbivoro");
    }

    public boolean haMuertoPorVejez() {
        return edad >= edadMaxima;
    }

    public boolean haMuertoPorHambre() {
        return vida <= 0;
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

    public int getCantidadDeAlimentoConsumido() {
        return cantidadDeAlimentoConsumido;
    }

    public void setCantidadDeAlimentoConsumido(int cantidadDeAlimentoConsumido) {
        this.cantidadDeAlimentoConsumido = cantidadDeAlimentoConsumido;
    }

    public void setPorcentajeDeProduccionConDestaze(int porcentajeDeProduccionConDestaze) {
        this.porcentajeDeProduccionConDestaze = porcentajeDeProduccionConDestaze;
    }

    public void setPorcentajeDeProduccionSinDestaze(int porcentajeDeProduccionSinDestaze) {
        this.porcentajeDeProduccionSinDestaze = porcentajeDeProduccionSinDestaze;
    }

    public boolean haComido() {
        return haComido;
    }

    public void setHaComido(boolean haComido) {
        this.haComido = haComido;
    }

    public Grama getGrama() {
        return grama;
    }

    public void setGrama(Grama grama) {
        this.grama = grama;
    }

}
