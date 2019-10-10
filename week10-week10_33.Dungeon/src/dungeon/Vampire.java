
package dungeon;

public class Vampire extends Player{
    
    public Vampire(int x, int y, int maxX, int maxY) {
        super(x, y, maxX, maxY);
    }
    
    @Override
    public String toString() {
        return "v " + this.getX() + " " + this.getY() + " ";
    }
    
}
