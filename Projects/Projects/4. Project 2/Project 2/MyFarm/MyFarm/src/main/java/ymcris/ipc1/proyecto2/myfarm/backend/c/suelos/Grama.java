package ymcris.ipc1.proyecto2.myfarm.backend.c.suelos;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import ymcris.ipc1.proyecto2.myfarm.backend.a.cola.Cola;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Grano;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Frutas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.plantas.Semillas;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Animales;
import ymcris.ipc1.proyecto2.myfarm.backend.b.granjero.Granjero;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.a.interfaces.Siembrable;
import ymcris.ipc1.proyecto2.myfarm.backend.a.interfaces.Finquerable;
import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble.ListaDoble;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Herbivoros;
import ymcris.ipc1.proyecto2.myfarm.backend.c.animales.Omnivoros;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Fertilizantes;

/**
 * Clase Grama es la clase hija de Suelo encargada de representar la grama
 * dentro del terreno
 *
 * @author YmCris
 * @since Apr 26, 2025
 */
public class Grama extends Suelo implements Siembrable, Finquerable {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private Grano grano;
    private Frutas fruta;
    private Granjero granjero;
    private String animalesPermitidos;
    private Animales animalCriado;
    private ListaDoble<Animales> animales;
    private Cola<Integer> ordenDeProduccionCelda;
    private Cola<Alimentos> ordenDeProduccionAlimentos;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int fertilidad;
    private boolean esParcela;
    private boolean estaOpupado;
    private boolean tienePlanta;
    private boolean tieneAnimales;

    // CONSTANTES --------------------------------------------------------------
    private static final String NOMBRE_SUELO = "Grama";
    private static final String RUTA_IMAGEN = "/grama.png";
    private static final String NOMBRE_IMAGEN_SEMILLA_INICIO = "/siembraInicio.png";
    private static final String NOMBRE_IMAGEN_SEMILLA_FIN = "/siembraFin.png";

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Grama(Cola<Integer> ordenDeProduccionCelda, Cola<Alimentos> ordenDeProduccionAlimentos, Granjero granjero) {
        this.granjero = granjero;
        this.fertilidad = 0;
        this.animales = new ListaDoble<>();
        this.ordenDeProduccionCelda = ordenDeProduccionCelda;
        this.ordenDeProduccionAlimentos = ordenDeProduccionAlimentos;
        this.esParcela = false;
        this.estaOpupado = false;
        this.nombre = NOMBRE_SUELO;
        this.rutaImagen = RUTA_IMAGEN;
        this.tienePlanta = false;
        colocarImagen();
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    public void agregarImagenSemillaInicio() {
        ImageIcon icon = new ImageIcon(getClass().getResource(NOMBRE_IMAGEN_SEMILLA_INICIO));
        int ancho = this.getWidth();
        int alto = this.getHeight();
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        this.setIcon(icono);
    }

    public void agregarImagenSemillaFin() {
        ImageIcon icon = new ImageIcon(getClass().getResource(NOMBRE_IMAGEN_SEMILLA_FIN));
        int ancho = this.getWidth();
        int alto = this.getHeight();
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        this.setIcon(icono);
    }

    @Override
    public void sembrar(Semillas semilla, JButton boton) {
        agregarImagenSemillaInicio();
        if (semilla.produceFruta()) {//Hilo Fruta
            grano = new Grano(semilla.getNombre(), semilla, fertilidad, ordenDeProduccionAlimentos, this, granjero, boton);
            Thread hiloGrano = new Thread(grano);
            hiloGrano.start();
        } else {//Hilo grano
            grano = new Grano(semilla.getNombre(), semilla, fertilidad, ordenDeProduccionAlimentos, this, granjero, boton);
            Thread hiloGrano = new Thread(grano);
            hiloGrano.start();
        }
    }

    @Override
    public void criarAnimales(Animales animal) {
        try {
            if (animal.esHerbivoro()) {
                Herbivoros herbivoro = (Herbivoros) animal;
                Thread hiloHerbivoro = new Thread(herbivoro);
                hiloHerbivoro.start();
            } else {
                Omnivoros omnivoros = (Omnivoros) animal;
                Thread hiloOmnivoros = new Thread(omnivoros);
                hiloOmnivoros.start();
            }
        } catch (ClassCastException e) {
            System.out.println("No se pudo iniciar los hilos de animales porque " + e.getMessage());
        }
    }

    public void detenerHilo() {
        try {
            grano.setCosechaRecogida(true);
        } catch (Exception e) {
        }
        try {
            fruta.setCosechaRecogida(true);
        } catch (Exception e) {
        }
    }

    public void añadirFertilidad(Fertilizantes fertilizante) {
        this.fertilidad = fertilidad + fertilizante.getFertilidad();
    }

    // GETTERS -----------------------------------------------------------------
    public ListaDoble<Animales> getAnimales() {
        return animales;
    }

    public String getAnimalesPermitidos() {
        return animalesPermitidos;
    }

    public int getFertilidad() {
        return fertilidad;
    }

    public boolean esParcela() {
        return esParcela;
    }

    public boolean estaOpupado() {
        return estaOpupado;
    }

    public Cola<Integer> getOrdenDeProduccionCelda() {
        return ordenDeProduccionCelda;
    }

    public Cola<Alimentos> getOrdenDeProduccionAlimentos() {
        return ordenDeProduccionAlimentos;
    }

    public boolean tienePlanta() {
        return tienePlanta;
    }

    public boolean tieneAnimales() {
        return tieneAnimales;
    }

    // SETTERS -----------------------------------------------------------------
    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }

    public void setEsParcela(boolean esParcela) {
        this.esParcela = esParcela;
    }

    public void setAnimalesPermitidos(String animalesPermitidos) {
        this.animalesPermitidos = animalesPermitidos;
    }

    public void setEstaOpupado(boolean estaOpupado) {
        this.estaOpupado = estaOpupado;
    }

    public void setTienePlanta(boolean tienePlanta) {
        this.tienePlanta = tienePlanta;
    }

    public void setTieneAnimales(boolean tieneAnimales) {
        this.tieneAnimales = tieneAnimales;
    }

    public Animales getAnimalCriado() {
        return animalCriado;
    }

    public void setAnimalCriado(Animales animalCriado) {
        this.animalCriado = animalCriado;
    }

}
