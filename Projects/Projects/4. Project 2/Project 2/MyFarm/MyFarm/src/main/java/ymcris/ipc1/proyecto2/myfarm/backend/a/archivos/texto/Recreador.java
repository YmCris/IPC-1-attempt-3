package ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto;

import java.io.File;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ArchivoException;

/**
 * Clase Recreador
 *
 * @author YmCris
 * @since May 7, 2025
 */
public class Recreador {

    // INSTANCIAS --------------------------------------------------------------
    private ArchivosDeTexto archivo = new ArchivosDeTexto();

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public Fertilizantes[] recrearFertilizantes() {
        try {
            int cantidadDeFertilizantes = archivo.numeroDeArchivosEnCarpeta(archivo.getRutaCarpetaFertilizantes());
            File[] archivos = archivo.obtenerArchivosDeCarpeta(archivo.getRutaCarpetaFertilizantes());
            Fertilizantes[] fertilizantes = new Fertilizantes[cantidadDeFertilizantes];
            for (int i = 0; i < cantidadDeFertilizantes; i++) {
                String nombre = archivo.leerArchivo(archivos[i], 0);
                int fertilidad = (int) Integer.parseInt(archivo.leerArchivo(archivos[i], 1));
                int precio = (int) Integer.parseInt(archivo.leerArchivo(archivos[i], 2));
                fertilizantes[i] = new Fertilizantes(nombre, fertilidad, precio);
            }
            return fertilizantes;
        } catch (NumberFormatException | ArchivoException e) {
            System.out.println("Ha habido un error al recrear los fertilizantes porque " + e.getMessage());
        }
        return null;
    }

    public Alimentos[] recrearAlimentos() {
        try {
            int cantidadDeAlimentos = archivo.numeroDeArchivosEnCarpeta(archivo.getRutaCarpetaAlimentos());
            File[] archivos = archivo.obtenerArchivosDeCarpeta(archivo.getRutaCarpetaAlimentos());
            Alimentos[] alimentos = new Alimentos[cantidadDeAlimentos];
            for (int i = 0; i < alimentos.length; i++) {
                String nombre = archivo.leerArchivo(archivos[i], 0);
                int precioDeVenta = Integer.parseInt(archivo.leerArchivo(archivos[i], 1));
                int precioDeCompra = Integer.parseInt(archivo.leerArchivo(archivos[i], 2));
                boolean esParaHerbivoros = Boolean.parseBoolean(archivo.leerArchivo(archivos[i], 3));
                alimentos[i] = new Alimentos(nombre, precioDeVenta, precioDeCompra, esParaHerbivoros);
            }
            return alimentos;
        } catch (NumberFormatException | ArchivoException e) {
            System.out.println("Ocurrió un eeror en la recreación de alimentos: " + e.getMessage());
        }
        return null;
    }

    public Semillas[] recreadorSemillas() {
        try {
            int cantidadDeSemillas = archivo.numeroDeArchivosEnCarpeta(archivo.getRutaCarpetaSemillas());
            File[] archivos = archivo.obtenerArchivosDeCarpeta(archivo.getRutaCarpetaSemillas());
            Semillas[] semillas = new Semillas[cantidadDeSemillas];
            for (int i = 0; i < semillas.length; i++) {
                String nombre = archivo.leerArchivo(archivos[i], 0);
                int precio = Integer.parseInt(archivo.leerArchivo(archivos[i], 1));
                boolean produceFruta = Boolean.parseBoolean(archivo.leerArchivo(archivos[i], 2));
                String nombreAlimento = archivo.leerArchivo(archivos[i], 3);
                semillas[i] = new Semillas(nombre, precio, produceFruta, nombreAlimento);
            }
            return semillas;
        } catch (NumberFormatException | ArchivoException e) {
            System.out.println("Hubo un error al recrear las semillas " + e.getMessage());
        }
        return null;
    }

}
