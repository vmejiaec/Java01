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
        tmp.perteneceA=Carta.Jugador.J_A;
        tmp.color=Carta.Jugador.J_A;
        tmp.pos = pos;
        orden.add(tmp);
        campo[pos[0]][pos[1]]=tmp;
    }
    public void B_Juega(int noCarta, int[] pos) {
        Carta tmp = mazoB[noCarta];
        mazoB[noCarta] = Carta.CartaVacio();
        tmp.perteneceA=Carta.Jugador.J_B;
        tmp.color = Carta.Jugador.J_B;
        tmp.pos = pos;
        orden.add(tmp);
        campo[pos[0]][pos[1]]=tmp;
    }
    
    public void resuelveTurno(){
        // Los límites máximos de i,j
        int imax=3;
        int jmax =3;
        Carta atq = orden.get(orden.size()-1);
        int ic = atq.pos[0];
        int jc = atq.pos[1];
        for (int i=-1;i<2;i++) {
            for (int j=-1;j<2;j++){
                if (i==0 && j==0) continue;
                int iv=ic+i;
                int jv = jc+j;
                if (iv<0 || iv>imax) break;
                if (jv<0 || jv>jmax) continue;
                Carta vecino = campo[iv][jv];
                if (vecino.esVacio) continue;
                if (vecino.esPiedra) continue;
                // Llegados hasta aquí la vecina es una carta
                if (vecino.color == atq.color) continue;
                // La carta vecina es enemiga y hay que confirmar
                // las flechas en la esquina o lado que comparten
                if (!atq.esquinas[i+1][j+1]) continue;
                // Ahora se debe calcular la esquina opuesta correspondiente de la carta vecina
                // Si la posición es i,j entonces se sigue la siguiente tabla
                //   -1,-1  -1,0  -1,1           1,1   1,0   1,-1
                //    0,-1   0,0   0,1     ->    0,1   0,0   0,-1
                //    1,-1   1,0   1,1          -1,1  -1,0  -1,-1
                if (vecino.esquinas[-i+1][-j+1]) {
                    // El ganador se decide en combate
                    String quienGana=atq.combate(vecino);
                    if (quienGana.contains("<Gana Atacante>")) vecino.color = atq.color;
                    if (quienGana.contains("<Gana Defensor>")) atq.color = vecino.color;
                } else{
                    // El atacante gana porque el vecino no tiene esquina
                    vecino.color = atq.color;
                }
            }
        }
    }
    
    public int[] esquinaOpuesta(int i, int j){
        int[] op = new int[]{0,0};
        op[0]=-i;
        op[1]=-j;
        return op;
    }
}
