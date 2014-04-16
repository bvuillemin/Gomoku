package JeuDeGomoku;

import gomoku.*;
import JoueurGomoku.*;

public class JeuDeGomoku extends JeuDePlateau{

    public JeuDeGomoku() {
        super();
        this.plateau = new PlateauGomoku();
        if(this.plateau.getDernierID() == 0)
             this.joueurCourant = this.tabJoueur[0];
         else
             this.joueurCourant = this.tabJoueur[this.plateau.getDernierID() - 1];
    }
    
    public void setPlateau(PlateauGomoku plateau){
        this.plateau = plateau;
    }
    
    public boolean partieTerminee()
    {
        //On teste chaque ligne possible pour les deux joueurs
        for(int i = 1; i <= 5; i++)
        {
            for(int j = 1; j <= 9; j++)
            {
                if(this.plateau.CheckColonneId(new Position(i, j), this.valeur_victoire, 1))
                    return true;
                if(this.plateau.CheckColonneId(new Position(i, j), this.valeur_victoire, 2))
                    return true;
            }
        }
        //On teste chaque colonne possible pour les deux joueurs
        for(int i = 1; i <= 9; i++)
        {
            for(int j = 1; j <= 5; j++)
            {
                if(this.plateau.CheckLigneId(new Position(i, j), this.valeur_victoire, 1))
                    return true;
                if(this.plateau.CheckLigneId(new Position(i, j), this.valeur_victoire, 2))
                    return true;
            }
        }
        //On retourne faux si personne ne gagne
        return false;
    }
    
    
    public boolean partieNulle()
    {
        for(int i = 0; i < this.plateau.getLargeur(); i++)
        {
            for(int j = 0; j < this.plateau.getLongueur(); j++)
            {
                if(this.plateau.getEtatPlateau(i, j) == 0)
                    return false;
            }
        }
        return true;
    }
    
    public boolean coupValide(Coup coup)
    {
        int x = coup.getPos().getX();
        int y = coup.getPos().getY();
        if(x > 0 && x <= 9)
            if(y > 0 && y <= 9)
                if(this.plateau.getEtatPlateau(x - 1, y - 1) == 0) //Teste si la case est vide
                    return true;
        return false;
    }
}
