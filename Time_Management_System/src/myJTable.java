import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class myJTable extends JTable {
    String[][] data = {
            { "Kundan Kumar Jha", "4031", "CSE" },
            { "Anand Jha", "6014", "IT" }
    };

    // Column Names

    myJTable() {
        this.setGridColor(Color.BLUE);
        // this.setRowHeight(35);
        this.setPreferredSize(preferredViewportSize);
        this.setBorder(BorderFactory.createDashedBorder(gridColor, 1, 10, .3f, true));

        DefaultTableModel model = new DefaultTableModel(
                new Object[][] {}, // Initial data (none)
                new String[] { "Name", "Roll Number", "Department" });
        this.setModel(model);

        Object[] row1 = { "Kundan Kumar Jha", "4031", "CSE" };
        model.addRow(row1);
        Object[] row2 = { "Anand Jha", "6014", "IT" };
        model.addRow(row2);
    }
}
