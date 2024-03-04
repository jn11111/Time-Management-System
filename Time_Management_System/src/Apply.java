import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Insets;

public class Apply extends JPanel {
    Apply() {
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
        myJLabel lastName = new myJLabel("Last Name");
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;

        this.add(lastName, c);
        myJLabel email = new myJLabel("Email");
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;

        this.add(email, c);
        myJLabel reason = new myJLabel("Reason");
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        this.add(reason, c);

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
        myJTextField email_tf = new myJTextField();
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;

        this.add(email_tf, c);

        JTextArea reason_ta = new JTextArea(10, 14);
        reason_ta.setLineWrap(true);
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 3;
        this.add(reason_ta, c);
        // instantiating custom button. adding them to the container with
        // corresponding constraint for the layout
        myJButton login = new myJButton("Apply");
        c.gridx = 2;
        c.gridy = 5;
        c.gridwidth = 1;
        this.add(login, c);
        this.setVisible(true);
    }
}
