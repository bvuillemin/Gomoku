package Joueur;

import Principal.JeuDePlateauFactory;
import Principal.*;
import JeuDeGomoku.*;
import java.util.ArrayList;

public class JoueurMonteCarlo extends Joueur {

    private int nbSimulation;
    private JeuDePlateauFactory factory;

    public JoueurMonteCarlo(int _id, int _nbSimulation, JeuDePlateauFactory _factory) {
        super(_id);
        this.nbSimulation = _nbSimulation;
        this.factory = _factory;
    }

    @Override
    public Coup genererCoup(Plateau etatJeu) {
        //Algorithme repris de l'énoncé du TP
        Noeud meilleurCoup = null;
        ArrayList<Position> positionsPossibles = etatJeu.etatId(0);
        Joueur j;
        for (Position p : positionsPossibles) {
            Coup cCourant = new Coup(this.id, p);
            Noeud nCourant = new Noeud(cCourant);
            etatJeu.jouer(cCourant);
            ArrayList<Coup> sit = etatJeu.getSituation();
            for (int i = 0; i < this.nbSimulation; i++) {
                j = this.factory.CreerPartieAleatoireVSAleatoire(sit).jouerPartie(false);
                if (j != null) {
                    if (j.getId() == super.getId()) {
                        nCourant.ajouterVictoire();
                    } else {
                        nCourant.ajouterDefaite();
                    }
                }
            }
            if ((meilleurCoup == null) || (meilleurCoup.getNbSimulation() == 0)
                    || (meilleurCoup.getMoyenne() < nCourant.getMoyenne())) {
                meilleurCoup = nCourant;
            }
            etatJeu.annuler();
        }
        return meilleurCoup.getCoup();
    }
}
