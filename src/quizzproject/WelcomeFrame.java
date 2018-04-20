/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizzproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
/**
 *
 * @author panea
 */
public class WelcomeFrame {
    
    private String name;
    private JPanel mainContainer;
    private JButton startButton;

    
    WelcomeFrame(){
        // Define and Set Layout manager
        mainContainer = new JPanel();
        mainContainer.setLayout(new GridBagLayout());
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        // the contentPane is the container that holds all our components
        //getContentPane().setLayout(new BorderLayout());
        //getContentPane().add(mainContainer);
        
        //mainContainer.setVisible(false);
        
        //Create components
        
       
        
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
        
        startButton = new JButton("Start");
        startButton.setFont(new Font("Seriff", Font.PLAIN, 30));
        
        
        GridBagConstraints gc = new GridBagConstraints();
        
        gc.weightx = 0.5;
        //gc.weighty = 0.5;

        gc.gridx = 0;
        gc.gridy = 0;
        //mainContainer.add(timerPanel);
        
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
        
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                QuestionFrame frameOne = new QuestionFrame("1.What will be the output of the program?",
                        "q1.txt", "A. Base", "B. BaseBase", "C. Compilation fails","D. The code runs with no output " );
                mainContainer.removeAll();
                mainContainer.revalidate();
                mainContainer.repaint();
                
                mainContainer.add(frameOne.getQuestionPanel());

            }

        });
    }
    
    public JPanel getWelcomePanel() {
        return mainContainer;
    }
    
}
