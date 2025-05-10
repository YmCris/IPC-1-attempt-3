package ymcris.ipc1.proyecto2.myfarm.backend.b.granjero;

import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble.ListaDoble;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Recreador;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaDobleException;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble.NodoDoble;

/**
 * Clase Granjero es la clase encargada de representar al jugador dentro del
 * videojuego teniendo todos los atributos necesarios.
 *
 * @author YmCris
 * @since Apr 26, 2025
 */
public final class Granjero {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nick;
    private String nombre;
    private Fertilizantes[] fertilizantes;
    private Alimentos[] alimentosParaAnimales;
    private ListaDoble<Semillas> semillas;
    private ListaDoble<Animales> animales;
    private ListaDoble<Alimentos> alimentos;
    private ListaDoble<MateriasPrimas> materias;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int oro;
    private int vida;
    private int alimento;
    private boolean haComido;
    private boolean estaLleno;

    // CONSTANTES --------------------------------------------------------------
    private final int VIDA_MAXIMA = 10;
    private final int TIEMPO_PARA_DISMINUIR_VIDA = 100;

    // INSTANCIAS --------------------------------------------------------------
    Recreador recreador = new Recreador();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Granjero(String nick, String nombre) {
        this.fertilizantes = recreador.obtenerFertilizantesExistentes();
        this.alimentosParaAnimales = recreador.obtenerAlimentosParaAnimalesExistentes();
        this.materias = new ListaDoble<>();
        this.alimentos = new ListaDoble<>();
        this.animales = new ListaDoble<>();
        this.semillas = new ListaDoble<>();
        alimentos.agregar(new Alimentos("alimento1", 50, 100, true), "alimento1");
        alimentos.agregar(new Alimentos("alimento2", 50, 100, true), "alimento2");
        alimentos.agregar(new Alimentos("alimento3", 50, 100, true), "alimento3");
        alimentos.agregar(new Alimentos("alimento4", 50, 100, true), "alimento4");
        alimentos.agregar(new Alimentos("alimento5", 50, 100, true), "alimento5");
        alimentos.agregar(new Alimentos("alimento6", 50, 100, true), "alimento6");
        materias.agregar(new MateriasPrimas("materia1", 50, 15), "materia1");
        this.nick = nick;
        this.nombre = nombre;
        this.oro = 1000;
        this.vida = 3;
        this.alimento = 0;
        this.haComido = false;
        this.estaLleno = true;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Verifica si el jugador tiene comida
     *
     * @return mensaje de no tener comida para el frontend.
     */
    public String hayComida() {
        if (alimentos.estaVacia()) {
            return "No tienes comida";
        }
        return "";
    }

    /**
     * Método encargado de comer, sumar vida, y eliminar el alimento del
     * inventario.
     *
     * @param nombreAlimento- Alimentos a consumir
     */
    public void comer(String nombreAlimento) {
        if (!alimentos.estaVacia()) {
            try {
                alimentos.usar(nombreAlimento);
                alimento++;
                haComido = true;
            } catch (ListaDobleException ex) {
                System.out.println("Ha ocurrido un error al comer porque " + ex.getMessage());
            }
        }
    }

    public boolean haComidoLoSuficiente() {
        if (alimento >= 5) {
            alimento = 0;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método encargado de obtener los alimentos del granjero.
     *
     * @return arreglo con todos los alimentos del granjero.
     */
    public Alimentos[] obtenerAlimentosDeAnimalesDelGranjero() {
        Object[] objetos = alimentos.obtenerArregloDeObjetos();
        Alimentos[] arreglo = new Alimentos[objetos.length];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (Alimentos) objetos[i];
        }
        System.out.println("tamaño del arreglo de los alimentos es: " + arreglo.length);
        return arreglo;
    }

    /**
     * Método encaragdo de obtener todas las materias primas del granjero.
     *
     * @return arreglo con todas las materias primas del granjero.
     */
    public MateriasPrimas[] obtenerMateriaDelGranjero() {
        Object[] objetos = materias.obtenerArregloDeObjetos();
        MateriasPrimas[] arreglo = new MateriasPrimas[objetos.length];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (MateriasPrimas) objetos[i];
        }
        System.out.println("tamaño del arreglo de las materias primas es: " + arreglo.length);
        return arreglo;
    }

    public void agregarCantidadASemilla(String nombreSemilla, int cantidad) {
        for (int i = 0; i < semillas.length(); i++) {
            NodoDoble<Semillas> nodo = semillas.obtenerNodo(i);
            if (nodo.getNombre().equals(nombreSemilla)) {
                nodo.getContenido().setCantidad(nodo.getContenido().getCantidad() + cantidad);
                System.out.println("Se tienen " + nodo.getContenido().getCantidad() + " semillas de las semilla" + nodo.getContenido().getNombre());
            }
        }
    }

    public void agregarCantidadFertilizante(String nombreFertilizante) {
        for (Fertilizantes fertilizante : fertilizantes) {
            if (fertilizante.getNombre().equals(nombreFertilizante)) {
                fertilizante.setCantidad(fertilizante.getCantidad() + 1);
                System.out.println("Se tienen " + fertilizante.getCantidad() + " fertilizantes del fertilizante " + fertilizante.getNombre());
            }
        }
    }

    public void agregarCantidadAlimentoParaAnimales(String nombreAlimentos) {
        for (Alimentos alimentoParaAnimal : alimentosParaAnimales) {
            if (alimentoParaAnimal.getNombre().equals(nombreAlimentos)) {
                alimentoParaAnimal.setCantidad(alimentoParaAnimal.getCantidad() + 1);
                System.out.println("Se tienen " + alimentoParaAnimal.getCantidad() + " alimnentos para animal del tipo " + alimentoParaAnimal.getNombre());
            }
        }
    }

    // GETTERS -----------------------------------------------------------------
    public ListaDoble<Animales> getAnimales() {
        return animales;
    }

    public ListaDoble<Alimentos> getAlimentos() {
        return alimentos;
    }

    public String getNick() {
        return nick;
    }

    public String getNombre() {
        return nombre;
    }

    public int getOro() {
        return oro;
    }

    public int getVida() {
        return vida;
    }

    public int getAlimento() {
        return alimento;
    }

    public boolean estaLleno() {
        return estaLleno;
    }

    public boolean haComido() {
        return haComido;
    }

    public int getTIEMPO_PARA_DISMINUIR_VIDA() {
        return TIEMPO_PARA_DISMINUIR_VIDA;
    }

    public Fertilizantes[] getFertilizantes() {
        return fertilizantes;
    }

    public Alimentos[] getAlimentosParaAnimales() {
        return alimentosParaAnimales;
    }

    public ListaDoble<Semillas> getSemillas() {
        return semillas;
    }

    public ListaDoble<MateriasPrimas> getMaterias() {
        return materias;
    }

    public boolean isHaComido() {
        return haComido;
    }

    // SETTERS -----------------------------------------------------------------
    public void setOro(int oro) {
        this.oro = oro;
    }

    public void setVida(int vida) {
        this.vida = vida;
        if (this.vida >= VIDA_MAXIMA) {
            this.vida = VIDA_MAXIMA;
        } else if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public void setAlimento(int alimento) {
        this.alimento = alimento;
    }

    public void estaLleno(boolean estaLleno) {
        this.estaLleno = estaLleno;
    }

    public void setHaComido(boolean haComido) {
        this.haComido = haComido;
    }

}
