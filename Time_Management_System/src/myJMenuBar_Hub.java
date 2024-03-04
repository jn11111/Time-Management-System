import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class myJMenuBar_Hub extends JMenuBar {
    static JMenu file;
    static JMenuItem apply, login, exit;

    myJMenuBar_Hub() {
        file = new JMenu("Action");

        apply = new JMenuItem("Apply");
        login = new JMenuItem("Login");
        exit = new JMenuItem("Exit");
        file.add(apply);
        file.add(login);
        file.add(exit);

        this.add(file);

    }

    public void addActionListenerToApply(ActionListener listener) {
        apply.addActionListener(listener);
    }

    public void addActionListenerToLogin(ActionListener listener) {
        login.addActionListener(listener);
    }

    public void addActionListenerToExit(ActionListener listener) {
        exit.addActionListener(listener);
    }
}