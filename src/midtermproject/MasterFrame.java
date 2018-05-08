
package midtermproject;

import javax.swing.*;
import java.awt.*;

/**
 *  This is the master frame which holds the WelcomeFrame and the Timer.
 * @author panea
 */
public class MasterFrame extends JFrame {

    protected static JPanel timerPanel;
    protected static JLabel stillTimer;

    MasterFrame() {
        super("Midterm Test");

        // Define and Set Layout manager
        JPanel masterPanel = new JPanel(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // the contentPane is the container that holds all our components
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(masterPanel);

        // Creating the welcome frame
        WelcomeFrame welcomeFrame = new WelcomeFrame();

        masterPanel.add(welcomeFrame.getWelcomePanel(), BorderLayout.CENTER);

        //Create components
        // Create the panel for the timer
        timerPanel = new JPanel(new FlowLayout());
        JLabel titleTimer = new JLabel();
        titleTimer.setFont(new Font("Dialog", Font.PLAIN + Font.BOLD, 24));
        titleTimer.setText("Time Left: ");
        stillTimer = new JLabel();
        stillTimer.setFont(new Font("Dialog", Font.PLAIN + Font.BOLD, 24));
        stillTimer.setText("22:00");
        timerPanel.add(titleTimer);
        timerPanel.add(stillTimer);

        masterPanel.add(timerPanel, BorderLayout.NORTH);
    }

}
