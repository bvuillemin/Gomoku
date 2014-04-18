package JeuDeGomoku;

import Joueur.*;
import Principal.*;
import java.util.ArrayList;

public class JeuDeGomokuFactory implements JeuDePlateauFactory {

    public JeuDeGomokuFactory() {

    }

    public JeuDePlateau CreerPartieHumainVSHumain(ArrayList<Coup> situation) {
        PlateauGomoku p = new PlateauGomoku();
        JeuDeGomoku jeu = new JeuDeGomoku();
        JoueurHumain jh1 = new JoueurHumain(1);
        JoueurHumain jh2 = new JoueurHumain(2);

        jeu.setPlateau(p);
        jeu.setJoueur(1, jh1);
        jeu.setJoueur(2, jh2);

        for (int i = 0; i < situation.size(); i++) {
            jeu.getPlateau().jouer(situation.get(i));
        }
        return jeu;
    }

    public JeuDePlateau CreerPartieHumainVSAleatoire(ArrayList<Coup> situation) {
        PlateauGomoku p = new PlateauGomoku();
        JeuDeGomoku jeu = new JeuDeGomoku();
        JoueurHumain jh = new JoueurHumain(1);
        JoueurAleatoire ja = new JoueurAleatoire(2);

        jeu.setPlateau(p);
        jeu.setJoueur(1, jh);
        jeu.setJoueur(2, ja);

        for (int i = 0; i < situation.size(); i++) {
            jeu.getPlateau().jouer(situation.get(i));
        }
        return jeu;
    }

    public JeuDePlateau CreerPartieHumainVSMonteCarlo(ArrayList<Coup> situation) {
        PlateauGomoku p = new PlateauGomoku();
        JeuDeGomoku jeu = new JeuDeGomoku();
        JoueurHumain jh = new JoueurHumain(2);
        JoueurMonteCarlo jm = new JoueurMonteCarlo(1, 50, this);

        jeu.setPlateau(p);
        jeu.setJoueur(2, jh);
        jeu.setJoueur(1, jm);

        for (int i = 0; i < situation.size(); i++) {
            jeu.getPlateau().jouer(situation.get(i));
        }
        return jeu;
    }

    public JeuDePlateau CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation) {
        PlateauGomoku p = new PlateauGomoku();
        JeuDeGomoku jeu = new JeuDeGomoku();
        JoueurAleatoire ja1 = new JoueurAleatoire(1);
        JoueurAleatoire ja2 = new JoueurAleatoire(2);

        jeu.setPlateau(p);
        jeu.setJoueur(1, ja1);
        jeu.setJoueur(2, ja2);

        for (int i = 0; i < situation.size(); i++) {
            jeu.getPlateau().jouer(situation.get(i));
        }
        return jeu;
    }
}
