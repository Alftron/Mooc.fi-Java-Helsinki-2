package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.gui.Updatable;
import wormgame.domain.Worm;
import wormgame.domain.Apple;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;
    private Random random;

    public WormGame(int width, int height) {
        super(1000, null);
        random = new Random();

        this.width = width;
        this.height = height;
        this.continues = true;
        
        this.worm = new Worm(width/2, height/2, Direction.DOWN);
        createApple();

        addActionListener(this);
        setInitialDelay(2000);

    }
    
    public void createApple() {
        int appleX = random.nextInt(width);
        int appleY = random.nextInt(height);
        this.apple = new Apple(appleX, appleY);
        
        while(worm.runsInto(apple)) {
            appleX = random.nextInt(width);
            appleY = random.nextInt(height);
            this.apple = new Apple(appleX, appleY);
        }
    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }
    
    public void setWorm(Worm worm) {
        this.worm = worm;
    }
    
    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    public Worm getWorm() {
        return worm;
    }
    
    public Apple getApple() {
        return apple;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        worm.move();
        if (worm.runsInto(apple)) {
            worm.grow();
            createApple();
        } else if (worm.runsIntoItself()) {
            continues = false;
        } else if (worm.getHead().getX() < 0 || worm.getHead().getX() == this.width) {
            continues = false;
        } else if (worm.getHead().getY() < 0 || worm.getHead().getY() == this.height) {
            continues = false;
        }
        updatable.update();
        setDelay(1000 / worm.getLength());
    }

}
