/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizzproject;

import javax.swing.*;
import java.awt.*;
import java.text.*;

/**
 * 
 * @author panea
 */
public class MasterFrame extends JFrame {
    
    // Used to save the name from the JTextField
    private String name;
    
    MasterFrame() {
        super("Quizz");
       
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
        
        //mainContainer.setVisible(false);
        
        //Create components
        
        // Create the panel for the timer
        JPanel timerPanel = new JPanel(new FlowLayout());
        JLabel titleTimer = new JLabel();
        titleTimer.setFont( new Font("Dialog", Font.PLAIN + Font.BOLD,24));
        titleTimer.setText("Time Left: ");
        JLabel stillTimer = new JLabel();
        stillTimer.setFont( new Font("Dialog", Font.PLAIN + Font.BOLD,24));
        stillTimer.setText("20:00");
        timerPanel.add(titleTimer);
        timerPanel.add(stillTimer);
        timerPanel.remove(stillTimer);
        QuizzTimer timer = new QuizzTimer();
        timer.start();
        timerPanel.add(timer.getTimeLabel());
        
        masterPanel.add(timerPanel, BorderLayout.NORTH);
        
        
        
       
       /**   This is replaced by WelcomeFrame obj
        JLabel welcomeText = new JLabel();
        welcomeText.setFont(new Font("Seriff", Font.PLAIN, 30));
        welcomeText.setText("This is a quizz that tests your java knowledge.");
        
        JLabel welcomeText2 = new JLabel();
        welcomeText2.setFont(new Font("Seriff", Font.PLAIN, 30));
        welcomeText2.setText("Please enter your name below and press the Start button.");
        
        JLabel nameLabel = new JLabel();
        nameLabel.setText("Name: ");
        nameLabel.setFont(new Font("Seriff", Font.PLAIN, 30));
        
        JTextField nameEnterField = new JTextField(10);
        nameEnterField.setFont(new Font("Seriff", Font.PLAIN, 30));
       
        name = nameEnterField.getText();
        
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Seriff", Font.PLAIN, 30));
        
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.weightx = 0.5;
        //gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        mainContainer.add(timerPanel);
        
        gc.gridx = 0;
        gc.gridy = 1;
        mainContainer.add(welcomeText, gc);
        
        gc.gridx = 0;
        gc.gridy = 2;
        mainContainer.add(welcomeText2, gc);
      
        gc.gridx = 0;
        gc.gridy = 3;
        
        JPanel namePanel = new JPanel(new FlowLayout());
        namePanel.add(nameLabel);
        namePanel.add(nameEnterField);
        mainContainer.add(namePanel, gc);
        
        gc.gridx = 0;
        gc.gridy = 4;
        
        mainContainer.add(startButton, gc);
       */
       
    }

}
