
package dungeon;

public class Dungeon {
    
    private int length;
    private int height;
    private int vampires;
    private boolean vampiresMove;
   
    private Player player;
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        /*
        Length and height of game board, number of vampires, number of moves to start
        and if the vampires can move or not
        */
        if (length > 1 && height > 1 && vampires > 0 && moves > 0) {
            // We have a valid game situation so populate it
            this.length = length;
            this.height = height;
            this.vampires = vampires;
            this.vampiresMove = vampiresMove;
            player = new Player(moves);
        }
    }
    
    public void run() {
        
    }
    
}
