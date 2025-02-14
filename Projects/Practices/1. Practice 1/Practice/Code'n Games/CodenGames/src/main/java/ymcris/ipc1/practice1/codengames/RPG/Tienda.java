package ymcris.ipc1.practice1.codengames.RPG;

import java.util.Scanner;
import static ymcris.ipc1.practice1.codengames.RPG.Personaje.inventario;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.jugador;

/**
 * Clase encargada de mostrar la tienda y comprar elementos y guardarlos en el
 * inventario del jugador.
 *
 * @Date Feb 14, 2025
 * @author YmCris
 */
public class Tienda {

    // VARIABLES ---------------------------------------------------------------
    private int PRECIO_POTION;
    private int PRECIO_M_POTION;
    private int PRECIO_HI_POTION;

    // INSTANCIAS --------------------------------------------------------------
    Scanner scanner = new Scanner(System.in);

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Tienda() {
        this.PRECIO_POTION = 50;
        this.PRECIO_M_POTION = 75;
        this.PRECIO_HI_POTION = 100;
    }

    // MÉTODOS -----------------------------------------------------------------
    private void comprarItems() {
        int opcionComprar;
        System.out.println("Tienes " + jugador.getOro() + " de oro");
        System.out.println("Tienes " + jugador.getHp() + " de Hp");
        System.out.println("Tienes " + jugador.getMp() + " de Mp");
        System.out.println("");
        System.out.println("                                        ┌------------------------------------------------┐");
        System.out.println("                                        |               ¿QUÉ DESEA COMPRAR?              |");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ¦ [1]  Potion    | Precio:  50   | Cura: 25 HP   ¦");
        System.out.println("                                        ¦ [2]  M-Potion  | Precio:  75   | Cura: 10 MP   ¦");
        System.out.println("                                        ¦ [3]  Hi-Potion | Precio: 100   | Cura: 75 HP   ¦");
        System.out.println("                                        ¦ [4]                Regresar                    ¦");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦            -Seleccione una opción-             ¦");
        System.out.println("                                        └------------------------------------------------┘");
        opcionComprar = scanner.nextInt();
        switch (opcionComprar) {
            case 1 -> {
                if (verificarOro(PRECIO_POTION) == true) {
                    System.out.println(jugador.getNombre() + " ha comprado 1 Potion");
                    System.out.println(jugador.getNombre() + " tiene" + " potions");
                }
            }
            case 2 -> {
                if (verificarOro(PRECIO_M_POTION) == true) {
                    System.out.println(jugador.getNombre() + " ha comprado 1 MPotion");
                    System.out.println(jugador.getNombre() + " tiene" + " Mpotions");
                }
            }
            case 3 -> {
                if (verificarOro(PRECIO_HI_POTION) == true) {
                    System.out.println(jugador.getNombre() + " ha comprado 1 HiPotion");
                    System.out.println(jugador.getNombre() + " tiene" + " Hipotions");
                }
            }
            default -> {
                System.out.println("Ingresa una opción válida");
                comprarItems();
            }
        }
    }

    private boolean verificarOro(int oro) {
        if (jugador.getOro() >= oro) {
            return true;
        } else {
            System.out.println(jugador.getNombre() + " no tienes el oro suficiente");
            return false;
        }
    }

    private void venderItems() {
        int opcionVender;
        System.out.println("Tienes " + jugador.getOro() + " de oro");
        System.out.println("Tienes " + inventario.cantidadPotion + " potions");
        System.out.println("Tienes " + inventario.cantidadMPotion + " Mpotions");
        System.out.println("Tienes " + inventario.cantidadHiPotion + " Hipotions");
        System.out.println("");
        System.out.println("                                        ┌------------------------------------------------┐");
        System.out.println("                                        |               ¿QUÉ DESEA VENDER?               |");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ¦ [1]         Potion    | Precio:  25            ¦");
        System.out.println("                                        ¦ [2]         M-Potion  | Precio:  35            ¦");
        System.out.println("                                        ¦ [3]         Hi-Potion | Precio:  50            ¦");
        System.out.println("                                        ¦ [4]                Regresar                    ¦");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦            -Seleccione una opción-             ¦");
        System.out.println("                                        └------------------------------------------------┘");
        opcionVender = scanner.nextInt();
        switch (opcionVender) {
            case 1 -> {
                if (inventario.verificarItems("potion")) {
                    System.out.println(jugador.getNombre() + " has vendido 1 potion y has ganado 25 de oro");
                    inventario.setCantidadPotion(-1);
                    jugador.setOro(+25);
                }
            }
            case 2 -> {
                if (inventario.verificarItems("mpotion")) {
                    System.out.println(jugador.getNombre() + " has vendido 1 Mpotion y has ganado 35 de oro");
                    inventario.setCantidadMPotion(-1);
                    jugador.setOro(+35);
                }
            }
            case 3 -> {
                if (inventario.verificarItems("hipotion")) {
                    System.out.println(jugador.getNombre() + " has vendido 1 Hipotion y has ganado 50 de oro");
                    inventario.setCantidadMPotion(-1);
                    jugador.setOro(+50);
                }
            }
            default -> {
                System.out.println("Ingresa una opción válida");
                venderItems();
            }
        }
    }

}
