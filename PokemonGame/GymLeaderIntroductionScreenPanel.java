package PokemonGame.PokemonGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GymLeaderIntroductionScreenPanel extends JPanel {
    private BufferedImage gymleaderImage;
    private BGM bgm;
    private MainBgm mabg;
    public GymLeaderIntroductionScreenPanel(PokemonBattleBackground parentFrame) {


        try {
            gymleaderImage = ImageIO.read(new File("PokemonGame/src/gymleaderintroductionImage.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(null);


        JButton continueButton = createStyledButton("Battle!");
        continueButton.setBounds(325, 340, 120, 30);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.showCard("Battle Screen");
                playBGM();
                stopmabg();
                mabg.stop();

            }
        });
        add(continueButton);

        JButton backButton = createStyledButton("Run away");
        backButton.setBounds(325, 380, 120, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.showCard("Intro Screen");
                playmabg();
                mabg.play();
            }
        });
        add(backButton);

        bgm = new BGM();
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
        g.drawImage(gymleaderImage, 0, 0, getWidth(), getHeight(), this);
    }


    private void playBGM() {
        // BGM 재생
        if (bgm != null) {
            bgm.play();
        }
    }
        //메인 브금 다시 재생
    public void playmabg() {
        mabg = new MainBgm();
        mabg.play();
    }

    public void stopmabg() {
        mabg = new MainBgm();
        mabg.stop();
    }
}
