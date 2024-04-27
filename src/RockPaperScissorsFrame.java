import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RockPaperScissorsFrame extends JFrame {
    private int playerWins = 0;
    private int computerWins = 0;
    private int ties = 0;

    private JLabel playerWinsLabel;
    private JLabel computerWinsLabel;
    private JLabel tiesLabel;
    private JTextArea resultsTextArea;

    public RockPaperScissorsFrame() {
        setTitle("Rock Paper Scissors Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBorder(BorderFactory.createTitledBorder("Choose Your Move"));

        ImageIcon rockIcon = resizeImage("rock.png");
        JButton rockButton = new JButton(rockIcon);
        rockButton.addActionListener(new ButtonClickListener("rock"));

        ImageIcon paperIcon = resizeImage("paper.png");
        JButton paperButton = new JButton(paperIcon);
        paperButton.addActionListener(new ButtonClickListener("paper"));

        ImageIcon scissorsIcon = resizeImage("scissors.png");
        JButton scissorsButton = new JButton(scissorsIcon);
        scissorsButton.addActionListener(new ButtonClickListener("scissors"));

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonsPanel.add(rockButton);
        buttonsPanel.add(paperButton);
        buttonsPanel.add(scissorsButton);
        buttonsPanel.add(quitButton);

        JPanel statsPanel = new JPanel(new GridLayout(3, 2));
        statsPanel.setBorder(BorderFactory.createTitledBorder("Stats"));
        playerWinsLabel = new JLabel("Player Wins: 0");
        computerWinsLabel = new JLabel("Computer Wins: 0");
        tiesLabel = new JLabel("Ties: 0");
        statsPanel.add(playerWinsLabel);
        statsPanel.add(computerWinsLabel);
        statsPanel.add(tiesLabel);

        resultsTextArea = new JTextArea(10, 20);
        resultsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsTextArea);

        add(buttonsPanel, BorderLayout.NORTH);
        add(statsPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }

    private ImageIcon resizeImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    private class ButtonClickListener implements ActionListener {
        private String playerChoice;

        public ButtonClickListener(String choice) {
            this.playerChoice = choice;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Your game logic here
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RockPaperScissorsFrame frame = new RockPaperScissorsFrame();
                frame.setVisible(true);
            }
        });
    }
}