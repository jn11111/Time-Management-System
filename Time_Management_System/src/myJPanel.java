import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class myJPanel extends JPanel {
    myJPanel() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setPreferredSize(new Dimension(500, 280));
    }
}
