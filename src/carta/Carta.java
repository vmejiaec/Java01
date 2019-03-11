/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carta;

import java.util.Arrays;

/**
 *
 * @author Victor
 */
public class Carta {
    
    String nombre;
    int ataque;
    public enum AtaqueTipo {FISICO, MAGICO, ESPECIAL, AVANZADO};
    AtaqueTipo ataqueTipo = AtaqueTipo.FISICO;
    int defensaFisica;
    int defensaMagica;
    boolean esquinas[];
    int hitpoint;
    
    // Constructores
    public Carta(){
        nombre = "S/N";
        esquinas = new boolean[8];
        hitpoint = 0;
        analiza("1F23","000-0-000-0");
    }
    
    public Carta(String nombre, int hp, String valores, String esquinas){
        this.nombre = nombre;
        this.hitpoint = hp;
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
        ataque = tmp[0]-48;
        ataqueTipo = charToTipo(tmp[1]);
        defensaFisica = tmp[2]-48;
        defensaMagica = tmp[3]-48;
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
    public Carta combate(Carta oponente, int noEsquina){
        
        // Si no comparten esquina es empate
        
        // Si la oponente no tiene esquina entonces gana la carta this
        
        // Si la oponente tiene esquina y this no la tiene gana la opoenente
        
        // Si ambas comparten esquina, entonces van a pelear
        
        return this;
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
               " Atq:" + " ("+ ataque + " " + ataqueTipo +")" +
               "\t\thp(" + hitpoint + ")"+
               " Def:" +
               " Fis(" + defensaFisica +") "+
               " Mag(" + defensaMagica +"). " +
               " {"+esq+"}" +
               "\n";
        return resp;
    }
}
