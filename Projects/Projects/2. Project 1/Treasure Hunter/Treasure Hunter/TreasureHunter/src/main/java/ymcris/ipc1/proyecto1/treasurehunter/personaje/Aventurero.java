package ymcris.ipc1.proyecto1.treasurehunter.personaje;

import java.io.File;
import java.util.Scanner;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.crearArchivo;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.rutaCarpetaJugadores;
import static ymcris.ipc1.proyecto1.treasurehunter.archivos.Archivos.añadirTextoEnArchivo;

/**
 * SubClase encargada de crear aventureros y de realizar sus acciones durante
 * una batalla
 *
 * @author YmCris
 * @see Personaje
 * @since Mar 13, 2025
 */
public final class Aventurero extends Personaje {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private File archivoJugador;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private int batallas;
    private int vidaTotal;
    private int manaTotal;
    private int filaJugador;
    private int columnaJugador;
    private int batallasHuidas;
    private int batallasGanadas;
    private int batallasPerdidas;
    private int cantidadMovimientos;
    private int vidaPrevioAUnaBatalla;
    private int manaPrevioAUnaBatalla;
    private int defensaPrevioAUnaBatalla;
    private boolean haEncontradoTesoro;
    private boolean haPerdido;

    // INSTANCIAS --------------------------------------------------------------
    Scanner scanner = new Scanner(System.in);

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public Aventurero(String nombre, boolean haEncontradoTesoro, int cantidadMovimientos, int batallas, int batallasGanadas, int batallasPerdidas, int batallasHuidas, boolean haPerdido, int vida,
            int vidaPrevioAUnaBatalla, int vidaTotal, int mana, int manaPrevioAUnaBatalla, int manaTotal, int ataque, int defensa, int defensaPrevioAUnaBatalla, int filaJugador, int columnaJugador,
            File archivoJugador) {
        super(vida, mana, ataque, defensa, nombre);
        this.batallas = batallas;//
        this.vidaTotal = vidaTotal;//
        this.manaTotal = manaTotal;//
        this.filaJugador = filaJugador;//
        this.columnaJugador = columnaJugador;//
        this.batallasHuidas = batallasHuidas;//
        this.archivoJugador = archivoJugador;//
        this.batallasGanadas = batallasGanadas;//
        this.batallasPerdidas = batallasPerdidas;//
        this.cantidadMovimientos = cantidadMovimientos;//
        this.vidaPrevioAUnaBatalla = vidaPrevioAUnaBatalla;//
        this.manaPrevioAUnaBatalla = manaPrevioAUnaBatalla;//
        this.defensaPrevioAUnaBatalla = defensaPrevioAUnaBatalla;//
        this.haEncontradoTesoro = haEncontradoTesoro;///
        this.haPerdido = haPerdido;
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de mostrar las características más importantes del
     * aventurero.
     */
    public void mostrarEstadoAventurero() {
        System.out.println("                    ..........................................................................................");
        System.out.println("                                    Las estadísticas del aventurero " + this.getNombre() + " son:");
        System.out.println("                    ..........................................................................................");
        System.out.println("                        Vida: " + this.getVida() + "/" + this.getVidaPrevioAUnaBatalla() + "/" + this.getVidaTotal());
        System.out.println("                        Mana: " + this.getMana() + "/" + this.getManaPrevioAUnaBatalla() + "/" + this.getManaMaximo());
        System.out.println("                        Ataque: " + this.getAtaque());
        System.out.println("                        Defensa: " + this.getDefensa());
        System.out.println("                        Símbolo: " + this.getSimbolo());
        System.out.println("                        Posición Aventurero: [" + filaJugador + "][" + columnaJugador + "]");
        System.out.println("                        Batallas Tenidas: " + this.getBatallas());
        System.out.println("                        Movimientos Realizados: " + this.getCantidadMovimientos());
        System.out.println("                    ..........................................................................................");
        System.out.println("");
        System.out.println("Presione enter para continuar:");
        scanner.nextLine();
    }

    /**
     * Método encargado de aumentar la defensa del jugador.
     *
     */
    public void defender() {
        if (this.getMana() >= 1) {//Verifica si tiene mana para defenderse 
            int defensaAAumentar = (int) (this.getDefensa() + this.getDefensa() * 0.5);//Aumenta su defensa según la fórmula
            this.setDefensa(defensaAAumentar);
            this.setMana(this.getMana() - 1);//quita mana
            System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + this.getNombre() + " tu defensa ha aumentado " + this.getDefensa() * 0.5 + ", tienes " + this.getDefensa() + " puntos de defensa" + CYAN + " ------------------------- " + RESETEAR);
        } else {//no tiene mana
            System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + this.getNombre() + " no tienes el mana suficiente" + CYAN + " ------------------------- " + RESETEAR);
        }
    }

    /**
     * Método encargado de curar al personaje
     */
    public void curar() {
        if (this.getMana() >= 1) {//Verifiaca si tiene mana
            int cantidadACurar = random.nextInt(0, 30);//Se cura según el rango de la fórmula
            this.setVida(this.getVida() + cantidadACurar);
            this.setMana(this.getMana() - 1);
            System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + this.getNombre() + " te has curado " + cantidadACurar + " de vida, tienes " + this.getVida() + " puntos de vida" + CYAN + " ------------------------- " + RESETEAR);
        } else {//no tiene mana
            System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + this.getNombre() + " no tienes el mana suficiente" + CYAN + " ------------------------- " + RESETEAR);
        }
    }

    /**
     * Método encargado de actualizar la información del jugador en el archivo
     * borrandolo y volviendolo a crear para evitar problemas de
     * sobreescribimiento
     */
    public void guardarAvanceEnArchivo() {
        //0. si existe el archivo del jugador lo borra (Mejor reescribirlo que intendar editar línea por línea)
        if (archivoJugador.exists()) {
            archivoJugador.delete();//Elimina el archivo
        }
        //1. Recrea el archivo del jugador
        this.archivoJugador = crearArchivo(this.getNombre().toLowerCase(), rutaCarpetaJugadores);//Lo vuelve a crear (osea lo hace para que este vacio)
        if (archivoJugador.exists()) {//Verifica que si exista
            //2. Rellena el archivo del jugador con su getters en las líneas correspondientes
            añadirTextoEnArchivo(this.getNombre(), archivoJugador);//0 nombre del jugador
            añadirTextoEnArchivo(String.valueOf(haEncontradoTesoro), archivoJugador);//1 haEcontrado el tesoro si ha ganado (Encontro el tesoro) 
            añadirTextoEnArchivo(String.valueOf(this.getCantidadMovimientos()), archivoJugador);//2. numero de movimientos 
            añadirTextoEnArchivo(String.valueOf(this.getBatallas()), archivoJugador);//3. Cantidad de combates 
            añadirTextoEnArchivo(String.valueOf(this.getBatallasGanadas()), archivoJugador);//4. combates ganados 
            añadirTextoEnArchivo(String.valueOf(this.getBatallasPerdidas()), archivoJugador);//5. combates perdidos 
            añadirTextoEnArchivo(String.valueOf(this.batallasHuidas), archivoJugador);//6. combates huidos
            añadirTextoEnArchivo(String.valueOf(this.isHaPerdido()), archivoJugador);//7. haPerdido(Se ha quedado sin vida por trampas o penalizaciones)
            añadirTextoEnArchivo(String.valueOf(this.getVida()), archivoJugador);//8. Vida
            añadirTextoEnArchivo(String.valueOf(this.getVidaPrevioAUnaBatalla()), archivoJugador);//9. Vida previo a un combate
            añadirTextoEnArchivo(String.valueOf(this.getVidaTotal()), archivoJugador);//10. vida total
            añadirTextoEnArchivo(String.valueOf(this.getMana()), archivoJugador);//11. mana
            añadirTextoEnArchivo(String.valueOf(this.getManaPrevioAUnaBatalla()), archivoJugador);//12. mana previo a un combate
            añadirTextoEnArchivo(String.valueOf(this.getManaMaximo()), archivoJugador);//13. mana total
            añadirTextoEnArchivo(String.valueOf(this.getAtaque()), archivoJugador);//14. ataque
            añadirTextoEnArchivo(String.valueOf(this.getDefensa()), archivoJugador);//15. defensa
            añadirTextoEnArchivo(String.valueOf(this.getDefensaPrevioAUnaBatalla()), archivoJugador);//16. defensa previo  a un combate
            añadirTextoEnArchivo(String.valueOf(this.getFilaJugador()), archivoJugador);//14. fila jugador
            añadirTextoEnArchivo(String.valueOf(this.getColumnaJugador()), archivoJugador);//15. columna jugador
            System.out.println("Se ha guardado el avance de la partida");
        }
        //3. Ya
    }

    // GETTERS & SETTERS -------------------------------------------------------
    public int getBatallas() {
        return batallas;
    }

    public void setBatallas(int batallas) {
        this.batallas = batallas;
    }

    public int getVidaTotal() {
        return vidaTotal;
    }

    public void setVidaTotal(int vidaMaxima) {
        this.vidaTotal = vidaMaxima;
    }

    public int getManaMaximo() {
        return manaTotal;
    }

    public void setManaMaximo(int manaMaximo) {
        this.manaTotal = manaMaximo;
    }

    public int getBatallasHuidas() {
        return batallasHuidas;
    }

    public void setBatallasHuidas(int batallasHuidas) {
        this.batallasHuidas = batallasHuidas;
    }

    public int getBatallasGanadas() {
        return batallasGanadas;
    }

    public void setBatallasGanadas(int batallasGanadas) {
        this.batallasGanadas = batallasGanadas;
    }

    public int getBatallasPerdidas() {
        return batallasPerdidas;
    }

    public void setBatallasPerdidas(int batallasPerdidas) {
        this.batallasPerdidas = batallasPerdidas;
    }

    public int getCantidadMovimientos() {
        return cantidadMovimientos;
    }

    public void setCantidadMovimientos(int cantidadMovimientos) {
        this.cantidadMovimientos = cantidadMovimientos;
    }

    public int getVidaPrevioAUnaBatalla() {
        return vidaPrevioAUnaBatalla;
    }

    public void setVidaPrevioAUnaBatalla(int vidaPrevioAUnaBatalla) {
        this.vidaPrevioAUnaBatalla = vidaPrevioAUnaBatalla;
        if (this.vidaPrevioAUnaBatalla <= 0) {
            this.vidaPrevioAUnaBatalla = 0;
        }
    }

    public int getManaPrevioAUnaBatalla() {
        return manaPrevioAUnaBatalla;
    }

    public void setManaPrevioAUnaBatalla(int manaPrevioAUnaBatalla) {
        this.manaPrevioAUnaBatalla = manaPrevioAUnaBatalla;
        if (this.manaPrevioAUnaBatalla <= 0) {
            this.manaPrevioAUnaBatalla = 0;
        }
    }

    public int getDefensaPrevioAUnaBatalla() {
        return defensaPrevioAUnaBatalla;
    }

    public void setDefensaPrevioAUnaBatalla(int defensaPrevioAUnaBatalla) {
        this.defensaPrevioAUnaBatalla = defensaPrevioAUnaBatalla;
    }

    public int getFilaJugador() {
        return filaJugador;
    }

    public void setFilaJugador(int filaJugador) {
        this.filaJugador = filaJugador;
    }

    public int getColumnaJugador() {
        return columnaJugador;
    }

    public void setColumnaJugador(int columnaJugador) {
        this.columnaJugador = columnaJugador;
    }

    public boolean isHaEncontradoTesoro() {
        return haEncontradoTesoro;
    }

    public void setHaEncontradoTesoro(boolean haEncontradoTesoro) {
        this.haEncontradoTesoro = haEncontradoTesoro;
    }

    public boolean isHaPerdido() {
        return haPerdido;
    }

    public void setHaPerdido(boolean haPerdido) {
        this.haPerdido = haPerdido;
    }

}
