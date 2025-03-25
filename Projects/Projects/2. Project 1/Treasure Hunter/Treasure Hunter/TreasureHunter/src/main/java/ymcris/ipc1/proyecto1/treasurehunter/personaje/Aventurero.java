package ymcris.ipc1.proyecto1.treasurehunter.personaje;

import java.util.Scanner;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.CYAN;
import static ymcris.ipc1.proyecto1.treasurehunter.diseño.DiseñoMenus.RESETEAR;

/**
 * SubClase encargada de crear aventureros y de realizar sus acciones durante
 * una batalla
 *
 * @author YmCris
 * @see Personaje
 * @since Mar 13, 2025
 */
public class Aventurero extends Personaje {

    // VARIABLES PRIMITIVAS --------------------------------------------------------
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

    // INSTANCIAS --------------------------------------------------------------
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
        this.batallas = 0;
        this.manaTotal = mana;
        this.vidaTotal = vida;
        this.batallasHuidas = 0;
        this.batallasGanadas = 0;
        this.batallasPerdidas = 0;
        this.cantidadMovimientos = 0;
        this.manaPrevioAUnaBatalla = mana;
        this.vidaPrevioAUnaBatalla = vida;
        this.defensaPrevioAUnaBatalla = defensa;
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

}
