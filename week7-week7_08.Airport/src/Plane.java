
/**
 *
 * @author martinh
 */

public class Plane {
    
    private String ID;
    private int capacity;
    
    public Plane(String id, int size) {
        this.ID = id;
        this.capacity = size;
    }
    
    @Override
    public String toString() {
        return this.ID + " (" + this.capacity + " ppl)";
    }
}
