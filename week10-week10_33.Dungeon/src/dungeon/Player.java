
package dungeon;

public class Player {
    
    private int x;
    private int maxX;
    private int y;
    private int maxY;
    
    public Player(int x, int y, int maxX, int maxY) {
        //Player always starts at 0,0
        this.x = x;
        this.y = x;
        this.maxX = maxX;
        this.maxY = maxY;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void moveUp() {
        this.y--;
    }
    
    public void moveRight() {
        this.x++;
    }
    
    public void moveDown() {
        this.y++;
    }
    
    public void moveLeft() {
        this.x--;
    }
    
    @Override
    public String toString() {
        return "@ " + this.getX() + " " + this.getY() + " ";
    }
    
}
