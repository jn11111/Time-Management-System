import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class myJMenuBar_Main extends JMenuBar {
    static JMenu file;
    static JMenuItem timestamps, employee, applicant, logout;

    myJMenuBar_Main() {
        file = new JMenu("Action");
        timestamps = new JMenuItem("Entry");
        employee = new JMenuItem("Employee");
        applicant = new JMenuItem("Applicant");
        logout = new JMenuItem("Logout");
        file.add(timestamps);
        file.add(employee);
        file.add(applicant);
        file.add(logout);

        this.add(file);

    }

    public void addActionListenerToEntry(ActionListener listener) {
        timestamps.addActionListener(listener);
    }

    public void addActionListenerToEmployee(ActionListener listener) {
        employee.addActionListener(listener);
    }

    public void addActionListenerToApplicant(ActionListener listener) {
        applicant.addActionListener(listener);
    }

    public void addActionListenerToLogout(ActionListener listener) {
        logout.addActionListener(listener);
    }
}