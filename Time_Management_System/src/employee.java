import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class employee extends myJPanel {
    myJTable myJTable;
    DefaultTableModel model;

    employee() {
        model = new database().getDataForAdmin("employees");
        JScrollPane jScrollPane = new JScrollPane(new myJTable(model));
        this.setPreferredSize(getPreferredSize());
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(jScrollPane);
    }
}
