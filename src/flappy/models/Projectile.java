package flappy.models;

import flappy.Principal;

import java.awt.*;

public class Projectile extends Sprite{
    public Projectile(int x, int y) {
        setLargeur(5);
        setVitesse(7);
        setX(x);
        setY(y);
        setCouleur(Color.BLACK);
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x,y, largeur, largeur);
    }

    public void deplacement() {
        x += getVitesse();
    }

    public boolean doitDetruire(){
        if (getX() > Principal.LARGEUR) {
            return true;
        }
        return false;
    }
}
