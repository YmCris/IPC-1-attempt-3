/**
 * Paquete donde se orienta al usuario sobre el videojuego
 */
package ymcris.ipc1.proyecto1.treasurehunter.ayuda;

import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.ROJO;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

/**
 * Clase AcercaDe es la clase encargada de mostrar los creditos, algo
 * innecesario? si jaja
 *
 * @author YmCris
 * @since Mar 21, 2025
 */
public class AcercaDe {

    // ----------------------------- MÉTODOS -----------------------------------
    /**
     * Método encargado de mostrar los creditos del juego
     */
    public static void mostrarCreditos() {
        System.out.println(ROJO + "Creditos: Cristian Sanic :)" + RESETEAR);
    }

}
