package ymcris.ipc1.practice1.codengames;

import java.util.Scanner;
import ymcris.ipc1.practice1.codengames.RPG.RPG;
import ymcris.ipc1.practice1.codengames.carreras.Carreras;
import ymcris.ipc1.practice1.codengames.reportes.Reportes;

/**
 *
 * @author YmCris
 * @version 21.0.5
 * @see RPG
 * @see Carreras
 * @see Reportes
 */
public class CodenGames {

    private int opcionJuego;
    //Son estáticas para poder utilizarlas en cualquier clase
    public static final String AZUL = "\033[34m";
    public static final String RESETEAR_COLOR = "\033[0m";
    public static int[] iniciosRpg = new int[1];
    public static int[] iniciosCarreras = new int[1];
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Método Main encargado de iniciar el programa.
     *
     * @param args - Argumentos para iniciar los juegos de forma inmediata.
     */
    public static void main(String[] args) {
        CodenGames games = new CodenGames();
        games.iniciarConParametroInmediato(args);
    }

    /**
     * Método encargado de mostrar la bienvenida al usuario.
     */
    private void mostrarBienvenida() {
        System.out.println("\n".repeat(100));
        System.out.println(AZUL
                + "                 ░█████╗░░█████╗░██████╗░███████╗██╗███╗░░██╗  ░██████╗░░█████╗░███╗░░░███╗███████╗░██████╗\n"
                + "                 ██╔══██╗██╔══██╗██╔══██╗██╔════╝╚█║████╗░██║  ██╔════╝░██╔══██╗████╗░████║██╔════╝██╔════╝\n"
                + "                 ██║░░╚═╝██║░░██║██║░░██║█████╗░░░╚╝██╔██╗██║  ██║░░██╗░███████║██╔████╔██║█████╗░░╚█████╗░\n"
                + "                 ██║░░██╗██║░░██║██║░░██║██╔══╝░░░░░██║╚████║  ██║░░╚██╗██╔══██║██║╚██╔╝██║██╔══╝░░░╚═══██╗\n"
                + "                 ╚█████╔╝╚█████╔╝██████╔╝███████╗░░░██║░╚███║  ╚██████╔╝██║░░██║██║░╚═╝░██║███████╗██████╔╝\n"
                + "                 ░╚════╝░░╚════╝░╚═════╝░╚══════╝░░░╚═╝░░╚══╝  ░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝╚═════╝░");
        System.out.println(RESETEAR_COLOR);
        System.out.println("\n".repeat(10));
        System.out.println("Presione enter para continuar.");
        scanner.nextLine();
    }

    /**
     * Método encargado de mostrar el menú principal.
     */
    private void mostrarMenuPrincipal() {
        System.out.println("\n".repeat(100));
        System.out.println("                                        ┌------------------------------------------------┐");
        System.out.println("                                        |                 MENÚ PRINCIPAL                 |");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦ [1] ¿Cómo jugar Code'n Games?                  ¦");
        System.out.println("                                        ¦ [2] Jugar RPG                                  ¦");
        System.out.println("                                        ¦ [3] Jugar Carreras                             ¦");
        System.out.println("                                        ¦ [4] Ver reportes                               ¦");
        System.out.println("                                        ¦ [5] Salir del programa                         ¦");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦            -Seleccione una opción-             ¦");
        System.out.println("                                        └------------------------------------------------┘");
    }

    private void iniciarConParametroInmediato(String[] parametro) {
        CodenGames code = new CodenGames();
        if (parametro.length > 0) {//valida que el usuario haya colocado algo
            String comando = parametro[0].trim().toLowerCase();
            if (comando.equals("hola")) {
                System.out.println("HOLA MUNDO");
            } else if (comando.equals("rpg")) {
                code.setIniciosRpg(+1);
                RPG rpg = new RPG();
                rpg.decirHola();
            } else if (comando.equals("carreras")) {
                code.setIniciosCarreras(+1);
                Carreras carrera = new Carreras();
                carrera.holaCarros();
            } else if (comando.equals("reportes")) {
                Reportes reporte = new Reportes();
                reporte.decirReportes();
            } else {
                System.out.println("INGRESA UN COMANDO VÁLIDO");
                System.out.println("'RPG', 'CARRERAS', 'REPORTES'");
            }
        } else {
            code.mostrarBienvenida();
            System.out.println("\n".repeat(100));
            pedirOpcionMenu();
        }
    }

    public void pedirOpcionMenu() {
        CodenGames games = new CodenGames();
        System.out.println("\n".repeat(10));
        mostrarMenuPrincipal();
        opcionJuego = scanner.nextInt();
        switch (opcionJuego) {
            case 1:
                ComoJugar jugar = new ComoJugar();
                jugar.mostrarComoJugar();
                break;
            case 2:
                games.setIniciosRpg(+1);
                RPG rpg = new RPG();
                rpg.decirHola();
                break;
            case 3:
                games.setIniciosCarreras(+1);
                Carreras carrera = new Carreras();
                carrera.holaCarros();
                break;
            case 4:
                Reportes reporte = new Reportes();
                reporte.decirReportes();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Por favor, ingrese una opción válida ('1','2','3','4','5')");
                pedirOpcionMenu();
                break;
        }
    }

    //Setters & Getters
    public int getIniciosRpg() {
        return iniciosRpg[0];
    }

    public void setIniciosRpg(int inicioR) {
        iniciosRpg[0] += inicioR;
    }

    public int getIniciosCarreras() {
        return iniciosCarreras[0];
    }

    public void setIniciosCarreras(int inicioC) {
        iniciosCarreras[0] += inicioC;
    }

}
