package models;

import java.awt.*;

public class Oiseau extends Sprite{

    protected float gravite = 1.0f;

    public void deplacement(){
        this.y += gravite;
        this.gravite += 0.2;
    }

    public void dessiner(Graphics2D dessin){
        dessin.setColor(Color.red);
        dessin.fillOval(x,y, 50, 50);
    }

}
