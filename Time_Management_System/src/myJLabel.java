import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class myJLabel extends JLabel {
    myJLabel(String title) {
        this.setText(title);
        this.setForeground(Color.darkGray);
        this.setFont(new Font("calibri", Font.PLAIN, 16));
        this.setPreferredSize(new Dimension(85, 24));
        this.setHorizontalAlignment(SwingConstants.RIGHT);
        this.setOpaque(true);
        this.setVisible(true);
    }
}
