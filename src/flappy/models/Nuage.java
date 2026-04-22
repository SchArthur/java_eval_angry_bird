package flappy.models;

import flappy.Principal;

import java.awt.*;

public class Nuage extends Sprite {

    protected int largeur;

    public Nuage(){
        setCouleur(Color.WHITE);
        setVitesse(2);
    }

    @Override
    public void dessiner(Graphics2D dessin) {
       dessin.setColor(couleur);
       dessin.fillOval(x, y , largeur , largeur / 2);
    }

    @Override
    public void deplacement() {
        x -= vitesse;

        if(x < -largeur) {
            x = Principal.LARGEUR;
        }
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
}
