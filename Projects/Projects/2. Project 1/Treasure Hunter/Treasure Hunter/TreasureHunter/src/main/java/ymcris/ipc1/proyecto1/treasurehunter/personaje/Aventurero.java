package ymcris.ipc1.proyecto1.treasurehunter.personaje;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * SubClase encargada de crear aventureros y de realizar sus acciones durante
 * una batalla
 *
 * @author YmCris
 * @since Mar 13, 2025
 */
public class Aventurero extends Personaje {

    // VARIABLES DE REFENRENCIA ------------------------------------------------
    private final String CYAN;
    private final String RESETEAR;

    // VARIABLES PRIMITIVAS --------------------------------------------------------
    private int batallas;
    private int vidaMaxima;
    private int manaMaximo;
    private int batallasHuidas;
    private int batallasGanadas;
    private int batallasPerdidas;
    private int[][] posicionActual;
    private int[][] posicionInicial;
    private int cantidadMovimientos;
    private int vidaPrevioAUnaBatalla;
    private int manaPrevioAUnaBatalla;
    private int defensaPrevioAUnaBatalla;

    // INSTANCIAS --------------------------------------------------------------
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    /**
     * Método constructor encargado de crear un Aventurero.
     *
     * @param vida - Vida inicial del aventurero
     * @param mana - Mana inicial del aventurero
     * @param ataque - Ataque inicial del aventurero
     * @param defensa - Defensa inicial del aventurero
     * @param nombre - Nombre del aventurero
     */
    public Aventurero(int vida, int mana, int ataque, int defensa, String nombre) {
        super(vida, mana, ataque, defensa, nombre);
        this.RESETEAR = "\u001B[0m";
        this.CYAN = "\u001B[96m";
        this.batallas = 0;
        this.manaMaximo = 10;
        this.vidaMaxima = 100;
        this.batallasHuidas = 0;
        this.batallasGanadas = 0;
        this.batallasPerdidas = 0;
        this.cantidadMovimientos = 0;
        this.manaPrevioAUnaBatalla = 10;
        this.vidaPrevioAUnaBatalla = 100;
        this.defensaPrevioAUnaBatalla = defensa;
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de mostrar las características más importantes del
     * aventurero.
     */
    public void mostrarEstadoAventurero() {
        System.out.println("                        Las estadísticas del aventurero " + this.getNombre() + " son:");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("    ·   Vida: " + this.getVida() + "/" + this.getVidaMaxima());
        System.out.println("    ·   Mana: " + this.getMana() + "/" + this.getManaMaximo());
        System.out.println("    ·   Ataque: " + this.getAtaque());
        System.out.println("    ·   Defensa: " + this.getDefensa());
        System.out.println("    ·   Símbolo: " + this.getSimbolo());
        System.out.println("    ·   Posición Actual:" + Arrays.toString(this.getPosicionActual()));
        System.out.println("    ·   Batallas Tenidas: " + this.getBatallas());
        System.out.println("    ·   Movimientos Realizados: " + this.getCantidadMovimientos());
        System.out.println("------------------------------------------------------------------------------------------");
        scanner.nextLine();
    }

    /**
     * Método encargado de aumentar la defensa del jugador.
     *
     */
    public void defender() {
        if (this.getMana() >= 1) {
            int defensaAAumentar = (int) (this.getDefensa() + this.getDefensa() * 0.5);
            this.setDefensa(defensaAAumentar);
            this.setMana(this.getMana() - 1);
            System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + this.getNombre() + " tu defensa ha aumentado " + this.getDefensa() * 0.5 + ", tienes " + this.getDefensa() + " puntos de defensa" + CYAN + " ------------------------- " + RESETEAR);
        } else {
            System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + this.getNombre() + " no tienes el mana suficiente" + CYAN + " ------------------------- " + RESETEAR);
        }
    }

    /**
     * Método encargado de curar al personaje
     */
    public void curar() {
        if (this.getMana() >= 1) {
            int cantidadACurar = random.nextInt(0, 30);
            this.setVida(this.getVida() + cantidadACurar);
            this.setMana(this.getMana() - 1);
            System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + this.getNombre() + " te has curado " + cantidadACurar + " de vida, tienes " + this.getVida() + " puntos de vida" + CYAN + " ------------------------- " + RESETEAR);
        } else {
            System.out.println(CYAN + "              ------------------------- " + RESETEAR + "Aventurero " + this.getNombre() + " no tienes el mana suficiente" + CYAN + " ------------------------- " + RESETEAR);
        }
    }

    // GETTERS & SETTERS -------------------------------------------------------
    public int getBatallas() {
        return batallas;
    }

    public void setBatallas(int batallas) {
        this.batallas = batallas;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getManaMaximo() {
        return manaMaximo;
    }

    public void setManaMaximo(int manaMaximo) {
        this.manaMaximo = manaMaximo;
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

    public int[][] getPosicionInicial() {
        return posicionInicial;
    }

    public void setPosicionInicial(int[][] posicionInicial) {
        this.posicionInicial = posicionInicial;
    }

    public int[][] getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int[][] posicionActual) {
        this.posicionActual = posicionActual;
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
    }

    public int getManaPrevioAUnaBatalla() {
        return manaPrevioAUnaBatalla;
    }

    public void setManaPrevioAUnaBatalla(int manaPrevioAUnaBatalla) {
        this.manaPrevioAUnaBatalla = manaPrevioAUnaBatalla;
    }

    public int getDefensaPrevioAUnaBatalla() {
        return defensaPrevioAUnaBatalla;
    }

    public void setDefensaPrevioAUnaBatalla(int defensaPrevioAUnaBatalla) {
        this.defensaPrevioAUnaBatalla = defensaPrevioAUnaBatalla;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}
