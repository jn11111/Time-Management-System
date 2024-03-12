import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class adminActionPanel extends JPanel {
    myJButton Accept, Deny;

    adminActionPanel() {
        this.add(Accept = new myJButton("Accept"));
        this.add(Deny = new myJButton("Deny"));
        Accept.setEnabled(false);
        Deny.setEnabled(false);
        this.setOpaque(false);
    }

    public void AcceptBTN(ActionListener ActionListener) {
        this.Accept.addActionListener(ActionListener);
    }

    public void DenyBTN(ActionListener ActionListener) {
        this.Deny.addActionListener(ActionListener);
    }
}
