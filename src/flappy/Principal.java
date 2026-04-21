package flappy;

import flappy.models.Oiseau;
import flappy.models.Tuyau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Principal extends Canvas implements KeyListener {

    public static final int LARGEUR = 800;
    public static final int HAUTEUR = 600;

    private JFrame fenetre = new JFrame();
    private Oiseau oiseau;
    private Tuyau tuyau;

    private boolean pause = false;
    private int score = 0;

    public Principal() throws InterruptedException {

        fenetre.setSize(LARGEUR, HAUTEUR);

        this.setSize(LARGEUR, HAUTEUR);
        this.setBounds(0, 0, LARGEUR, HAUTEUR);

        //addEventListener("click", () => console.log("coucou") )
        fenetre.addKeyListener(this);


        JPanel panel = new JPanel();
        panel.add(this);
        fenetre.setContentPane(panel);

        fenetre.requestFocus();
        this.setFocusable(false);

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fenetre.setIgnoreRepaint(true);
        fenetre.setResizable(false);

        fenetre.pack();

        fenetre.setVisible(true);

        this.createBufferStrategy(2);

        demarrer();
    }

    public void reset() {

        pause = false;

        oiseau = new Oiseau();
        oiseau.setX(200);
        oiseau.setY(200);

        tuyau = new Tuyau();
        tuyau.setX(LARGEUR);
        tuyau.setY(300);

        score = 0;
    }

    public void demarrer() throws InterruptedException {

        reset();

        while(!pause) {

            score ++;

            Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();

            dessin.setColor(Color.white);
            dessin.fillRect(0,0, LARGEUR, HAUTEUR);

            oiseau.deplacement();
            oiseau.dessiner(dessin);

            tuyau.deplacement();
            tuyau.dessiner(dessin);

            if(tuyau.testCollision(oiseau) || oiseau.getY() > HAUTEUR - 50) {
                pause = true;
            }

            dessin.setColor(Color.BLACK);
            dessin.setFont(new Font("Arial", Font.BOLD, 20));
            dessin.drawString("score " + score, LARGEUR - 200 ,20);

            //enregistrement du dessin
            dessin.dispose();
            //on switch du buffer d'affichage au buffer de preparation
            this.getBufferStrategy().show();

            Thread.sleep(1000 / 60);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        new Principal();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {

            System.out.println("toto");

            if(pause) {
                reset();
            } else {
                oiseau.saut();
            }
        }
    }
}
