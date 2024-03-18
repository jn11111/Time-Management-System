import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class applicant extends myJPanel {
    myJTable myJTable;
    adminActionPanel adminActionPanel;
    DefaultTableModel model;
    Object firstColumnValue = 0;
    database database;
    Object fname, lname, email, status;
    myJOptionPane optionPane;

    applicant() {
        adminActionPanel = new adminActionPanel();
        model = new database().getDataForAdmin("incomings");
        database = new database();
        JScrollPane jScrollPane = new JScrollPane(this.myJTable = new myJTable(model));
        this.setPreferredSize(getPreferredSize());
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
                    this.fname = myJTable.getValueAt(selectedRow, 1);
                    this.lname = myJTable.getValueAt(selectedRow, 2);
                    this.email = myJTable.getValueAt(selectedRow, 3);
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
            optionPane = new myJOptionPane("Are you sure?", "APPROVE?", 0, 1);
            if (optionPane.getResult() == 0) {
                System.out.println("ACCEPT");
                System.out.println(this.fname.toString() + this.lname.toString() + this.email.toString());
                database.changeIncomingStatus((int) this.firstColumnValue, 2, this.fname.toString(),
                        this.lname.toString(), this.email.toString());
                model = new database().getDataForAdmin("incomings");
                btnEnabler(false);
                myJTable.setModel(model);
            }
        });
        adminActionPanel.DenyBTN((e) -> {
            optionPane = new myJOptionPane("Are you sure?", "DENY?", 0, 1);
            if (optionPane.getResult() == 0) {
                System.out.println("DENY " + this.firstColumnValue);
                database.changeIncomingStatus((int) this.firstColumnValue, 3, this.fname.toString(),
                        this.lname.toString(), this.email.toString());
                model = new database().getDataForAdmin("incomings");
                myJTable.setModel(model);
                btnEnabler(false);
            }
        });
        this.add(adminActionPanel);
        this.repaint();
    }

    public void btnEnabler(boolean a) {
        adminActionPanel.getComponent(0).setEnabled(a);
        adminActionPanel.getComponent(1).setEnabled(a);
    }
}
