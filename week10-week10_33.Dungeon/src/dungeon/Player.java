
package dungeon;

public class Player {
    
    private int x;
    private int maxX;
    private int y;
    private int maxY;
    
    public Player(int x, int y, int maxX, int maxY) {
        //Player always starts at 0,0
        this.x = x;
        this.y = y;
        this.maxX = maxX;
        this.maxY = maxY;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void moveCharacter(char direction) {
        switch (direction) {
            case 'w':
                this.moveUp();
                break;
            case 'd':
                this.moveRight();
                break;
            case 's':
                this.moveDown();
                break;
            case 'a':
                this.moveLeft();
                break;
        }
    }
    
    public void moveUp() {
        if (this.y > 0) {
            this.y--;
        }
    }
    
    public void moveRight() {
        if (this.x < this.maxX) {
            this.x++;
        }
    }
    
    public void moveDown() {
        if (this.y < this.maxY) {
            this.y++;
        }
    }
    
    public void moveLeft() {
        if (this.x > 0) {
            this.x--;
        }
    }
    
    public boolean sameSpace(Player other) {
        // Returns if the two objects occupy the same space
        return this.getX() == other.getX() && this.getY() == other.getY();
    }
    
    public boolean sameSpaceAfterMove(int dx, int dy, Player other) {
        // Returns if the two objects WILL occupy the same space
        if (this.x + dx == other.getX() && this.y + dy == other.getY()) {
            return true;
        }
        
        return false;    
    }
    
    @Override
    public String toString() {
        return "@ " + this.getX() + " " + this.getY() + " ";
    }
    
}
