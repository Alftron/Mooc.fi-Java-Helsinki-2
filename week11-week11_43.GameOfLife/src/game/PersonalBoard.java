
package game;

import gameoflife.GameOfLifeBoard;

import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard {

    private Random random;
    
    public PersonalBoard(int width, int height) {
        super(width, height);
        random = new Random();
    }
    
    public boolean insideBoard(int x, int y) {
        if (x < 0 || y < 0 || x >= super.getWidth() || y >= super.getHeight()) {
            return false;
        }
        return true;
    }

    @Override
    public void initiateRandomCells(double d) {
        
        for (int y = 0; y < super.getHeight(); y++) {
            for (int x = 0; x < super.getWidth(); x++) {
                double randomNum = random.nextDouble();
                    if (randomNum <= d) {
                        // Cell is alive
                        turnToLiving(x, y);
                    } else {
                        turnToDead(x, y);
                    }
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (insideBoard(x, y) && super.getBoard()[x][y] == true) {
            return true;
        }
        return false;
    }

    @Override
    public void turnToLiving(int x, int y) {
        if (insideBoard(x, y)) {
            super.getBoard()[x][y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if (insideBoard(x, y)) {
            super.getBoard()[x][y] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int numAlive = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int k = y - 1; k <= y + 1; k++) {
                if (isAlive(i, k)) {
                    numAlive++;
                }
            }
        }
        
        if (isAlive(x, y)) {
            numAlive--;
        }
        return numAlive;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if (livingNeighbours < 2 || livingNeighbours > 3) {
            turnToDead(x, y);
        } else if(livingNeighbours == 3) {
            turnToLiving(x, y);
        }
        
    }
    
}
