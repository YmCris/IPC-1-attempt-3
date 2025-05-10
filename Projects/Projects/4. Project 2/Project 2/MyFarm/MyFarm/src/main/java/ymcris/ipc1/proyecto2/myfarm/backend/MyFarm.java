package ymcris.ipc1.proyecto2.myfarm.backend;

import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios.ArchivosBinarios;
import ymcris.ipc1.proyecto2.myfarm.frontend.menu.JFMenuPrincipal;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Archivos;

/**
 *
 * @author YmCris
 */
public class MyFarm {

    public static void main(String[] args) {
        JFMenuPrincipal menu = new JFMenuPrincipal();
        Archivos archivosTxt = new Archivos();
        ArchivosBinarios binario = new ArchivosBinarios();
        binario.crearCarpetas();
        archivosTxt.crearCarpetas();
        CreadorDeItemsPredeterminados creador = new CreadorDeItemsPredeterminados();
        creador.crearFertilizantesPredeterminados();
        creador.creadorDeAlimentosPredeterminados();
        creador.creadorDeProductosPredeterminados();
        System.out.println("Se crean los productos");
        creador.creadorDeAnimalesPredeterminados();
        System.out.println("Se crean los animales");
        creador.creadorDeSemillasPredeterminadas();
        System.out.println("Se crean las semillas");
        menu.setVisible(true);
    }

}
