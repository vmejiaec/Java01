package carta;

/**
 * Un generador de arreglos de cartas para pruebas
 * @author Victor
 */
public class FuenteCartas {
    // Atributos
    
    private Carta[] muestra;
    
    // Constructores
    public FuenteCartas(){
        
    }
    
    // Cartas de prueba 
    public static Carta[] muestra1(){
        return new Carta[]{
            new Carta("Blanco",     "4M15", "000-0-011-0"),
            new Carta("Planta",     "2M02", "011-1-100-0"),
            new Carta("Bicho",      "1P10", "000-0-110-0"),
            new Carta("Pajaro",     "2P01", "010-1-100-1"),
            new Carta("Llama",      "1M00", "001-1-010-0"),
            new Carta("Negro",      "0M01", "110-0-101-0"),
            new Carta("Chica",      "4M03", "101-0-100-0"),
            new Carta("Azul",       "2P03", "011-0-010-1"),
            new Carta("Castillo",   "0P59","111-1-110-0"),
            new Carta("Nube",       "1P20", "001-0-011-0")
        };
    }
    
}
