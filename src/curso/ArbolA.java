package curso;
/*
    Para buscar en el árbol de números hay que crear una instancia del 
    árbol con el número buscado. Entonces se invoca el método buscar
    tal como se muestra a continuación:

        System.out.println("Inicio de la búsqueda del número");
        ArbolA a = new ArbolA(38);
        NodoA nodoEncontrado = a.buscar();
        
        if (nodoEncontrado != null) {
            System.out.println(" ** Encontrado **  \n"+nodoEncontrado.toString());
        } else {
            System.out.println("No encontrado");
        }
        
        System.out.println("Rastro de la búsqueda: \n"+a.rastro);
*/
import java.util.Arrays;

/**
 * Resuelve el problema de búsqueda en arbol de valores generado por
 * sumas y multiplicaciones
 * @author Victor
 */
public class ArbolA {
    int nBuscado ;
    NodoA nodoEncontrado = null;
    NodoA[] lista = new NodoA[]{new NodoA()};
    String rastro = "->";
    boolean fin = false;
    int k=0;
    int k_limite = 20;
    // Constructor
    public ArbolA(int numeroBuscado){
        this.nBuscado = numeroBuscado;
    }
    // Métodos
    public NodoA buscar(){
        rastro += Arrays.toString(lista) + "\n";
        while(!fin){
            ++k;
            NodoA[] acum = new NodoA[1];
            salto: // Para salir cuando encontramos al buscado en algun nodo
            for(int i=0;i<lista.length; ++i){
                NodoA[] gen = lista[i].Generar(nBuscado);
                if (gen == null) continue;
                for(NodoA n : gen){
                    if (n.Verifica(nBuscado)){
                        nodoEncontrado = n;
                        fin = true;
                        break salto; // Hemos encontrado el valor y vamos a salir
                    }
                }
                if (acum[0]== null){
                    acum = gen;
                } else {
                    NodoA[] temp = new NodoA[gen.length+acum.length];
                    System.arraycopy(acum, 0, temp, 0, acum.length);
                    System.arraycopy(gen, 0, temp, acum.length, gen.length);
                    acum = temp;
                }
            }
            if (k>k_limite) fin = true;  // Se acaba la búsqueda sin saber existe el valor
            if (acum.length ==1 && acum[0]== null) {
                lista = new NodoA[0];
                fin = true;  // Se acaba la búsqueda porque no existe el valor
            }
            else {
                lista = acum;
            }
            rastro += Arrays.toString(lista) +"\n";
        }
        return nodoEncontrado;
    }
}
