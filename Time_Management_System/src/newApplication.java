import javax.swing.table.DefaultTableModel;

public class newApplication extends myJPanel {
    Apply apply;
    String fname, lname, email, reason;
    database database;
    DefaultTableModel model;

    newApplication() {
        database = new database();
        apply = new Apply("Apply");
        this.add(apply);
        apply.getBTN().addActionListener((a) -> {
            this.fname = apply.getFN();
            this.lname = apply.getLN();
            this.email = apply.getEmail();
            this.reason = apply.getReason();
            System.out.println(fname + lname + email + reason);
            database.newIncoming(fname, lname, email, reason);
        });
    }
}
