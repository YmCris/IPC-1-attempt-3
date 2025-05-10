package ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto;

import java.io.File;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ArchivoException;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios.ArchivosBinarios;

/**
 * Clase Recreador
 *
 * @author YmCris
 * @see ArchivosBinarios
 * @since May 7, 2025
 */
public class Recreador {

    // INSTANCIAS --------------------------------------------------------------
    private Archivos archivo = new Archivos();
    private ArchivosBinarios binario = new ArchivosBinarios();

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encarado de leer los fertilizantes guardados y retornarlos para el
     * mercado
     *
     * @return arreglo de fertilizantes.
     */
    public Fertilizantes[] obtenerFertilizantesExistentes() {
        try {
            int cantidadDeFertilizantes = archivo.numeroDeArchivosEnCarpeta(archivo.getRutaCarpetaFertilizantes());
            File[] archivos = archivo.obtenerArchivosDeCarpeta(archivo.getRutaCarpetaFertilizantes());
            Fertilizantes[] fertilizantes = new Fertilizantes[cantidadDeFertilizantes];
            for (int i = 0; i < cantidadDeFertilizantes; i++) {
                String nombre = archivo.leerArchivoDeTexto(archivos[i], 0);
                int fertilidad = (int) Integer.parseInt(archivo.leerArchivoDeTexto(archivos[i], 1));
                int precio = (int) Integer.parseInt(archivo.leerArchivoDeTexto(archivos[i], 2));
                fertilizantes[i] = new Fertilizantes(nombre, fertilidad, precio);
            }
            return fertilizantes;
        } catch (NumberFormatException | ArchivoException e) {
            System.out.println("Ha habido un error al recrear los fertilizantes porque " + e.getMessage());
        }
        return null;
    }

    /**
     * Mëtodo encargado de recrear los alimentos predefinidos para los animales.
     *
     * @return alimentos para animales.
     */
    public Alimentos[] obtenerAlimentosParaAnimalesExistentes() {
        try {
            int cantidadDeAlimentos = archivo.numeroDeArchivosEnCarpeta(archivo.getRutaCarpetaAlimentosAnimales());
            File[] archivos = archivo.obtenerArchivosDeCarpeta(archivo.getRutaCarpetaAlimentosAnimales());
            Alimentos[] alimentos = new Alimentos[cantidadDeAlimentos];
            for (int i = 0; i < alimentos.length; i++) {
                String nombre = archivo.leerArchivoDeTexto(archivos[i], 0);
                int precioDeVenta = Integer.parseInt(archivo.leerArchivoDeTexto(archivos[i], 1));
                int precioDeCompra = Integer.parseInt(archivo.leerArchivoDeTexto(archivos[i], 2));
                boolean esParaHerbivoros = Boolean.parseBoolean(archivo.leerArchivoDeTexto(archivos[i], 3));
                alimentos[i] = new Alimentos(nombre, precioDeVenta, precioDeCompra, esParaHerbivoros);
            }
            return alimentos;
        } catch (NumberFormatException | ArchivoException e) {
            System.out.println("Ocurrió un eeror en la recreación de alimentos: " + e.getMessage());
        }
        return null;
    }

    /**
     * Método encargado de recrear las semillas que se han creado.
     *
     * @return arreglo de todas las semillas creadas.
     */
    public Semillas[] obtenerSemillasExistentes() {
        return binario.obtenerSemillas();
    }

    /**
     * Método encargado de recrear los animales que se han agregado al programa.
     *
     * @return arreglo de todos los animales creados.
     */
    public Animales[] obtenerAnimalesExistentes() {
        return binario.obtenerAnimales();
    }

}
