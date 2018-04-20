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

/**
 *
 * @author panea
 */
public class ResultsFrame extends JFrame {

    //JOptionPane.showMessageDialog(null, "Your quiz has been automatically submitted for grading.", "Out of Time", JOptionPane.OK_OPTION);
    private JPanel mainFrame;

    ResultsFrame() {
        //QuestionFrame frame = new QuestionFrame("","q1.txt","","","","");
        mainFrame = new JPanel(new FlowLayout());
        JLabel showScore = new JLabel("congratz " + WelcomeFrame.getName() + " your score is " + QuestionFrame.getScore());
        mainFrame.add(showScore);
    }

    public JPanel getRestultsPanel() {
        return mainFrame;
    }
}
