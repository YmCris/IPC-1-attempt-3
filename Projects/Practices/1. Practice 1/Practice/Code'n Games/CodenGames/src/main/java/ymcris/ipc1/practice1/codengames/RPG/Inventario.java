package ymcris.ipc1.practice1.codengames.RPG;

import static ymcris.ipc1.practice1.codengames.RPG.Personaje.inventario;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.jugador;

/**
 * Clase encargada de mostrar y usar los items que tiene el jugador
 *
 * @since Feb 14, 2025
 * @author YmCris
 * @see Personaje
 * @see Tienda
 */
public class Inventario {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private final String MAGENTA;
    private final String RESETEAR;
    // VARIABLES PRIMITIVAS ----------------------------------------------------
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
        this.MAGENTA = "\033[95m";
        this.RESETEAR = "\033[0m";
        this.cantidadHiPotion = 0;
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de mostrar los items que posee un PERSONAJE.
     */
    protected void mostrarItems() {
        System.out.println("1. Aventurero " + jugador.getNombre() + " tienes " + inventario.getCantidadPotion() + " items Potion");
        System.out.println("2. Aventurero " + jugador.getNombre() + " tienes " + inventario.getCantidadMPotion() + " items M-Potion");
        System.out.println("3. Aventurero " + jugador.getNombre() + " tienes " + inventario.getCantidadHiPotion() + " items Hi-Potion");
    }

    /**
     * Método encargado de usar el item para UN PERSONAJE (Aliado)
     *
     * @param item - Item a utilizar sobre un aliado.
     * @param personaje - Personaje a quien se le atribuirá el item.
     */
    protected void usarItem(String item, Personaje personaje) {
        if (verificarItems(item)) {//Verifica que en inventario este el item
            if (personaje.getMp() == personaje.getMpMaximo() || personaje.getHp() == personaje.getHpMaximo()) {//verifica que el personaje no tenga mp y hp máximos.
                System.out.println("No puedes usar las posiones, ya que tus capacidades de vida o mana estan llenas");
            } else {//Dependiendo del item elegido se aplicará su efecto y se resta en el inventario.
                if (item.equalsIgnoreCase("potion")) {
                    System.out.println(jugador.getNombre() + " Usa " + item + " y Recupera 25 de vida");
                    this.setCantidadPotion(-1);
                    personaje.setHp(+25);
                } else if (item.equalsIgnoreCase("mpotion")) {
                    System.out.println(jugador.getNombre() + " Usa " + item + " y Recupera 10 de mana");
                    this.setCantidadMPotion(-1);
                    personaje.setMp(+10);
                } else if (item.equalsIgnoreCase("hipotion")) {
                    System.out.println(jugador.getNombre() + " Usa " + item + " y Recupera 75 de vida");
                    this.setCantidadHiPotion(-1);
                    personaje.setHp(+75);
                }
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
        switch (item.toLowerCase()) {//verifica si el jugador tiene el item en el inventario.
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
                System.out.println("No existe el item");
            }
        }
        System.out.println(MAGENTA + "                                                          ---------- " + RESETEAR + jugador.getNombre() + " no tienes el item " + item + MAGENTA + " ---------- " + RESETEAR);
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
