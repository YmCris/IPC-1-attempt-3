package ymcris.ipc1.practice1.codengames.RPG;

import static ymcris.ipc1.practice1.codengames.RPG.Personaje.inventario;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.jugador;

/**
 * Clase encargada de mostrar y usar los items que tiene el jugador
 *
 * @Date Feb 14, 2025
 * @author YmCris
 * @see Personaje
 */
public class Inventario {

    // VARIABLES ---------------------------------------------------------------
    protected int cantidadPotion;
    protected int cantidadMPotion;
    protected int cantidadHiPotion;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método constructor encargado de inicializar la cantidad de potions que
     * tiene el JUGADOR.
     */
    public Inventario() {
        this.cantidadPotion = 0;
        this.cantidadMPotion = 0;
        this.cantidadHiPotion = 0;
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de mostrar los items que posee un PERSONAJE.
     */
    protected void mostrarItems() {
        System.out.println("Aventurero " + jugador.getNombre() + " tienes " + inventario.getCantidadPotion() + " items Potion");
        System.out.println("Aventurero " + jugador.getNombre() + " tienes " + inventario.getCantidadMPotion() + " items M-Potion");
        System.out.println("Aventurero " + jugador.getNombre() + " tienes " + inventario.getCantidadHiPotion() + " items Hi-Potion");
    }

    /**
     * Método encargado de usar el item para UN PERSONAJE (Aliado)
     *
     * @param item - Item a utilizar sobre un aliado.
     * @param personaje - Personaje a quien se le atribuirá el item.
     */
    protected void usarItem(String item, Personaje personaje) {
        if (verificarItems(item)) {
            if (item.equalsIgnoreCase("potion")) {
                System.out.println(jugador.getNombre() + " Usa " + item + " y Recupera 25 de HP");
                this.setCantidadPotion(-1);
                personaje.setHp(+25);
            } else if (item.equalsIgnoreCase("mpotion")) {
                System.out.println(jugador.getNombre() + " Usa " + item + " y Recupera 10 de MP");
                this.setCantidadMPotion(-1);
                personaje.setMp(+10);
            } else if (item.equalsIgnoreCase("hipotion")) {
                System.out.println(jugador.getNombre() + " Usa " + item + " y Recupera 75 de MP");
                this.setCantidadHiPotion(-1);
                personaje.setHp(+75);
            }
        }
    }

    /**
     * Método encargado de verificar si el JUGADOR tiene el item.
     *
     * @param item - Item a verificar.
     * @return true si el JUGADOR posee el item.
     */
    protected boolean verificarItems(String item) {
        switch (item.toLowerCase()) {
            case "potion" -> {
                if (inventario.getCantidadPotion() > 0) {
                    return true;
                }
            }
            case "mpotion" -> {
                if (inventario.getCantidadMPotion() > 0) {
                    return true;
                }
            }
            case "hipotion" -> {
                if (inventario.getCantidadHiPotion() > 0) {
                    return true;
                }
            }
            default -> {
            }
        }
        System.out.println(jugador.getNombre() + " No tiene el item " + item);
        return false;
    }

    // GETTERS & SETTERS -------------------------------------------------------
    public int getCantidadPotion() {
        return cantidadPotion;
    }

    public void setCantidadPotion(int cantidadPotion) {
        this.cantidadPotion += cantidadPotion;
    }

    public int getCantidadMPotion() {
        return cantidadMPotion;
    }

    public void setCantidadMPotion(int cantidadMPotion) {
        this.cantidadMPotion += cantidadMPotion;
    }

    public int getCantidadHiPotion() {
        return cantidadHiPotion;
    }

    public void setCantidadHiPotion(int cantidadHiPotion) {
        this.cantidadHiPotion += cantidadHiPotion;
    }

}
