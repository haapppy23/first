package PokemonGame.PokemonGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class HowToPlayScreenPanel extends JPanel {
    private BufferedImage howtoplayImage;
    private BGM2 bgm2;
    private MainBgm mabg;

    public HowToPlayScreenPanel(PokemonBattleBackground parentFrame) {
        try {
            howtoplayImage = ImageIO.read(new File("PokemonGame/src/how to play.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(null);

        JButton backButton = createStyledButton("Go back to Main");
        backButton.setBounds(270, 0, 200, 50);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bgm2 != null) {
                    bgm2.stop();
                    playmabg();
                    mabg.play();
                }
                parentFrame.showCard("Intro Screen");
            }
        });
        add(backButton);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        return button;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (howtoplayImage != null) {
            g.drawImage(howtoplayImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            playBgm();
        } else {
            if (bgm2 != null) {
                bgm2.stop();
            }
        }
    }

    public void playBgm() {
        bgm2 = new BGM2();
        bgm2.play();
    }

    public void playmabg() {
        mabg = new MainBgm();
        mabg.play();
    }
}
