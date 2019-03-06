package curso;

public class Curso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hola");
        ArbolA a = new ArbolA(38);
        NodoA nodoEncontrado = a.buscar();
        
        if (nodoEncontrado != null) {
            System.out.println(" ** Encontrado **  \n"+nodoEncontrado.toString());
        } else {
            System.out.println("No encontrado");
        }
        
        System.out.println("Rastro de la búsqueda: \n"+a.rastro);
    }
    
}
