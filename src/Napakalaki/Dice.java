package Napakalaki;
import java.util.Random;

public class Dice {
    public static final Dice instance = new Dice();
    
    private Dice() {
        
    }
    
    public static Dice getInstance() {
        return instance;
    }
    
    public int nextNumber() {
        Random rn = new Random();
        int result;
        result = rn.nextInt(6) + 1;
        
        return result;
    }
} 