
package dungeon;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Dungeon {
    
    private int length;
    private int height;
    private boolean vampiresMove;
    private List<Vampire> vampires;
    private Scanner input;
   
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
            this.vampiresMove = vampiresMove;
            this.player = new Player(moves);
            this.vampires = new ArrayList<Vampire>();
            input = new Scanner(System.in);
            addVampires(vampires);
        } else {
            throw new IllegalStateException("Incorrect game state!");
        }
    }
    
    public void run() {
        // Main run loop of the game
        if (this.player.movesRemaining()) {
            drawGameScreen();
        }
    }
    
    public void drawGameScreen() {
        // Draws the current moves and co-ordinates
        System.out.println(this.player.getRemainingMoves());
        System.out.println();
        System.out.println(this.player);
        for (Vampire v : this.vampires) {
            System.out.println(v);
        }
        System.out.println();
        
        // Now draw the actual game board
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.length; x++) {
                boolean playerSpace = this.player.playerSpace(x, y);
                boolean vampireSpace = false;
                for (Vampire v: this.vampires) {
                    if (v.vampireSpace(x, y)) {
                        vampireSpace = true;
                        break;
                    }
                }
                if (playerSpace) {
                    System.out.print("@");
                } else if (vampireSpace) {
                    System.out.print("v");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    
    public void addVampires(int numVampires) {
        // Takes the number of vampires as a parameter and gets them ready
        Random randomNum = new Random();
        for (int x = 1; x <= numVampires; x++) {
            // Need to find a way to check that the space isn't already occupied!
            int randomX = randomNum.nextInt(this.length);
            int randomY = randomNum.nextInt(this.height);
            this.vampires.add(new Vampire(randomX,randomY));
        }
    }
    
}
