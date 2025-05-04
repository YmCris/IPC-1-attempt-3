package ymcris.ipc1.proyecto2.myfarm.backend.c.suelos;

import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;

/**
 * Clase Desierto es la clase encargada de representar las celdas de decierto,
 * no hacen nadota
 *
 * @author YmCris
 * @since Apr 26, 2025
 */
public class Desierto extends Suelo {

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Desierto(Granjero granjero, int precio, int distribucion, boolean estaSucio) {
        super(granjero, precio, distribucion, estaSucio);
    }

}
