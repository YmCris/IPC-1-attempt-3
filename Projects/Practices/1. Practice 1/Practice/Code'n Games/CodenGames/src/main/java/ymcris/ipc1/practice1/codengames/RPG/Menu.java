package ymcris.ipc1.practice1.codengames.RPG;

import java.util.Scanner;
import ymcris.ipc1.practice1.codengames.CodenGames;
import static ymcris.ipc1.practice1.codengames.RPG.RPG.jugador;

/**
 * Clase encargada de mostrar las opciones del menú principal y ejecutarlas.
 *
 * @Date Feb 15, 2025
 * @author YmCris
 * @see CodenGames
 */
public class Menu {

    // INSTANCIAS --------------------------------------------------------------
    Scanner scanner = new Scanner(System.in);
    Batallas batalla = new Batallas(jugador);

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de mostrar las opciones del menú y realizarlos/
     * llamarlos.
     */
    protected void mostrarOpciones() {
        int opcionMenu;
        do {
            System.out.println("                                        ┌------------------------------------------------┐");
            System.out.println("                                        |              ¿QUÉ DESEA REALIZAR?              |");
            System.out.println("                                        ├------------------------------------------------┤");
            System.out.println("                                        ¦                                                ¦");
            System.out.println("                                        ¦ [1]            ¡¡¡A LA CARGA!!!                ¦");
            System.out.println("                                        ¦ [2]                 TIENDA                     ¦");
            System.out.println("                                        ¦ [3]               zZZzzZzzZZ                   ¦");
            System.out.println("                                        ¦ [4]                 STATUS                     ¦");
            System.out.println("                                        ¦ [5]             ¡¡¡MÁS PODER!!!                ¦");
            System.out.println("                                        ¦ [6]                Regresar                    ¦");
            System.out.println("                                        ¦                                                ¦");
            System.out.println("                                        ├------------------------------------------------┤");
            System.out.println("                                        ¦             -Seleccione una opción-            ¦");
            System.out.println("                                        └------------------------------------------------┘");
            opcionMenu = scanner.nextInt();
            scanner.nextLine();
            switch (opcionMenu) {
                case 1 ->
                    batalla.pelear();
                case 2 ->
                    new Tienda().mostrarOpciones();
                case 3 ->
                    descansarPersonaje(jugador);
                case 4 ->
                    mostrarEstadisticas(jugador);
                case 5 ->
                    jugador.verificarNivel();
                case 6 ->
                    new CodenGames().pedirOpcionMenu();
                default ->
                    System.out.println("Introduce una opción válida");
            }
        } while (opcionMenu <= 0 || opcionMenu > 6);
        continuarJugando();
    }

    /**
     * Método encargado de recuperar a un PERSONAJE,verifica si tiene el dinero
     * necesario, lo resta y aumenta su hp y mp a lo máximo.
     *
     * @param personaje - Personaje el cual resivirá el descanso.
     */
    private void descansarPersonaje(Personaje personaje) {
        if (personaje.getHp() == personaje.getHpMaximo() && personaje.getMp() == personaje.getMpMaximo()) {//Verifica que el personaje no tenga mp y hp máximos
            System.out.println("No puedes descansar a tu personaje ya que tiene sus puntos de hp y mp en su capacidad máxima");
        } else {
            if (personaje.getOro() >= 30) {//Verifica si el personaje tiene oro
                personaje.hp = personaje.hpMaximo;
                personaje.mp = personaje.mpMaximo;
                personaje.setOro(-30);
                System.out.println("Aventurero " + personaje.getNombre() + " Has descansado lo suficiente, te has recuperado!");
                System.out.println(personaje.getNombre() + " tienes " + personaje.hp + " de vida y " + personaje.mp + " de mana");
                System.out.println("Tu oro actual es de " + personaje.getOro());
            } else {
                System.out.println("Aventurero " + personaje.getNombre() + " no tienes los recursos necesarios");
                System.out.println("Sigue realizando tareas y misiones para poder descansar");
            }
        }
    }

    /**
     * Método encargado de mostrar las carácterísticas de un personaje y el
     * inventario en general.
     *
     * @param personaje - Personaje del cual se van a mostrar las estadísticas.
     */
    private void mostrarEstadisticas(Personaje personaje) {
        Inventario inventario = new Inventario();
        System.out.println("-------------------- Aventurero: " + personaje.getNombre() + " estas son tus características --------------------");
        System.out.println("Vida: " + personaje.getHp() + "/" + personaje.getHpMaximo());
        System.out.println("Mana: " + personaje.getMp() + "/" + personaje.getMpMaximo());
        System.out.println("Nivel: " + personaje.getNivel());
        System.out.println("Experiencia: " + personaje.getExperiencia());
        System.out.println("Oro: " + personaje.getOro());
        System.out.println("Monstruos Vencidos: " + personaje.getMonstruosVencidos());
        System.out.println("--------------------------------------- Inventario ---------------------------------------");
        inventario.mostrarItems();

    }

    /**
     * Método super importante para que no se termine el juego.
     */
    private void continuarJugando() {
        System.out.println("Presione enter para regresar al Menu principal.");
        scanner.nextLine();
        mostrarOpciones();
    }

}
