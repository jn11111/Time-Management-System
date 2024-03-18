import javax.swing.JOptionPane;

public class myJOptionPane {
    int result = -1;

    myJOptionPane(String title, String message, int otype, int mtype) {
        this.result = JOptionPane.showConfirmDialog(null, title, message, otype, mtype);
    }

    public int getResult() {
        return this.result;
    }
}
