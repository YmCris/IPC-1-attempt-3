package ymcris.ipc1.practica2.codengames.a.frontend;

import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 * Clase JPanelPersonalizado crea un panel personalizado para poder ponerle una
 * imagen
 *
 * @author YmCris
 * @since Apr 3, 2025
 */
public class JPanelPersonalizado extends JLabel {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private final String path;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int alto;
    private int ancho;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método constructor encargado de inicializar los atributos para modificar
     *
     * @param panel - Panel en el cual se va a mostrar el JLabel
     * @param path - Ruta donde se encuentra la imagen a colocar
     */
    public JPanelPersonalizado(JPanel panel, String path) {
        this.path = path;
        this.ancho = panel.getWidth();
        this.alto = panel.getHeight();
        this.setSize(ancho, alto);
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public void paint(Graphics grafico) {//"Pinta" la imagen al panel, no la agrega
        super.paint(grafico);
        ImageIcon imagen = new ImageIcon(getClass().getResource(path));
        grafico.drawImage(imagen.getImage(), 0, 0, ancho, alto, null);
    }
}
