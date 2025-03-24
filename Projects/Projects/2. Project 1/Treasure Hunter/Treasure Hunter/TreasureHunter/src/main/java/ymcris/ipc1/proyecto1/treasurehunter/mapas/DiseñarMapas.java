package ymcris.ipc1.proyecto1.treasurehunter.mapas;

import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.Casillas;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaMuro;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaPista;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaTesoro;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaTrampa;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaEnergia;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaEnemigos;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaPersonaje;
import ymcris.ipc1.proyecto1.treasurehunter.casillas.CasillaTeletransporte;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.ROJO;
import static ymcris.ipc1.proyecto1.treasurehunter.TreasureHunter.aventurero;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.añadirTextoEnArchivo;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.crearArchivo;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.rutaCarpetaMapas;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import static ymcris.ipc1.proyecto1.treasurehunter.exception.EntradaNoValidaException.errorEncontrado;

/**
 * Clase encargada de crear y dieñar las casillas y los mapas.
 *
 * @author YmCris
 * @since Mar 18, 2025
 */
public class DiseñarMapas {

    // --------------------- VARIABLES DE REFERENCIA ---------------------------
    private Mapas mapaCreado;
    private File archivoMapa;
    private String nombreMapa;
    private CasillaTesoro casillaTesoro;
    private CasillaPersonaje casillaAventurero;
    // ----------------------- VARIABLES PRIMITIVAS ----------------------------
    private int filaTesoro;
    private int filaJugador;
    private int columnaTesoro;
    private int numeroDeFilas;
    private int columnaJugador;
    private int numeroDeColumnas;
    private int cantidadCasillasPista;
    private int cantidadCasillasTrampa;
    private int cantidadCasillasEnergia;
    private int cantidadCasillasEnemigos;
    private int cantidadCasillasTeletransporte;
    // ----------------------------- INSTANCIAS --------------------------------
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    // ----------------------------- MÉTODOS -----------------------------------
    /**
     * Método encargado de crear un nuevo mapa
     *
     * @return retorna el mapa modificado
     */
    public Mapas preguntarCaracteristicasMapa() {
        //0. Preguntar las características (Parámetros del mapa)
        try {
            do {
                System.out.println("\n".repeat(100));
                //0. Preguntar detalles del mapa
                System.out.println(ROJO + "MAPA" + RESETEAR);
                System.out.println("· INGRESE EL NOMBRE DEL MAPA:");//Preguntar el nombre del mapa
                this.nombreMapa = scanner.nextLine();
                System.out.println("· INGRESE EL NÚMERO DE FILAS DEL MAPA:");//Preguntar el número de filas
                this.numeroDeFilas = scanner.nextInt();
                System.out.println("· INGRESE EL NÚMERO DE COLUMNAS DEL MAPA:");//Preguntar el número de columnas
                this.numeroDeColumnas = scanner.nextInt();
                System.out.println("\n".repeat(100));
                //1. Preguntar detalles del tesoro
                System.out.println(ROJO + "TESORO" + RESETEAR);
                System.out.println("· INGRESE LA FILA EN LA QUE SE ENCONTRARÁ EL TESORO:");//Preguntar la fila del tesoro
                this.filaTesoro = scanner.nextInt();
                System.out.println("· INGRESE LA COLUMNA EN LA QUE SE ENCONTRARÁ EL TESORO:");//Preguntar la columnas del tesoro
                this.columnaTesoro = scanner.nextInt();
                System.out.println("\n".repeat(100));
                //2. Preguntar detalles del jugador
                System.out.println(ROJO + "AVENTURERO" + RESETEAR);
                System.out.println("· INGRESE LA FILA EN LA QUE SE ENCONTRARÁ EL AVENTURERO:");//Preguntar la fila del jugador
                this.filaJugador = scanner.nextInt();
                aventurero.setFilaJugador(filaJugador);
                System.out.println("· INGRESE LA COLUMNA EN LA QUE SE ENCONTRARÁ EL AVENTURERO:");//Preguntar la columna del jugador
                this.columnaJugador = scanner.nextInt();
                aventurero.setColumnaJugador(columnaJugador);
            } while (tieneErrores() == true);//3. Validaciones
        } catch (InputMismatchException e) {
            errorEncontrado();
            TreasureHunter inicio = new TreasureHunter();
            inicio.verMenuPrincipal();
        }
        archivoMapa = crearArchivo(this.nombreMapa, rutaCarpetaMapas);
        añadirTextoEnArchivo(nombreMapa, archivoMapa);
        añadirTextoEnArchivo(String.valueOf(numeroDeFilas), archivoMapa);
        añadirTextoEnArchivo(String.valueOf(numeroDeColumnas), archivoMapa);
        añadirTextoEnArchivo(String.valueOf(filaTesoro), archivoMapa);
        añadirTextoEnArchivo(String.valueOf(columnaTesoro), archivoMapa);
        añadirTextoEnArchivo(String.valueOf(filaJugador), archivoMapa);
        añadirTextoEnArchivo(String.valueOf(columnaJugador), archivoMapa);
        this.casillaAventurero = new CasillaPersonaje(filaJugador, columnaJugador, aventurero);
        this.casillaTesoro = new CasillaTesoro(filaTesoro, columnaTesoro);
        this.mapaCreado = new Mapas(nombreMapa, numeroDeFilas, numeroDeColumnas, casillaTesoro, casillaAventurero);
        this.mapaCreado.crearTablero();
        this.mapaCreado.modificarMapas(filaTesoro, columnaTesoro, casillaTesoro);
        this.mapaCreado.modificarMapas(filaJugador, columnaJugador, casillaAventurero);
        diseñarMapas();
        return this.mapaCreado;
    }

    /**
     * Método encargado de verificar que todos los atributos esten tengan las
     * dimensiones correctas.
     */
    private boolean tieneErrores() {
        boolean nombreMapaVacio = nombreMapa.isBlank();
        boolean dimensionesInvalidas = numeroDeFilas < 25 || numeroDeColumnas < 25;
        boolean tesoroFueraDeRango = filaTesoro < 0 || filaTesoro >= numeroDeFilas || columnaTesoro < 0 || columnaTesoro >= numeroDeColumnas;
        boolean tesoroYJugadorFueradeRango = filaJugador == filaTesoro && columnaTesoro == columnaJugador;
        boolean jugadorFueraDeRango = filaJugador < 0 || filaJugador >= numeroDeFilas || columnaJugador < 0 || columnaJugador >= numeroDeColumnas;
        if (nombreMapaVacio || dimensionesInvalidas || tesoroFueraDeRango || jugadorFueraDeRango || tesoroYJugadorFueradeRango) {
            System.out.println("No has introducido correctamente alguno de los siguientes datos:");
            if (nombreMapaVacio) {
                System.out.println("0) El mapa no puede tener un nombre vacio");
            }
            if (dimensionesInvalidas) {
                System.out.println("1) El mapa debe ser de al menos 25x25.");
            }
            if (tesoroFueraDeRango) {
                System.out.println("2) La posición del tesoro debe estar dentro del rango del mapa");
            }
            if (jugadorFueraDeRango) {
                System.out.println("3) La posición del jugador debe estar dentro del rango del mapa");
            }
            if (tesoroYJugadorFueradeRango) {
                System.out.println("4) La posición del jugador y del tesoro deben ser distintas");
            }
            System.out.println("");
            System.out.println("Vuelve a intentarlo evitando estos errores.");
            errorEncontrado();
            scanner.nextLine();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método encargado de diseñar el mapa con las casillas.
     *
     * @return mapaCreado
     */
    public Mapas diseñarMapas() {
        try {//Crea las casillas
            System.out.println("\n".repeat(100));
            System.out.println(ROJO + "DISEÑO DE CASILLAS" + RESETEAR);
            System.out.println("Durante la creación de las casillas asegurate de:");
            System.out.println("1. Ingresar un número");
            System.out.println("2. No ingresar cantidades negativas, ni 0, ni muy grandes");
            System.out.println("3. Si no eliges una opción dada entre [1] o [2], se tomará la segunda");
            System.out.println("Presione enter para continuar");
            scanner.nextLine();
            scanner.nextLine();
            diseñarCasillasMuros();//casillas muro
            diseñarCasillasTrampa();//casillas trampa
            diseñarCasillasPista();//casillas pista
            diseñarCasillasTeletransporte();//casilla teletransporte
            diseñarCasillasEnergia();//casillas energía
            diseñarCasillasEnemigos();//casillas enemigo
        } catch (InputMismatchException e) {
            System.out.println("Debes introducir un valor numérico");
            errorEncontrado();
            scanner.nextLine();
            diseñarMapas();
        }
        return this.mapaCreado;
    }

    /**
     * Método encargado de diseñar casillas trampa, pidiendo todos sus
     * paramétros necesarios y validando que sean correctos.
     */
    private void diseñarCasillasTrampa() throws InputMismatchException {
        boolean quitaVida = false;
        System.out.println("\n".repeat(100));
        System.out.println(ROJO + "CASILLAS TRAMPA" + RESETEAR);
        System.out.println("¿Cuántas casillas trampa desea tener?");
        cantidadCasillasTrampa = scanner.nextInt();
        if (sobrepasaElLimiteCantidadCasillas(cantidadCasillasTrampa)) {
            diseñarCasillasTrampa();
        } else {
            System.out.println("Elija el efecto de la trampa");
            System.out.println("[1] Quitar vida  [2] Quitar mana");
            quitaVida = scanner.nextInt() == 1;
            System.out.println("¿Cuántos puntos va a quitar?");
            int puntosAQuitar = scanner.nextInt();
            if (puntosAQuitar <= 0) {
                System.out.println("No puedes quitar puntos negativos o 0");
                errorEncontrado();
                diseñarCasillasTrampa();
            } else {
                añadirTextoEnArchivo(String.valueOf(cantidadCasillasTrampa), archivoMapa);
                añadirTextoEnArchivo(String.valueOf(puntosAQuitar), archivoMapa);
                añadirTextoEnArchivo(String.valueOf(quitaVida), archivoMapa);
                for (int i = 0; i < cantidadCasillasTrampa; i++) {
                    CasillaTrampa trampa = new CasillaTrampa(cantidadCasillasTrampa, puntosAQuitar, quitaVida);
                    int filaRandom = calcularFilaRandom();
                    int columnaRandom = calcularColumnaRandom();
                    trampa.setFila(filaRandom);
                    trampa.setColumna(columnaRandom);
                    agregarCasillasMapa(trampa, filaRandom, columnaRandom);
                }
            }
        }
    }

    /**
     * Método encargado de diseñar casillas pista, pidiendo todos sus paramétros
     * necesarios y validando que sean correctos.
     */
    private void diseñarCasillasPista() throws InputMismatchException {
        boolean esDireccional;
        System.out.println("\n".repeat(100));
        System.out.println(ROJO + "CASILLAS PISTA" + RESETEAR);
        System.out.println("¿Cuántas casillas Pista desea tener?");
        cantidadCasillasPista = scanner.nextInt();
        if (sobrepasaElLimiteCantidadCasillas(cantidadCasillasPista)) {
            diseñarCasillasPista();
        } else {
            System.out.println("¿Desea que la pista sea direccional (Norte, sur, este, oeste, noreste, noroesete, sureste, suroeste) o de aproximación (muy cerca, cerca, medio, lejos, muy lejos, super lejos)?");
            System.out.println("[1] Pista direccional  [2] Pista de aproximación");
            esDireccional = scanner.nextInt() == 1;
            añadirTextoEnArchivo(String.valueOf(cantidadCasillasPista), archivoMapa);
            añadirTextoEnArchivo(String.valueOf(esDireccional), archivoMapa);
            for (int i = 0; i < cantidadCasillasPista; i++) {
                CasillaPista pista = new CasillaPista(cantidadCasillasPista, esDireccional);
                int filaRandom = calcularFilaRandom();
                int columnaRandom = calcularColumnaRandom();
                pista.setFila(filaRandom);
                pista.setColumna(columnaRandom);
                agregarCasillasMapa(pista, filaRandom, columnaRandom);
            }
        }
    }

    /**
     * Método encargado de diseñar casillas teletransporte, pidiendo todos sus
     * paramétros necesarios y validando que sean correctos.
     */
    private void diseñarCasillasTeletransporte() throws InputMismatchException {
        boolean ubicacionAleatoria = false;
        int filaTeletransporte = 0;
        int columnaTeletransporte = 0;
        System.out.println("\n".repeat(100));
        System.out.println(ROJO + "CASILLAS DE TELETRANSPORTE" + RESETEAR);
        System.out.println("¿Cuántas casillas Teletransporte desea tener?");
        cantidadCasillasTeletransporte = scanner.nextInt();
        if (sobrepasaElLimiteCantidadCasillas(cantidadCasillasTeletransporte)) {
            diseñarCasillasTeletransporte();
        } else {
            System.out.println("¿Desea que la casilla teletransporte a un lugar aleatorio?");
            System.out.println("[1] Si  [2] No");
            if (scanner.nextInt() == 1) {
                ubicacionAleatoria = true;
            } else {
                System.out.println("Ingrese la fila a la que se va a teletransportar el jugador:");
                filaTeletransporte = scanner.nextInt();
                System.out.println("Ingrese la columna a la que se va a teletransportar el jugador:");
                columnaTeletransporte = scanner.nextInt();
                if (filaTeletransporte == filaTesoro && columnaTeletransporte == columnaTesoro) {
                    System.out.println("No puedes teletransportarte a la posición del tesoro");
                    errorEncontrado();
                    diseñarCasillasTeletransporte();
                } else {
                    if (filaTeletransporte >= numeroDeFilas || columnaTeletransporte >= numeroDeColumnas || filaTeletransporte < 0 || columnaTeletransporte < 0) {
                        System.out.println("La posición a teletransportar debe de estar en el rango del mapa");
                        scanner.nextLine();
                        errorEncontrado();
                        diseñarCasillasTeletransporte();
                    }
                }
            }
            añadirTextoEnArchivo(String.valueOf(cantidadCasillasTeletransporte), archivoMapa);
            añadirTextoEnArchivo(String.valueOf(ubicacionAleatoria), archivoMapa);
            añadirTextoEnArchivo(String.valueOf(filaTeletransporte), archivoMapa);
            añadirTextoEnArchivo(String.valueOf(columnaTeletransporte), archivoMapa);
            añadirTextoEnArchivo(String.valueOf(numeroDeFilas), archivoMapa);
            añadirTextoEnArchivo(String.valueOf(numeroDeColumnas), archivoMapa);
            for (int i = 0; i < cantidadCasillasTeletransporte; i++) {
                CasillaTeletransporte teletransporte = new CasillaTeletransporte(cantidadCasillasTeletransporte, ubicacionAleatoria, filaTeletransporte, columnaTeletransporte, this.getNumeroDeFilas(), this.getNumeroDeColumnas());
                int filaRandom = calcularFilaRandom();
                int columnaRandom = calcularColumnaRandom();
                teletransporte.setFila(filaRandom);
                teletransporte.setColumna(columnaRandom);
                agregarCasillasMapa(teletransporte, filaRandom, columnaRandom);
            }
        }
    }

    /**
     * Método encargado de diseñar casillas energía, pidiendo todos sus
     * paramétros necesarios y validando que sean correctos.
     */
    private void diseñarCasillasEnergia() throws InputMismatchException {
        boolean recuperaVida;
        System.out.println("\n".repeat(100));
        System.out.println(ROJO + "CASILLAS DE ENERGÍA" + RESETEAR);
        System.out.println("¿Cuántas casillas Energía desea tener?");
        cantidadCasillasEnergia = scanner.nextInt();
        if (sobrepasaElLimiteCantidadCasillas(cantidadCasillasEnergia)) {
            diseñarCasillasEnergia();
        } else {
            System.out.println("¿Qué desea que realice la casilla de energía?");
            System.out.println("[1] Recuperar vida  [2] Recuperar mana");
            recuperaVida = scanner.nextInt() == 1;
            System.out.println("¿Cuántos puntos va a recuperar?");
            int puntosARecuperar = scanner.nextInt();
            if (puntosARecuperar <= 0) {
                System.out.println("No puedes recuperarte una cantidad menor a 0");
                errorEncontrado();
                diseñarCasillasEnergia();
            } else {
                añadirTextoEnArchivo(String.valueOf(cantidadCasillasEnergia), archivoMapa);
                añadirTextoEnArchivo(String.valueOf(puntosARecuperar), archivoMapa);
                añadirTextoEnArchivo(String.valueOf(recuperaVida), archivoMapa);
                for (int i = 0; i < cantidadCasillasEnergia; i++) {
                    CasillaEnergia energia = new CasillaEnergia(cantidadCasillasEnergia, puntosARecuperar, recuperaVida);
                    int filaRandom = calcularFilaRandom();
                    int columnaRandom = calcularColumnaRandom();
                    energia.setFila(filaRandom);
                    energia.setColumna(columnaRandom);
                    agregarCasillasMapa(energia, filaRandom, columnaRandom);
                }
            }
        }
    }

    /**
     * Método encargado de diseñar casillas enemigos, pidiendo todos sus
     * paramétros necesarios y validando que sean correctos.
     */
    private void diseñarCasillasEnemigos() throws InputMismatchException {
        int filaARetornar = 0;
        int columnaARetornar = 0;
        int puntosAQuitar = 0;
        int tipoDePuntos = 0;
        boolean puedeEscapar;
        boolean pierdePuntos = false;
        System.out.println("\n".repeat(100));
        System.out.println(ROJO + "CASILLAS DE ENEMIGOS" + RESETEAR);
        System.out.println("¿Cuántas casillas de enemigos desea tener?");
        cantidadCasillasEnemigos = scanner.nextInt();
        if (sobrepasaElLimiteCantidadCasillas(cantidadCasillasEnemigos)) {
            diseñarCasillasEnemigos();
        } else {
            System.out.println("¿El jugador puede escapar de la batalla?  [1] Si [2] No ");
            puedeEscapar = scanner.nextInt() == 1;
            System.out.println("De perder una batalla ¿Qué desea que suceda?");
            System.out.println("[1] Pierde Puntos [2] Es reubicado");
            if (scanner.nextInt() == 1) {//1. Vida 2. Mana 3. Ataque 4. Defensa
                pierdePuntos = true;
                System.out.println("¿Qué tipo de puntos se deben quitar? [1] Vida [2] Mana [3] Ataque [4] Defensa");
                tipoDePuntos = scanner.nextInt();
                if (tipoDePuntos < 1 || tipoDePuntos > 4) {
                    errorEncontrado();
                    diseñarCasillasEnemigos();
                } else {
                    System.out.println("¿Cuántos puntos debe quitar?");
                    puntosAQuitar = scanner.nextInt();
                    if (puntosAQuitar <= 0) {
                        System.out.println("No puedes quitar valores menores que 0");
                        errorEncontrado();
                        diseñarCasillasEnemigos();
                    }
                }
            } else {//Es reubicado
                System.out.println("Fila a donde será reubicado:");
                filaARetornar = scanner.nextInt();
                System.out.println("Columna a donde será reubicado:");
                columnaARetornar = scanner.nextInt();
                if (filaARetornar == filaTesoro && columnaARetornar == columnaTesoro) {
                    System.out.println("No te puedes rehubicar en la posición del tesoro");
                    errorEncontrado();
                    diseñarCasillasEnemigos();
                }
                if (filaARetornar >= numeroDeFilas || columnaARetornar >= numeroDeColumnas || filaARetornar < 0 || columnaARetornar < 0) {
                    System.out.println("La ubicacación a retornar debe estar en el rango del mapa");
                    errorEncontrado();
                    diseñarCasillasEnemigos();
                }
            }
            añadirTextoEnArchivo(String.valueOf(cantidadCasillasEnemigos), archivoMapa);
            añadirTextoEnArchivo(String.valueOf(puedeEscapar), archivoMapa);
            añadirTextoEnArchivo(String.valueOf(pierdePuntos), archivoMapa);
            añadirTextoEnArchivo(String.valueOf(filaARetornar), archivoMapa);
            añadirTextoEnArchivo(String.valueOf(columnaARetornar), archivoMapa);
            añadirTextoEnArchivo(String.valueOf(puntosAQuitar), archivoMapa);
            añadirTextoEnArchivo(String.valueOf(tipoDePuntos), archivoMapa);
            for (int i = 0; i < cantidadCasillasEnemigos; i++) {
                CasillaEnemigos enemigo = new CasillaEnemigos(cantidadCasillasEnemigos, puedeEscapar, pierdePuntos, filaARetornar, columnaARetornar, puntosAQuitar, tipoDePuntos);
                int filaRandom = calcularFilaRandom();
                int columnaRandom = calcularColumnaRandom();
                enemigo.setFila(filaRandom);
                enemigo.setColumna(columnaRandom);
                agregarCasillasMapa(enemigo, filaRandom, columnaRandom);
            }
        }
    }

    /**
     * Método encargado de diseñar casillas muros
     */
    private void diseñarCasillasMuros() {
        int numeroDeCasillas = random.nextInt(3, mapaCreado.getColumnas() + 4);
        añadirTextoEnArchivo(String.valueOf(numeroDeCasillas), archivoMapa);
        for (int i = 0; i < numeroDeCasillas; i++) {
            CasillaMuro muro = new CasillaMuro(numeroDeCasillas);
            int filaRandom = calcularFilaRandom();
            int columnaRandom = calcularColumnaRandom();
            muro.setFila(filaRandom);
            muro.setColumna(columnaRandom);
            agregarCasillasMapa(muro, filaRandom, columnaRandom);
        }
    }

    /**
     * Método encargado de verificar que el jugador no introduzca una cantidad
     * de casillas negativa
     *
     * @param cantidad - cantidad a validar
     * @return true si sale del límite
     */
    private boolean sobrepasaElLimiteCantidadCasillas(int cantidad) {
        if (cantidad <= 0 || cantidad >= (int) (numeroDeFilas * numeroDeColumnas) / 2) {//evita que no tenga casillas de un tipo o que rellene todo el mapa con un solo tipo de casillas
            System.out.println("No puedes tener esa cantidad de casillas");
            errorEncontrado();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método encaragdo de calcular una fila random basado en el límite de las
     * filas del mapa.
     *
     * @return numero random de fila
     */
    private int calcularFilaRandom() {
        return random.nextInt(0, this.getNumeroDeFilas());
    }

    /**
     * Método encaragdo de calcular una columna random basado en el límite de
     * las columnas del mapa.
     *
     * @return numero random de columna
     */
    private int calcularColumnaRandom() {
        return random.nextInt(0, this.getNumeroDeColumnas());
    }

    /**
     * Método encargado de agregar casillas a el mapa creado
     *
     * @param casillas - casilla a agregar en el mapa
     * @param fila - fila donde se agregará la casilla en el mapa
     * @param columna - columna donde se agregará la casilla en el mapa
     */
    private void agregarCasillasMapa(Casillas casillas, int fila, int columna) {
        try {
            mapaCreado.modificarMapas(fila, columna, casillas);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ha ocurrido un error grandísimo");
            new TreasureHunter().verMenuPrincipal();
        }
    }

    // GETTERS -----------------------------------------------------------------
    public int getNumeroDeFilas() {
        return numeroDeFilas;
    }

    public int getNumeroDeColumnas() {
        return numeroDeColumnas;
    }

}
