import java.util.ArrayList;

public class Container {
    private ArrayList<Suitcase> cases;
    private int maxWeight;
    
    public Container(int maxWeightLimit) {
        cases = new ArrayList<Suitcase>();
        maxWeight = maxWeightLimit;
    }
    
    public void addSuitcase(Suitcase suitcase) {
        int currentWeight = 0;
        for (Suitcase item : cases) {
            currentWeight += item.totalWeight();
        }
        
        if (currentWeight + suitcase.totalWeight() <= this.maxWeight) {
            cases.add(suitcase);
        }
    }
    
    public int totalWeight() {
        int totalWeight = 0;
        for (Suitcase item : cases) {
            totalWeight += item.totalWeight();
        }
        return totalWeight;
    }
    
    public void printThings() {
        for (Suitcase item : cases) {
            item.printThings();
        }
    }
    
    public String toString() {
        return cases.size() + " suitcases (" + totalWeight() + "kg)";
    }
}
