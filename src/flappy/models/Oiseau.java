package flappy.models;

import flappy.Principal;
import flappy.utils.Utils;

import java.awt.*;

public class Oiseau extends Sprite{

    protected float gravite = 1.0f;

    private int hauteurBec = 20;

    public Oiseau() {
        largeur = 50;
        setCouleur(Color.RED);
        setVitesse(3);
    }

    public void deplacement(){
        this.y += gravite;
        this.gravite += 0.2;
    }

    public void deplacementHorizontal(boolean versGauche){
        if (versGauche){
            this.x -= vitesse;
        } else {
            this.x += vitesse;
        }
    }

    public void dessiner(Graphics2D dessin){
        dessin.setColor(couleur);
        dessin.fillOval(x,y, largeur, largeur);

        // BEC
        dessin.setColor(Color.ORANGE);

        Polygon bec = new Polygon();
        bec.addPoint(x + largeur, y + (largeur/2) - (hauteurBec/2)); // haut
        bec.addPoint(x + largeur + 20, y + largeur/2); // bout du bec
        bec.addPoint(x + largeur, y + (largeur/2) + (hauteurBec/2)); // bas
        dessin.fill(bec);
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

    @Override
    public Zone[] getZones(){
        return new Zone[]{
                new Zone(
                        new Point(x, y),
                        new Point(x + largeur, y),
                        new Point(x, y + largeur),
                        new Point(x + largeur, y + largeur)),
                new Zone(
                    new Point(x + largeur, y + (largeur/2) - (hauteurBec/2)),
                    new Point(x + largeur + 20, y + largeur/2),
                    new Point(x + largeur, y + (largeur/2) + (hauteurBec/2)),
                    new Point(x + largeur + 20, y + largeur/2))
        };
    }
}
