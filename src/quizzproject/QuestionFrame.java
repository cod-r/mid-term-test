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
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.*;

/**
 *
 * @author panea
 */
public class QuestionFrame extends JFrame {

    private static int score = 0;
    private JPanel mainContainer;
    private JPanel changeQuestionPanel;
    private JButton nextQuestion;
    private JButton previousQuestion;
    private JRadioButton answerOne;
    private JRadioButton answerTwo;
    private JRadioButton answerThree;
    private JRadioButton answerFour;
    private JLabel testScore;

    private Font font = new Font("Seriff", Font.PLAIN, 30);

    QuestionFrame(String question, String fileName, String a1, String a2, String a3, String a4) {

        // Set Layout manager
        mainContainer = new JPanel();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
        setContentPane(mainContainer);

        // Create components
        testScore = new JLabel();
        testScore.setText("score is " + QuestionFrame.getScore());
        // Create question label
        JLabel questionOne = new JLabel();
        questionOne.setText(question);
        questionOne.setFont(font);
        questionOne.setAlignmentX(Component.CENTER_ALIGNMENT);
        //questionOne.setHorizontalAlignment(SwingConstants.CENTER);

        // Create the text area where the question code will be placed
        // The code is read from a text file because
        JTextArea code = new JTextArea();
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);
            code.read(br, null);
            br.close();
            code.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        code.setEditable(false);
        code.setTabSize(4);
        code.setFont(new Font("Seriff", Font.PLAIN, 20));

        // Create the radio buttons for the answers and add them in a ButtonGroup
        answerOne = new JRadioButton(a1);
        answerOne.setFont(font);
        answerTwo = new JRadioButton(a2);
        answerTwo.setFont(font);
        answerThree = new JRadioButton(a3);
        answerThree.setFont(font);
        answerFour = new JRadioButton(a4);
        answerFour.setFont(font);
        ButtonGroup group = new ButtonGroup();
        group.add(answerOne);
        group.add(answerTwo);
        group.add(answerThree);
        group.add(answerFour);

        // Add buttons for next question and last question
        changeQuestionPanel = new JPanel(new FlowLayout());
        nextQuestion = new JButton("Next");
        nextQuestion.setFont(font);
        previousQuestion = new JButton("Back");
        previousQuestion.setFont(font);
        changeQuestionPanel.add(previousQuestion);
        changeQuestionPanel.add(nextQuestion);

        // Calculate the score
        nextQuestion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Create the next question depending on the current question "q1.txt"
                if (fileName == "q1.txt") {
                    
                    if ("b".equals(getSelected())) {
                        QuestionFrame.addToScore(1);
                    }
                    
                    QuestionFrame frame = new QuestionFrame("2.What will be the output of the program?",
                            "q2.txt", "A. ABCD", "B. Compilation fails.", "C. C is printed before exiting with an error message.",
                            "D. BC is printed before exiting with an error message.");
                    // Check if the answer is correct and update the score
                    
                    
                    
                    
                    
                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    
                    
                    // Add the new question panel to the master frame
                    mainContainer.add(frame.getQuestionPanel());
                    //pack();
                    
                } else if (fileName == "q2.txt") {
                    // Check if the answer is correct and update the score
                    if ("c".equals(getSelected())) {
                        QuestionFrame.addToScore(1);
                    }
                    QuestionFrame frame = new QuestionFrame("3.What will be the output of the program?",
                            "q3.txt", "A. AB", "B. BC", "C. ABC", "D. BCD");
                    
                   
                    
                    
                    
                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    
                    
                    
                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q3.txt") {
                    // Check if the answer is correct and update the score
                    if ("d".equals(getSelected())) {
                        QuestionFrame.addToScore(1);
                    }
                    QuestionFrame frame = new QuestionFrame("4. Which two are acceptable types for x? ",
                            "q4.txt", "A. 1 and 3", "B. 2 and 4", "C. 3 and 5", "D. 4 and 6");
                    
                    
                    
                    
                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    
                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q4.txt") {
                    // Check if the answer is correct and update the score
                    if ("a".equals(getSelected())) {
                        QuestionFrame.addToScore(1);
                    }
                    QuestionFrame frame = new QuestionFrame("5.What will be the output of the program?",
                            "q5.txt", "A. 0 1 2 ", "B. 0 1 2 1 2 2", "C. 2 1 0 1 0 0", "D. 2 1 2 0 1 2");
                    
                    
                    
                    
                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    
                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q5.txt") {
                    // Check if the answer is correct and update the score
                    if ("d".equals(getSelected())) {
                        QuestionFrame.addToScore(1);
                    }
                    QuestionFrame frame = new QuestionFrame("6.What will be the output of the program?",
                            "q6.txt", "A. 0 def 1 ", "B. 2 1 0 def 1 ", "C. 2 1 0 def def ", "D. 2 1 0 def 1 def 1");
                    
                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    
                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q6.txt") {
                    // Check if the answer is correct and update the score
                    if ("d".equals(getSelected())) {
                        QuestionFrame.addToScore(1);
                    }
                    QuestionFrame frame = new QuestionFrame("7.What will be the output of the program?",
                            "q7.txt", "A. abcXyZ ", "B. abcxyz ", "C. xyzabc ", "D. XyZabc");
                    
                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    
                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q7.txt") {
                    // Check if the answer is correct and update the score
                    if ("c".equals(getSelected())) {
                        QuestionFrame.addToScore(1);
                    }
                    QuestionFrame frame = new QuestionFrame("8.What will be the output of the program?",
                            "q8.txt", "A. Pine", "B. Tree", "C. Forest", "D. Oops");
                    
                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    
                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q8.txt") {
                    // Check if the answer is correct and update the score
                    if ("a".equals(getSelected())) {
                        QuestionFrame.addToScore(2);
                    }
                    QuestionFrame frame = new QuestionFrame("9.Which three statements are true?",
                            "q9.txt", "A. 1, 2 and 3 ", "B. 2, 4 and 5 ", "C. 3, 4 and 5 ", "D. 1, 4 and 5 ");
                    
                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    
                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q9.txt") {
                    // Check if the answer is correct and update the score
                    if ("b".equals(getSelected())) {
                        QuestionFrame.addToScore(2);
                    }
                    QuestionFrame frame = new QuestionFrame("10.Which two of the following methods are defined in class Thread?",
                            "q10.txt", "A. 1 and 4", "B. 2 and 3", "C. 3 and 4", "D. 2 and 4");
                    
                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    
                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q10.txt") {
                    // Check if the answer is correct and update the score
                    if ("a".equals(getSelected())) {
                        QuestionFrame.addToScore(2);
                    }
                    QuestionFrame frame = new QuestionFrame("11.What will be the output of the program?",
                            "q11.txt", "A. 10", "B. None of the others", "C. Compilation fails due to error on line 2",
                            "D. 20");
                    
                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    
                    
                    
                    mainContainer.add(frame.getQuestionPanel());
                    frame.nextQuestion.setText("Finish Test");
                    
                } else if (fileName == "q11.txt"){
                    
                    if ("d".equals(getSelected())) {
                        QuestionFrame.addToScore(2);
                    }
                    ResultsFrame frame = new ResultsFrame();
                    
                   
                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    
                    mainContainer.add(frame.getRestultsPanel());
                    
                }

            }

        });

        // Add components to the main panel
        mainContainer.add(testScore);
        mainContainer.add(questionOne);
        mainContainer.add(code);
        mainContainer.add(answerOne);
        mainContainer.add(answerTwo);
        mainContainer.add(answerThree);
        mainContainer.add(answerFour);
        mainContainer.add(changeQuestionPanel);

    }

    // Returns the main panel
    public JPanel getQuestionPanel() {
        return mainContainer;

    }

    public String getSelected() {
        String selected = "x";
        if (answerOne.isSelected()) {
            selected = "a";
        } else if (answerTwo.isSelected()) {
            selected = "b";
        } else if (answerThree.isSelected()) {
            selected = "c";
        } else if (answerFour.isSelected()) {
            selected = "d";
        }
        return selected;

    }

    // Get the score
    public static int getScore() {
        return score;
    }

    //Set the score
    public static void addToScore(int addedScore) {
        score = score + addedScore;
    }

}
