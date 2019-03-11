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
    public Carta[] muestra1(){
        return new Carta[]{
            new Carta("Blanco",     71, "4M15", "000-0-001-0"),
            new Carta("Planta",     35, "2M02", "001-0-100-0"),
            new Carta("Bicho",      18, "1P10", "000-0-100-0"),
            new Carta("Pajaro",     40, "2P01", "010-1-100-1"),
            new Carta("Llama",      19, "1M00", "001-1-000-0"),
            new Carta("Negro",      12, "0M01", "110-0-101-0"),
            new Carta("Chica",      68, "4M03", "101-0-100-0"),
            new Carta("Azul",       32, "2P03", "011-0-010-1"),
            new Carta("Castillo",   10, "0P59","111-1-110-0"),
            new Carta("Nube",       29, "1P20", "001-0-011-0")
        };
    }
    
}
