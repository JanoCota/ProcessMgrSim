package processmgrsim;

import javax.swing.UIManager;

/**
 *
 * @author janoc
 */
public class Main {

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UI frm = new UI();
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
