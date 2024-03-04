import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class employee_entry extends JPanel {
    myJTable myJTable;
    GridBagLayout layout;
    GridBagConstraints c = new GridBagConstraints();

    employee_entry() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(layout = new GridBagLayout());

        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0;
        c.weighty = 0;
        this.add(myJTable = new myJTable(), c);

        this.setVisible(true);
    }
}
