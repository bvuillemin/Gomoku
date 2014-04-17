package JoueurGomoku;

import JeuDeGomoku.*;
import gomoku.*;
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
            System.out.println(p.getX());
            System.out.println(p.getY());
            Coup cCourant = new Coup(this.id, p);
            Noeud nCourant = new Noeud(cCourant);
            etatJeu.jouer(cCourant);
            ArrayList<Coup> sit = etatJeu.getSituation();
            for (int i = 0; i < this.nbSimulation; i++) {
                j = this.factory.CreerPartieAleatoireVSAleatoire(sit).jouerPartie();
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
        System.out.println("OK");
        return meilleurCoup.getCoup();
    }
}
