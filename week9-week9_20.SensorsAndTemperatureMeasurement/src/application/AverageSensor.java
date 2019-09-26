
package application;

import java.util.List;
import java.util.ArrayList;

public class AverageSensor implements Sensor {
    
    private List<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor additional) {
        sensors.add(additional);
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
    
    @Override
    public boolean isOn() {
        for (Sensor s : sensors) {
            if (!s.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for (Sensor s : sensors) {
            s.on();
        }
    }

    @Override
    public void off() {
        for (Sensor s : sensors) {
            s.off();
        }
    }

    @Override
    public int measure() {
        // Returns the average of all its sensors
        if (sensors.isEmpty() || !isOn()) {
            throw new IllegalStateException();
        } else {
            int measures = 0;
            int count = 0;
            for (Sensor s : sensors) {
                int reading = s.measure();
                measures += reading;
                count++;
            }
            int average = measures / count;
            readings.add(average);
            return average;
        }
    }
    
}
