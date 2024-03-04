import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class myJPanel extends JPanel {
    myJPanel() {
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setPreferredSize(getPreferredSize());
    }
}
