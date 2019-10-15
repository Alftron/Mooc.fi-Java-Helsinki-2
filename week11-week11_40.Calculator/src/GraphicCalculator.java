
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {
    
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setLayout(new GridLayout(3, 1));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JTextField output = new JTextField("0");
        output.setEnabled(false);
        
        JTextField input = new JTextField("0");
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        JButton plusButton = new JButton("+");
        JButton minusButton = new JButton("-");
        JButton zButton = new JButton("Z");
        zButton.setEnabled(false);
        buttonPanel.add(plusButton);
        buttonPanel.add(minusButton);
        buttonPanel.add(zButton);
        
        ButtonListener listener = new ButtonListener(plusButton, minusButton, zButton, input, output);
        plusButton.addActionListener(listener);
        minusButton.addActionListener(listener);
        zButton.addActionListener(listener);
        
        container.add(output);
        container.add(input);
        container.add(buttonPanel);
    }

    public JFrame getFrame() {
        return frame;
    }
}
