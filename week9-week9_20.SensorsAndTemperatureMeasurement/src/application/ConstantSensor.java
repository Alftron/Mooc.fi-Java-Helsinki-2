
package application;

public class ConstantSensor implements Sensor {
    
    private int measure;
    
    public ConstantSensor(int num) {
        this.measure =  num;
    }
    
    @Override
    public boolean isOn() {
        return true;
    }
    
    @Override
    public void off() {
        
    }
    
    @Override
    public void on() {
        
    }
    
    @Override
    public int measure() {
        return this.measure;
    }
}
