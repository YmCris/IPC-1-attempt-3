package ymcris.ipc1.practice1.codengames.RPG;

import java.util.Scanner;
import static ymcris.ipc1.practice1.codengames.RPG.Personaje.inventario;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.jugador;

/**
 * Clase encargada de mostrar la tienda y comprar elementos y guardarlos en el
 * inventario del jugador.
 *
 * @since Feb 14, 2025
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
    protected void mostrarOpciones() {
        int opcionOpciones;
        System.out.println("                                        ┌------------------------------------------------┐");
        System.out.println("                                        |              ¿QUÉ DESEA REALIZAR?              |");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ¦ [1]              Comprar items                 ¦");
        System.out.println("                                        ¦ [2]               Vender items                 ¦");
        System.out.println("                                        ¦ [3]                 Regresar                   ¦");
        System.out.println("                                        ¦ [4]              Salir del juego               ¦");
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
            case 4 ->
                System.exit(0);
            default -> {
                System.out.println("Ingresa una opción válida.");
            }
        }
        volverALaTienda();
    }

    /**
     * Método encargado de mostrar los items que el jugador puede comprar.
     */
    private void comprarItems() {
        int opcionComprar;
        System.out.println("Tienes " + jugador.getOro() + " de oro");
        System.out.println("Tienes " + jugador.getHp() + "/" + jugador.getHpMaximo() + " de Hp");
        System.out.println("Tienes " + jugador.getMp() + "/" + jugador.getMpMaximo() + " de Mp");
        System.out.println("");
        System.out.println("                                        ┌------------------------------------------------┐");
        System.out.println("                                        |               ¿QUÉ DESEA COMPRAR?              |");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ¦ [1]  Potion    | Precio:  50   | Cura: 25 HP   ¦");
        System.out.println("                                        ¦ [2]  M-Potion  | Precio:  75   | Cura: 10 MP   ¦");
        System.out.println("                                        ¦ [3]  Hi-Potion | Precio: 100   | Cura: 75 HP   ¦");
        System.out.println("                                        ¦ [4]                Regresar                    ¦");
        System.out.println("                                        ¦ [5]             Salir del juego                ¦");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦            -Seleccione una opción-             ¦");
        System.out.println("                                        └------------------------------------------------┘");
        opcionComprar = scanner.nextInt();
        switch (opcionComprar) {
            case 1 -> {
                if (verificarOro(PRECIO_POTION)) {//Verifica que el personaje tenga el oro para la potion
                    System.out.println("Aventurero " + jugador.getNombre() + " has comprado 1 Potion");
                    inventario.setCantidadPotion(+1);
                    System.out.println(jugador.getNombre() + " tienes " + inventario.cantidadPotion + " potions");
                }
            }
            case 2 -> {
                if (verificarOro(PRECIO_M_POTION)) {//Verifica que el personaje tenga el oro para la mpotion
                    System.out.println("Aventurero " + jugador.getNombre() + " has comprado 1 MPotion");
                    inventario.setCantidadMPotion(+1);
                    System.out.println(jugador.getNombre() + " tienes " + inventario.cantidadMPotion + " Mpotions");
                }
            }
            case 3 -> {
                if (verificarOro(PRECIO_HI_POTION)) {//Verifica que el personaje tenga el oro para la hipotion
                    System.out.println("Aventurero " + jugador.getNombre() + " has comprado 1 HiPotion");
                    inventario.setCantidadHiPotion(+1);
                    System.out.println(jugador.getNombre() + " tienes " + inventario.cantidadHiPotion + " Hipotions");
                }
            }
            case 4 -> {
                mostrarOpciones();
            }
            case 5 -> {
                System.exit(0);
            }
            default -> {
                System.out.println("Ingresa una opción válida");
            }
        }
        volverALaTienda();
    }

    /**
     * Método encargado de verificar si el PERSONAJE tiene el oro suficiente
     * para gastar.
     *
     * @param oro - Precio que tiene el objeto u actividad.
     * @return true si el PERSONAJE tiene la cantidad de oro requerido.
     */
    private boolean verificarOro(int oro) {
        if (jugador.getOro() >= oro) {//Verifica si el personaje tiene el oro y se lo quita
            jugador.setOro(-oro);
            return true;
        } else {
            System.out.println(jugador.getNombre() + " no tienes el oro suficiente");
            return false;
        }
    }

    /**
     * Método super importante para que el juego no se quede estancado, regresa
     * al menú principal de la tienda.
     */
    private void volverALaTienda() {
        System.out.println("Presione enter para volver al menú de compras.");
        scanner.nextLine();
        scanner.nextLine();
        mostrarOpciones();
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
        System.out.println("                                        ¦ [5]             Salir del juego                ¦");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦            -Seleccione una opción-             ¦");
        System.out.println("                                        └------------------------------------------------┘");
        opcionVender = scanner.nextInt();
        switch (opcionVender) {
            case 1 -> {
                if (inventario.verificarItems("potion")) {//verifica que existe el item en el inventario
                    System.out.println("Aventurero " + jugador.getNombre() + " has vendido 1 potion y has ganado 25 de oro");
                    inventario.setCantidadPotion(-1);
                    jugador.setOro(+(PRECIO_POTION / 2));//50/2=25;
                }
            }
            case 2 -> {
                if (inventario.verificarItems("mpotion")) {//verifica que existe el item en el inventario
                    System.out.println("Aventurero " + jugador.getNombre() + " has vendido 1 Mpotion y has ganado 38 de oro");
                    inventario.setCantidadMPotion(-1);
                    jugador.setOro(+(PRECIO_M_POTION + 1) / 2);//(75+1)/2=38;
                }
            }
            case 3 -> {
                if (inventario.verificarItems("hipotion")) {//verifica que existe el item en el inventario
                    System.out.println("Aventurero " + jugador.getNombre() + " has vendido 1 Hipotion y has ganado 50 de oro");
                    inventario.setCantidadHiPotion(-1);
                    jugador.setOro(+(PRECIO_HI_POTION / 2));//100/2=50;
                }
            }
            case 4 -> {
                mostrarOpciones();
            }
            case 5 -> {
                System.exit(0);
            }
            default -> {
                System.out.println("Ingresa una opción válida");
            }
        }
        volverALaTienda();
    }
    
}
