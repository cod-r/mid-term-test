/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermproject;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.plaf.FontUIResource;

/**
 * This class creates the JOptionPane needed to show the score to the user and
 * saves the score to a file
 *
 * @author panea
 */
public class ResultsFrame extends JFrame {

    ResultsFrame(String extraMessage) {

        // Change the button size of JOptionPane
        UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL", Font.PLAIN, 25)));
        // Change text size of JOptionPane
        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.PLAIN, 30));

        // Save the score into a file with all the answers the user answered
        try {
            PrintWriter writer = new PrintWriter(WelcomeFrame.getName() + "_test_result.txt", "UTF-8");
            writer.println("Student Name: " + WelcomeFrame.getName());
            writer.println("Score: " + QuestionFrame.getScore() + "\n");
            writer.println("Answers: ");
            
            for (int i = 1; i <= 11; i++){
                String index = "q" + String.valueOf(i);
                writer.println("Question " + i + ": " + QuestionFrame.getAnswer(index));
            }
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        // Using a showOptionDialog to find out when the "ok" button is clicked
        //The showOptionDialog will return 0 if OK was clicked and -1 if the user closed the dialog.
        int res = JOptionPane.showOptionDialog(null, extraMessage + " Click \"OK\" to see your result.",
                "Info", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if (res == 0 || res == -1) {
            if (QuestionFrame.getScore() >= 8) {
                UIManager.put("OptionPane.okButtonText", "Exit");
                JOptionPane.showOptionDialog(null, "Congratulations " + WelcomeFrame.getName() + "!" + "\n" +
                        "Your score is " + QuestionFrame.getScore() + " out of 15.",
                        "Congratulations!", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, null, null);
                System.exit(0);
            } else {
                UIManager.put("OptionPane.okButtonText", "Exit");
                JOptionPane.showMessageDialog(null, WelcomeFrame.getName() + 
                        ", your score is " + QuestionFrame.getScore() + " out of 15.",
                        "You failed the test!", JOptionPane.OK_OPTION);
                System.exit(0);
            }
        }

    }

}
