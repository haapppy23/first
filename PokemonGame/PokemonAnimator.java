package PokemonGame.PokemonGame;

import javax.swing.*;

public class PokemonAnimator {

    private JLabel pokemonLabel;
    private int originalX;
    private int originalY;
    private int initialWidth;
    private int initialHeight;

    public PokemonAnimator(JLabel pokemonLabel, int originalX, int originalY) {
        this.pokemonLabel = pokemonLabel;
        this.originalX = originalX;
        this.originalY = originalY;
        this.initialWidth = pokemonLabel.getWidth();
        this.initialHeight = pokemonLabel.getHeight();

        updateLabelPosition(originalX, originalY);
    }


    public void animateAttack() {
        int attackDistance = 20;

        // 앞으로
        for (int i = 0; i < attackDistance; i++) {
            pokemonLabel.setLocation(pokemonLabel.getX() + 1, pokemonLabel.getY());
            sleep(8);
        }

        // 뒤로
        for (int i = 0; i < attackDistance; i++) {
            pokemonLabel.setLocation(pokemonLabel.getX() - 1, pokemonLabel.getY());
            sleep(8);
        }
        updateLabelPosition(originalX, originalY);
    }


    public void animateHit() {
        int hitDistance = 20;

        for (int i = 0; i < hitDistance; i++) {
            pokemonLabel.setLocation(pokemonLabel.getX() - 1, pokemonLabel.getY());
            sleep(8);
        }

        for (int i = 0; i < hitDistance; i++) {
            pokemonLabel.setLocation(pokemonLabel.getX() + 1, pokemonLabel.getY());
            sleep(8);
        }

        updateLabelPosition(originalX, originalY);

    }


    public void animateSummon() {
        int growSize = 10; // 확대할 크기
        int startX = originalX ;// 왼쪽 아래 꼭지점 X 좌표
        int startY = originalY ; // 왼쪽 아래 꼭지점 Y 좌표

        // 확대 애니메이션
        new Thread(() -> {
            for (int i = 0; i <= 50; i++) {
                int newWidth = initialWidth * i / 50;
                int newHeight = initialHeight * i / 50;
                pokemonLabel.setSize(newWidth, newHeight);
                updateLabelPosition(startX, startY - growSize * i / 50);
                sleep(10);
            }
        }).start();
    }


    private void updateLabelPosition(int x, int y) {
        pokemonLabel.setLocation(x, y);
        pokemonLabel.repaint();
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
