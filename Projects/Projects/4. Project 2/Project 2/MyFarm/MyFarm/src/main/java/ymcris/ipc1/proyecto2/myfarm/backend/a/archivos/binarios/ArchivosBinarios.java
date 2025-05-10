package ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
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
    private final String rutaCarpetaMateriaPrima = rutaProyecto + File.separator + "Materia";

    // MÉTODOS CONCRETOS -------------------------------------------------------
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

    public Object obtenerObjeto(String rutaCarpeta, String nombreArchivo) {
        File file = new File(rutaCarpeta + File.separator + nombreArchivo + ".bin");
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            System.out.println("No se pudo obtener el objeto porque " + e.getMessage());
            return null;
        }
    }

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

    public void guardarObjeto(Object objeto, String rutaCarpeta, String nombre) {
        File file = new File(rutaCarpeta + File.separator + nombre + ".bin");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(objeto);
        } catch (IOException e) {
            System.out.println("No se pudo guardar el objeto porque " + e.getMessage());
        }
    }

    // ANIMALES ----------------------------------------------------------------
    public Animales[] obtenerAnimales() {
        System.out.println("Se obtiene el arreglo de todos los animales");
        Object[] objetos = obtenerObjetos(rutaCarpetaAnimales);
        Animales[] animales = new Animales[objetos.length];
        for (int i = 0; i < animales.length; i++) {
            animales[i] = (Animales) objetos[i];
        }
        return animales;
    }

    public void guardarAnimales(Animales animal) {
        guardarObjeto(animal, rutaCarpetaAnimales, animal.getNombre());
        System.out.println("Se ha guardado el animal " + animal.getNombre());
    }

    // SEMILLAS ----------------------------------------------------------------
    public Semillas[] obtenerSemillas() {
        System.out.println("Se obtiene el arreglo de todas las semillas");
        Object[] objetos = obtenerObjetos(rutaCarpetaSemillas);
        Semillas[] semillas = new Semillas[objetos.length];
        for (int i = 0; i < semillas.length; i++) {
            semillas[i] = (Semillas) objetos[i];
        }
        return semillas;
    }

    public void guardarSemillas(Semillas semilla) {
        guardarObjeto(semilla, rutaCarpetaSemillas, semilla.getNombre());
        System.out.println("Se ha guardado la semilla " + semilla.getNombre());
    }

    // ALIMENTOS ---------------------------------------------------------------
    public Alimentos[] obtenerAlimentos() {
        System.out.println("Se obtiene el arreglo de todos los alimentos");
        Object[] objetos = obtenerObjetos(rutaCarpetaAlimentos);
        Alimentos[] alimentos = new Alimentos[objetos.length];
        for (int i = 0; i < alimentos.length; i++) {
            alimentos[i] = (Alimentos) objetos[i];
        }
        return alimentos;
    }

    public void guardarAlimento(Alimentos alimento) {
        guardarObjeto(alimento, rutaCarpetaAlimentos, alimento.getNombre());
        System.out.println("Se ha guardado el alimento " + alimento.getNombre());
    }

    // MATERIA PRIMA -----------------------------------------------------------
    public MateriasPrimas[] obtenerMaterias() {
        System.out.println("Se obtiene el arreglo de todas las materias");
        Object[] objetos = obtenerObjetos(rutaCarpetaMateriaPrima);
        MateriasPrimas[] materias = new MateriasPrimas[objetos.length];
        for (int i = 0; i < materias.length; i++) {
            materias[i] = (MateriasPrimas) objetos[i];
        }
        return materias;
    }

    public void guardarMaterias(MateriasPrimas materia) {
        guardarObjeto(materia, rutaCarpetaMateriaPrima, materia.getNombre());
        System.out.println("Se ha guardado la materia " + materia.getNombre());
    }

    // GETTERS -----------------------------------------------------------------
    public String getRutaCarpetaAnimales() {
        return rutaCarpetaAnimales;
    }

    public String getRutaProyecto() {
        return rutaProyecto;
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
