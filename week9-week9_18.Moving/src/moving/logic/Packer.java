
package moving.logic;

import moving.domain.Box;
import moving.domain.Thing;

import java.util.List;
import java.util.ArrayList;

public class Packer {
    
    private int boxVolume;
    
    public Packer(int boxesVolume) {
        this.boxVolume = boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();
        
        for (Thing t: things) {
            Box box = new Box(this.boxVolume);
            box.addThing(t);
            boxes.add(box);
        }
        return boxes;
    }
    
}
