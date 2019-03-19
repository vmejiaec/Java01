/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carta;

/**
 *
 * @author Victor
 */
public class Mesa {
    //Atributos
    int noCartasMazo = 5;
    String mesa;
    Carta[] mazoA = new Carta[5];
    Carta[] mazoB = new Carta[5];
    Carta[][] campo = new Carta[4][4];
    /*
    Inicia la mesa vacía con cuatro cartas tipo piedras colocadas
    al azar.
    */
    public Mesa(int[][] piedras){
        // Coloca las piedras en el campo
        for (int i=0; i<4; i++) {
            campo[piedras[i][0]][piedras[i][1]]= Carta.CartaPiedra();
        }
    }
    /*
    
    */
}
