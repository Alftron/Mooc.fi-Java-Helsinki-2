
package clicker.applicationlogic;

public class PersonalCalculator implements Calculator{

    private int value;
    
    @Override
    public int giveValue() {
        return this.value;
    }

    @Override
    public void increase() {
        this.value++;
    }
    
}
