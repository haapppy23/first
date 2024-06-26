package PokemonGame.PokemonGame;

import javax.swing.*;
import java.awt.*;

public class PokemonBattleBackground extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private String playerName;

    public PokemonBattleBackground() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel introScreen = new Intro(this);
        JPanel instructionsScreen = new InstructionsScreenPanel(this);
        JPanel howToPlayScreen = new HowToPlayScreenPanel(this);
        JPanel userNameScreen = new UserNameScreenPanel(this);
        JPanel enemyIntroductionScreen = new GymLeaderIntroductionScreenPanel(this);
        JPanel battleScreen = new PokemonGUI(this);

        mainPanel.add(introScreen, "Intro Screen");
        mainPanel.add(instructionsScreen, "Instructions Screen");
        mainPanel.add(howToPlayScreen, "How to Play Screen");
        mainPanel.add(userNameScreen, "User Name Screen");
        mainPanel.add(enemyIntroductionScreen, "Gym Leader Introduction Screen");
        mainPanel.add(battleScreen, "Battle Screen");


        setContentPane(mainPanel);
        setVisible(true);

        setLocationRelativeTo(null);
    }

    public void showCard(String cardName) {
        cardLayout.show(mainPanel, cardName);
        if (cardName.equals("Battle Screen")) {
            setSize(615, 533);
        } else {
            setSize(500, 500);
        }
        validate();
        repaint();
    }


    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PokemonBattleBackground::new);
    }
}
