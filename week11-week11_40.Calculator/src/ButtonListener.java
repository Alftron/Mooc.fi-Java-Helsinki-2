
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ButtonListener implements ActionListener {
    
    private JButton plusButton;
    private JButton minusButton;
    private JButton resetButton;
    private JTextField input;
    private JTextField output;
    private Calculator calculator;
    
    public ButtonListener(JButton plusButton, JButton minusButton, JButton resetButton,
                            JTextField input, JTextField output) {
        this.plusButton = plusButton;
        this.minusButton = minusButton;
        this.resetButton = resetButton;
        this.input = input;
        this.output = output;
        calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int amount = 0;
        try {
            amount = Integer.parseInt(input.getText());        
        } catch (NumberFormatException ex) {
            
        }

        if (e.getSource() == this.plusButton) {
            calculator.increaseValue(amount);
        } else if (e.getSource() == this.minusButton) {
            calculator.decreaseValue(amount);
        } else if (e.getSource() == this.resetButton) {
            calculator.resetValue();
        }
        output.setText(Integer.toString(calculator.getValue()));
        input.setText("");
        setResetButton();
    }
    
    public void setResetButton() {
        if (calculator.getValue() == 0) {
            resetButton.setEnabled(false);
        } else {
            resetButton.setEnabled(true);
        }
    }
    
}
