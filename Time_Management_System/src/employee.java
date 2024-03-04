import java.awt.Color;

import javax.swing.BoxLayout;

public class employee extends myJPanel {
    adminActionPanel adminActionPanel;
    myJTable myJTable;

    employee() {
        this.setPreferredSize(getPreferredSize());
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(myJTable = new myJTable());
        this.add(adminActionPanel = new adminActionPanel());
    }
}
