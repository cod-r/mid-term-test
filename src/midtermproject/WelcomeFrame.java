/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author panea
 */
public class WelcomeFrame {

    private static String name;
    private JPanel mainContainer;
    private JButton startButton;

    private Font font = new Font("Seriff", Font.PLAIN, 30);

    WelcomeFrame() {
        // Define and Set Layout manager
        mainContainer = new JPanel();
        mainContainer.setLayout(new GridBagLayout());
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        // the contentPane is the container that holds all our components
        
        //Create components
        JPanel welcomeTextPanel = new JPanel();
        welcomeTextPanel.setLayout(new BoxLayout(welcomeTextPanel, BoxLayout.Y_AXIS));
        
        JLabel welcomeText = new JLabel();
        welcomeText.setFont(new Font("Seriff", Font.PLAIN, 30));
        welcomeText.setText("Welcome to the midterm test for Programming 2 class.");
        
        JLabel welcomeText2 = new JLabel();
        welcomeText2.setFont(new Font("Seriff", Font.PLAIN, 30));
        welcomeText2.setText("The test consists of 11 multiple choice questions.");
        
        JLabel welcomeText3 = new JLabel();
        welcomeText3.setFont(new Font("Seriff", Font.PLAIN, 30));
        welcomeText3.setText("You will have 2 minutes/question, in total 22 minutes.");
       
        JLabel welcomeText4 = new JLabel();
        welcomeText4.setFont(new Font("Seriff", Font.PLAIN, 30));
        welcomeText4.setText("Please enter your name below and press the Start button.");
        
        welcomeTextPanel.add(welcomeText);
        welcomeTextPanel.add(welcomeText2);
        welcomeTextPanel.add(welcomeText3);
        welcomeTextPanel.add(welcomeText4);
        //welcomeTextPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        welcomeTextPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        Border border = welcomeTextPanel.getBorder();
        Border margin = new EmptyBorder(10,10,10,10);
        welcomeTextPanel.setBorder(new CompoundBorder(border, margin));

        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name: ");
        nameLabel.setFont(new Font("Seriff", Font.PLAIN, 30));

        JTextField nameEnterField = new JTextField(15);
        nameEnterField.setFont(new Font("Seriff", Font.PLAIN, 30));

        startButton = new JButton("Start");
        startButton.setFont(new Font("Seriff", Font.PLAIN, 30));

        GridBagConstraints gc = new GridBagConstraints();

        gc.weightx = 0.5;
        //gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        mainContainer.add(welcomeTextPanel, gc);


        gc.gridx = 0;
        gc.gridy = 1;

        JPanel namePanel = new JPanel(new FlowLayout());
        namePanel.add(nameLabel);
        namePanel.add(nameEnterField);
        mainContainer.add(namePanel, gc);

        gc.gridx = 0;
        gc.gridy = 5;

        mainContainer.add(startButton, gc);
        
        // When the user clicks the "START" button: check if the name is entered,
        // create the frame for the first question and start the timer
        startButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // Save user's name into a variable
                name = nameEnterField.getText();
                // Check if the user didn't enter his name
                if ("".equals(name)) {
                    // Change the button size of JOptionPane
                    UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 25)));
                    // Change text size of JOptionPane
                    JLabel infoMessage = new JLabel("Please enter your name");
                    infoMessage.setFont(font);
                    // Show the info message
                    JOptionPane.showMessageDialog(null, infoMessage, "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //Remove the fixed time from the MasterFrame so we can add the real timer
                    MasterFrame.timerPanel.remove(MasterFrame.stillTimer);
                    QuizzTimer timer = new QuizzTimer();
                    timer.start();
                    // Add the timer to the MasterFrame
                    MasterFrame.timerPanel.add(timer.getTimeLabel());
                    
                    // Create the frame for the first question
                    QuestionFrame frameOne = new QuestionFrame("1.What will be the output of the program?",
                            "q1.txt", "A. Base", "B. BaseBase", "C. Compilation fails", "D. The code runs with no output ");
                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();

                    mainContainer.add(frameOne.getQuestionPanel());
                }
            }

        });
    }

    // Returns the JPanel which will be added tot the MasterFrame
    public JPanel getWelcomePanel() {
        return mainContainer;
    }

    // Return the name of the user.
    public static String getName() {
        return name;
    }

}
