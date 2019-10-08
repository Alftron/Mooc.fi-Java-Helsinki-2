
package boxes;

import java.util.List;
import java.util.ArrayList;

public class OneThingBox extends Box{

    private List<Thing> boxedThing;
    
    public OneThingBox() {
        boxedThing = new ArrayList<Thing>();
    }
    
    @Override
    public void add(Thing thing) {
        if (boxedThing != null && boxedThing.size() == 0) {
            boxedThing.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if (boxedThing.contains(thing)) {
            return true;
        }
        return false;
    }
    
}
