import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class timeStamps extends myJPanel {
    adminActionPanel adminActionPanel;
    myJTable myJTable;
    DefaultTableModel model;
    Object status;
    Object firstColumnValue = 0;
    database database;

    timeStamps() {
        database = new database();
        model = new database().getDataForAdmin("timestamps");
        adminActionPanel = new adminActionPanel();
        JScrollPane jScrollPane = new JScrollPane(this.myJTable = new myJTable(model));
        this.setPreferredSize(getPreferredSize());
        this.setBackground(Color.gray);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(jScrollPane);
        myJTable.getSelectionModel().addListSelectionListener(e -> {
            // Check if the selection is adjusting (i.e., selection is in progress)
            if (!e.getValueIsAdjusting()) {
                // Get the index of the selected row
                int selectedRow = myJTable.getSelectedRow();
                if (selectedRow != -1) { // Check if a row is selected
                    // Get the value of the cell in the first column of the selected row
                    this.firstColumnValue = myJTable.getValueAt(selectedRow, 0);
                    this.status = myJTable.getValueAt(selectedRow, 5);
                    // Do something with the first column value (e.g., print it)
                    System.out.println("First column value: " + firstColumnValue + "::" + status + "::");
                    if (status.toString().contains("PENDING")) {
                        System.out.println("ee");
                        btnEnabler(true);
                    } else {
                        btnEnabler(false);
                    }
                }
            }
        });
        adminActionPanel.AcceptBTN((e) -> {
            System.out.println("ACCEPT");
            database.changeTimestampsStatus((int) firstColumnValue, 2);
            model = new database().getDataForAdmin("timestamps");
            btnEnabler(false);
            myJTable.setModel(model);
        });
        adminActionPanel.DenyBTN((e) -> {
            database.changeTimestampsStatus((int) firstColumnValue, 3);
            model = new database().getDataForAdmin("timestamps");
            myJTable.setModel(model);
            btnEnabler(false);
            System.out.println("DENY");
        });
        this.add(adminActionPanel);
    }

    public void btnEnabler(boolean a) {
        adminActionPanel.getComponent(0).setEnabled(a);
        adminActionPanel.getComponent(1).setEnabled(a);
    }
}
