/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        Noeud meilleurCoup = null;
        ArrayList<Position> positionsPossibles = etatJeu.etatId(0);
        int a;
        for (Position p : positionsPossibles) {
            Coup cCourant = new Coup(id, p);
            Noeud nCourant = new Noeud(cCourant);
            etatJeu.jouer(cCourant);
            ArrayList<Coup> sit = etatJeu.getSituation();
            for (int i = 0; i < this.nbSimulation; i++) {
                a = this.factory.CreerPartieAleatoireVSAleatoire(sit).jouerPartie().getId();
                if (a == 2) {
                    nCourant.ajouterVictoire();
                } else {
                    nCourant.ajouterDefaite();
                }
            }
            if ((meilleurCoup == null) || (meilleurCoup.getMoyenne() < nCourant.getMoyenne())) {
                meilleurCoup = nCourant;
            }
            etatJeu.annuler();
        }
        return meilleurCoup.getCoup();
    }
}
