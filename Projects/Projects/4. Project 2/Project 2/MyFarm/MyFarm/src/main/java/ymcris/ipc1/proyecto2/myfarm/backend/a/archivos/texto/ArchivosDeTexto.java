package ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ArchivoException;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;

/**
 * Clase ArchivosDeTexto clase encargada de crear archivos de texto y las
 * carpetas correspondientes, esto es para utilizar en los creadores de plantas,
 * animales y productos, no en el guardado de partida
 *
 * @author YmCris
 * @since May 3, 2025
 */
public class ArchivosDeTexto {

    // CONSTANTES --------------------------------------------------------------
    private final String rutaProyecto = System.getProperty("user.dir");
    private final String rutaCarpetaPlantas = rutaProyecto + File.separator + "Plantas";
    private final String rutaCarpetaAnimales = rutaProyecto + File.separator + "Animales";
    private final String rutaCarpetaAlimentos = rutaProyecto + File.separator + "Alimentos";
    private final String rutaCarpetaMateriaPrima = rutaProyecto + File.separator + "Materia";
    private final String rutaCarpetaFertilizantes = rutaProyecto + File.separator + "Fertilizantes";

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public void crearCarpetas() {
        File carpetaPlantas = new File(rutaCarpetaPlantas);
        File carpetaAnimales = new File(rutaCarpetaAnimales);
        File carpetaProductos = new File(rutaCarpetaAlimentos);
        File carpetaMateria = new File(rutaCarpetaMateriaPrima);
        File carpetaFertilizantes = new File(rutaCarpetaFertilizantes);
        carpetaPlantas.mkdirs();
        carpetaAnimales.mkdirs();
        carpetaProductos.mkdirs();
        carpetaMateria.mkdirs();
        carpetaFertilizantes.mkdirs();
    }

    public int numeroDeArchivosEnCarpeta(String rutaCarpeta) {
        File file = new File(rutaCarpeta);
        return file.listFiles().length;
    }

    public File crearArchivo(String rutaCarpeta, String nombreArchivo) throws ArchivoException {
        File file = new File(rutaCarpeta + File.separator + nombreArchivo + ".txt");
        if (!existeArchivo(rutaCarpeta, nombreArchivo)) {
            try {
                file.createNewFile();
                return file;
            } catch (IOException e) {
                System.out.println("No se pudo crear el archivo, motivo: " + e.getMessage());
            }
        } else {
            throw new ArchivoException("Ya existe un archivo con ese nombre en la carpeta: " + rutaCarpeta);
        }
        return null;
    }

    public File[] obtenerArchivosDeCarpeta(String rutaCarpeta) throws ArchivoException {
        File file = new File(rutaCarpeta);
        if (file.listFiles() != null) {
            return file.listFiles();
        }
        throw new ArchivoException("No existen archivos en la carpeta");
    }

    public File obtenerArchivoDeCarpeta(String rutaCarpeta, String nombre) {
        File[] files;
        try {
            files = obtenerArchivosDeCarpeta(rutaCarpeta);
            for (File file : files) {
                if (file.getName().toLowerCase().equals(nombre.toLowerCase())) {
                    return file;
                }
            }
        } catch (ArchivoException ex) {
            System.out.println("No se pudo obtener el archivo: " + nombre + " de la carpeta " + rutaCarpeta + "porque " + ex.getMessage());
        }
        return null;
    }

    public void escribirEnArchivo(File archivo, String contenido) {
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo, true))) {
            escribir.write(contenido);
            escribir.newLine();
        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el archivo " + archivo.getName() + ", porque " + e.getMessage());
        }
    }

    // FUNCIONES ---------------------------------------------------------------
    public boolean existeArchivo(String rutaCarpeta, String nombreArchivo) {
        File carpeta = new File(rutaCarpeta);
        File[] archivosTxt = carpeta.listFiles();
        if (archivosTxt != null) {
            for (File archivo : archivosTxt) {
                if (archivo.getName().toLowerCase().equals(nombreArchivo.toLowerCase())) {//Todo lo guardaré en minusculas, pero por si acaso
                    return true;
                }
            }
        }
        return false;
    }

    public String leerArchivo(File archivo, int linea) throws ArchivoException {
        try (BufferedReader leer = new BufferedReader(new FileReader(archivo))) {
            int contador = 0;
            String temp;
            while ((temp = leer.readLine()) != null) {
                if (contador == linea) {
                    return temp;
                }
                contador++;
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer en el archivo " + archivo.getName() + ", porque " + e.getMessage());
        }
        throw new ArchivoException("No existe la línea " + linea + " en el archivo " + archivo.getName());
    }

    // GETTERS -----------------------------------------------------------------
    public String getRutaProyecto() {
        return rutaProyecto;
    }

    public String getRutaCarpetaPlantas() {
        return rutaCarpetaPlantas;
    }

    public String getRutaCarpetaAnimales() {
        return rutaCarpetaAnimales;
    }

    public String getRutaCarpetaAlimentos() {
        return rutaCarpetaAlimentos;
    }

    public String getRutaCarpetaMateriaPrima() {
        return rutaCarpetaMateriaPrima;
    }

    public String getRutaCarpetaFertilizantes() {
        return rutaCarpetaFertilizantes;
    }

}
