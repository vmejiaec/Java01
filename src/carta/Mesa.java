/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carta;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class Mesa {
    //Atributos
    String JugA="J-a";
    String JugB="J-b";
    public int[][] piedras;
    public Carta[] mazoA = new Carta[5];
    public Carta[] mazoB = new Carta[5];
    public Carta[][] campo = new Carta[4][4];
    // Para mantener el orden en el que se jugaron las cartas
    public ArrayList<Carta> orden = new ArrayList<Carta>();
    /*
    Inicia la mesa vacía 
    */
    public Mesa(){
        
    }
    /*
    Inicia la mesa con los nombres de jugadores
    */
    public Mesa(String JugA, String JugB){
        this.JugA = JugA;
        this.JugB = JugB;
    }
    /*
    Prepara el campo y los mazos en la mesa
    */
    public void preparar(){
        // Coloca los vacios para completar el campo
        for (int i=0; i<4;i++){
            for (int j=0;j<4;j++){
                campo[i][j]= Carta.CartaVacio();
            }
        }
        // Coloca las 5 piedras en el campo
        for (int i=0; i<5; i++) {
            campo[piedras[i][0]][piedras[i][1]]= Carta.CartaPiedra();
        }
    }
    
    /*
    Imprime el campo
    */
    public String dibuja(){
        String res="";
        //Dibuja el mazo A
        res = "                     Mazo A" + "\n";
        res += StringTools.Encadena5Lineas(
                        mazoA[0].dibuja(), 
                        mazoA[1].dibuja(), 
                        mazoA[2].dibuja(), 
                        mazoA[3].dibuja(),
                        mazoA[4].dibuja()
                );
        res += "\n";
        // Dibuja el campo
        res += "                   Campo\n";
        for (int i=0;i<4;i++){
                res += StringTools.Encadena4Lineas(
                        campo[i][0].dibuja(), 
                        campo[i][1].dibuja(), 
                        campo[i][2].dibuja(), 
                        campo[i][3].dibuja()
                );
        }
        res += "\n";
        // Dibuja el mazo B
        res += "                     Mazo B" + "\n";
        res += StringTools.Encadena5Lineas(
                        mazoB[0].dibuja(), 
                        mazoB[1].dibuja(), 
                        mazoB[2].dibuja(), 
                        mazoB[3].dibuja(),
                        mazoA[4].dibuja()
                );
        return res;
    }

    public void A_Juega(int noCarta, int[] pos) {
        Carta tmp = mazoA[noCarta];
        mazoA[noCarta] = Carta.CartaVacio();
        tmp.perteneceA="J-A";
        tmp.setMensaje("J-A>A");
        tmp.pos = pos;
        orden.add(tmp);
        campo[pos[0]][pos[1]]=tmp;
    }
    public void B_Juega(int noCarta, int[] pos) {
        Carta tmp = mazoB[noCarta];
        mazoB[noCarta] = Carta.CartaVacio();
        tmp.setMensaje("J-B");
        tmp.setMensaje("J-B>B");
        tmp.pos = pos;
        orden.add(tmp);
        campo[pos[0]][pos[1]]=tmp;
    }
    
    
}
