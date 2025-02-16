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
 * @see Inventario
 */
public class Tienda {

    // VARIABLES ---------------------------------------------------------------
    private final int PRECIO_POTION;//Deberían ser static, pero me gusta tenerlos en el constructor :)
    private final int PRECIO_M_POTION;
    private final int PRECIO_HI_POTION;

    // INSTANCIAS --------------------------------------------------------------
    Menu menu = new Menu();
    Scanner scanner = new Scanner(System.in);

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método constructor encargado de inicializar las variables de los precios
     */
    public Tienda() {
        this.PRECIO_POTION = 50;//tiene que ser par
        this.PRECIO_M_POTION = 75;//tiene que ser impar (75+1)/2
        this.PRECIO_HI_POTION = 100;//tiene que ser par
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de mostrar las opciones que ofrece la tienda.
     */
    private void mostrarOpciones() {
        int opcionOpciones;
        System.out.println("                                        ┌------------------------------------------------┐");
        System.out.println("                                        |              ¿QUÉ DESEA REALIZAR?              |");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ¦ [1]              Comprar items                 ¦");
        System.out.println("                                        ¦ [2]               Vender items                 ¦");
        System.out.println("                                        ¦ [3]                Regresar                    ¦");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦             -Seleccione una opción-            ¦");
        System.out.println("                                        └------------------------------------------------┘");
        opcionOpciones = scanner.nextInt();
        switch (opcionOpciones) {
            case 1 ->
                comprarItems();
            case 2 ->
                venderItems();
            case 3 ->
                menu.mostrarOpciones();
            default -> {
                System.out.println("Ingresa una opción válida.");
                mostrarOpciones();
            }
        }

    }

    /**
     * Método encargado de mostrar los items que el jugador puede comprar.
     */
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
                if (verificarOro(PRECIO_POTION)) {
                    System.out.println(jugador.getNombre() + " ha comprado 1 Potion");
                    System.out.println(jugador.getNombre() + " tiene" + " potions");
                }
            }
            case 2 -> {
                if (verificarOro(PRECIO_M_POTION)) {
                    System.out.println(jugador.getNombre() + " ha comprado 1 MPotion");
                    System.out.println(jugador.getNombre() + " tiene" + " Mpotions");
                }
            }
            case 3 -> {
                if (verificarOro(PRECIO_HI_POTION)) {
                    System.out.println(jugador.getNombre() + " ha comprado 1 HiPotion");
                    System.out.println(jugador.getNombre() + " tiene" + " Hipotions");
                }
            }
            case 4 -> {
                mostrarOpciones();
            }
            default -> {
                System.out.println("Ingresa una opción válida");
                comprarItems();
            }
        }
    }

    /**
     * Método encargado de verificar si el PERSONAJE tiene el oro suficiente
     * para gastar.
     *
     * @param oro - Precio que tiene el objeto u actividad.
     * @return true si el PERSONAJE tiene la cantidad de oro requerido.
     */
    private boolean verificarOro(int oro) {
        if (jugador.getOro() >= oro) {
            return true;
        } else {
            System.out.println(jugador.getNombre() + " no tienes el oro suficiente");
            return false;
        }
    }

    /**
     * Método encargado de mostrar las opciones que tiene el JUGADOR para
     * vender.
     */
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
        System.out.println("                                        ¦ [2]         M-Potion  | Precio:  38            ¦");
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
                    jugador.setOro(+(PRECIO_POTION / 2));//50/2=25;
                }
            }
            case 2 -> {
                if (inventario.verificarItems("mpotion")) {
                    System.out.println(jugador.getNombre() + " has vendido 1 Mpotion y has ganado 35 de oro");
                    inventario.setCantidadMPotion(-1);
                    jugador.setOro(+(PRECIO_M_POTION + 1) / 2);//(75+1)/2=38;
                }
            }
            case 3 -> {
                if (inventario.verificarItems("hipotion")) {
                    System.out.println(jugador.getNombre() + " has vendido 1 Hipotion y has ganado 50 de oro");
                    inventario.setCantidadMPotion(-1);
                    jugador.setOro(+(PRECIO_HI_POTION / 2));//100/2=50;
                }
            }
            case 4 -> {
                mostrarOpciones();
            }
            default -> {
                System.out.println("Ingresa una opción válida");
                venderItems();
            }
        }
    }

}
