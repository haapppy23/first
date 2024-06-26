package PokemonGame.PokemonGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UserNameScreenPanel extends JPanel {
    private JTextField nameField;
    private BufferedImage nameImage;

    public UserNameScreenPanel(PokemonBattleBackground parentFrame) {

        try {
            nameImage = ImageIO.read(new File("PokemonGame/src/usernameImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLayout(null);

        nameField = new JTextField();
        nameField.setBounds(200, 375, 120, 40);
        add(nameField);

        JButton continueButton = createStyledButton("Continue");
        continueButton.setBounds(325, 380, 120, 30);
        add(continueButton);

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (!name.isEmpty()) {
                    Trainer.setPlayerName(name);
                    parentFrame.setPlayerName(name);
                    parentFrame.showCard("Gym Leader Introduction Screen");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter your name.");
                }
            }
        });
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(nameImage, 0, 0, getWidth(), getHeight(), this);
    }
}
