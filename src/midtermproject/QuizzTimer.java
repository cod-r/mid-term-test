/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermproject;

/**
 *
 * @author panea
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.Timer;

public class QuizzTimer {

    private double time = 1.32*Math.pow(10,6);
    private SimpleDateFormat setTime = new SimpleDateFormat("mm:ss");
    private JLabel timeLabel;
    private Timer countDown;
    private Font font = new Font("Arial", Font.PLAIN, 30);

    public QuizzTimer() {

        countDown = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (time >= 0) {
                    timeLabel.setText(setTime.format(time));
                    time = time - 1000;
                } else {
                    // Create  the JOptionPanes needed to show the score to the user
                    new ResultsFrame("You're out of time!");

                }
            }
        });

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Dialog", Font.PLAIN + Font.BOLD, 24));
        timeLabel.setVisible(true);
    }

    public JLabel getTimeLabel() {
        return timeLabel;
    }

    public void start() {
        countDown.setInitialDelay(0);
        countDown.start();
    }
}
