/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Joueur;

import Principal.*;

public class JoueurAleatoire extends Joueur {

    public JoueurAleatoire(int _id) {
        super(_id);
    }

    @Override
    public Coup genererCoup(Plateau etatJeu) {
        Coup c;
        Position p;
        int x = Utilitaire.monRandom(1, etatJeu.getLongueur());
        int y = Utilitaire.monRandom(1, etatJeu.getLargeur());
        while (etatJeu.getEtatPlateau(x - 1, y - 1) != 0) {
            x = Utilitaire.monRandom(1, etatJeu.getLongueur());
            y = Utilitaire.monRandom(1, etatJeu.getLargeur());
            // Tant que la case choisie est occupée, on recommence le choix aléatoire d'une case
        }
        p = new Position(x, y);
        c = new Coup(this.id, p);
        return c;
    }
}
