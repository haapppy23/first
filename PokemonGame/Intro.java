package PokemonGame.PokemonGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
//게임 시작화면 구성
public class Intro extends JPanel {
    JLabel imageLabel = new JLabel();
    JButton startButton;
    JButton howtoplay;
    MainBgm mabg;

    //인트로 창 초기화
    public Intro(PokemonBattleBackground parentFrame) {
        try {
            setLayout(new BorderLayout());
            setSize(new Dimension(515, 500));

            URL imageURL = this.getClass().getResource("src/play.gif");

            ImageIcon gold = new ImageIcon(imageURL);
            imageLabel.setIcon(gold);
            add(imageLabel, BorderLayout.CENTER);
            //배틀 시작 버튼 디자인 설정
            startButton = new JButton("배틀 시작!");
            startButton.setFont(new Font("", Font.HANGING_BASELINE, 15));
            startButton.setForeground(Color.ORANGE);
            startButton.setOpaque(false);
            startButton.setContentAreaFilled(false);
            startButton.setBorderPainted(false);
            startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));


            //게임방법 버튼 디자인 설정
            howtoplay = new JButton("게임 방법!");
            howtoplay.setFont(new Font("", Font.HANGING_BASELINE, 15));
            howtoplay.setForeground(Color.ORANGE);
            howtoplay.setOpaque(false);
            howtoplay.setContentAreaFilled(false);
            howtoplay.setBorderPainted(false);
            howtoplay.setCursor(new Cursor(Cursor.HAND_CURSOR));

            //게임 진행창 이동 액션리스너
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    parentFrame.showCard("Instructions Screen");
                    mabg.stop();
                }
            });
            //게임방법창 이동 액션리스너
            howtoplay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    parentFrame.showCard("How to Play Screen");
                    mabg.stop();
                }

            });

            imageLabel.setLayout(null);

            startButton.setBounds(150, 300, 200, 100);

            howtoplay.setBounds(150, 350, 200, 100);

            imageLabel.add(startButton);

            imageLabel.add(howtoplay);

            this.setVisible(true);

            //메인브금 클래스 인스턴스 생성
            mabg = new MainBgm();
            //배경음악 재생
            mabg.play();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PokemonBattleBackground();
    }
}
