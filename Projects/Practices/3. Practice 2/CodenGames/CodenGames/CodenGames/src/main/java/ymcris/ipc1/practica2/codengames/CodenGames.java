/*
 * Práctica entera en github (Manual de usuario, manual técnico, diagrama de clases, etc.)
 * https://github.com/YmCris/IPC-1-attempt-3
 */
package ymcris.ipc1.practica2.codengames;

import ymcris.ipc1.practica2.codengames.reportes.backend.Archivos;
import ymcris.ipc1.practica2.codengames.a.frontend.JFMenuPrincipal;

/**
 * Clase CodenGames es la clase encargada de dar inicio al programa llamando al
 * frame JFMenuPrincipal.
 *
 * @author YmCris
 * @see JFMenuPrincipal
 * @since Apr 3, 2025
 */
public class CodenGames {

    /**
     * Método main encargado de iniciar el programa
     *
     * @param args shortcuts del programa (no hay)
     */
    public static void main(String[] args) {
        Archivos.crearCarpetas();
        JFMenuPrincipal menu = new JFMenuPrincipal();
        menu.setVisible(true);
    }
}
