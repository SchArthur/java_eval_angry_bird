package flappy.models;

import java.awt.*;

public abstract class Sprite {

    protected int x;
    protected int y;
    protected int largeur;
    protected Zone[] zones;

    public abstract void dessiner(Graphics2D dessin);
    public abstract void deplacement();

    public boolean testCollision(Sprite cible){

//        Point[] positionCible = cible.position();
//
//        Point[] position = position();

//        int p1xTuyauBas = x;
//        int p1yTuyauBas = y;
//        int p2xTuyauBas = x + largeur;
//        int p3yTuyauBas = y + 800;
//
//        int p1yTuyauHaut = y - 800;
//        int p3yTuyauHaut = y - ecartement;

//        for (Point pointCible : positionCible) {
//
//            //si le point est entre les 2 tuyaux horizontalement
//            // et qu'il se trouve verticalement entre le tuyau du bas ou le tuyau du haut
//            if( (pointCible.x() > p1xTuyauBas && pointCible.x() < p2xTuyauBas) &&
//                    ((pointCible.y() > p1yTuyauBas && pointCible.y() < p3yTuyauBas)
//                            || pointCible.y() > p1yTuyauHaut && pointCible.y() < p3yTuyauHaut)){
//                return true;
//            }
//        }
        return false;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
}
