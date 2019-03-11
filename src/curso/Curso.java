package curso;

import carta.Carta;
import carta.FuenteCartas;
import java.util.Arrays;

public class Curso {

    /**
     * Pruebas con las cartas de Final Fantasy IX
     */
    public static void main(String[] args) {
        System.out.println("Carta: \n");
        Carta c = new Carta();
        System.out.print(c);
        FuenteCartas fc = new FuenteCartas();
        System.out.print(Arrays.toString( fc.muestra1()));
    }
}
