package PokemonGame.PokemonGame;

import javax.sound.sampled.*;
import java.io.*;



public class MainBgm {
    private Clip Mg;


    //BGM초기화
    public MainBgm() {
        try {
            File soundFile = new File("PokemonGame/src/sfx/Pokemon-gold.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Mg = AudioSystem.getClip();
            Mg.open(audioInputStream);

            //브금 볼륨 조절
            FloatControl gainControl = (FloatControl) Mg.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    //음악 시작
    public void play() {
        if (Mg!= null) {
            Mg.start();
        }
    }
    //음악 종료
    public void stop() {
        if (Mg != null && Mg.isRunning()) {
            Mg.stop();
            Mg.close();
        }
    }
}