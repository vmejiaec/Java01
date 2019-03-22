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
            new Carta("Blanco",     "4M15", "000-001-100"),
            new Carta("Planta",     "2M02", "011-101-000"),
            new Carta("Bicho",      "1P10", "000-001-100"),
            new Carta("Pajaro",     "2P01", "010-101-001"),
            new Carta("Llama",      "1M00", "001-100-100"),
            new Carta("Negro",      "0M01", "110-001-010"),
            new Carta("Chica",      "4M03", "101-001-000"),
            new Carta("Azul",       "2P03", "011-000-101"),
            new Carta("Castillo",   "0P59", "111-101-100"),
            new Carta("Nube",       "1P20", "001-000-110")
        };
    }
    
}
