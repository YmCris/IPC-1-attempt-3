package ymcris.ipc1.proyecto2.myfarm.backend;

import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Creador;
import ymcris.ipc1.proyecto2.myfarm.frontend.menu.JFMenuPrincipal;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.texto.Archivos;
import ymcris.ipc1.proyecto2.myfarm.backend.a.archivos.binarios.ArchivosBinarios;

/**
 * Clase MyFarm es la clase Main encargada de iniciar el programa creando las
 * carpetas y agregando los fertilizantes y almentos para animales
 * inmodificables al inicio del juego.
 *
 * @author YmCris
 */
public class MyFarm {

    /**
     * Método encargado de iniciar el programa
     *
     * @param args argumentos para iniciar algun proceso en especifico.
     */
    public static void main(String[] args) {
        Archivos archivosTxt = new Archivos();
        ArchivosBinarios binario = new ArchivosBinarios();
        binario.crearCarpetas();
        archivosTxt.crearCarpetas();
        Creador creador = new Creador();
        creador.crearFertilizantesPredeterminados();
        creador.crearAlimentosParaAnimalesPredeterminados();
        JFMenuPrincipal menu = new JFMenuPrincipal(creador);
        menu.setVisible(true);
    }

}
