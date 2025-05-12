package ymcris.ipc1.proyecto2.myfarm.backend.b.terreno;

import java.io.Serializable;
import java.util.Random;
import ymcris.ipc1.proyecto2.myfarm.backend.a.cola.Cola;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Agua;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Grama;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Suelo;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Desierto;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.ortogonal.NodoOrtogonal;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.ortogonal.ListaOrtogonal;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaOrtogonalException;

/**
 * Clase Terreno
 *
 * @author YmCris
 * @since Apr 27, 2025
 */
public final class Terreno implements Serializable{

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Granjero granjero;
    private NodoOrtogonal[] suelosPredeterminados;
    private Cola<Integer> ordenDeProduccionCelda;
    private Cola<Alimentos> ordenDeProduccionAlimentos;

    // CONSTANTES --------------------------------------------------------------
    public static final int PRECIO_LIMPIEZA_TODO_EL_TERRENO = 300;
    public static final int PRECIO_LIMPIEZA_CELDA = 50;
    private static final int DISTRIBUCION_GRAMA = 40;
    private static final int DISTRIBUCION_DESIERTO = 25;
    public static final long serialVersionUID = 44551100;

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();
    ListaOrtogonal tablero = new ListaOrtogonal();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Terreno(Granjero granjero) {
        this.granjero = granjero;
        this.suelosPredeterminados = new NodoOrtogonal[25];
        this.ordenDeProduccionCelda = new Cola<>();
        this.ordenDeProduccionAlimentos = new Cola<>();
        generarSuelos();
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public void generarSuelos() {
        try {
            for (int i = 0; i < suelosPredeterminados.length; i++) {
                suelosPredeterminados[i] = new NodoOrtogonal(generarSuelo());
            }
            tablero.crearTablero(suelosPredeterminados);
        } catch (ListaOrtogonalException ex) {
            System.out.println("Hubo un error al agregar los suelos iniciales a la lista porque " + ex.getMessage());
        }
    }

    public Suelo generarSuelo() {
        int probabilidad = random.nextInt(0, 101);
        if (probabilidad <= DISTRIBUCION_DESIERTO) {//[0,25]==25% de prob
            return new Desierto();
        } else if (probabilidad <= 100 - DISTRIBUCION_GRAMA) {//[26,60] ==35% de prob
            return new Agua();
        } else {//[60,100] 40% de prob
            return new Grama(ordenDeProduccionCelda, ordenDeProduccionAlimentos, granjero);
        }
    }

    public void generarTerreno() {

    }

    public boolean parcelaEliminada(int filaInicio, int columnaInicio, int filaFin, int columnaFin, String nombreAnimal) {
        try {
            if (parcelaCreada(filaInicio, columnaInicio, filaFin, columnaFin, nombreAnimal)) {
                for (int i = filaInicio; i <= filaFin; i++) {
                    for (int j = columnaInicio; j <= columnaFin; j++) {
                        Suelo suelo = tablero.obtenerNodo(i, j).getSuelo();
                        if (suelo instanceof Grama grama) {
                            grama.setEsParcela(false);
                            grama.setAnimalesPermitidos("No hay animales permitidos");
                        }
                    }
                }
                return true;
            }
        } catch (ListaOrtogonalException e) {
            System.out.println("No se ha podido crear la parcela porque " + e.getMessage());
        }
        return false;
    }

    public boolean parcelaCreada(int filaInicio, int columnaInicio, int filaFin, int columnaFin, String nombreAnimal) {
        try {
            for (int i = filaInicio; i <= filaFin; i++) {// verificación para saber si son del tipo grama
                for (int j = columnaInicio; j <= columnaFin; j++) {
                    Suelo suelo = tablero.obtenerNodo(i, j).getSuelo();
                    if (suelo instanceof Agua || suelo instanceof Desierto) {
                        return false;
                    }
                }
            }
            for (int i = filaInicio; i <= filaFin; i++) {// verificar que no este ocupada
                for (int j = columnaInicio; j <= columnaFin; j++) {
                    Suelo suelo = tablero.obtenerNodo(i, j).getSuelo();
                    if (suelo instanceof Grama grama) {
                        if (grama.estaOpupado() || grama.tieneAnimales() || grama.tienePlanta()) {
                            return false;
                        }
                    }
                }
            }
            for (int i = filaInicio; i <= filaFin; i++) {// asignarlo como parcela
                for (int j = columnaInicio; j <= columnaFin; j++) {
                    Suelo suelo = tablero.obtenerNodo(i, j).getSuelo();
                    if (suelo instanceof Grama grama) {
                        grama.setEsParcela(true);
                        grama.setAnimalesPermitidos(nombreAnimal);
                    }
                }
            }
            return true;
        } catch (ListaOrtogonalException e) {
            System.out.println("No se ha podido crear la parcela porque " + e.getMessage());
            return false;
        }
    }

    public void modificarCelda(int fila, int columna, Suelo suelo) {
        try {
            tablero.obtenerNodo(fila, columna).setSuelo(suelo);
        } catch (ListaOrtogonalException ex) {
            System.out.println("No se pudo modificar la celda porque " + ex.getMessage());
        }
    }

    public void limpiarTerreno() {
        try {
            for (int i = 0; i < tablero.getFilas(); i++) {
                for (int j = 0; j < tablero.getColumnas(); j++) {
                    Suelo suelo = tablero.obtenerNodo(i, j).getSuelo();
                    if (suelo.estaSucio()) {
                        suelo.setEstaSucio(false);
                        suelo.setBloqueado(false);
                        if (suelo instanceof Grama grama) {
                            if (grama.tieneAnimales() == false || grama.tienePlanta() == false) {
                                grama.setEstaOpupado(false);
                            }
                        }
                        suelo.colocarImagen();
                    }
                }
            }
        } catch (ListaOrtogonalException e) {
            System.out.println("Hubo un error al limpiar el terreno porque " + e.getMessage());
        }
    }

    public void limpiarTerreno(int fila, int columna) {
        try {
            Suelo suelo = tablero.obtenerNodo(fila, columna).getSuelo();
            suelo.setEstaSucio(false);
            suelo.setBloqueado(false);
            if (suelo instanceof Grama grama) {
                if (grama.tieneAnimales() == false || grama.tienePlanta() == false) {
                    grama.setEstaOpupado(false);
                }
            }
            suelo.colocarImagen();
        } catch (ListaOrtogonalException e) {
            System.out.println("Hubo un error al limpiar la celda [" + fila + "," + columna + "] porque " + e.getMessage());
        }
    }

    // GETTERS -----------------------------------------------------------------
    public ListaOrtogonal getTablero() {
        return tablero;
    }
    // SETTERS -----------------------------------------------------------------
}
