package PokemonGame.PokemonGame;

import javax.sound.sampled.*;
import java.io.*;


public class BGM {
    private Clip bgm;


    //BGM초기화
    public BGM() {
        try {
            File soundFile = new File("PokemonGame/src/sfx/gold.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            bgm = AudioSystem.getClip();
            bgm.open(audioInputStream);

            //브금 볼륨 조절
            FloatControl gainControl = (FloatControl) bgm.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20.0f);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    //음악 시작
    public void play() {
        if (bgm!= null) {
            bgm.start();
        }
    }

}