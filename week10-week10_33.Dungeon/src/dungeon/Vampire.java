
package dungeon;

import java.util.Random;

public class Vampire extends Player{
    
    Random random;
    
    public Vampire(int x, int y, int maxX, int maxY) {
        super(x, y, maxX, maxY);
        random = new Random();
    }
    
    public void moveCharacter() {
        // Vampire moves once in a random 4 way direction
        int direction = random.nextInt(4);
        switch (direction) {
            case 0:
                // Up
                this.moveUp();
                break;
            case 1:
                // Right
                this.moveRight();
                break;
            case 2:
                // Down
                this.moveDown();
                break;
            case 3:
                // Left
                this.moveLeft();
                break;
        }
    }
    
    @Override
    public String toString() {
        return "v " + this.getX() + " " + this.getY() + " ";
    }
    
}
