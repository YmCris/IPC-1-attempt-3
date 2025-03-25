package ymcris.ipc1.proyecto1.treasurehunter.mapas;

import java.io.File;
import java.util.Scanner;
import ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.obtenerCuantasLineasTieneUnArchivo;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.sobreEscribirUnaLineaDeArchivo;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.mostrarOpcionesEditarMapa;
import static ymcris.ipc1.proyecto1.treasurehunter.exception.EntradaNoValidaException.errorEncontrado;

/**
 * Clase encargada de editar los mapas persistentes desde los archivos
 *
 * @author YmCris
 * @since Mar 24, 2025
 */
public class EditorDeMapas {

    // --------------------- VARIABLES DE REFERENCIA ---------------------------
    private File mapaAEditar;
    // ----------------------- VARIABLES PRIMITIVAS ----------------------------
    // ---------------------------- INSTANCIAS ---------------------------------
    Scanner scanner = new Scanner(System.in);

    // ------------------------ MÉTODO CONSTRUCTOR -----------------------------
    public EditorDeMapas(File mapaAEditar) {
        this.mapaAEditar = mapaAEditar;
    }

    // ----------------------------- MÉTODOS -----------------------------------
    public void editarMapa() {
        while (true) {
            try {
                //3. Mostrar todas las características del mapa
                mostrarOpcionesEditarMapa();
                //4. Pedir qué línea va a modificar
                int opcionAModificar = scanner.nextInt();
                scanner.nextLine();
                if (opcionAModificar < 0 || opcionAModificar > obtenerCuantasLineasTieneUnArchivo(mapaAEditar)) {
                    System.out.println("No puedes modificar algo que no existe");
                } else {
                    //5. Modificar esa línea en su archivo
                    if (opcionAModificar == 0) {
                        //texto
                        String nuevoString = modificarUnTexto();
                        sobreEscribirUnaLineaDeArchivo(nuevoString, mapaAEditar, opcionAModificar);
                        //entero
                    } else if (opcionAModificar == 1 || opcionAModificar == 2 || opcionAModificar == 3 || opcionAModificar == 4 || opcionAModificar == 5 || opcionAModificar == 6 || opcionAModificar == 7 || opcionAModificar == 8 || opcionAModificar == 10 || opcionAModificar == 12 || opcionAModificar == 14 || opcionAModificar == 15 || opcionAModificar == 18 || opcionAModificar == 19 || opcionAModificar == 21 || opcionAModificar == 24 || opcionAModificar == 25 || opcionAModificar == 26 || opcionAModificar == 27 || opcionAModificar == 28) {
                        int nuevoValor = modificarUnNúmero();
                        sobreEscribirUnaLineaDeArchivo(String.valueOf(nuevoValor), mapaAEditar, opcionAModificar);
                        //Boolean
                    } else if (opcionAModificar == 9) {
                        System.out.println("[1] Quitar vida  [2] Quitar mana");
                        boolean quitaVida = scanner.nextInt() == 1;
                        sobreEscribirUnaLineaDeArchivo(String.valueOf(quitaVida), mapaAEditar, opcionAModificar);
                    } else if (opcionAModificar == 11) {
                        System.out.println("[1] Pista direccional  [2] Pista de aproximación");
                        boolean esDireccional = scanner.nextInt() == 1;
                        sobreEscribirUnaLineaDeArchivo(String.valueOf(esDireccional), mapaAEditar, opcionAModificar);
                    } else if (opcionAModificar == 13) {
                        System.out.println("¿Desea que la casilla teletransporte a un lugar aleatorio?");
                        System.out.println("[1] Si  [2] No");
                        boolean ubicacionAleatoria = scanner.nextInt() == 1;
                        sobreEscribirUnaLineaDeArchivo(String.valueOf(ubicacionAleatoria), mapaAEditar, opcionAModificar);
                    } else if (opcionAModificar == 20) {
                        System.out.println("¿Qué desea que realice la casilla de energía?");
                        System.out.println("[1] Recuperar vida  [2] Recuperar mana");
                        boolean recuperaVida = scanner.nextInt() == 1;
                        sobreEscribirUnaLineaDeArchivo(String.valueOf(recuperaVida), mapaAEditar, opcionAModificar);
                    } else if (opcionAModificar == 22) {
                        System.out.println("¿El jugador puede escapar de la batalla?  [1] Si [2] No ");
                        boolean puedeEscapar = scanner.nextInt() == 1;
                        sobreEscribirUnaLineaDeArchivo(String.valueOf(puedeEscapar), mapaAEditar, opcionAModificar);
                    } else if (opcionAModificar == 23) {
                        System.out.println("De perder una batalla ¿Qué desea que suceda?");
                        System.out.println("[1] Pierde Puntos [2] Es reubicado");
                        boolean pierdePuntos = scanner.nextInt() == 1;
                        sobreEscribirUnaLineaDeArchivo(String.valueOf(pierdePuntos), mapaAEditar, opcionAModificar);
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("Debes introducir un valor numérico");
                errorEncontrado();
                editarMapa();
            }
        }
        System.out.println("Presione: [1] Para seguir editando [2] Para volver al menú principal");
        boolean sigueEditando = scanner.nextInt() == 1;
        if (sigueEditando) {
            editarMapa();
        } else {
            new TreasureHunter().verMenuPrincipal();
        }
    }

    public int modificarUnNúmero() {
        int nuevoValor = 0;
        while (true) {
            try {
                System.out.println("¿Cuál es el nuevo valor?");
                nuevoValor = scanner.nextInt();
                if (nuevoValor <= 0) {
                    System.out.println("No puedes colocar esa cantidad");
                    System.out.println("Presiona enter para continuar");
                    scanner.nextLine();
                } else {
                    return nuevoValor;
                }
            } catch (Exception e) {
                System.out.println("Tienes que introducir un número.");
                errorEncontrado();
            }
        }
    }

    public String modificarUnTexto() {
        while (true) {
            System.out.println("Cuál es el nuevo nombre");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isBlank()) {
                return nuevoNombre;
            } else {
                System.out.println("No puedes tener un nombre en blanco");
            }
        }
    }

    public void modificarUnBooolean() {
        System.out.println("¿Cuál?");
    }

    // ------------------------- GETTERS & SETTERS -----------------------------
}
