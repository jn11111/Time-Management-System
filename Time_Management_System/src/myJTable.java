import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class myJTable extends JTable {
    DefaultTableModel model;
    // Column Names

    myJTable(DefaultTableModel model) {
        this.setGridColor(Color.BLUE);
        this.model = new DefaultTableModel();
        this.model = model;
        this.setAutoCreateColumnsFromModel(true);
        this.setBorder(BorderFactory.createDashedBorder(gridColor, 1, 10, .3f, true));
        this.setModel(this.model);
        this.setRowHeight(50);
        // this.setEnabled(false);
        // this.setRowSelectionAllowed(true); // Allow row selection by mouse
        // this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }
}
