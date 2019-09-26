
package moving.domain;

import java.util.List;
import java.util.ArrayList;

public class Box implements Thing{
    private int maxCapacity;
    private List<Thing> contents;
    
    public Box(int maximumCapacity) {
        this.maxCapacity = maximumCapacity;
        this.contents = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {        
        if ((this.getVolume() + thing.getVolume()) <= this.maxCapacity) {
            contents.add(thing);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int getVolume() {
        int totalVolume = 0;
        for (Thing t : contents) {
            totalVolume += t.getVolume();
        }
        return totalVolume;
    }
}
