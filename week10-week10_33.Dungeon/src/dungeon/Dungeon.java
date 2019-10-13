
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
            moveCharacters(moves);
            this.movesRemaining--;
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
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.length; x++) {
                boolean characterPrinted = false;
                // Tester object to compare places
                Player tester = new Player(x, y, this.length - 1, this.height -1);
                
                // Test for player
                if (player.sameSpace(tester)) {
                    System.out.print("@");
                    characterPrinted = true;
                }
                
                // Test for vampire
                for (Player p : this.vampires) {
                    if (p.sameSpace(tester)) {
                        System.out.print("v");
                        characterPrinted = true;
                        break;
                    }
                }
                
                // Nothing here so print dot
                if (!characterPrinted) {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public char[] getInput() {
        String in = input.nextLine().toLowerCase();
        return in.toCharArray();
    }
    
    public void moveCharacters(char[] moves) {
        for (int x = 0; x < moves.length; x++) {
            // Move the player once
            player.moveCharacter(moves[x]);
            
            /*
            // Move all the vampires once ensuring we won't bump into another vampire
            for (Vampire v : this.vampires) {
                v.moveCharacter();
            }
            */
            
            // Check if the player has touched any vampires and destroy them if so
            for (int v = 0; v < this.vampires.size(); v++) {
                if (this.player.sameSpace(this.vampires.get(v))) {
                    // Player is touching a vampire so remove it!
                    killVampire(v);
                }
            }
        }
    }
    
    public void addVampires(int num) {
        // Populates the vampires list with amount given by parameter
        Random random = new Random();
        for (int x = 1; x <= num; x++) {
            // Keep looping to get a valid vampire
            while (true) {
                int randomX = random.nextInt(this.length);
                int randomY = random.nextInt(this.height);
                boolean occupiedSpace = false;
        
                Vampire newVampire = new Vampire(randomX, randomY, this.length -1, this.height -1);
                
                // Check for a player in the space
                occupiedSpace = player.sameSpace(newVampire);
                
                // Check for a vampire in the space
                for (Vampire v: this.vampires) {
                    if (v.sameSpace(newVampire)) {
                        occupiedSpace = true;
                    }
                }
                
                if (!occupiedSpace) {
                    vampires.add(newVampire);
                    break;
                }   
            }
        }
    }
    
    public void killVampire(int whichVamp) {
        // Takes an index number to remove from the LinkedList of vampires
        this.vampires.remove(whichVamp);
    }
    
}
