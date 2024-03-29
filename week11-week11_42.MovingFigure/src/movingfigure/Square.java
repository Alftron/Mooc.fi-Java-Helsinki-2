
package movingfigure;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Figure {
    
    private int sideLength;

    public Square(int x, int y, int sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.fillRect(getX(), getY(), sideLength, sideLength);
    }
    
}
