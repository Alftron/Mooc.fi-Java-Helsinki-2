
package noticeboard;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ActionEventListener implements ActionListener {
    
    private JTextField originText;
    private JLabel destLabel;
    
    public ActionEventListener(JTextField text, JLabel label) {
        originText = text;
        destLabel = label;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        destLabel.setText(originText.getText());
        originText.setText("");
    }
    
}
