package flappy.models;

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

    public Point[] position(){

        Point[] points = new Point[4];

        //point en haut à gauche de l'oiseau
        points[0] = new Point(x, y);
        points[1] = new Point(x + 50, y);
        points[2] = new Point(x, y + 50);
        points[3] = new Point(x +50, y + 50);

        return points;
    }

    public void saut(){
       this.gravite = -5;
    }

    public float getGravite() {
        return gravite;
    }

    public void setGravite(float gravite) {
        this.gravite = gravite;
    }
}
