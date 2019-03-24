package curso;

import carta.Carta;
import carta.FuenteCartas;
import carta.Mesa;
import carta.StringTools;
import java.util.Arrays;

public class Curso {

    /**
     * Pruebas con las cartas de Final Fantasy IX
     */
    public static void main(String[] args) {
        System.out.println("Pelea de cartas: \n");
        Carta tmp = new Carta();
        Carta[] cartas = FuenteCartas.muestra1();
        
        
        Mesa mesa = new Mesa();
        //Colocamos las piedras
        mesa.piedras = new int[][]{{0,2},{0,3},{1,1},{2,3},{3,3}};
        // Armo los masos A y B con cinco cartas cada uno
        mesa.mazoA = new Carta[]{cartas[0],cartas[2],cartas[4],cartas[6], cartas[8]};
        mesa.mazoB = new Carta[]{cartas[1],cartas[2],cartas[5],cartas[7], cartas[9]};
        // Prepara la mesa
        mesa.preparar();
        System.out.println(mesa.dibuja());
        // Pongo la primera carta
        mesa.A_Juega(2,new int[]{1,0});
        System.out.println(mesa.dibuja());
        // Pongo la segunda carta
        mesa.B_Juega(2,new int[]{0,1});
        System.out.println(mesa.dibuja());
        // Verifica si hay pelea 
        mesa.resuelveTurno();
        System.out.println(mesa.dibuja());        
    }
}
