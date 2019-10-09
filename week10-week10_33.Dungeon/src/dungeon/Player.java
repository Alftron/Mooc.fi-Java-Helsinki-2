
package dungeon;

public class Player {
    
    private int remainingMoves;
    
    public Player(int moves) {
        remainingMoves = moves;
    }
    
    @Override
    public String toString() {
        return "@ " + "x " + "y";
    }
    
}
