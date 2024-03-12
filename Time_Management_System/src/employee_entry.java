import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class employee_entry extends myJPanel {
    myJTable myJTable;
    JTable jtable;
    GridBagLayout layout;
    String target;
    DefaultTableModel model;
    int id;
    database database = new database();
    JScrollPane jScrollPane;
    Object firstColumnValue = -1;

    employee_entry(String target, int id) {
        this.target = target;
        this.id = id;
        System.out.println(id);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(getPreferredSize());
        if (target.toString() == "Employees") {
            model = database.getDataForTimeStamps(target, this.id);
            jScrollPane = new JScrollPane(myJTable = new myJTable(model));
            this.add(jScrollPane);
            this.add(employeePanel());
        } else {
            model = database.getDataForApplication(target, this.id);
            jScrollPane = new JScrollPane(myJTable = new myJTable(model));
            this.add(jScrollPane);
            this.add(applicantPanel());
        }
        this.setVisible(true);
        myJTable.getSelectionModel().addListSelectionListener(e -> {
            // Check if the selection is adjusting (i.e., selection is in progress)
            if (!e.getValueIsAdjusting()) {
                // Get the index of the selected row
                int selectedRow = myJTable.getSelectedRow();
                if (selectedRow != -1) { // Check if a row is selected
                    // Get the value of the cell in the first column of the selected row
                    this.firstColumnValue = myJTable.getValueAt(selectedRow, 0);
                    // Do something with the first column value (e.g., print it)
                    System.out.println("First column value: " + firstColumnValue);
                }
            }
        });
    }

    private JPanel employeePanel() {
        myJPanel myJPanel = new myJPanel();
        myJButton timeIn = new myJButton("Time IN");
        myJButton timeOut = new myJButton("Time Out");
        myJPanel.add(timeIn);
        myJPanel.add(timeOut);
        timeIn.setEnabled(database.TimeIN(this.id));
        timeIn.addActionListener((e) -> {
            database.InsertTimeIN(id);
            timeIn.setEnabled(false);
            model = database.getDataForTimeStamps(target, this.id);
            myJTable.setModel(model);
            myJTable.repaint();
        });
        timeOut.addActionListener((e) -> {
            System.out.println(((int) this.firstColumnValue));
            if (firstColumnValue.toString() != "-1") {
                if (database.TimeOut(this.id, ((int) this.firstColumnValue)) != true) {
                    database.InsertTimeOut(((int) this.firstColumnValue));
                    model = database.getDataForTimeStamps(target, this.id);
                    myJTable.setModel(model);
                    myJTable.repaint();
                } else {
                    System.out.println("already timed");
                }
            }
        });
        return myJPanel;
    }

    String fn, ln, email, reason;

    private JPanel applicantPanel() {
        myJPanel myJPanel = new myJPanel();
        myJButton edit = new myJButton("Edit");
        Apply apply = new Apply("Update");
        edit.addActionListener((e) -> {
            JFrame myFrame = new JFrame();
            myFrame.setContentPane(apply);
            System.out.println("eaeae");
            apply.getBTN().addActionListener((a) -> {
                fn = apply.getFN();
                ln = apply.getLN();
                email = apply.getEmail();
                reason = apply.getReason();
                System.out.println(fn + ln + email + reason + "eh");
                database.updateApplication(fn, ln, email, reason, this.id);
                model = database.getDataForApplication(target, this.id);
                myJTable.setModel(model);
                myJTable.repaint();
                myFrame.dispose();
            });
            myFrame.pack();
            myFrame.setLocationRelativeTo(null);
            myFrame.setVisible(true);
        });
        myJPanel.add(edit);
        return myJPanel;
    }
}
