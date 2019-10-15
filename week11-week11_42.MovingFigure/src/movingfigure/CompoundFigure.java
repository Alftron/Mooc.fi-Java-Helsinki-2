
package movingfigure;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class CompoundFigure extends Figure {
    
    private List<Figure> figures;

    public CompoundFigure() {
        this.figures = new ArrayList<Figure>();
    }
    
    public void add(Figure f) {
        figures.add(f);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.black);
        for (Figure item : figures) {
            item.draw(graphics);
        }
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Figure item : figures) {
            item.move(dx, dy);
        }
    }
    
}
