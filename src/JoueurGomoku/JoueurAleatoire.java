/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JoueurGomoku;

import gomoku.*;

/**
 *
 * @author p1106866
 */
public class JoueurAleatoire extends Joueur{
    public JoueurAleatoire(int _id)
    {
        super(_id);
    }
    
    @Override
    public Coup genererCoup(Plateau etatJeu)
    {
        Coup c;
        Position p;
        int a = Utilitaire.monRandom(1, etatJeu.getLongueur());
        int b = Utilitaire.monRandom(1, etatJeu.getLargeur());
        while(etatJeu.getEtatPlateau(a, b) != 0)
        {
            a = Utilitaire.monRandom(1, etatJeu.getLongueur());
            b = Utilitaire.monRandom(1, etatJeu.getLargeur());
        }
        p = new Position(a, b);
        c = new Coup(this.id,p);
        return c;
    }
}
