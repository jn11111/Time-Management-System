import javax.swing.JPanel;

public class adminActionPanel extends JPanel {
    myJButton Accept, Deny;

    adminActionPanel() {
        this.add(Accept = new myJButton("Accept"));
        this.add(Deny = new myJButton("Deny"));
        this.setOpaque(false);
    }
}
