package ymcris.ipc1.proyecto2.myfarm.backend;

import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.ArchivosDeTexto;
import ymcris.ipc1.proyecto2.myfarm.frontend.menu.JFMenuPrincipal;

/**
 *
 * @author YmCris
 */
public class MyFarm {

    public static void main(String[] args) {
        JFMenuPrincipal menu = new JFMenuPrincipal();
        ArchivosDeTexto archivosTxt = new ArchivosDeTexto();
        archivosTxt.crearCarpetas();
        menu.setVisible(true);
    }
}
