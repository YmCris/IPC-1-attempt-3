/*
 * Práctica entera en github (Manual de usuario, manual técnico, diagrama de clases, etc.)
 * https://github.com/YmCris/IPC-1-attempt-3
 */
package ymcris.ipc1.practica2.codengames;

import ymcris.ipc1.practica2.codengames.a.frontend.MenuPrincipal;

/**
 * Clase CodenGames es la clase encargada de dar inicio al programa
 *
 * @author YmCris
 * @since Apr 3, 2025
 */
public class CodenGames {

    /**
     * Método main encargado de iniciar el programa
     *
     * @param args shortcuts del programa (no hay)
     */
    public static void main(String[] args) {
        System.out.println("Hola Tilín");
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
    }
}
