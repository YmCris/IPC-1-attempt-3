package ymcris.ipc1.practice1.codengames.carreras;

import java.util.Random;
import static ymcris.ipc1.practice1.codengames.CodenGames.AZUL;
import static ymcris.ipc1.practice1.codengames.CodenGames.RESETEAR_COLOR;

/**
 * Clase encargada de simular los dados y dar el resultado de X dados.
 *
 * @Date Feb 9, 2025
 * @author YmCris
 */
public class Dados {

    //VARIABLES-----------------------------------------------------------------
    private int resultado;

    //OBJETOS-------------------------------------------------------------------
    private Random random = new Random();

    //MÉTODOS-------------------------------------------------------------------
    /**
     * Método encargado de simular el lanzado de dados.
     *
     * @param numeroDeDados - número de dados con los que se desearán jugar.
     * @return
     */
    protected int lanzarDados(int numeroDeDados) {
        int resultadoDado;
        resultado = 0;
        for (int i = 0; i < numeroDeDados; i++) {
            resultadoDado = random.nextInt(1, 7);
            resultado += resultadoDado;
            System.out.println("El resultado del dado " + (i + 1) + " es: " + resultadoDado);
        }
        System.out.println(AZUL + "El jugador avanza " + resultado + " metros" + RESETEAR_COLOR);
        return resultado;
    }

    //GETTER--------------------------------------------------------------------
    public int getResultado() {
        return resultado;
    }

}
