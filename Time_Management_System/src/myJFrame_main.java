import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class myJFrame_main extends JFrame {
    myJMenuBar_Main myJMenuBar_Main = new myJMenuBar_Main();
    myJMenuBar_NonAdmin myJMenuBar_NonAdmin = new myJMenuBar_NonAdmin();
    CardLayout layout = new CardLayout();
    timeStamps timeStamps;
    employee employee;
    applicant applicant;
    myJPanel myJPanel;
    String name, email, target;
    int id;
    myJFrame_hub myJFrame_hub;

    employee_entry employee_entry;

    myJFrame_main(access Myaccess, String target, String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.target = target;
        this.id = id;
        this.setTitle("Time Management System");
        this.setBackground(Color.lightGray);
        this.setSize(680, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        if (Myaccess == access.Admin) {
            System.out.println(Myaccess);
            adminAction();
        } else {
            System.out.println(Myaccess);
            nonAdminAction();
        }

        this.setVisible(true);
    }

    private void adminAction() {
        myJPanel = new myJPanel();

        myJPanel.setLayout(layout);
        this.getContentPane().add(myJPanel);
        myJPanel.add(timeStamps = new timeStamps(), "TimeStamps");
        myJPanel.add(employee = new employee(), "Employee");
        myJPanel.add(applicant = new applicant(), "Applicant");

        this.setJMenuBar(myJMenuBar_Main);
        myJMenuBar_Main.addActionListenerToEntry(e -> layout.show(myJPanel, "TimeStamps"));
        myJMenuBar_Main.addActionListenerToEmployee(e -> layout.show(myJPanel, "Employee"));
        myJMenuBar_Main.addActionListenerToApplicant(e -> layout.show(myJPanel, "Applicant"));
        myJMenuBar_Main.addActionListenerToLogout((e) -> {
            this.dispose();
            myJFrame_hub = new myJFrame_hub();
        });

    }

    private void nonAdminAction() {
        this.setJMenuBar(myJMenuBar_NonAdmin);
        myJMenuBar_NonAdmin.addActionListenerToLogout((e) -> {
            this.dispose();
            myJFrame_hub = new myJFrame_hub();
        });
        this.add(employee_entry = new employee_entry(target, id));
    }
}
