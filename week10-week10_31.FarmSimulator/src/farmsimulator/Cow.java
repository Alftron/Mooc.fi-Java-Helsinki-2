
package farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive {
    
    private String name;
    private double udderCapacity;
    private double milkVolume;
    
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"
    };
    
    public Cow() {
        name = NAMES[new Random().nextInt(31)];
        setCapacity();
    }
    
    public Cow(String name) {
        this.name = name;
        setCapacity();
    }
    
    public void setCapacity() {
        int num = 15 + new Random().nextInt(26);
        udderCapacity = num;
    }
    
    public String getName() {
        return name;
    }
    
    public double getCapacity() {
        return udderCapacity;
    }
    
    public double getAmount() {
        return milkVolume;
    }
    
    @Override
    public String toString() {
        return getName() + " " + getAmount() + "/" + getCapacity();
    }
    
    @Override
    public double milk() {
        double milked = milkVolume;
        milkVolume = 0.0;
        return milked;
    }
    
    @Override
    public void liveHour() {
        double increase = Math.ceil(0.7 + ((2.0 - 0.7) * new Random().nextDouble()));
        if (milkVolume + increase > udderCapacity) {
            milkVolume = udderCapacity;
        } else {
            milkVolume += increase;
        }
    }
    
}
