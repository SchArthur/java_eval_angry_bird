package flappy.models;

import flappy.Principal;
import flappy.utils.Utils;

import java.awt.*;

public class Bonus extends Sprite {

    public Bonus() {
        largeur = 25;
        x = Principal.LARGEUR;
        y = Utils.aleatoire(25, Principal.HAUTEUR - 25);
        setCouleur(Color.YELLOW);
        setVitesse(6);
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x,y,largeur,largeur);
    }

    @Override
    public void deplacement() {
        x -= vitesse;
    }
}
