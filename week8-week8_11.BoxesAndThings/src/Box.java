
import java.util.ArrayList;

public class Box implements ToBeStored{
    private final double maxWeight;
    private int numItems;
    private ArrayList<ToBeStored> boxes;
    
    public Box(double maxWeight) {
        boxes = new ArrayList<ToBeStored>();
        this.maxWeight = maxWeight;
        this.numItems = 0;
    }
    
    public void add(ToBeStored object) {
        if (this.weight() + object.weight() <= this.maxWeight) {
            numItems++;
            boxes.add(object);
        }
    }
    
    public double weight() {
        double weight = 0.0;
        for (ToBeStored i : boxes) {
            weight += i.weight();
        }
        return weight;
    }
    
    @Override
    public String toString() {
        return "Box: " + this.numItems + " things, total weight " + this.weight() + " kg";
    }
}
