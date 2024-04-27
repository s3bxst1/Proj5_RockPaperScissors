import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    private JTextArea resultsTextArea;
    private int playerWins;
    private int computerWins;
    private int ties;

    public RockPaperScissorsFrame() {
        setTitle("Rock Paper Scissors Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ... (Other components: buttons, stats panel, etc.)

        // Add action listeners for buttons
        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Rock");
            }
        });

        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Paper");
            }
        });

        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Scissors");
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle quitting the game (e.g., close the window)
                System.exit(0);
            }
        });

        // ...
    }

    private void playGame(String playerChoice) {
        // Generate computer's choice (randomly)
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        String computerChoice = choices[random.nextInt(choices.length)];

        // Determine the winner
        String result;
        if (playerChoice.equals(computerChoice)) {
            result = "Tie";
            ties++;
        } else if ((playerChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (playerChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (playerChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            result = "Player wins!";
            playerWins++;
        } else {
            result = "Computer wins!";
            computerWins++;
        }

        // Update stats and results text area
        updateStats();
        updateResultsTextArea(playerChoice, computerChoice, result);
    }

    private void updateStats() {
        // Update the text fields for player wins, computer wins, and ties
        // (Use the playerWins, computerWins, and ties variables)
    }

    private void updateResultsTextArea(String playerChoice, String computerChoice, String result) {
        // Append the game result to the JTextArea
        resultsTextArea.append(playerChoice + " vs. " + computerChoice + " - " + result + "\n");
    }

    // Other methods (e.g., initializing components, setting up layout, etc.)

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RockPaperScissorsFrame().setVisible(true);
        });
    }
}