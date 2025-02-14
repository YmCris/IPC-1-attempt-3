package ymcris.ipc1.practice1.codengames.RPG;

/**
 * Clase encargada de Crear al personaje, y reiniciar sus estadísticas o
 * modificarlas
 *
 * @Date Feb 14, 2025
 * @author YmCris
 */
public class Personaje {

    // VARIABLES ---------------------------------------------------------------
    private int hp;
    private int mp;
    private int oro;
    private int nivel;
    private String nombre;
    private int experiencia;
    private boolean estavivo;
    private int monstruosVencidos;

    // INSTANCIAS --------------------------------------------------------------
    public static Inventario inventario = new Inventario();

    // MÉTODO CONSTRUCTOR -------------------------------------------------------
    public Personaje(int hp, int mp, int oro, int nivel, String nombre, int experiencia, boolean estavivo, int monstruosVencidos) {
        this.hp = hp;
        this.mp = mp;
        this.oro = oro;
        this.nivel = nivel;
        this.nombre = nombre;
        this.experiencia = experiencia;
        this.estavivo = estavivo;
        this.monstruosVencidos = monstruosVencidos;
    }

    // MÉTODOS -----------------------------------------------------------------
    private boolean verificarReinicio(Personaje personaje) {
        if (personaje.hp <= 0) {
            return true;
        } else {
            return false;
        }
    }

    private void resetearEstadisticas(Personaje personaje) {
        personaje.oro = 0;
        personaje.hp = 100;
        personaje.mp = 100;
        personaje.nivel = 0;
        personaje.experiencia = 0;
        personaje.estavivo = true;
        inventario.cantidadPotion = 0;
        inventario.cantidadMPotion = 0;
        inventario.cantidadHiPotion = 0;
    }

    // GETTERS & SETTERS -------------------------------------------------------
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public boolean isEstavivo() {
        return estavivo;
    }

    public void setEstavivo(boolean estavivo) {
        this.estavivo = estavivo;
    }

    public int getMonstruosVencidos() {
        return monstruosVencidos;
    }

    public void setMonstruosVencidos(int monstruosVencidos) {
        this.monstruosVencidos = monstruosVencidos;
    }

}
