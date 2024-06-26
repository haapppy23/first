package PokemonGame.PokemonGame;
import javax.swing.*;
import java.awt.*;

//배틀창 배경화면
public class BackGround extends JPanel{
    private Image backgroundImage;
    //생성자
    public BackGround(String fileName){
        try {
            //파일 이미지로 배경 설정
            backgroundImage = new ImageIcon("PokemonGame/src/realui.png").getImage();
        }catch (Exception z){
            z.printStackTrace();
        }
    }

    //
    @Override
    protected void paintComponent(Graphics s){
        super.paintComponent(s);
        //배경 이미지가 설정 된 경우만 이미지
        if(backgroundImage != null){
            //배경 이미지를 패널 크기에 맞게 확장
            s.drawImage(backgroundImage,0,0,this.getWidth(),this.getHeight(),this);

        }
    }
}
