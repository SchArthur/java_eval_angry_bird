package flappy.models;

import java.awt.*;

public class TextBonus extends Sprite{
    private int dureeDeVie = 180; //frames
    private int pointsAttribues = 200;
    private int age = 0;

    public TextBonus(int x, int y) {
        setX(x);
        setY(y - 30);
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(Color.BLACK);
        dessin.setFont(new Font("Arial", Font.BOLD, 20));
        dessin.drawString("+  " + pointsAttribues, x, y);
    }

    public boolean vieillir(){
        age ++;
        if(age >= dureeDeVie){
            return true;
        }
        return false;
    }

    public void deplacement() {}
}
