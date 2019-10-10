
package dungeon;

import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;

public class Dungeon {
    
    private int length;
    private int height;
    private int movesRemaining;
    private boolean vampiresMove;
    private List<Vampire> vampires;
    private Random random;
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
            this.movesRemaining = moves;
            this.vampiresMove = vampiresMove;
            this.player = new Player(0, 0, length - 1, height - 1);
            this.vampires = new LinkedList<Vampire>();
            addVampires(vampires);
            input = new Scanner(System.in);
        } else {
            throw new IllegalStateException("Incorrect game state!");
        }
    }
    
    public void run() {
        // Main run loop of the game
        while (this.movesRemaining > 0) {
            drawGameScreen();
            char[] moves = getInput();
            this.movesRemaining--;
            System.out.println(this.movesRemaining);
        }
    }
    
    public void drawGameScreen() {
        // Write number of moves remaining
        System.out.println(this.movesRemaining);
        System.out.println();
        
        // Write everyones co-ordinates
        System.out.println(player);
        for (Vampire v : vampires) {
            System.out.println(v);
        }
        
        // Draw the game board
    }
    
    public char[] getInput() {
        String in = input.nextLine();
        return in.toCharArray();
    }
    
    public void addVampires(int num) {
        // Populates the vampires list with amount given by parameter
        int randomX = random.nextInt(this.length);
        int randomY = random.nextInt(this.height);
        
        
    }
    
}
