package ymcris.ipc1.practice1.codengames.RPG;

import static ymcris.ipc1.practice1.codengames.RPG.Personaje.inventario;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.jugador;

/**
 * Clase encargada de mostrar y usar los items que tiene el jugador
 *
 * @Date Feb 14, 2025
 * @author YmCris
 */
public class Inventario {

    // VARIABLES ---------------------------------------------------------------
    protected int cantidadPotion;
    protected int cantidadMPotion;
    protected int cantidadHiPotion;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Inventario() {
        this.cantidadPotion = 0;
        this.cantidadMPotion = 0;
        this.cantidadHiPotion = 0;
    }

    // MÉTODOS -----------------------------------------------------------------
    protected void mostrarItems() {
        System.out.println(jugador.getNombre() + " tiene: " + inventario.getCantidadPotion() + " items Potion");
        System.out.println(jugador.getNombre() + " tiene: " + inventario.getCantidadMPotion() + " items M-Potion");
        System.out.println(jugador.getNombre() + " tiene: " + inventario.getCantidadHiPotion() + " items Hi-Potion");
    }

    protected void usarItem(String item, Personaje personaje) {
        if (verificarItems(item)) {
            System.out.println(jugador.getNombre() + " Recupera 25 de HP");
            personaje.setHp(+25);
        } else if (verificarItems(item)) {
            System.out.println(jugador.getNombre() + " Recupera 10 de MP");
            personaje.setMp(+10);
        } else if (verificarItems(item)) {
            System.out.println(jugador.getNombre() + " Recupera 75 de HP");
            personaje.setHp(+75);
        } else {
            System.out.println(jugador.getNombre() + " no tiene el item " + item);
        }
    }

    protected boolean verificarItems(String item) {
        if (item.toLowerCase().equals("potion")) {
            if (inventario.getCantidadPotion() > 0) {
                return true;
            }
        } else if (item.toLowerCase().equals("mpotion")) {
            if (inventario.getCantidadMPotion() > 0) {
                return true;
            }
        } else if (item.toLowerCase().equals("hipotion")) {
            if (inventario.getCantidadHiPotion() > 0) {
                return true;
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
