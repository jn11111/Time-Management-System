import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class myJFrame_main extends JFrame {
    myJMenuBar_Main myJMenuBar_Main = new myJMenuBar_Main();
    CardLayout layout = new CardLayout();
    employee employee;
    applicant applicant;
    myJPanel myJPanel;

    myJFrame_hub myJFrame_hub;
    private String getAccess = "aadmin";

    myJFrame_main() {
        this.setTitle("Time Management System");
        this.setBackground(Color.lightGray);
        this.setSize(680, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        if (getAccess != "admin") {
            nonAdminAction();
        } else {
            adminAction();
        }

        this.setVisible(true);
    }

    private void adminAction() {
        myJPanel = new myJPanel();

        myJPanel.setLayout(layout);
        this.getContentPane().add(myJPanel);

        myJPanel.add(employee = new employee(), "Employee");
        myJPanel.add(applicant = new applicant(), "Applicant");

        this.setJMenuBar(myJMenuBar_Main);

        myJMenuBar_Main.addActionListenerToEmployee(e -> layout.show(myJPanel, "Employee"));
        myJMenuBar_Main.addActionListenerToApplicant(e -> layout.show(myJPanel, "Applicant"));
        myJMenuBar_Main.addActionListenerToLogout((e) -> {
            this.dispose();
            myJFrame_hub = new myJFrame_hub();
        });

    }

    private void nonAdminAction() {
        employee_entry employee_entry = new employee_entry();
        this.add(employee_entry);
    }
}
