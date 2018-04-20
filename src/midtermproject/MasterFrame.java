/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermproject;

import javax.swing.*;
import java.awt.*;
import java.text.*;

/**
 *
 * @author panea
 */
public class MasterFrame extends JFrame {

    protected static JPanel timerPanel;
    protected static JLabel stillTimer;

    MasterFrame() {
        super("Midterm Test");

        // Define and Set Layout manager
        JPanel masterPanel = new JPanel(new BorderLayout());
        //mainContainer.setLayout(new GridBagLayout());
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
        stillTimer.setText("20:00");
        timerPanel.add(titleTimer);
        timerPanel.add(stillTimer);

        masterPanel.add(timerPanel, BorderLayout.NORTH);
    }

}
