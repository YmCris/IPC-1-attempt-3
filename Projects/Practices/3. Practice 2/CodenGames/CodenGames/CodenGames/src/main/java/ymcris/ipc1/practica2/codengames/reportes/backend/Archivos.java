package ymcris.ipc1.practica2.codengames.reportes.backend;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * Clase Archivos es la clase encargada de almacenar los reportes en archivos
 * através de métodos de creación, lectura y escritura.
 *
 * @author YmCris
 * @since Apr 9, 2025
 */
public class Archivos {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    public static File carpetaHunter;
    public static File carpetaBuscaminasGanadas;
    public static File carpetaBuscaminasPerdidas;
    public static String nombreRutaCarpetaHunter;
    public static String nombreRutaCarpetaBuscaminasGanadas;
    public static String nombreRutaCarpetaBuscaminasPerdidas;
    public static final String NOMBRE_RUTA_PROYECTO = System.getProperty("user.dir");

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de crear carpetas en la ruta del proyecto
     */
    public static void crearCarpetas() {
        //1. Crear la carpeta donde se guardarán todos los reportes de hunter
        nombreRutaCarpetaHunter = NOMBRE_RUTA_PROYECTO + File.separator + "Hunter";
        carpetaHunter = new File(nombreRutaCarpetaHunter);
        carpetaHunter.mkdirs();
        //2. Crear la carpeta donde se guardarán todos los reportes de Buscaminas ganadas
        nombreRutaCarpetaBuscaminasGanadas = NOMBRE_RUTA_PROYECTO + File.separator + "BuscaminasG";
        carpetaBuscaminasGanadas = new File(nombreRutaCarpetaBuscaminasGanadas);
        carpetaBuscaminasGanadas.mkdirs();
        //3. Crear la carpeta donde se guardarán todos los reportes de Buscaminas perdidas
        nombreRutaCarpetaBuscaminasPerdidas = NOMBRE_RUTA_PROYECTO + File.separator + "BuscaminasP";
        carpetaBuscaminasPerdidas = new File(nombreRutaCarpetaBuscaminasPerdidas);
        carpetaBuscaminasPerdidas.mkdirs();
    }

    /**
     * Método encargado de obtener los archivos de texto de una carpeta
     *
     * @param rutaCarpeta - Ruta de donde se devolverán los archivos.
     * @return arreglo de archivos de texto.
     */
    public static File[] obtenerArchivosDeUnaCarpeta(String rutaCarpeta) {
        return new File(rutaCarpeta).listFiles();
    }

    /**
     * Métoo encargado de crear archivos.
     *
     * @param rutaCarpeta - ruta a donde se creará el archivo de texto
     * @param nombreArchivo - nombre del archivo de texto.
     * @return archivo creado
     */
    public static File crearArchivos(String rutaCarpeta, String nombreArchivo) {
        try {
            File file = new File(rutaCarpeta + File.separator + nombreArchivo + ".txt");
            file.createNewFile();
            return file;
        } catch (IOException e) {
            System.out.println("No se pudo crear el archivo");
            return null;
        }
    }

    /**
     * Método encargado de escribir en un archivo de texto
     *
     * @param file - Archivo en el cual se escribirá
     * @param texto - Texto que se añadirá
     */
    public static void escribirEnArchivo(File file, String texto) {
        try (FileWriter writer = new FileWriter(file,true)) {
            BufferedWriter escribir = new BufferedWriter(writer);
            escribir.write(texto);
            escribir.newLine();
            escribir.flush();
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el archivo: " + file.getName());
        }
    }

    /**
     * Método encargado de leer todas las líneas de todos los archivos de texto
     * en una carpeta.
     *
     * @param files - Arreglo de archivos de texto
     * @return Una cadena de texto con todo el contenido de la carpeta
     */
    public static String leerCarpetas(File[] files) {
        StringBuilder texto = new StringBuilder();
        for (File file : files) {//Recorre todos los archivos
            if (file != null) {//Seguridad
                try (FileReader reader = new FileReader(file)) {
                    BufferedReader leer = new BufferedReader(reader);
                    while (leer.read() != -1) {
                        texto.append(leer.readLine());//Agrega todo el contenido al String Builder
                        texto.append("\n");
                    }
                    texto.append("--------------------------------------------------------------\n");//Separa cada archivo
                } catch (IOException e) {
                    System.out.println("No se ha podido leer todo el texto del archivo: " + file.getName());
                }
            }
        }
        return texto.toString();
    }

}
