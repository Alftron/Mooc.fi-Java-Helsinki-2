
package application;

import java.util.Random;

public class Thermometer implements Sensor{

    private boolean onState;
    
    public Thermometer() {
        this.onState = false;
    }
    
    @Override
    public boolean isOn() {
        return this.onState;
    }

    @Override
    public void on() {
        this.onState = true;
    }

    @Override
    public void off() {
        this.onState = false;
    }

    @Override
    public int measure() {
        if (isOn()) {
            Random random = new Random();
            return random.nextInt(30 - -30) + -30;
        } else {
            throw new IllegalStateException();
        }
    }
    
}
