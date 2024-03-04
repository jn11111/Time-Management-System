import javax.swing.BoxLayout;

public class applicant extends myJPanel {
    myJTable myJTable;
    adminActionPanel adminActionPanel;

    applicant() {
        this.setPreferredSize(getPreferredSize());
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(myJTable = new myJTable());
        this.add(adminActionPanel = new adminActionPanel());
    }
}
