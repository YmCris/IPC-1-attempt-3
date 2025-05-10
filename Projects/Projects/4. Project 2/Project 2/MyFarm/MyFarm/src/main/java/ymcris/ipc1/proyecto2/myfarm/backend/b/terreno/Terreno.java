package ymcris.ipc1.proyecto2.myfarm.backend.b.terreno;

import java.util.Random;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Agua;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Grama;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Suelo;
import ymcris.ipc1.proyecto2.myfarm.backend.c.suelos.Desierto;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.ortogonal.NodoOrtogonal;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.ortogonal.ListaOrtogonal;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaOrtogonalException;

/**
 * Clase Terreno
 *
 * @author YmCris
 * @since Apr 27, 2025
 */
public final class Terreno {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private NodoOrtogonal[] suelosPredeterminados = new NodoOrtogonal[25];

    // CONSTANTES --------------------------------------------------------------
    private static final int PRECIO_LIMPIEZA = 15;
    private static final int DISTRIBUCION_DESIERTO = 25;
    private static final int DISTRIBUCION_GRAMA = 40;

    // INSTANCIAS --------------------------------------------------------------
    ListaOrtogonal tablero = new ListaOrtogonal();
    Random random = new Random();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Terreno() {
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
            return new Grama();
        }
    }

    public void generarTerreno() {

    }

    public void crearParcela() {

    }

    public void eliminarParcela() {

    }

    public void modificarCelda(int fila, int columna, Suelo suelo) {
        try {
            tablero.obtenerNodo(fila, columna).setSuelo(suelo);
        } catch (ListaOrtogonalException ex) {
            System.out.println("No se pudo modificar la celda porque " + ex.getMessage());
        }
    }
    // GETTERS -----------------------------------------------------------------

    // SETTERS -----------------------------------------------------------------
    public ListaOrtogonal getTablero() {
        return tablero;
    }
}
