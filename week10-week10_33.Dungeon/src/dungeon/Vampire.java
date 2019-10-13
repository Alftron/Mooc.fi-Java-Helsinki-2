
package dungeon;

import java.util.Random;
import java.util.List;
import java.util.LinkedList;

public class Vampire extends Player{
    
    Random random;
    
    public Vampire(int x, int y, int maxX, int maxY) {
        super(x, y, maxX, maxY);
        random = new Random();
    }
     
    public void moveVampires(List<Vampire> vampires) {
        // Move the vampires given in the parameter
        int direction = random.nextInt(4);
        switch (direction) {
            case 0:
                // Up
                this.moveUp(vampires);
                break;
            case 1:
                // Right
                this.moveRight(vampires);
                break;
            case 2:
                // Down
                this.moveDown(vampires);
                break;
            case 3:
                // Left
                this.moveLeft(vampires);
                break;
        }
    }
    
    public void moveUp(List<Vampire> vampires) {
        for (Vampire v : vampires) {
            if (this.sameSpaceAfterMove(0, -1, v)) {
                return;
            }
        }
        this.moveUp();
    }
    
    public void moveRight(List<Vampire> vampires) {
        for (Vampire v : vampires) {
            if (this.sameSpaceAfterMove(1, 0, v)) {
                return;
            }
        }
        this.moveRight();
    }
    
    public void moveDown(List<Vampire> vampires) {
        for (Vampire v : vampires) {
            if (this.sameSpaceAfterMove(0, 1, v)) {
                return;
            }
        }
        this.moveDown();      
    }
    
    public void moveLeft(List<Vampire> vampires) {
        for (Vampire v : vampires) {
            if (this.sameSpaceAfterMove(-1, 0, v)) {
                return;
            }
        }
        this.moveLeft();
    }
    
    @Override
    public String toString() {
        return "v " + this.getX() + " " + this.getY() + " ";
    }
    
}
