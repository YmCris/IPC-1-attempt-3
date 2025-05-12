package ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Productos;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.MateriasPrimas;

/**
 * Clase ArchivosBinarios es la clase encargada de guardar y obtener los datos
 * de los archivos binarios.
 *
 * @author YmCris
 * @since May 9, 2025
 */
public class ArchivosBinarios {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private final String rutaProyecto = System.getProperty("user.dir");
    private final String rutaCarpetaAnimales = rutaProyecto + File.separator + "Animales";
    private final String rutaCarpetaSemillas = rutaProyecto + File.separator + "Semillas";
    private final String rutaCarpetaAlimentos = rutaProyecto + File.separator + "Alimentos";
    private final String rutaCarpetaMateriaPrima = rutaProyecto + File.separator + "Materia Prima";

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Método encargado de crear las carpetas del programa.
     */
    public void crearCarpetas() {
        File carpetaAnimales = new File(rutaCarpetaAnimales);
        File carpetaSemillas = new File(rutaCarpetaSemillas);
        File carpetaMateria = new File(rutaCarpetaMateriaPrima);
        File carpetaProductos = new File(rutaCarpetaAlimentos);
        carpetaProductos.mkdirs();
        carpetaSemillas.mkdirs();
        carpetaMateria.mkdirs();
        carpetaAnimales.mkdirs();
    }

    /**
     * Método encargado de guardar un objeto en un archivo binario
     *
     * @param objeto Objeto a guardar en el archivo binario
     * @param rutaCarpeta carpeta donde se guardará el archivo
     * @param nombre nombre que tendrá el archivo binario (DEBERÍA SER EL NOMBRE
     * DEL OBJETO)
     */
    public void guardarObjeto(Object objeto, String rutaCarpeta, String nombre) {
        File file = new File(rutaCarpeta + File.separator + nombre + ".bin");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(objeto);
        } catch (IOException e) {
            System.out.println("No se pudo guardar el objeto porque " + e.getMessage());
        }
    }

    /**
     * Método encargado de obtener un objeto, no se debe poner .bin al archivo
     *
     * @param rutaCarpeta ruta donde se encuentra el archivo.
     * @param nombreArchivo nombre del objeto.
     * @return objeto para castear explicitamente
     */
    public Object obtenerObjeto(String rutaCarpeta, String nombreArchivo) {
        File file = new File(rutaCarpeta + File.separator + nombreArchivo + ".bin");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            System.out.println("No se pudo obtener el objeto porque " + e.getMessage());
            return null;
        }
    }

    /**
     * Método encargado de obtener todos los objetos de una carpeta
     *
     * @param rutaCarpeta ruta donde se encuentran los objetos a recuperar.
     * @return arreglo de objetos para castearlos manualmente.
     */
    public Object[] obtenerObjetos(String rutaCarpeta) {
        try {
            File carpeta = new File(rutaCarpeta);
            File[] archivos = carpeta.listFiles();
            Object[] objetos = new Object[archivos.length];
            for (int i = 0; i < objetos.length; i++) {
                objetos[i] = obtenerObjeto(rutaCarpeta, archivos[i].getName().substring(0, archivos[i].getName().length() - 4));
            }
            return objetos;
        } catch (Exception e) {
            System.out.println("Hubo un error al intentar obtener los objetos porque: " + e.getMessage());
            return null;
        }
    }

    /**
     * Método encargado de eliminar un archivo binario
     *
     * @param rutaCarpeta carpeta donde se encuentra el archivo
     * @param nombreArchivo nombre del archivo a eliminar
     */
    public void eliminarArchivo(String rutaCarpeta, String nombreArchivo) {
        File archivo = new File(rutaCarpeta + File.separator + nombreArchivo + ".bin");
        archivo.delete();
    }

    // ANIMALES ----------------------------------------------------------------
    /**
     * Método encargado de obtener el arreglo de todos los animales que se han
     * creado y guardado con el método guardarObjeto()
     *
     * @return arreglo de animales existentes
     */
    public Animales[] obtenerAnimales() {
        Object[] objetos = obtenerObjetos(rutaCarpetaAnimales);
        Animales[] animales = new Animales[objetos.length];
        for (int i = 0; i < animales.length; i++) {
            animales[i] = (Animales) objetos[i];
        }
        return animales;
    }

    /**
     * Método encargado de guardar objetos del tipo animal con el método
     * guardarObjeto()
     *
     * @param animal objeto animal a guardar en un archivo binario.
     */
    public void guardarAnimales(Animales animal) {
        guardarObjeto(animal, rutaCarpetaAnimales, animal.getNombre());
    }

    // SEMILLAS ----------------------------------------------------------------
    /**
     * Método encargado de obtener el arreglo de todas las semillas que se han
     * creado y guardado con el método guardarObjeto()
     *
     * @return arreglo de semillas existentes
     */
    public Semillas[] obtenerSemillas() {
        Object[] objetos = obtenerObjetos(rutaCarpetaSemillas);
        Semillas[] semillas = new Semillas[objetos.length];
        for (int i = 0; i < semillas.length; i++) {
            semillas[i] = (Semillas) objetos[i];
        }
        return semillas;
    }

    /**
     * Método encargado de guardar objetos del tipo semilla con el método
     * guardarObjeto()
     *
     * @param semilla objeto semilla a guardar en un archivo binario.
     */
    public void guardarSemillas(Semillas semilla) {
        guardarObjeto(semilla, rutaCarpetaSemillas, semilla.getNombre());
    }

    // ALIMENTOS ---------------------------------------------------------------
    /**
     * Método encargado de obtener el arreglo de todos los alimentos que se han
     * creado y guardado con el método guardarObjeto()
     *
     * @return arreglo de alimentos existentes
     */
    public Alimentos[] obtenerAlimentos() {
        Object[] objetos = obtenerObjetos(rutaCarpetaAlimentos);
        Alimentos[] alimentos = new Alimentos[objetos.length];
        for (int i = 0; i < alimentos.length; i++) {
            alimentos[i] = (Alimentos) objetos[i];
        }
        return alimentos;
    }

    /**
     * Método encargado de guardar objetos del tipo alimento con el método
     * guardarObjeto()
     *
     * @param alimento objeto alimento a guardar en un archivo binario.
     */
    public void guardarAlimento(Alimentos alimento) {
        guardarObjeto(alimento, rutaCarpetaAlimentos, alimento.getNombre());
    }

    // MATERIA PRIMA -----------------------------------------------------------
    /**
     * Método encargado de obtener el arreglo de todas las materias primas que
     * se han creado y guardado con el método guardarObjeto()
     *
     * @return arreglo de materias primas existentes
     */
    public MateriasPrimas[] obtenerMaterias() {
        Object[] objetos = obtenerObjetos(rutaCarpetaMateriaPrima);
        MateriasPrimas[] materias = new MateriasPrimas[objetos.length];
        for (int i = 0; i < materias.length; i++) {
            materias[i] = (MateriasPrimas) objetos[i];
        }
        return materias;
    }

    /**
     * Método encargado de guardar objetos del tipo materia prima con el método
     * guardarObjeto()
     *
     * @param materia objeto materia prima a guardar en un archivo binario.
     */
    public void guardarMaterias(MateriasPrimas materia) {
        guardarObjeto(materia, rutaCarpetaMateriaPrima, materia.getNombre());
    }

    /**
     * Método encargado de editar un animal obteniendo el animal, modificando la
     * instancia, eliminando el archivo existente y luego recreando el archivo
     * pero ahora con la nueva instancia de animal.
     *
     * @param animal animal a modificar.
     * @param materia producto a agregar.
     * @param porcentajeDeProduccion
     * @return un chingo de mensajes porque es necesario comunicarle al frontend
     * que chingados pasó.
     */
    public String editarAnimalMateriaPrima(Animales animal, MateriasPrimas materia, int porcentajeDeProduccion) {
        Animales nuevoAnimal = animal;
        if ((nuevoAnimal.getPorcentajeDeProduccionMateriaPrima() + porcentajeDeProduccion) <= 100) {
            nuevoAnimal.getMateriasPrimas().agregar(materia, materia.getNombre());
            nuevoAnimal.setPorcentajeDeProduccionMateriaPrima(nuevoAnimal.getPorcentajeDeProduccionMateriaPrima() + porcentajeDeProduccion);
            eliminarArchivo(rutaCarpetaAnimales, nuevoAnimal.getNombre());
            guardarAnimales(nuevoAnimal);
            return "Se ha agregado el producto " + materia.getNombre() + " al animal " + nuevoAnimal.getNombre() + " ahora tiene un porcentaje de producción con destace del " + nuevoAnimal.getPorcentajeDeProduccionMateriaPrima();
        }
        return "No puedes agregarle ese alimento que se obtiene al destazar el animal, porque sobrepasa el límite";
    }

    public String editarAnimalAlimentos(Animales animal, Alimentos alimento, int porcentajeDeProduccion) {
        Animales nuevoAnimal = animal;
        if ((nuevoAnimal.getPorcentajeDeProduccionAlimentos() + porcentajeDeProduccion) <= 100) {
            nuevoAnimal.getAlimentos().agregar(alimento, alimento.getNombre());
            nuevoAnimal.setPorcentajeDeProduccionAlimentos(nuevoAnimal.getPorcentajeDeProduccionAlimentos() + porcentajeDeProduccion);
            eliminarArchivo(rutaCarpetaAnimales, nuevoAnimal.getNombre());
            guardarAnimales(nuevoAnimal);
            return "Se ha agregado el producto " + alimento.getNombre() + " al animal " + nuevoAnimal.getNombre() + " ahora tiene un porcentaje de producción sin destace del " + nuevoAnimal.getPorcentajeDeProduccionAlimentos();
        }
        return "No puedes agregarle ese alimento que se obtiene al destazar el animal, porque sobrepasa el límite";
    }

    // GETTERS -----------------------------------------------------------------
    public String getRutaProyecto() {
        return rutaProyecto;
    }

    public String getRutaCarpetaAnimales() {
        return rutaCarpetaAnimales;
    }

    public String getRutaCarpetaSemillas() {
        return rutaCarpetaSemillas;
    }

    public String getRutaCarpetaAlimentos() {
        return rutaCarpetaAlimentos;
    }

    public String getRutaCarpetaMateriaPrima() {
        return rutaCarpetaMateriaPrima;
    }

}
