import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class myJFrame_hub extends JFrame {
    myJMenuBar_Hub myJMenuBar = new myJMenuBar_Hub();
    CardLayout layout = new CardLayout();
    Login login;
    newApplication apply;
    myJPanel myJPanel;
    myJOptionPane optionPane;

    myJFrame_hub() {
        // setting the Frame configuration in myJFrame constructor
        this.setTitle("Time Management System");
        this.setBackground(Color.gray);
        this.setSize(680, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        myJPanel = new myJPanel();
        myJPanel.setLayout(layout);
        this.getContentPane().add(myJPanel);

        myJPanel.add(login = new Login(this), "Login");
        myJPanel.add(apply = new newApplication(), "Apply");

        this.setJMenuBar(myJMenuBar);

        myJMenuBar.addActionListenerToLogin(e -> layout.show(myJPanel, "Login"));
        myJMenuBar.addActionListenerToApply(e -> layout.show(myJPanel, "Apply"));
        myJMenuBar.addActionListenerToExit((e) -> {
            optionPane = new myJOptionPane("Are you sure?", "Exit", 0, 3);
            int getOptionPaneResult = optionPane.getResult();
            if (getOptionPaneResult == 0) {
                System.exit(0);
            }
        });
        // the frame sometimes don't show without setting it visible.
        this.setVisible(true);
    }

    public void newFrame(ActionListener e) {
        this.dispose();
    }
}
