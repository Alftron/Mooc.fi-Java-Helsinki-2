
package dungeon;

public class Player {
    
    private int remainingMoves;
    private int x;
    private int y;
    
    public Player(int moves) {
        remainingMoves = moves;
        //Player always starts at 0,0
        this.x = 0;
        this.y = 0;
    }
    
    public boolean playerSpace(int x, int y) {
        // Returns true if the player co-ordinates match the parameters
        return this.x == x && this.y == y;
    }
    
    public int getRemainingMoves() {
        return remainingMoves;
    }
    
    public boolean movesRemaining() {
        return remainingMoves > 0;
    }
    
    @Override
    public String toString() {
        return "@ " + this.x + " " + this.y + " ";
    }
    
}
