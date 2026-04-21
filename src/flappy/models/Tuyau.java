package flappy.models;

import flappy.Principal;

import java.awt.*;

public class Tuyau extends Sprite{

    protected int ecartement = 200;
    protected int largeur = 100;
    protected int marge = 50;
    protected int vitesse = 4;
    protected Color couleur = Color.GREEN;

    public void deplacement(){
        x -= vitesse;

        if(x < -largeur) {
            x = Principal.LARGEUR;
            y = aleatoire(marge + ecartement, Principal.HAUTEUR - marge);
        }
    }

    public void dessiner(Graphics2D dessin){
        dessin.setColor(couleur);
        dessin.fillRect(x,y, largeur, Principal.HAUTEUR);
        dessin.fillRect(x,y-ecartement-Principal.HAUTEUR, largeur, Principal.HAUTEUR);
    }

    public boolean testCollision(Oiseau oiseau){

        Point[] positionOiseau = oiseau.position();

        int p1xTuyauBas = x;
        int p1yTuyauBas = y;
        int p2xTuyauBas = x + largeur;
        int p3yTuyauBas = y + 800;

        int p1yTuyauHaut = y - 800;
        int p3yTuyauHaut = y - ecartement;

        for (Point point : positionOiseau) {

            //si le point est entre les 2 tuyaux horizontalement
            // et qu'il se trouve verticalement entre le tuyau du bas ou le tuyau du haut
            if( (point.x() > p1xTuyauBas && point.x() < p2xTuyauBas) &&
                    ((point.y() > p1yTuyauBas && point.y() < p3yTuyauBas)
                      || point.y() > p1yTuyauHaut && point.y() < p3yTuyauHaut)){
                return true;
            }
        }
        return false;
    }

    public int aleatoire(int min, int max){
        return (int)(Math.random() * (max - min) + min);
    }

}
