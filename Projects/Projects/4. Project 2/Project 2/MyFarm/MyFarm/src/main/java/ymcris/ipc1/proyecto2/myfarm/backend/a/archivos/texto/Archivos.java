package ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ArchivoException;

/**
 * Clase Archivos clase encargada de crear archivos de texto y las carpetas
 * correspondientes para almacenar los elementos del mercado in cambiables,
 * porque de ser cambiables resultaria muy dificil, por ello esta la clase
 * archivosBinarios.
 *
 * @author YmCris
 * @see ArchivoException
 * @since May 3, 2025
 */
public class Archivos {

    // VARIABLES DE REFERNCIA --------------------------------------------------
    private final String rutaProyecto = System.getProperty("user.dir");
    private final String rutaCarpetaFertilizantes = rutaProyecto + File.separator + "Fertilizantes";
    private final String rutaCarpetaAlimentosAnimales = rutaProyecto + File.separator + "Alimentos para animales";

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de crear las carpetas de los elemntos incambiables.
     */
    public void crearCarpetas() {
        File carpetaFertilizantes = new File(rutaCarpetaFertilizantes);
        File carpetaAlimentosAnimales = new File(rutaCarpetaAlimentosAnimales);
        carpetaAlimentosAnimales.mkdirs();
        carpetaFertilizantes.mkdirs();
    }

    /**
     * Método encargado de obtener el número de archivos que existen en una
     * carpeta.
     *
     * @param rutaCarpeta carpeta a conocer la cantidad de archivos.
     * @return número de archivos que hay en la carpeta.
     */
    public int numeroDeArchivosEnCarpeta(String rutaCarpeta) {
        File file = new File(rutaCarpeta);
        return file.listFiles().length;
    }

    /**
     * Método encargado de crear un nuevo archivo de texto.
     *
     * @param rutaCarpeta carpeta donde se creará
     * @param nombreArchivo nombre que tendrá el archivo.
     * @return archivo de texto creado.
     * @throws ArchivoException si falla en la creación
     */
    public File crearArchivoDeTexto(String rutaCarpeta, String nombreArchivo) throws ArchivoException {
        File file = new File(rutaCarpeta + File.separator + nombreArchivo + ".txt");
        if (!existeArchivo(rutaCarpeta, nombreArchivo)) {
            try {
                file.createNewFile();
                return file;
            } catch (IOException e) {
                System.out.println("No se pudo crear el archivo, motivo: " + e.getMessage());
            }
        }
        throw new ArchivoException("Ya existe un archivo con ese nombre en la carpeta: " + rutaCarpeta);
    }

    /**
     * Método encargado de obtener los archivos X que hay en una carpeta.
     *
     * @param rutaCarpeta carpeta de donde se encontrarán los archivos.
     * @return arreglo de archivos X
     * @throws ArchivoException si no hay archivos en carpeta o no se puede
     */
    public File[] obtenerArchivosDeCarpeta(String rutaCarpeta) throws ArchivoException {
        File file = new File(rutaCarpeta);
        if (file.listFiles() != null) {
            return file.listFiles();
        }
        throw new ArchivoException("No existen archivos en la carpeta");
    }

    /**
     * Método encargado de obtener un archivo de texto en una carpeta
     *
     * @param rutaCarpeta carpeta donde se ubica el archivo
     * @param nombre nombre del archivo
     * @return archivo buscado.
     */
    public File obtenerArchivoDeCarpeta(String rutaCarpeta, String nombre) {
        File[] files;
        try {
            files = obtenerArchivosDeCarpeta(rutaCarpeta);
            for (File file : files) {
                if (file.getName().toLowerCase().equals(nombre.toLowerCase() + ".txt")) {
                    return file;
                }
            }
        } catch (ArchivoException ex) {
            System.out.println("No se pudo obtener el archivo: " + nombre + " de la carpeta " + rutaCarpeta + "porque " + ex.getMessage());
        }
        System.out.println("No se ha podido obtener el archivo de la carpeta");
        return null;
    }

    /**
     * Método encargado de escribir un string en un archivo de texto
     *
     * @param archivo archivo donde se escribirá
     * @param contenido contenido a agregar en el archivo de texto
     */
    public void escribirEnArchivoDeTexto(File archivo, String contenido) {
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo, true))) {
            escribir.write(contenido);
            escribir.newLine();
        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el archivo " + archivo.getName() + ", porque " + e.getMessage());
        }
    }

    /**
     * Método encargado de verificar si existe un archivo X en una carpeta NO SE
     * VERIFICA LA EXTENSIÓN.
     *
     * @param rutaCarpeta carpeta donde se verificará el archivo
     * @param nombreArchivo archivo a verificar
     * @return
     */
    public boolean existeArchivo(String rutaCarpeta, String nombreArchivo) {
        File carpeta = new File(rutaCarpeta);
        File[] archivosTxt = carpeta.listFiles();
        if (archivosTxt != null) {
            for (File archivo : archivosTxt) {
                if (archivo.getName().toLowerCase().equals(nombreArchivo.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método encargado de leer un archivo de texto en base a una linea
     *
     * @param archivo archivo sobre el cual se va a leer
     * @param linea linea en la cual sabemos que está la información que
     * queremos.
     * @return linea dentro del archivo
     * @throws ArchivoException si no existe la línea en el archivo.
     */
    public String leerArchivoDeTexto(File archivo, int linea) throws ArchivoException {
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
    public String getRutaCarpetaFertilizantes() {
        return rutaCarpetaFertilizantes;
    }

    public String getRutaCarpetaAlimentosAnimales() {
        return rutaCarpetaAlimentosAnimales;
    }

}
