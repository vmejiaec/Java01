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
public  class StringTools {
    public static String Encadena2Lineas(String A, String B){
        String res="";
        String lineasA[] = A.split("\n");
        String lineasB[] = B.split("\n");
        for (int i =0; i < lineasA.length ;i++){
            res += lineasA[i] + lineasB[i] + "\n";
        }
        return res;
    }
    public static String Encadena4Lineas(String A, String B, String C, String D){
        String AB = Encadena2Lineas(A, B);
        String CD = Encadena2Lineas(C, D);
        String ABCD = Encadena2Lineas(AB, CD);
        return ABCD;
    }
    public static String Encadena5Lineas(String A, String B, String C, String D, String E){
        String AB = Encadena2Lineas(A, B);
        String CD = Encadena2Lineas(C, D);
        String ABCD = Encadena2Lineas(AB, CD);
        String ABCDE = Encadena2Lineas(ABCD, E);
        return ABCDE;
    }
}
