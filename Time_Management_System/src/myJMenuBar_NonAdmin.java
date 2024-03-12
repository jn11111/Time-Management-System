import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class myJMenuBar_NonAdmin extends JMenuBar {
    static JMenu file;
    static JMenuItem logout;

    myJMenuBar_NonAdmin() {
        file = new JMenu("Action");
        logout = new JMenuItem("Logout");
        file.add(logout);

        this.add(file);
    }

    public void addActionListenerToLogout(ActionListener listener) {
        logout.addActionListener(listener);
    }
}
