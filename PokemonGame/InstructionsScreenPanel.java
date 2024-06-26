package PokemonGame.PokemonGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class InstructionsScreenPanel extends JPanel {
    private BufferedImage instructionsImage;
    private JButton continueButton;

    public InstructionsScreenPanel(PokemonBattleBackground parentFrame) {

        try {
            instructionsImage = ImageIO.read(new File("PokemonGame/src/instructionsImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(null);

        continueButton = createStyledButton("continue");
        continueButton.setSize(120, 30);
        add(continueButton);

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.showCard("User Name Screen");
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adjustButtonPosition();
            }
        });

        adjustButtonPosition();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(instructionsImage, 0, 0, getWidth(), getHeight(), this);
    }

    private void adjustButtonPosition() {
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int buttonWidth = continueButton.getWidth();
        int buttonHeight = continueButton.getHeight();
        int x = panelWidth - buttonWidth - 60;
        int y = panelHeight - buttonHeight - 40;
        continueButton.setLocation(x, y);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return button;
    }

}
