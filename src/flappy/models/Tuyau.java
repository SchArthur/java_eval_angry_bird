package flappy.models;

import flappy.Principal;
import flappy.utils.Utils;

import java.awt.*;
import java.util.ArrayList;

public class Tuyau extends Sprite{

    protected int ecartement = 200;
    protected int marge = 50;
    protected int vieHaut = 3;
    protected int vieBas = 3;

    public Tuyau(){
        largeur = 100;
        setCouleur(Color.GREEN);
        setVitesse(4);
    }

    public void deplacement(){
        x -= vitesse;

        if(x < -largeur) {
            x = Principal.LARGEUR;
            y = Utils.aleatoire(marge + ecartement, Principal.HAUTEUR - marge);
            setVieHaut(3);
            setVieBas(3);
        }
    }

    public void toucherParUnProjectile(Projectile projectile){
        if (projectile.getY() < y-ecartement){
            setVieHaut(getVieHaut()-1);
        } else {
            setVieBas(getVieBas()-1);
        }
    }

    public void gereImpactAvecJoueur(Sprite cible, Graphics2D dessin){
        dessin.setColor(new Color(184,0,0));
        if (cible.getY() < y-ecartement-Principal.HAUTEUR){
            dessin.fillRect(x,y-ecartement-Principal.HAUTEUR, largeur, Principal.HAUTEUR);
        } else {
            dessin.fillRect(x,y, largeur, Principal.HAUTEUR);
        }
    }

    public void dessiner(Graphics2D dessin){
        if (getVieBas() > 0) {
            dessin.setColor(getColorAvecVie(getVieBas()));
            dessin.fillRect(x,y, largeur, Principal.HAUTEUR); // Bas
        }
        if (getVieHaut() > 0) {
            dessin.setColor(getColorAvecVie(getVieHaut()));
            dessin.fillRect(x,y-ecartement-Principal.HAUTEUR, largeur, Principal.HAUTEUR); // Haut
        }
    }

    private Color getColorAvecVie(int vie){
        if (vie == 3){
            return Color.GREEN;
        } else if (vie == 2) {
            return Color.ORANGE;
        }
        return Color.RED;
    }

    @Override
    public Zone[] getZones() {
        ArrayList<Zone> zones = new ArrayList<>();

        // Zone du bas
        if (vieBas > 0) {
            zones.add(
                new Zone(
                        new Point(x, y),
                        new Point(x + largeur, y),
                        new Point(x, y + Principal.HAUTEUR),
                        new Point(x+ largeur, y + Principal.HAUTEUR)
                ));
        }

        if (vieHaut > 0) {
            zones.add(
                new Zone(
                        new Point(x, y - Principal.HAUTEUR),
                        new Point(x + largeur, y - Principal.HAUTEUR),
                        new Point(x, y - ecartement),
                        new Point(x+ largeur, y - ecartement)
                ));
        }
        return zones.toArray(new Zone[zones.size()]);
    }

    public int getVieBas() {
        return vieBas;
    }

    public void setVieBas(int vieBas) {
        this.vieBas = vieBas;
    }

    public int getVieHaut() {
        return vieHaut;
    }

    public void setVieHaut(int vieHaut) {
        this.vieHaut = vieHaut;
    }
}
