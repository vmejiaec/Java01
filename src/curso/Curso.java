package curso;

import carta.Carta;
import carta.FuenteCartas;
import java.util.Arrays;

public class Curso {

    /**
     * Pruebas con las cartas de Final Fantasy IX
     */
    public static void main(String[] args) {
        System.out.println("Pelea de cartas: \n");
        Carta c = new Carta();
        System.out.print(c);
        FuenteCartas fc = new FuenteCartas();
        Carta[] cartas = fc.muestra1();
        for (Carta retador : cartas){
            System.out.print(" - " + retador + " -> ");
            System.out.println(c.combate(retador, 2));
        }   
        
    }
}
