package PokemonGame.PokemonGame;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffect {

    private Clip sfx;
    //스킬 사용시 포켓몬이 사용하는 스킬에 맞는 사운드
    public static void playSkillSound(String soundFileName) {
        try {

            Clip sfx;

            File soundFile = new File(soundFileName).getAbsoluteFile();


            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            sfx = AudioSystem.getClip();
            sfx.open(audioStream);
            sfx.start();


        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    // 데미지를 입었을 때 사운드
    public void Damage(){
        try {

            File soundFile = new File("PokemonGame/src/sfx/hit.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            sfx = AudioSystem.getClip();
            sfx.open(audioStream);
            sfx.start();

        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException e){
            e.printStackTrace();

    }}
    //적이 공격 했을 때 사운드
    public void enemyhit(){
        try {

            File soundFile = new File("PokemonGame/src/sfx/Spark.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            sfx = AudioSystem.getClip();
            sfx.open(audioStream);
            sfx.start();

        } catch(UnsupportedAudioFileException | IOException | LineUnavailableException e){
            e.printStackTrace();

        }}



}

