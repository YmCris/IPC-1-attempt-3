package ymcris.ipc1.proyecto2.myfarm.backend.c.plantas;

import java.io.File;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.ArchivosDeTexto;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ArchivoException;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;

/**
 * Clase Semillas es la clase encargada de crear semillas
 *
 * @author YmCris
 * @since May 4, 2025
 */
public class Semillas {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nombre;
    private Alimentos alimento;
    private String nombreAlimento;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int precio;
    private int cantidad;
    private boolean produceFruta;

    // INSTANCIAS --------------------------------------------------------------
    ArchivosDeTexto archivo = new ArchivosDeTexto();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Semillas(String nombre, int precio, boolean produceFruta, String nombreAlimento) {
        this.nombre = nombre;
        this.precio = precio;
        this.produceFruta = produceFruta;
        this.nombreAlimento = nombreAlimento;
        this.alimento = agregarAlimento(nombreAlimento);
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    private Alimentos agregarAlimento(String nombreAlimento) {
        File alimentoArchivo = archivo.obtenerArchivoDeCarpeta(archivo.getRutaCarpetaAlimentos(), nombreAlimento);
        try {
            String alimentoNombre = archivo.leerArchivo(alimentoArchivo, 0);
            int precioVenta = Integer.parseInt(archivo.leerArchivo(alimentoArchivo, 1));
            int precioCompra = Integer.parseInt(archivo.leerArchivo(alimentoArchivo, 2));
            boolean esParaHerbivoros = Boolean.parseBoolean(archivo.leerArchivo(alimentoArchivo, 3));
            Alimentos alimentoDeArchivo = new Alimentos(alimentoNombre, precioVenta, precioCompra, esParaHerbivoros);
            return alimentoDeArchivo;
        } catch (ArchivoException ex) {
            System.out.println("Hubo un error al agregar el alimento a la semilla, porque " + ex.getMessage());
        }
        return null;
    }

    // GETTERS -----------------------------------------------------------------
    public int getCantidad() {
        return cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isProduceFruta() {
        return produceFruta;
    }

    public Alimentos getAlimento() {
        return alimento;
    }

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    // SETTERS -----------------------------------------------------------------
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
