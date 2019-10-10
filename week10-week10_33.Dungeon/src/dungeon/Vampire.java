
package dungeon;

public class Vampire {
    
    private int x;
    private int y;
    
    public Vampire(int x, int y) {
        // Constructor of the vampire class and sets the co-ordinates
        this.x = x;
        this.y = y;
    }
    
    public boolean vampireSpace(int x, int y) {
        // Returns true if the vampire co-ordinates match the parameters
        return this.x == x && this.y == y;
    }
    
    @Override
    public String toString() {
        return "v " + this.x + " " + this.y + " ";
    }
    
}
