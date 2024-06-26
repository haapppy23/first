package PokemonGame.PokemonGame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class BGM2 {
    private Clip bgm2;
    //BGM2초기화
    public BGM2() {
        try {
              File soundFile = new File("PokemonGame/src/sfx/포켓몬센터.wav");
                 AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                    bgm2 = AudioSystem.getClip();
                        bgm2.open(audioInputStream);
            //브금 볼륨 조절
            FloatControl gainControl = (FloatControl) bgm2.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-15.0f);
        } catch (Exception ex) {
                ex.printStackTrace();
        }
    }


    //음악 시작
    public void play() {
        if (bgm2 != null) {
              bgm2.start();
        }
    }

    //음악 종료
    public void stop() {
        if (bgm2 != null && bgm2.isRunning()) {
            bgm2.stop();
            bgm2.close();
        }
    }


}

