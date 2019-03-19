package curso;

import carta.Carta;
import carta.FuenteCartas;
import carta.StringTools;
import java.util.Arrays;

public class Curso {

    /**
     * Pruebas con las cartas de Final Fantasy IX
     */
    public static void main(String[] args) {
        System.out.println("Pelea de cartas: \n");
        Carta c = new Carta();
        System.out.println(c);
        System.out.println(c.dibujaCarta());
        FuenteCartas fc = new FuenteCartas();
        Carta[] cartas = fc.muestra1();
        String A = cartas[0].dibujaCarta();
        String B = cartas[3].dibujaCarta();
        String C = cartas[1].dibujaCarta();
        String D = cartas[5].dibujaCarta();
        String E = cartas[2].dibujaCarta();
        String F = cartas[4].dibujaCarta();
        String G = cartas[8].dibujaCarta();
        String X = Carta.CartaPiedra().dibujaCarta();
        
        System.out.print(StringTools.Encadena4Lineas(A, E, X, D));
        System.out.print(StringTools.Encadena4Lineas(B, X, F, A));
        System.out.print(StringTools.Encadena4Lineas(C, B, G, X));
        System.out.println(StringTools.Encadena4Lineas(A, D, E, X));
    }
}
