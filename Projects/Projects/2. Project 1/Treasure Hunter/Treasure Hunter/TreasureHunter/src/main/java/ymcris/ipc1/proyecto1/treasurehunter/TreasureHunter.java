package ymcris.ipc1.proyecto1.treasurehunter;

import ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus;

/**
 * Clase Main, encargada de dar inicio al programa.
 *
 * @since 03/09/2025
 * @author YmCris
 */
public class TreasureHunter {

    /**
     * Método main encargado de iniciar el programa.
     *
     * @param args - paramétros para iniciar directamente en el jar
     */
    public static void main(String[] args) {
        new TreasureHunter().mostrarMenuPrincipal();
    }

    private void mostrarMenuPrincipal() {
        new DiseñoMenus().mostrarBienvenida();
    }
}
