
package movable;

import java.util.List;
import java.util.ArrayList;

public class Group implements Movable{
    
    private List<Movable> movableGroup;
    
    public Group() {
        movableGroup = new ArrayList<Movable>();
    }
    
    public void addToGroup(Movable movable) {
        movableGroup.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Movable item : movableGroup) {
            item.move(dx, dy);
        }
    }
    
    @Override
    public String toString() {
        String positions = "";
        for (Movable item : movableGroup) {
            positions += item.toString();
            positions += "\n";
        }
        return positions;
    }
}
