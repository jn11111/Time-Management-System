import javax.swing.table.DefaultTableModel;

public class newApplication extends myJPanel {
    Apply apply;
    String fname, lname, email, reason;
    database database;
    DefaultTableModel model;
    myJOptionPane optionPane;

    newApplication() {
        database = new database();
        apply = new Apply("Apply");
        this.add(apply);
        apply.getBTN().addActionListener((a) -> {
            optionPane = new myJOptionPane("Done filling out?", "Apply", 1, 3);
            int getOptionPaneResult = optionPane.getResult();
            System.out.println(getOptionPaneResult);
            if (getOptionPaneResult == 0) {
                this.fname = apply.getFN();
                this.lname = apply.getLN();
                this.email = apply.getEmail();
                this.reason = apply.getReason();
                Boolean check = database.checkIncoming(this.fname, this.email);
                if (!check) {
                    database.newIncoming(fname, lname, email, reason);
                    optionPane = new myJOptionPane("Go, Login?", "Login", 1, 3);
                    if (optionPane.result == 0) {

                    }
                } else {
                    optionPane = new myJOptionPane("Your Credential is already in the database", "Error", 2, 1);
                }
            }
        });
    }
}
