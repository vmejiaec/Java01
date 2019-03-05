/*
 * El nodo de un árbol
 */
package curso;

import java.util.Arrays;

/**
 * El nodo de un árbol
 * @author Victor
 */
public class NodoA {
    // Tipos

    /**
     * El tipo de rama
     */
    public enum RamaTipo {R,A,B};
    
    // metodos
    private int noRamas=2;
    private int cabeza;
    private RamaTipo[] padres;    
    
    // constructor
    public NodoA (){
        cabeza = 1;
        padres = new RamaTipo[1];
        padres[0]=RamaTipo.R;
    }
    public NodoA (int cabeza, RamaTipo padres[])
    {
        this.cabeza = cabeza;
        this.padres = padres;
    }
    
    //Gets and Sets
    public int getCabeza(){
        return cabeza;
    }
    public void setCabeza(int cabeza){
        this.cabeza = cabeza;
    }
    public RamaTipo[] getPadres(){
        return padres;
    }
    public void setPadres(RamaTipo padres[]){
        this.padres = padres;
    }
    // métodos
    int f_suma5(int x){ return x+5;};
    int f_por3(int x){ return 3*x;};
    
    interface FuncionEntera{
        int funcion(int x);
    }    
    private FuncionEntera[] funciones = new FuncionEntera[]{
        new FuncionEntera () {
            @Override
            public int funcion(int x){ return f_suma5(x);} },
        new FuncionEntera () {
            @Override
            public int funcion(int x){ return f_por3(x);} }
    };
    
    public NodoA[] Generar(){
        NodoA[] resp = new NodoA[noRamas];
        RamaTipo[] rama = new RamaTipo[3];
        for(int i=0; i<noRamas ; ++i){
            resp[i] = new NodoA();
            resp[i].setCabeza(funciones[i].funcion(this.cabeza));
            rama = this.getPadres();
            rama = Arrays.copyOf(rama,rama.length+1);
            rama[rama.length-1]=RamaTipo.values()[i+1];
            resp[i].setPadres(rama);
        }
        return resp;
    }
    
    public NodoA[] Generar(int limite){
        NodoA[] res = null;
        NodoA[] gen = this.Generar();
        
        if (this.cabeza > limite) return res;
        for(NodoA n : gen){
            if (n.cabeza > limite) continue;
            if (res == null) 
                res = new NodoA[]{n};
            else{
                res = Arrays.copyOf(res, res.length+1);
                res[res.length-1] = n;
            }
        }        
        return res;
    }
    
    
    public boolean Verifica(int test){
        return (test == this.cabeza);
    }
    
    @Override
    public String toString(){
        String msg="";
        msg = msg + "N("+cabeza+" - "+ Arrays.toString(padres) +")";
        return msg;
    }
    
    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        NodoA nodo = (NodoA) obj;        
        return this.toString().equals(nodo.toString());
    }
}
