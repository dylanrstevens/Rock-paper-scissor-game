//Initiate Graphical User Interface
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class GUI extends JFrame {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    JFrame frame = new JFrame();
    JPanel textPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel choicePanel = new JPanel();
    Font font1 = new Font("Arial", Font.PLAIN, 40);
    JLabel counter = new JLabel("Press Start");
    JLabel playerCLabel = new JLabel("Your next move: ", SwingConstants.LEFT);
    JLabel score = new JLabel("You: 0"+" CPU: 0", SwingConstants.RIGHT);
    Timer timer;
    int second;
    int playerChoice;
    int val;
    String result;
    Color brown = new Color(107, 77, 60);
    Color grey = new Color(133, 133, 133);
    int round = 1;
    int cpuScore = 0;
    int pScore = 0;
    Boolean begin = false;



    public GUI() {

        //grid and dimension initiation
        textPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        choicePanel.setLayout(new GridLayout(0, 2));
        buttonPanel.setLayout(new GridLayout(0, 2));
        

        //label initiation
        counter.setFont(font1);
        textPanel.add(counter, BorderLayout.CENTER);
        choicePanel.add(playerCLabel, BorderLayout.WEST);
        choicePanel.add(score, BorderLayout.EAST);

        //button initiation
        JButton rock = new JButton("Rock");
        rock.setPreferredSize(new Dimension(50, 50));
        rock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                playerChoice = 1;
                playerCLabel.setText("Your next move: Rock");
            }
        });
        rock.setBackground(brown);
        rock.setForeground(Color.white);
        rock.setFocusPainted(false);

        JButton paper = new JButton("Paper");
        paper.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                playerChoice = 2;
                playerCLabel.setText("Your next move: Paper");
            }
        });
        paper.setBackground(Color.white);
        paper.setForeground(Color.black);
        paper.setFocusPainted(false);

        JButton scissors = new JButton("Scissors");
        scissors.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                playerChoice = 3;
                playerCLabel.setText("Your next move: Scissors");
            }
        });
        scissors.setBackground(grey);
        scissors.setForeground(Color.black);
        scissors.setFocusPainted(false);

        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                begin = true;
            }
        });
        start.setBackground(Color.black);
        start.setForeground(Color.white);
        start.setFocusPainted(false);

        buttonPanel.add(rock);
        buttonPanel.add(paper);
        buttonPanel.add(scissors);
        buttonPanel.add(start);

        //background
        textPanel.setBackground(Color.white);
        choicePanel.setBackground(Color.white);
        
        //Window initiation
        frame.add(textPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(choicePanel, BorderLayout.NORTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Rock Paper Scissors");
        frame.pack();
        frame.setVisible(true);

        //Set the new frame location
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);

        //begin timer
        countdown();
        timer.start();
 
    }

    public void countdown() {
        //Repeates recursively forever until the game stops
        
        second = 4;
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (begin) {
                    second--;
                    counter.setText(""+second);
                    
                    if (second == 0) {
                        result = showResult();
                        counter.setText(""+result);
                    }
                    else if (second < 0 && second > -2) {
                        counter.setText(""+result);
                    }
                    else if (second == -2) {
                        result = roundEnd();
                        counter.setText(""+result);
                    }
                    else if (second <= -2 && second > -4) {
                        counter.setText(""+result);
                    }
                    else if (second == -4) {
                        counter.setText("Round "+round);
                    }
                    else if (second == -5) {
                        counter.setText("Round "+round);
                        countdown();
                    }
                }
            }
        });
        round++;
    }

    public String roundEnd() {

        String result = "";
        if (val == 1) {
            result = "Rock";
        }
        else if (val == 2) {
            result = "Paper";
        }
        else if (val == 3) {
            result = "Scissors";
        }
        return result;
    }

    public String showResult() {

        String result = "";
        val = Initiate.cpuChoice();
        int resultOfRound = Initiate.decision(val, playerChoice);
        if (resultOfRound == 1) {
            result = "You Win!";
            pScore++;
            score.setText("You: "+pScore+" CPU: "+cpuScore);

        }
        else if (resultOfRound == 2) {
            result = "You Lose!";
            cpuScore++;
            score.setText("You: "+pScore+" CPU: "+cpuScore);
        }
        else if (resultOfRound == 3) {
            result = "Tie!";
        }
        return result;
    }

    
    public static void main(String[] args) {

        new GUI();
    }


}
