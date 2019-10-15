
public class Calculator {
    
    private int value;
    
    public Calculator() {
        value = 0;
    }
    
    public int getValue() {
        return value;
    }
    
    public void increaseValue(int amount) {
        value += amount;
    }
    
    public void decreaseValue(int amount) {
        value -= amount;
    }
    
    public void resetValue() {
        value = 0;
    }
    
    
}
