package ymcris.ipc1.practice1.codengames.carreras;

import java.util.Random;
import static ymcris.ipc1.practice1.codengames.CodenGames.AZUL;
import static ymcris.ipc1.practice1.codengames.CodenGames.RESETEAR_COLOR;
import static ymcris.ipc1.practice1.codengames.CodenGames.scanner;
import static ymcris.ipc1.practice1.codengames.reportes.Reportes.setContadorComputadoraGanadoraCarreras;
import static ymcris.ipc1.practice1.codengames.reportes.Reportes.setContadorHumanoGanadorCarreras;

/**
 * Clase encargada de Generar la pista, mostrarla y modificarla
 *
 * @since Feb 9, 2025
 * @author YmCris
 */
public class Pista {

    //VARIABLES-----------------------------------------------------------------
    private char jugador1;
    private char jugador2;
    private int numeroDeVehiculos;
    private int posicionJugador1;
    private int posicionJugador2;
    private int tamañoPista;
    private int[] posicionesVehiculos;
    private static char[] vehiculos;// static porque no puede acceder a pista si no es static
    private static char[][] pista;//static porque pertenece a la clase, no a una posible instancia.
    private final char trap;
    private final char booster;
    private final int longitudPistaCorta;
    private final int longitudPistaMedia;
    private final int longitudPistaLarga;
    private final int[] longitudesPistas;

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Pista(int numeroDeJugadores) {
        this.trap = '«';
        this.booster = '»';
        this.posicionJugador1 = 0;
        this.posicionJugador2 = 0;
        this.longitudPistaCorta = 75;
        this.longitudPistaMedia = 100;
        this.longitudPistaLarga = 150;
        this.numeroDeVehiculos = numeroDeJugadores;
        Pista.vehiculos = new char[numeroDeJugadores + 1];
        this.posicionesVehiculos = new int[numeroDeJugadores + 1];//+1 porque en la posición 1 esta el jugador
        this.longitudesPistas = new int[]{longitudPistaCorta, longitudPistaMedia, longitudPistaLarga};
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de crear la pista del juego y agregar los vehículos en
     * las posiciones iniciales.
     *
     * @param filas - Número de vehículos que habrá en el juego
     * @param columnas - longitud de la pista
     */
    private void crearPista(int filas, int columnas) {// Método encargado de crear una pista segun filas y columnas.
        pista = new char[filas + 1][columnas];
        tamañoPista = pista[0].length;
        for (char[] pista1 : pista) {
            for (int j = 0; j < pista1.length; j++) {
                pista1[j] = ' ';//RELLENA LA PISTA CON ' ' para ahorrar memoria
            }
        }
        agregarVehiculos();//Agrega los vehículos ya sean computadora o jugador rival
    }

    /**
     * Método encargado de mostrar la pista
     */
    protected void mostrarPista() {// Método encargado de mostrar la pista en consola
        System.out.println(AZUL + "PISTA:" + RESETEAR_COLOR);
        for (char[] pista1 : pista) {//i = filas
            for (int j = 0; j < pista1.length; j++) {//j = columnas
                System.out.print(pista1[j]);//print para que no salte de linea
            }
            System.out.println("|");//fin de la pista (al ser char sin espacios, no se miraría la meta xd)
        }
    }

    /**
     * Método encargado de modificar la pista, como agregar los boster,
     * vehículos, traps, etc
     *
     * @param modificacion - carácter que se implementará
     * @param fila - fila donde se pondrá
     * @param columna - columna donde se pondrá
     */
    private void modificarPista(char modificacion, int fila, int columna) {//Método encargado de modificar la pista
        for (char[] pista1 : pista) {
            for (int j = 0; j < pista1.length; j++) {
                if (fila < pista.length && columna < pista[0].length) {// Verifica que el tamaño de la fila y la columna sean los adecuados (= no porque no tendría sentido que estuviera en la meta.)
                    if (pista[fila][columna] == ' ') {//verifica que no hayan vehiculos, traps o boosters
                        pista[fila][columna] = modificacion;//implementa la modificación
                    }
                }
            }
        }
    }

    /**
     * Método encargado de añadir los bosters o trapas de manera aleatoria
     * verificando si es posible
     */
    private void añadirBoostersOTraps() {//Método encargado de implementar los booster y traps de forma aleatoria.
        boolean modificacionesActivadas;// Se asegura que los boosters o traps no cambien durante toda la partida.
        int limiteDeFilas = MotorDelJuego.cantidadDeRivales + 1;//+1 por el jugador.
        int limiteDeColumnas = pista[0].length;// para evitar el arrayindexofboundexception
        do {//do while para que sea solo una vez
            int numeroDeBoosters = random.nextInt(1, 7);//[1,6)
            int numeroDeTraps = random.nextInt(1, 7);//[1,6)
            for (char[] pista1 : pista) {
                for (int i = 0; i < numeroDeBoosters; i++) {//Implementa los boosters en la pista
                    modificarPista(booster, random.nextInt(0, limiteDeFilas), random.nextInt(0, limiteDeColumnas));//Fila [0,3] Columnas [0,150) con tres rivales
                }
                for (int i = 0; i < numeroDeTraps; i++) {//Implementa los traps
                    modificarPista(trap, random.nextInt(0, limiteDeFilas), random.nextInt(0, limiteDeColumnas));//Fila [0,2] Columnas [0,150)
                }
            }
            modificacionesActivadas = true;
        } while (modificacionesActivadas == false);
    }

    /**
     * Método encargado de elegir la pista o crear una
     */
    protected void elegirPista() {//poquito de producción
        System.out.println("                                        ┌------------------------------------------------┐");
        System.out.println("                                        |             ¿QUÉ PISTA DESEA USAR?             |");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ¦ [1]        Pista corta ( 75 metros)            ¦");
        System.out.println("                                        ¦ [2]        Pista Media (100 metros)            ¦");
        System.out.println("                                        ¦ [3]        Pista Larga (150 metros)            ¦");
        System.out.println("                                        ¦ [4]              Crear Pista                   ¦");
        System.out.println("                                        ¦ [5]                Regresar                    ¦");
        System.out.println("                                        ¦ [6]             Salir del juego                ¦");
        System.out.println("                                        ¦                                                ¦");
        System.out.println("                                        ├------------------------------------------------┤");
        System.out.println("                                        ¦            -Seleccione una opción-             ¦");
        System.out.println("                                        └------------------------------------------------┘");
        int opcionPista = scanner.nextInt();
        scanner.nextLine();
        switch (opcionPista) {
            case 1 -> {
                crearPista(MotorDelJuego.cantidadDeRivales, longitudesPistas[0]);
            }
            case 2 -> {
                crearPista(MotorDelJuego.cantidadDeRivales, longitudesPistas[1]);
            }
            case 3 -> {
                crearPista(MotorDelJuego.cantidadDeRivales, longitudesPistas[2]);
            }
            case 4 -> {
                System.out.println("Ingrese los metros de la pista:");
                int longitudPista = Integer.parseInt(scanner.nextLine());
                if (longitudPista < 0 || longitudPista > 500) {
                    System.out.println("Debes crear una pista mayor a 50 metros y menor a 500");
                    elegirPista();
                } else {
                    crearPista(MotorDelJuego.cantidadDeRivales, longitudPista);
                }
            }
            case 5 -> {
                new Carreras().irAlMenuPrincipal();
            }
            case 6 -> {
                System.exit(0);
            }
            default -> {
                System.out.println("Elige una pista adecuada.");
                elegirPista();
            }
        }
    }

    /**
     * Método encargado de agregar los vehículos de los x que valla a elegir el
     * jguador.
     */
    private void agregarVehiculos() {//Método encargado de agregar los x vehículos según el jugador seleccione jugar con rival (agrega 2) o jugar contra máquina (agrega x+1 rivales)
        if (Carreras.opcionMenu == 1) {//jugar contra computadora.
            jugador1 = Carreras.jugadorUno.charAt(0);//convierte la primera letra del nombre del jugador 1 en un char
            posicionJugador1 = 0;//La posición del jugador es 0 (porque es inicial)
            modificarPista(jugador1, 0, 0);//Coloca al jugador 1 en la pista
            for (int i = 1; i < numeroDeVehiculos + 1; i++) {//Agrega los n vehículos que el jugador haya elegido.
                char elementoAAgregar = Carreras.computadora[random.nextInt(0, 10)];//Asigna un nombre random (numero para distinguir que sea computadora) a un vehículo
                pista[i][0] = elementoAAgregar;//agrega el vehículo i en la fila i (1 pq la 0 es del jugador) y en la columna 0 (inicio)
                posicionesVehiculos[i] = 0;//Coloca todas las posiciones del vehículo en la posición inicial (0)
                vehiculos[i - 1] = elementoAAgregar;//rellena el array de vehículos con los seleccionados para poder usarlos luego para avanzar.
            }
            añadirBoostersOTraps();//Rellena toda la pista con los boosters y traps
        } else if (Carreras.opcionMenu == 2) {//jugar contra rival
            jugador1 = Carreras.jugadorUno.charAt(0);//convierte la primera letra del nombre del jugador 1 en un char
            jugador2 = Carreras.jugadorDos.charAt(0);//convierte la primera letra del nombre del jugador 2 en un char
            modificarPista(jugador1, 0, 0);//Coloca al jugador 1 en la pista
            modificarPista(jugador2, 1, 0);//Coloca al jugador 2 en la pista
            posicionJugador1 = 0;//pone las posiciones del jugador 1 de la pista
            posicionJugador2 = 0;//pone las posiciones del jugador 2 de la pista
            añadirBoostersOTraps();// Añade los booster y traps.
        }
    }

    /**
     * Método encargado de mover el vehículo del jugador o los jugadores y
     * verificar si han llegado a la meta.
     *
     * @param resultadoDado - avanse que tendrán los jugadores.
     */
    protected void moverVehiculoJugador(int resultadoDado) {//Método encargado de mover los vehículos de los jugadores (Humanos)
        if (verificarJuegoTerminado() == false) {
            if (Carreras.opcionMenu == 1) {//opcion 1 = jugar contra computadora
                pista[0][posicionJugador1] = ' ';// Limpia la posición del jugador 1
                posicionJugador1 += resultadoDado;// Renueva la posición del jugador con el resultado de los dados
                System.out.println(AZUL + " -------------------- El jugador avanza " + resultadoDado + " metros -------------------- " + RESETEAR_COLOR);
                System.out.println("Le hacen falta " + Math.max(0, pista[0].length - posicionJugador1) + " metros");
                if (posicionJugador1 >= pista[0].length) {//Verifica si el jugador 1 no ha salido de la pista (Evita una exception)
                    posicionJugador1 = pista[0].length - 1;
                }
                pista[0][posicionJugador1] = jugador1;//Pone el vehículo del jugador en la posición que le corresponde.
            } else if (Carreras.opcionMenu == 2) {//opcion 2 jugar contra rival
                pista[0][posicionJugador1] = ' ';//Límpia la posición del jugador 1
                int avance = random.nextInt(0, resultadoDado);
                posicionJugador1 += avance;// Renueva la posición del jugador 1
                System.out.println(AZUL + " -------------------- El jugador 1 avanza " + avance + " metros -------------------- " + RESETEAR_COLOR);
                System.out.println("Al jugador 1 le hacen falta " + Math.max(0, pista[0].length - posicionJugador1) + " metros");
                if (posicionJugador1 >= pista[0].length) {// Verifica que el jugador 1 no haya salido de la pista.
                    posicionJugador1 = pista[0].length - 1;
                }
                pista[0][posicionJugador1] = jugador1;
                //--------------------------------------------------------------
                pista[1][posicionJugador2] = ' ';
                int avance2 = random.nextInt(0, resultadoDado);
                posicionJugador2 += avance2;
                System.out.println(AZUL + " -------------------- El jugador 2  avanza " + avance2 + " metros -------------------- " + RESETEAR_COLOR);
                System.out.println("Al jugador 2 le hacen falta " + Math.max(0, pista[0].length - posicionJugador2) + " metros");
                if (posicionJugador2 >= pista[0].length) {
                    posicionJugador2 = pista[0].length - 1;
                }
                pista[1][posicionJugador2] = jugador2;
            }
            if (posicionJugador1 >= pista[0].length - 1 || posicionJugador2 >= pista[0].length - 1) {
                setContadorHumanoGanadorCarreras(+1);
            }
        }
    }

    /**
     * Método encargado de mover los vehículos de manera aleatoria
     *
     * @param resultadoDados - avance que tendrán los vehículos (según un
     * random) para que varie
     */
    protected void moverVehiculosAleatorios(int resultadoDados) {//Método encargado de mover los vehículos de manera aleatoria.
        if (verificarJuegoTerminado() == false) {
            System.out.println(AZUL + " -------------------- VEHÍCULOS -------------------- " + RESETEAR_COLOR);
            for (int i = 1; i <= numeroDeVehiculos; i++) {// for para poder mover los i+1 vehículos (máquina)
                pista[i][posicionesVehiculos[i]] = ' ';// Resetea las posiciones atuales de los vehículos
                int avanceAleatorio = random.nextInt(0, resultadoDados - 1) * 2;//Define un avance aleatorio para el vehículo i+1
                posicionesVehiculos[i] += avanceAleatorio;// Guarda la posición del vehículo i+1 con el avance aleatorio
                System.out.println("El vehículo: " + i + " '" + vehiculos[i] + "'" + " avanzó " + avanceAleatorio + " metros " + "le hacen falta " + Math.max(0, pista[0].length - posicionesVehiculos[i]));
                if (posicionesVehiculos[i] >= pista[0].length) {//Verifica si ningún vehículo ha sobrepasado la meta o se encuentra en ella
                    posicionesVehiculos[i] = pista[0].length - 1;// evita la exception
                    System.out.println("El vehículo " + (i) + " llegó a la meta " + Carreras.jugadorUno + " perdió");
                }
                pista[i][posicionesVehiculos[i]] = vehiculos[i];// Mueve los vehículos en la posición asignada
            }
        }
    }

    /**
     * Método encargado de verificar si el juego ha terminado.
     *
     * @return true si el juego ha terminado
     */
    protected boolean verificarJuegoTerminado() {
        for (int i = 0; i < pista.length; i++) {
            for (int j = 0; j < pista[i].length; j++) {
                if ((posicionJugador1 == pista[0].length && posicionJugador2 == pista[0].length)
                        || (posicionJugador1 == pista[0].length && getPosicionVehiculo(i) == pista[0].length)
                        || (posicionJugador2 == pista[0].length && getPosicionVehiculo(i) == pista[0].length)) { // POR SI HAY EMPATE
                    System.out.println("LOS JUGADORES HAN EMPATADOOOOOOO");
                    return true;
                }
                if (posicionJugador1 >= pista[0].length - 1) { // POR SI GANA EL JUGADOR 1
                    System.out.println("El jugador " + Carreras.jugadorUno + " es el ganador.");
                    return true;
                }
                if (posicionJugador2 >= pista[0].length - 1) { //POR SI GANA EL JUGADOR 2
                    System.out.println("El jugador " + Carreras.jugadorDos + " es el ganador.");
                    return true;
                }
                if (getPosicionVehiculo(i) >= pista[0].length - 1) { // POR SI GANA UN VEHÍCULO
                    System.out.println("El vehículo " + i + " '" + Carreras.computadora[i] + "' es el ganador.");
                    setContadorComputadoraGanadoraCarreras(+1);
                    return true;
                }
            }
        }
        return false;
    }

    // GETTERS -----------------------------------------------------------------
    public int getPosicionVehiculo(int indiceVehiculo) {
        if (indiceVehiculo == 0) {
            return posicionJugador1;
        } else {
            return posicionesVehiculos[indiceVehiculo];
        }
    }

    public int getPosicionJugador1() {
        return posicionJugador1;
    }

    public int getPosicionJugador2() {
        return posicionJugador2;
    }

    public static char[][] getPista() {
        return pista;
    }

    public int getTamañoPista() {
        return tamañoPista;
    }

}
