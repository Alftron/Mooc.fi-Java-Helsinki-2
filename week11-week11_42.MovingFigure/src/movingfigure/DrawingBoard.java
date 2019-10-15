
package movingfigure;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingBoard extends JPanel {
    
    Figure figure;
    
    public DrawingBoard(Figure item) {
        this.figure = item;
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        figure.draw(graphics);
    }
    
}
