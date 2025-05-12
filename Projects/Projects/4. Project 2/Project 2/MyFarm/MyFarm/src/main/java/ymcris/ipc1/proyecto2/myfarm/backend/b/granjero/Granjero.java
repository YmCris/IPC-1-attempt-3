package ymcris.ipc1.proyecto2.myfarm.backend.b.granjero;

import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble.NodoDoble;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble.ListaDoble;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Recreador;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaDobleException;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;

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
            quitarCantidadAAlimento(nombreAlimento, 1);
            alimento++;
            haComido = true;
        }
    }

    public boolean haComidoLoSuficiente() {
        return alimento >= 5;
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
        return arreglo;
    }

    public Semillas[] obtenerSemillasDelGranjero() {
        Object[] objetos = semillas.obtenerArregloDeObjetos();
        Semillas[] arregloDeSemillas = new Semillas[objetos.length];
        for (int i = 0; i < arregloDeSemillas.length; i++) {
            arregloDeSemillas[i] = (Semillas) objetos[i];
        }
        return arregloDeSemillas;
    }

    public void agregarCantidadASemilla(String nombreSemilla, int cantidad) {
        for (int i = 0; i < semillas.length(); i++) {
            NodoDoble<Semillas> nodo = semillas.obtenerNodo(i);
            if (nodo.getNombre().equals(nombreSemilla)) {
                nodo.getContenido().setCantidad(nodo.getContenido().getCantidad() + cantidad);
                System.out.println("Se tienen " + nodo.getContenido().getCantidad() + " semillas de la planta " + nodo.getContenido().getNombre());
            }
        }
    }

    public Alimentos obtenerAlimentos(String nombreAlimento) throws ListaDobleException {
        for (int i = 0; i < alimentos.length(); i++) {
            NodoDoble<Alimentos> alimentoAUsar = alimentos.obtenerNodo(i);
            if (alimentoAUsar.getNombre().equals(nombreAlimento)) {
                return alimentoAUsar.getContenido();
            }
        }
        throw new ListaDobleException("No se obtuvo el elemento con el nombre");
    }

    public void agregarCantidadAAlimento(String nombreAlimento, int cantidad) {
        for (int i = 0; i < alimentos.length(); i++) {
            NodoDoble<Alimentos> alimentoAUsar = alimentos.obtenerNodo(i);
            if (alimentoAUsar.getNombre().equals(nombreAlimento)) {
                alimentoAUsar.getContenido().setCantidad(alimentoAUsar.getContenido().getCantidad() + cantidad);
                System.out.println("Se tienen " + alimentoAUsar.getContenido().getCantidad() + " unidades del alimento " + alimentoAUsar.getContenido().getNombre());
            }
        }

    }

    private void quitarCantidadAAlimento(String nombreAlimento, int cantidad) {
        for (int i = 0; i < alimentos.length(); i++) {
            NodoDoble<Alimentos> nodo = alimentos.obtenerNodo(i);
            if (nodo.getNombre().equals(nombreAlimento)) {
                nodo.getContenido().setCantidad(nodo.getContenido().getCantidad() - cantidad);
                System.out.println("Se tienen " + nodo.getContenido().getCantidad() + " unidades del alimento " + nodo.getContenido().getNombre());
            }
        }
    }

    public void quitarCantidadASemilla(String nombreSemilla, int cantidad) {
        for (int i = 0; i < semillas.length(); i++) {
            NodoDoble<Semillas> nodo = semillas.obtenerNodo(i);
            if (nodo.getNombre().equals(nombreSemilla)) {
                nodo.getContenido().setCantidad(nodo.getContenido().getCantidad() - cantidad);
                System.out.println("Se tienen " + nodo.getContenido().getCantidad() + " semillas de la semilla " + nodo.getContenido().getNombre());
            }
        }
    }

    public boolean tieneLasSemillasSuficientes(String nombreSemilla, int cantidadRequerida) {
        for (int i = 0; i < semillas.length(); i++) {
            NodoDoble<Semillas> nodo = semillas.obtenerNodo(i);
            if (nodo.getNombre().equals(nombreSemilla)) {
                if (nodo.getContenido().getCantidad() >= cantidadRequerida) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean tieneLosFertilizantesSuficientes(String nombreFertilizante, int cantidad) {
        for (Fertilizantes fertilizante : fertilizantes) {
            if (fertilizante.getNombre().equals(nombreFertilizante)) {
                if (fertilizante.getCantidad() >= cantidad) {
                    return true;
                }
            }
        }
        return false;
    }

    public void agregarCantidadFertilizante(String nombreFertilizante) {
        for (Fertilizantes fertilizante : fertilizantes) {
            if (fertilizante.getNombre().equals(nombreFertilizante)) {
                fertilizante.setCantidad(fertilizante.getCantidad() + 1);
                System.out.println("Se tienen " + fertilizante.getCantidad() + " fertilizantes del fertilizante " + fertilizante.getNombre());
            }
        }
    }

    public void quitarCantidadAFertilizantes(String nombreFertilizante, int cantidad) {
        for (Fertilizantes fertilizante : fertilizantes) {
            if (fertilizante.getNombre().equals(nombreFertilizante)) {
                fertilizante.setCantidad(fertilizante.getCantidad() - cantidad);
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
        if (this.oro < 0) {
            this.oro = 0;
        }
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
