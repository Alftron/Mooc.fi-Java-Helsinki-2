
package boxes;

import java.util.List;
import java.util.ArrayList;

public class MaxWeightBox extends Box{
    
    private List<Thing> things;
    private int maxWeight;
    
    public MaxWeightBox(int maxWeight) {
        things = new ArrayList<Thing>();
        this.maxWeight = maxWeight;
    }
    
    public int getTotalWeight() {
        if (things != null && things.size() > 0)
        {
            int totalWeight = 0;
            for (Thing t : things) {
                totalWeight += t.getWeight();
            }
            return totalWeight;
        } else {
            return 0;
        }
    }

    @Override
    public void add(Thing thing) {
        if (getTotalWeight() + thing.getWeight() <= maxWeight) {
            things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if (things.contains(thing)) {
            return true;
        }
        return false;
    }
    
}
