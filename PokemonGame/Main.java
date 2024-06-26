package PokemonGame.PokemonGame;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Move ember = new Move("Ember", "Fire", 40, 100);
        Move waterGun = new Move("Water Gun", "Water", 40, 100);
        Move vineWhip = new Move("Vine Whip", "Grass", 45, 100);
        Move tackle = new Move("Tackle", "Normal", 40, 100);
        Move thunderShock = new Move("Thunder Shock", "Electric", 40, 100);
        Move scratch = new Move("Scratch", "Normal", 40, 100);
        Move rockThrow=new Move("Rock Throw","Rock",55,95);

        Pokemon charmander = new Pokemon("Charmander", 39, 52, 43, 65, "Fire", null, Arrays.asList(ember, scratch), 5);
        Pokemon squirtle = new Pokemon("Squirtle", 44, 48, 65, 43, "Water", null, Arrays.asList(waterGun, tackle), 5);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 45, 49, 49, 45, "Grass", "Poison", Arrays.asList(vineWhip, tackle), 5);
        Pokemon magnemite = new Pokemon("Magnamite", 37, 34, 62, 45, "Steel", "Electric", Arrays.asList(thunderShock, tackle), 5);
        Pokemon voltorb = new Pokemon("Voltorb", 43, 52, 48, 100, "Electric", null, Arrays.asList(thunderShock,tackle), 5);
        Pokemon onyx = new Pokemon("Onyx", 35, 45, 160, 45, "Rock", "Ground", Arrays.asList(rockThrow,tackle), 5);

        Trainer player = new Trainer("Player", Arrays.asList(charmander,squirtle,bulbasaur));
        Trainer gymLeader = new GymLeader("Gym Leader", Arrays.asList(magnemite,voltorb,onyx));

        Battle battle = new Battle(player, gymLeader);
    }

    public static class BackGround extends JPanel {
        private Image backgroundImage;

        public BackGround(String fileName){
            try {
                backgroundImage = new ImageIcon("PokemonGame/src/realui").getImage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            if(backgroundImage != null){
                g.drawImage(backgroundImage,0,0,this.getWidth(),this.getHeight(),this);
            }

        }
    }
}
