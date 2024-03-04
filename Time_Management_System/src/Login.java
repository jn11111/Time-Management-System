import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class Login extends JPanel {
    myJButton login;
    myJFrame_hub myJFrame_hub;
    myJFrame_main myJFrame_main;

    Login(myJFrame_hub hub) {
        this.myJFrame_hub = hub;
        // set layout
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        // adding constraints in the layout.
        GridBagConstraints c = new GridBagConstraints();
        // set constraints initial values
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0;
        c.weighty = 0;
        c.insets = new Insets(8, 8, 8, 8);
        // instantiating custom labels. adding them to the container with corresponding
        // constraint for the layout
        myJLabel firstName = new myJLabel("First Name");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;

        this.add(firstName, c);
        myJLabel email = new myJLabel("Email");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;

        this.add(email, c);

        // instantiating custom textfields. adding them to the container with
        // corresponding constraint for the layout
        myJTextField firstName_tf = new myJTextField();
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 2;

        this.add(firstName_tf, c);
        myJTextField lastName_tf = new myJTextField();
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;

        this.add(lastName_tf, c);

        // instantiating custom button. adding them to the container with
        // corresponding constraint for the layout
        login = new myJButton("Login");
        login.addActionListener((e) -> {
            myJFrame_hub.dispose();
            myJFrame_main = new myJFrame_main();
        });
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        this.add(login, c);
        this.setVisible(true);
    }
}
