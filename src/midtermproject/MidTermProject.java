package midtermproject;

import javax.swing.*;

/**
 *
 * @author panea
 */
public class MidTermProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame mainFrame = new MasterFrame();
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainFrame.setVisible(true);
            }
        });

    }

}
