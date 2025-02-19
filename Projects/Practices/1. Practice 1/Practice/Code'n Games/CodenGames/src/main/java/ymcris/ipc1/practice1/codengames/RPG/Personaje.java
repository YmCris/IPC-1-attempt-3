package ymcris.ipc1.practice1.codengames.RPG;

/**
 * Clase encargada de Crear al personaje, y reiniciar sus estadísticas o
 * modificarlas.
 *
 * @since Feb 14, 2025
 * @author YmCris
 * @see Inventario
 */
public class Personaje {

    // VARIABLES ---------------------------------------------------------------
    public int hp;
    public int mp;
    private int oro;
    private int nivel;
    public int hpMaximo;
    public int mpMaximo;
    private String nombre;
    private int experiencia;
    private boolean estaVivo;
    private int monstruosVencidos;
    private final int EXPERIENCIA_REQUERIDA;

    // INSTANCIAS --------------------------------------------------------------
    /**
     * Static porque lo va a usar el jugador, pero de tener más personajes, el
     * inventario no sería solo de un personaje (De querer que todos los
     * personajes tengan un propio inventario ya no sería estático).
     */
    public static Inventario inventario = new Inventario();

    // MÉTODO CONSTRUCTOR -------------------------------------------------------
    /**
     * Método encargado de inicializar los atributos necesarios del personaje.
     *
     * @param hp - Vida inicial del personaje
     * @param mp - Mana inicial del personaje
     * @param nivel - Nivel inicial del personaje
     * @param nombre - Nombre del personaje
     * @param experiencia - Experiencia inicial del personaje
     * @param monstruosVencidos - Monstruos iniciales vencidos del personaje
     */
    public Personaje(int hp, int mp, int nivel, String nombre, int experiencia, int monstruosVencidos) {
        this.hp = hp;
        this.mp = mp;
        this.oro = 100;
        this.nivel = nivel;
        this.mpMaximo = 10;
        this.hpMaximo = 100;
        this.nombre = nombre;
        this.estaVivo = hp > 0;
        this.experiencia = experiencia;
        this.EXPERIENCIA_REQUERIDA = 100;
        this.monstruosVencidos = monstruosVencidos;//De haber más personajes, sería una variable estática en otra clase.
    }

    // MÉTODOS -----------------------------------------------------------------
    /**
     * Método encargado de verificar si el personaje ha muerto.
     *
     * @return true si la vida es menor a 0 (esta muerto).
     */
    private boolean verificarReinicio() {
        return this.hp <= 0;
    }

    /**
     * Método encargado de reiniciar los atributos del personaje en dado caso
     * muera.
     */
    protected void resetearEstadisticas() {
        if (verificarReinicio()) {
            this.oro = 100;
            this.hp = 100;
            this.mp = 10;
            this.nivel = 0;
            this.estaVivo = true;
            this.experiencia = 0;
            this.monstruosVencidos = 0;
            inventario.cantidadPotion = 0;
            inventario.cantidadMPotion = 0;
            inventario.cantidadHiPotion = 0;
        }
    }

    /**
     * Método encargado de verificar si el personaje puede subir de nivel y
     * quitar la expericncia requerida
     */
    protected void verificarNivel() {
        if (this.experiencia >= EXPERIENCIA_REQUERIDA) {//Verifica si el jugador tiene la experiencia necesaria para subir de nivel y quita experiencia y aumenta estadísticas.
            this.setNivel(+1);
            this.setExperiencia(-100);
            this.hpMaximo = (100 * (this.nivel + 1));
            this.mpMaximo = (10 * (this.nivel + 1));
            System.out.println("El jugador " + this.getNombre() + " ha subido al nivel " + this.getNivel() + " y tiene " + this.getExperiencia() + " de experiencia.");
            System.out.println("Su HP actual es " + this.hp + "/" + this.hpMaximo);
            System.out.println("Su MP actual es " + this.mp + "/" + this.mpMaximo);
        } else {
            System.out.println(this.nombre + " no tienes la experiencia requerida, tienes " + this.experiencia);
        }
    }

    /**
     * Método encargado de verificar si el hp o el mp sobrepasa los valores
     * máximos del mp o hp
     *
     * @return true si el hp o el mp son máximos
     */
    protected boolean verificarHpyMpMaximosYMinimos() {
        if (this.hp >= this.hpMaximo) {//verifica que el hp no pase del máximo
            this.hp = this.hpMaximo;
            return true;
        }
        if (this.hp < 0) {//verifica que el hp no sea negativo
            this.hp = 0;
        }
        if (this.mp < 0) {//verifica que el mp no sea negativo
            this.mp = 0;
        }
        if (this.mp >= this.mpMaximo) {//verifica que el mp no pase del máximo
            this.mp = this.mpMaximo;
            return true;
        }
        return false;
    }

    // GETTERS & SETTERS (Para aumentar, disminuir las características)---------
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp += hp;
        verificarHpyMpMaximosYMinimos();
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp += mp;
        verificarHpyMpMaximosYMinimos();
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro += oro;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel += nivel;
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
        this.experiencia += experiencia;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    public int getMonstruosVencidos() {
        return monstruosVencidos;
    }

    public void setMonstruosVencidos(int monstruosVencidos) {
        this.monstruosVencidos += monstruosVencidos;
    }

    public int getHpMaximo() {
        return hpMaximo;
    }

    public int getMpMaximo() {
        return mpMaximo;
    }

}
