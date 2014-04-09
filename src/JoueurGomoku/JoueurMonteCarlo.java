/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JoueurGomoku;

import gomoku.*;
import java.util.ArrayList;

public class JoueurMonteCarlo extends Joueur {

    private int nbSimulation;
    //private JeuDePlateauFactory factory;
    public JoueurMonteCarlo(int _id, int _nbSimulation/*, JeuDePlateauFactory _factory*/) {
        super(_id);
        this.nbSimulation = _nbSimulation;
        //this.factory = _factory;
    }
    @Override
    public Coup genererCoup(Plateau etatJeu)
    {
        Noeud meilleurCoup = null;
        ArrayList<Position> positionsPossibles = etatJeu.etatId(0);
        for (Position p : positionsPossibles)
        {
            Coup cCourant = new Coup(id, p);
            Noeud nCourant = new Noeud(cCourant);
            etatJeu.jouer(cCourant);
            //ArrayList<Coup> sit = etatJeu.getSituation();
            // Faire les choses de l'énoncé
            /*if((meilleurCoup == null)||(meilleurCoup < nCourant))
            {
                meilleurCoup = nCourant;
            }*/
            etatJeu.annuler();
        }
        return meilleurCoup.getCoup();
    }
}
