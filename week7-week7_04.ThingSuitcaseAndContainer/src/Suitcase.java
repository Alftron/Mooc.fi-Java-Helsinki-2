import java.util.ArrayList;

public class Suitcase {
    
    private int maxWeight;
    private ArrayList<Thing> things;
    
    public Suitcase(int maxWeightLimit) {
        this.maxWeight = maxWeightLimit;
        this.things = new ArrayList<Thing>();
    }
    
    public void addThing(Thing thing) {
        int currentWeight = 0;
        for (Thing item : things) {
            currentWeight += item.getWeight();
        }
        
        if (currentWeight + thing.getWeight() <= this.maxWeight) {
            things.add(thing);
        }
    }
    
    public void printThings() {
        for (Thing item : things) {
            System.out.println(item.getName() + " thing " + "(" + item.getWeight() + " kg)");
        }
    }
    
    public int totalWeight() {
        int totalWeight = 0;
        for (Thing item : things) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
    
    public Thing heaviestThing() {
        if (this.things.size() > 0) {
            int heaviest = 0;
            int heaviestIndex = 0;
            for (int i = 0; i < things.size(); i++) {
                if (things.get(i).getWeight() > heaviest) {
                    heaviest = things.get(i).getWeight();
                    heaviestIndex = i;
                }
            }
        return things.get(heaviestIndex);
        } else {
            return null;
        }
    }
    
    public String toString() {
        if (things.size() < 1) {
            return "empty " + "(" + totalWeight() + " kg)";
        } else if (things.size() == 1) {
            return things.size() + " thing " + "(" + totalWeight() + " kg)";
        } else {
            return things.size() + " things " + "(" + totalWeight() + " kg)";
        }
    }
    
}
