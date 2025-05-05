package ymcris.ipc1.proyecto2.myfarm.backend.c.productos;

/**
 * Clase MateriaPrima 
 *
 * @author YmCris
 * @since May 4, 2025
 */
public class MateriaPrima extends Productos{
    
    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public MateriaPrima(String nombre, int porcentajeDeproduccion) {//La materia prima se obtiene al destazar animales, es decir cuero, carne, etc
        super(nombre, porcentajeDeproduccion, true,true);
    }
    


}
