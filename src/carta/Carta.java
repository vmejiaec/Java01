/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carta;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Victor
 */
public class Carta {
    
    String nombre;
    
    public boolean esquinas[];
    
    public enum AtaqueTipo {FISICO, MAGICO, ESPECIAL, AVANZADO};
    AtaqueTipo ataqueTipo = AtaqueTipo.FISICO;
    
    int nivelAtaque;
    int nivelDefensaFisica;
    int nivelDefensaMagica;
    
    int hpAtaque;
    int hpDefensaFisica;
    int hpDefensaMagica;
    
    // Obtiene random del nivel 
    public int getHP(int nivel){
        Random ran = new Random();
        int hp = ran.nextInt(16);
        return hp + nivel * 16;
    }
    
    // Obtiene random desde cero hasta un valor maximo
    public int getRand(int max){
        Random ran = new Random();
        if (max <= 0){
            return 0;
        }
        int n = ran.nextInt(max);
        return n;
    }
    
    // Constructores
    public Carta(){
        nombre = "S/N";
        esquinas = new boolean[8];        
        analiza("1F23","000-0-000-0");
    }
    
    public Carta(String nombre, String valores, String esquinas){
        this.nombre = nombre;
        this.esquinas = new boolean[8];
        analiza(valores, esquinas);
    }
    
    /*
    Convierte el char c que se ha extraido de las propiedades
    en un tipo de ataque
    */
    public AtaqueTipo charToTipo(char c){
        if (c == 'F' || c == 'P') return AtaqueTipo.FISICO;
        if (c == 'M') return AtaqueTipo.MAGICO;
        if (c == 'X') return AtaqueTipo.ESPECIAL;
        //if (c == 'A') 
        return AtaqueTipo.AVANZADO;
    }
    
    // Analiza el string de propiedades para obtener los
    // valores de ataque, defensa, etc.
    public void analiza(String valores, String esquinas){
        char tmp[] = valores.toCharArray();
        ataqueTipo = charToTipo(tmp[1]);
        nivelAtaque = tmp[0]-48;        
        nivelDefensaFisica = tmp[2]-48;
        nivelDefensaMagica = tmp[3]-48;
        char cEsquinas[] = (esquinas.replace("-", "")).toCharArray();
        for(int i=0;i<8;i++){
            this.esquinas[i]= (cEsquinas[i]!='0');
        }
    }
    
    /*
        Enfrenta dos cartas para encontrar
        carta que gana o empate
        adicionalmente indica la traza de cálculos
    */
    
    public void calculaHPs(){
        hpAtaque = getHP(nivelAtaque);
        hpDefensaFisica = getHP(nivelDefensaFisica);
        hpDefensaMagica = getHP(nivelDefensaMagica);
    }
    
    public String combate(Carta op, int noEsquina){
        String quienGana = "*";
        //if (esquinas[noEsquina] && op.esquinas[noEsquina]){
            
            // Calcula hps
            calculaHPs();
            op.calculaHPs();
            // Procede de acuerdo con el tipo de ataque            
            switch(ataqueTipo){
                case FISICO:
                    int ataque = hpAtaque;
                    int defensa = op.hpDefensaFisica;
                    quienGana += " A1:" + ataque + " F1: " + defensa;
                    ataque = getRand(ataque);
                    defensa = getRand(defensa);
                    quienGana += " A2:" + ataque + " F2: " + defensa;
                    if (ataque > defensa) quienGana += " <Gana Atacante>";
                    if (ataque == defensa) quienGana += " <Empate>";
                    if (ataque < defensa) quienGana += " <Gana Defensor>";
                    break;
                case MAGICO:
                    ataque = hpAtaque;
                    defensa = op.hpDefensaMagica;
                    quienGana += " A1:" + ataque + " M1: " + defensa;
                    ataque = getRand(ataque);
                    defensa = getRand(defensa);
                    quienGana += " A2:" + ataque + " M2: " + defensa;
                    if (ataque > defensa) quienGana += " <Gana Atacante>";
                    if (ataque == defensa) quienGana += " <Empate>";
                    if (ataque < defensa) quienGana += " <Gana Defensor>";
                    break;
                case ESPECIAL:
                    ataque = hpAtaque;
                    defensa =   op.hpDefensaFisica < op.hpDefensaMagica ? 
                                    op.hpDefensaFisica :
                                    op.hpDefensaMagica ;
                    ataque = getRand(ataque);
                    defensa = getRand(defensa);
                    if (ataque > defensa) quienGana = "Gana Atacante";
                    if (ataque == defensa) quienGana = "Empate";
                    if (ataque < defensa) quienGana = "Gana Defensor";
                    break;
                case AVANZADO:
                    ataque = hpAtaque;
                    defensa =   op.hpAtaque < op.hpDefensaFisica ? 
                                    op.hpAtaque < op.hpDefensaMagica ?
                                        op.hpAtaque : op.hpDefensaMagica :
                                    op.hpDefensaFisica < op.hpDefensaMagica ?
                                        op.hpDefensaFisica : op.hpDefensaMagica;
                    ataque = getRand(ataque);
                    defensa = getRand(defensa);
                    if (ataque > defensa) quienGana = "Gana Atacante";
                    if (ataque == defensa) quienGana = "Empate";
                    if (ataque < defensa) quienGana = "Gana Defensor";
                    break;
            }
        //}
        
        return quienGana;
    }
    
    /*
        Presenta la carta en formato:
        [*nombre]: Atq (* *tipo) Def Fis(*) Mag(*).
    */
    @Override
    public String toString(){
        String esq="";
        for(int i=0;i<8;i++) esq += esquinas[i]? 1:0;
        String resp =
               "["+nombre+"] "+               
               "\t\tAtq:" + " ("+ nivelAtaque + " " + ataqueTipo +")" +
               " Def:" +
               " Fis(" + nivelDefensaFisica +") "+
               " Mag(" + nivelDefensaMagica +"). " +
               " {"+esq+"}" +
               "\n";
        return resp;
    }
}
