
package wormgame.domain;

import wormgame.Direction;

import java.util.List;
import java.util.ArrayList;

public class Worm {
    
    private int x;
    private int y;
    private Direction direction;
    private List<Piece> worm;
    private boolean grow;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.direction = originalDirection;
        this.x = originalX;
        this.y = originalY;
        this.worm = new ArrayList<Piece>();
        this.worm.add(new Piece(originalX, originalY));
        this.grow = false;
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction dir) {
        direction = dir;
    }
    
    public int getLength() {
        return getPieces().size();
    }
    
    public List<Piece> getPieces() {
        return worm;
    }
    
    public void move() {
        int dx = worm.get(worm.size() - 1).getX();
        int dy = worm.get(worm.size() - 1).getY();
        switch (getDirection()) {
            case UP:
                dy--;
                break;
            case RIGHT:
                dx++;
                break;
            case DOWN:
                dy++;
                break;
            case LEFT:
                dx--;
                break;
        }
        
        if (getLength() > 2 && !grow) {
            worm.remove(0);
        }
        
        if (grow) {
            grow = false;
        }
        
        worm.add(new Piece(dx, dy));

    }
    
    public void grow() {
        grow = true;
    }
    
    public boolean runsInto(Piece piece) {
        return false;
    }
    
    public boolean runsIntoItself() {
        return false;
    }
    
}
