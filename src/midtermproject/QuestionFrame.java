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
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.*;

/**
 *
 * @author panea
 */
public class QuestionFrame extends JFrame {

    // Keeps the score
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

    // These variables store which button is checked from every question
    private static String q1Selection = null;
    private static String q2Selection = null;
    private static String q3Selection = null;
    private static String q4Selection = null;
    private static String q5Selection = null;
    private static String q6Selection = null;
    private static String q7Selection = null;
    private static String q8Selection = null;
    private static String q9Selection = null;
    private static String q10Selection = null;
    private static String q11Selection = null;
    

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

        // When "back" button is pressed, create the apropirate QuestionFrame
        // depending on the current question frame
        previousQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create the next question depending on the current question "q1.txt"

                if (fileName == "q2.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q2Selection != "c") {
                        // Check if the correct radio button is selected
                        if ("c".equals(getSelected())) {
                            QuestionFrame.addToScore(1);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q2Selection == "c") {
                        if (getSelected() != "c") {
                            QuestionFrame.addToScore(-1);
                        }
                    }
                    // Used in case the user goes to the next question without ansering the current question and returns back
                    q2Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("1.What will be the output of the program?",
                            "q1.txt", "A. Base", "B. BaseBase", "C. Compilation fails", "D. The code runs with no output ");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q1Selection != null) {
                        frame.setSelected(q1Selection);
                    }

                    // Remove the back button
                    frame.mainContainer.remove(previousQuestion);
                    // Add the new question panel to the master frame
                    mainContainer.add(frame.getQuestionPanel());

                } else if (fileName == "q3.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q3Selection != "d") {
                        // Check if the correct radio button is selected
                        if ("d".equals(getSelected())) {
                            QuestionFrame.addToScore(1);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q3Selection == "d") {
                        if (getSelected() != "d") {
                            QuestionFrame.addToScore(-1);
                        }
                    }
                    // Used in case the user goes to the next question without ansering the current question and returns back
                    q3Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("2.What will be the output of the program?",
                            "q2.txt", "A. ABCD", "B. Compilation fails.", "C. C is printed before exiting with an error message.",
                            "D. BC is printed before exiting with an error message.");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q2Selection != null) {
                        frame.setSelected(q2Selection);
                    }

                    // Add the new question panel to the master frame
                    mainContainer.add(frame.getQuestionPanel());

                } else if (fileName == "q4.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q4Selection != "a") {
                        // Check if the correct radio button is selected
                        if ("a".equals(getSelected())) {
                            QuestionFrame.addToScore(1);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q4Selection == "a") {
                        if (getSelected() != "a") {
                            QuestionFrame.addToScore(-1);
                        }
                    }
                    // Used in case the user goes to the next question without ansering the current question and returns back
                    q4Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("3.What will be the output of the program?",
                            "q3.txt", "A. AB", "B. BC", "C. ABC", "D. BCD");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q3Selection != null) {
                        frame.setSelected(q3Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q5.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q5Selection != "d") {
                        // Check if the correct radio button is selected
                        if ("d".equals(getSelected())) {
                            QuestionFrame.addToScore(1);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q5Selection == "d") {
                        if (getSelected() != "d") {
                            QuestionFrame.addToScore(-1);
                        }
                    }
                    // Used in case the user goes to the next question without ansering the current question and returns back
                    q5Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("4. Which two are acceptable types for x? ",
                            "q4.txt", "A. 1 and 3", "B. 2 and 4", "C. 3 and 5", "D. 4 and 6");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q4Selection != null) {
                        frame.setSelected(q4Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q6.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q6Selection != "d") {
                        // Check if the correct radio button is selected
                        if ("d".equals(getSelected())) {
                            QuestionFrame.addToScore(1);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q6Selection == "d") {
                        if (getSelected() != "d") {
                            QuestionFrame.addToScore(-1);
                        }
                    }
                    // Used in case the user goes to the next question without ansering the current question and returns back
                    q6Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("5.What will be the output of the program?",
                            "q5.txt", "A. 0 1 2 ", "B. 0 1 2 1 2 2", "C. 2 1 0 1 0 0", "D. 2 1 2 0 1 2");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q5Selection != null) {
                        frame.setSelected(q5Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q7.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q7Selection != "c") {
                        // Check if the correct radio button is selected
                        if ("c".equals(getSelected())) {
                            QuestionFrame.addToScore(1);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q7Selection == "c") {
                        if (getSelected() != "c") {
                            QuestionFrame.addToScore(-1);
                        }
                    }
                    // Used in case the user goes to the next question without ansering the current question and returns back
                    q7Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("6.What will be the output of the program?",
                            "q6.txt", "A. 0 def 1 ", "B. 2 1 0 def 1 ", "C. 2 1 0 def def ", "D. 2 1 0 def 1 def 1");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q6Selection != null) {
                        frame.setSelected(q6Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q8.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q8Selection != "a") {
                        // Check if the correct radio button is selected
                        if ("a".equals(getSelected())) {
                            QuestionFrame.addToScore(2);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q8Selection == "a") {
                        if (getSelected() != "a") {
                            QuestionFrame.addToScore(-2);
                        }
                    }
                    // Used in case the user goes to the next question without ansering the current question and returns back
                    q8Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("7.What will be the output of the program?",
                            "q7.txt", "A. abcXyZ ", "B. abcxyz ", "C. xyzabc ", "D. XyZabc");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q7Selection != null) {
                        frame.setSelected(q7Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q9.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q9Selection != "b") {
                        // Check if the correct radio button is selected
                        if ("b".equals(getSelected())) {
                            QuestionFrame.addToScore(2);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q9Selection == "b") {
                        if (getSelected() != "b") {
                            QuestionFrame.addToScore(-2);
                        }
                    }
                    // Used in case the user goes to the next question without ansering the current question and returns back
                    q9Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("8.What will be the output of the program?",
                            "q8.txt", "A. Pine", "B. Tree", "C. Forest", "D. Oops");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q8Selection != null) {
                        frame.setSelected(q8Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q10.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q10Selection != "a") {
                        // Check if the correct radio button is selected
                        if ("a".equals(getSelected())) {
                            QuestionFrame.addToScore(2);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q10Selection == "a") {
                        if (getSelected() != "a") {
                            QuestionFrame.addToScore(-2);
                        }
                    }
                    // Used in case the user goes to the next question without ansering the current question and returns back
                    q10Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("9.Which three statements are true?",
                            "q9.txt", "A. 1, 2 and 3 ", "B. 2, 4 and 5 ", "C. 3, 4 and 5 ", "D. 1, 4 and 5 ");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q9Selection != null) {
                        frame.setSelected(q9Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q11.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q11Selection != "d") {
                        // Check if the correct radio button is selected
                        if ("d".equals(getSelected())) {
                            QuestionFrame.addToScore(2);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q11Selection == "d") {
                        if (getSelected() != "d") {
                            QuestionFrame.addToScore(-2);
                        }
                    }

                    // Used in case the user goes to the next question without ansering the current question and returns back
                    q11Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("10.Which two of the following methods are defined in class Thread?",
                            "q10.txt", "A. 1 and 4", "B. 2 and 3", "C. 3 and 4", "D. 2 and 4");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the backquestion was already selected and if it 
                    // was then select that button
                    if (q10Selection != null) {
                        frame.setSelected(q10Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());

                }
            }
        });

        // When "next" button is pressed, create the apropirate QuestionFrame
        // depending on the current question frame
        nextQuestion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Create the next question depending on the current question "q1.txt"
                if (fileName == "q1.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q1Selection != "b") {
                        // Check if the correct radio button is selected
                        if ("b".equals(getSelected())) {
                            QuestionFrame.addToScore(1);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q1Selection == "b") {
                        if (getSelected() != "b") {
                            QuestionFrame.addToScore(-1);
                        }
                    }
                    // Save which radio button is selected
                    q1Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("2.What will be the output of the program?",
                            "q2.txt", "A. ABCD", "B. Compilation fails.", "C. C is printed before exiting with an error message.",
                            "D. BC is printed before exiting with an error message.");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q2Selection != null) {
                        frame.setSelected(q2Selection);
                    }

                    // Add the new question panel to the master frame
                    mainContainer.add(frame.getQuestionPanel());
                    //pack();

                } else if (fileName == "q2.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q2Selection != "c") {
                        // Check if the correct radio button is selected
                        if ("c".equals(getSelected())) {
                            QuestionFrame.addToScore(1);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q2Selection == "c") {
                        if (getSelected() != "c") {
                            QuestionFrame.addToScore(-1);
                        }
                    }
                    // Save which radio button is selected
                    q2Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("3.What will be the output of the program?",
                            "q3.txt", "A. AB", "B. BC", "C. ABC", "D. BCD");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q3Selection != null) {
                        frame.setSelected(q3Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q3.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q3Selection != "d") {
                        // Check if the correct radio button is selected
                        if ("d".equals(getSelected())) {
                            QuestionFrame.addToScore(1);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q3Selection == "d") {
                        if (getSelected() != "d") {
                            QuestionFrame.addToScore(-1);
                        }
                    }
                    // Save which radio button is selected
                    q3Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("4. Which two are acceptable types for x? ",
                            "q4.txt", "A. 1 and 3", "B. 2 and 4", "C. 3 and 5", "D. 4 and 6");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q4Selection != null) {
                        frame.setSelected(q4Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q4.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q4Selection != "a") {
                        // Check if the correct radio button is selected
                        if ("a".equals(getSelected())) {
                            QuestionFrame.addToScore(1);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q4Selection == "a") {
                        if (getSelected() != "a") {
                            QuestionFrame.addToScore(-1);
                        }
                    }
                    // Save which radio button is selected
                    q4Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("5.What will be the output of the program?",
                            "q5.txt", "A. 0 1 2 ", "B. 0 1 2 1 2 2", "C. 2 1 0 1 0 0", "D. 2 1 2 0 1 2");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q5Selection != null) {
                        frame.setSelected(q5Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q5.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q5Selection != "d") {
                        // Check if the correct radio button is selected
                        if ("d".equals(getSelected())) {
                            QuestionFrame.addToScore(1);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q5Selection == "d") {
                        if (getSelected() != "d") {
                            QuestionFrame.addToScore(-1);
                        }
                    }
                    // Save which radio button is selected
                    q5Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("6.What will be the output of the program?",
                            "q6.txt", "A. 0 def 1 ", "B. 2 1 0 def 1 ", "C. 2 1 0 def def ", "D. 2 1 0 def 1 def 1");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q6Selection != null) {
                        frame.setSelected(q6Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q6.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q6Selection != "d") {
                        // Check if the correct radio button is selected
                        if ("d".equals(getSelected())) {
                            QuestionFrame.addToScore(1);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q6Selection == "d") {
                        if (getSelected() != "d") {
                            QuestionFrame.addToScore(-1);
                        }
                    }
                    // Save which radio button is selected
                    q6Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("7.What will be the output of the program?",
                            "q7.txt", "A. abcXyZ ", "B. abcxyz ", "C. xyzabc ", "D. XyZabc");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q7Selection != null) {
                        frame.setSelected(q7Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q7.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q7Selection != "c") {
                        // Check if the correct radio button is selected
                        if ("c".equals(getSelected())) {
                            QuestionFrame.addToScore(1);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q7Selection == "c") {
                        if (getSelected() != "c") {
                            QuestionFrame.addToScore(-1);
                        }
                    }
                    // Save which radio button is selected
                    q7Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("8.What will be the output of the program?",
                            "q8.txt", "A. Pine", "B. Tree", "C. Forest", "D. Oops");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q8Selection != null) {
                        frame.setSelected(q8Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q8.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q8Selection != "a") {
                        // Check if the correct radio button is selected
                        if ("a".equals(getSelected())) {
                            QuestionFrame.addToScore(2);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q8Selection == "a") {
                        if (getSelected() != "a") {
                            QuestionFrame.addToScore(-2);
                        }
                    }                    // Save which radio button is selected
                    q8Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("9.Which three statements are true?",
                            "q9.txt", "A. 1, 2 and 3 ", "B. 2, 4 and 5 ", "C. 3, 4 and 5 ", "D. 1, 4 and 5 ");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q9Selection != null) {
                        frame.setSelected(q9Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q9.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q9Selection != "b") {
                        // Check if the correct radio button is selected
                        if ("b".equals(getSelected())) {
                            QuestionFrame.addToScore(2);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q9Selection == "b") {
                        if (getSelected() != "b") {
                            QuestionFrame.addToScore(-2);
                        }
                    }
                    // Save which radio button is selected
                    q9Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("10.Which two of the following methods are defined in class Thread?",
                            "q10.txt", "A. 1 and 4", "B. 2 and 3", "C. 3 and 4", "D. 2 and 4");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q10Selection != null) {
                        frame.setSelected(q10Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                } else if (fileName == "q10.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q10Selection != "a") {
                        // Check if the correct radio button is selected
                        if ("a".equals(getSelected())) {
                            QuestionFrame.addToScore(2);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q10Selection == "a") {
                        if (getSelected() != "a") {
                            QuestionFrame.addToScore(-2);
                        }
                    }
                    // Save which radio button is selected
                    q10Selection = getSelected();

                    QuestionFrame frame = new QuestionFrame("11.What will be the output of the program?",
                            "q11.txt", "A. 10", "B. None of the others", "C. Compilation fails due to error on line 2",
                            "D. 20");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();
                    // Check if the answer for the nextquestion was already selected and if it 
                    // was then select that button
                    if (q11Selection != null) {
                        frame.setSelected(q11Selection);
                    }

                    mainContainer.add(frame.getQuestionPanel());
                    frame.nextQuestion.setText("Finish Test");

                } else if (fileName == "q11.txt") {
                    // Check if the correct radio button wasnt checked before
                    if (q11Selection != "d") {
                        // Check if the correct radio button is selected
                        if ("d".equals(getSelected())) {
                            QuestionFrame.addToScore(2);
                        }
                        // Check if the answer was modified from correct to wrong and substract the score
                    } else if (q11Selection == "d") {
                        if (getSelected() != "d") {
                            QuestionFrame.addToScore(-2);
                        }
                    }
                    
                    
                    q11Selection = getSelected();

                    // Empty string because theres no need for an extra message
                    // Create  the JOptionPane needed to show the score to the user
                    new ResultsFrame("");

                    mainContainer.removeAll();
                    mainContainer.revalidate();
                    mainContainer.repaint();

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
        String selected = null;
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

    public void setSelected(String selection) {
        if (selection == "a") {
            answerOne.setSelected(true);
        } else if (selection == "b") {
            answerTwo.setSelected(true);
        } else if (selection == "c") {
            answerThree.setSelected(true);
        } else if (selection == "d") {
            answerFour.setSelected(true);
        }

    }

    // Get the score
    public static int getScore() {
        return score;
    }

    //Set the score
    public static void addToScore(int addedScore) {
        score = score + addedScore;
    }

    // Get the answers
    public static String getAnswer(String question) {
        if (question.equals("q1")) {
            return q1Selection;
        } else if ("q2".equals(question)) {
            return q2Selection;
        } else if ("q3".equals(question)) {
            return q3Selection;
        } else if ("q4".equals(question)) {
            return q4Selection;
        } else if ("q5".equals(question)) {
            return q5Selection;
        } else if ("q6".equals(question)) {
            return q6Selection;
        } else if ("q7".equals(question)) {
            return q7Selection;
        } else if ("q8".equals(question)) {
            return q8Selection;
        } else if ("q9".equals(question)) {
            return q9Selection;
        } else if ("q10".equals(question)) {
            return q10Selection;
        } else if ("q11".equals(question)) {
            return q11Selection;
        } else {
            return "No answer";
        }
    }

}
