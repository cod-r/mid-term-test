/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizzproject;

/**
 *
 * @author panea
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class QuizzTimer {

    private double time = 1.2*Math.pow(10,6);
    private SimpleDateFormat setTime = new SimpleDateFormat("mm:ss");
    private JLabel timeLabel;
    private Timer countDown;

    public QuizzTimer(){

        countDown = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (time >= 0) {
                    timeLabel.setText(setTime.format(time));
                    time = time-1000;
                }else{
                    JOptionPane.showMessageDialog(null, "Your quiz has been automatically submitted for grading.", "Out of Time", JOptionPane.OK_OPTION);
                    System.exit(0);
                }
            }   
        });

        timeLabel = new JLabel();
        timeLabel.setFont( new Font("Dialog", Font.PLAIN + Font.BOLD,24));
        timeLabel.setVisible(true);
    }

    public JLabel getTimeLabel(){
        return timeLabel;
    }

    public void start(){
        countDown.start();
    }
}
