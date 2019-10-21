
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import wormgame.game.WormGame;
import wormgame.domain.Piece;

import javax.swing.JPanel;

public class DrawingBoard extends JPanel implements Updatable {
    
    private WormGame game;
    private int pieceLength;
    
    public DrawingBoard (WormGame game, int pieceLength) {
        this.game = game;
        this.pieceLength = pieceLength;
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        for (Piece piece : game.getWorm().getPieces()) {
            graphics.setColor(Color.black);
            graphics.fill3DRect(pieceLength * piece.getX(), pieceLength * piece.getY(), pieceLength, pieceLength, true);
        }
        
        graphics.setColor(Color.RED);
        graphics.fillOval(pieceLength * game.getApple().getX(), pieceLength * game.getApple().getY(), pieceLength, pieceLength);
    }
    
    @Override
    public void update() {
        super.repaint();
    }
    
}
