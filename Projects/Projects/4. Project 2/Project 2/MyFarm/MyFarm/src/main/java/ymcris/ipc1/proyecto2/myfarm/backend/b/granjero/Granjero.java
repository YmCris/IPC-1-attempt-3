package ymcris.ipc1.proyecto2.myfarm.backend.b.granjero;

import ymcris.ipc1.proyecto2.myfarm.backend.a.listas.doble.ListaDoble;
import ymcris.ipc1.proyecto2.myfarm.backend.c.productos.Alimentos;
import ymcris.ipc1.proyecto2.myfarm.backend.a.exceptions.ListaDobleException;

/**
 * Clase Granjero es la clase encargada de representar al jugador dentro del
 * videojuego teniendo todos los atributos necesarios.
 *
 * @author YmCris
 * @since Apr 26, 2025
 */
public class Granjero extends Thread {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String nick;
    private String nombre;
    private ListaDoble<String> animales;
    private ListaDoble<Alimentos> alimentos;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int oro;
    private int vida;
    private int alimento;
    private boolean haComido;
    private boolean estaLleno;

    // CONSTANTES --------------------------------------------------------------
    private static final int VIDA_MAXIMA = 10;
    private static final int TIEMPO_PARA_DISMINUIR_VIDA = 100;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Granjero(String nick, String nombre) {
        this.nick = nick;
        this.nombre = nombre;
        this.oro = 1000;
        this.vida = 10;
        this.alimento = 0;
        this.haComido = false;
        this.estaLleno = true;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    /**
     * Verifica si el jugador tiene comida
     *
     * @return mensaje de no tener comida para el frontend.
     */
    public String hayComida() {
        if (alimentos.estaVacia()) {
            return "No tienes comida";
        }
        return "";
    }

    /**
     * Método encargado de comer, sumar vida, y eliminar el alimento del
     * inventario.
     *
     * @param alimento - Alimentos a consumir
     */
    public void comer(Alimentos alimento) {
        if (!alimentos.estaVacia()) {
            try {
                if (!estaLleno) {
                    alimentos.usar(alimento);
                    if (vida < VIDA_MAXIMA) {
                        vida++;
                    }
                    haComido = true;
                }
            } catch (ListaDobleException ex) {
                System.out.println("Ha ocurrido un error al comer porque " + ex.getMessage());
            }
        } else {
            System.out.println("No hay alimentos para comer");
        }
    }

    // MÉTODOS SOBREESCRITOS ---------------------------------------------------
    @Override
    public void run() {
        int contador = 0;
        while (vida > 0) {
            try {
                Thread.sleep(1000);
                if (haComido) {//Si ha comido se reinicia el contador
                    contador = 0;
                } else {//Si no ha comido durante 100 segundos se resta vida
                    contador++;
                    if (contador == TIEMPO_PARA_DISMINUIR_VIDA) {
                        System.out.println("Granjero ha perdido 1 punto de vida, tiene " + vida + " puntos de vida");
                        vida--;
                        contador = 0;
                    }
                }
                haComido = false;
            } catch (InterruptedException ex) {
                System.out.println("Se ha interrumpido el hilo del hilo del jugador");
                break;
            }
        }
        System.out.println("El juego ha terminado, el jugador ha muerto por no consumir alimento");
    }

    // GETTERS -----------------------------------------------------------------
    public ListaDoble<String> getAnimales() {
        return animales;
    }

    public ListaDoble<Alimentos> getAlimentos() {
        return alimentos;
    }

    public String getNick() {
        return nick;
    }

    public String getNombre() {
        return nombre;
    }

    public int getOro() {
        return oro;
    }

    public int getVida() {
        return vida;
    }

    public int getAlimento() {
        return alimento;
    }

    public boolean estaLleno() {
        return estaLleno;
    }

    // SETTERS -----------------------------------------------------------------
    public void setOro(int oro) {
        this.oro = oro;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAlimento(int alimento) {
        this.alimento = alimento;
    }

    public void estaLleno(boolean estaLleno) {
        this.estaLleno = estaLleno;
    }

}
