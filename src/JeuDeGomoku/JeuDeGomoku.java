package JeuDeGomoku;

import Principal.JeuDePlateau;
import Principal.*;

public class JeuDeGomoku extends JeuDePlateau{

    public JeuDeGomoku() {
        super();
        setPlateau(new PlateauGomoku());
        if(getPlateau().getDernierID() == 0)
             setJoueurCourant(getJoueur(0));
         else
            setJoueurCourant(getJoueur(getPlateau().getDernierID() - 1));
    }
   
    public boolean partieTerminee()
    {
        //On teste chaque ligne possible pour les deux joueurs
        for(int i = 1; i <= 5; i++)
        {
            for(int j = 1; j <= 9; j++)
            {
                if(getPlateau().CheckColonneId(new Position(i, j), getValeurVictoire(), 1))
                    return true;
                if(getPlateau().CheckColonneId(new Position(i, j), getValeurVictoire(), 2))
                    return true;
            }
        }
        //On teste chaque colonne possible pour les deux joueurs
        for(int i = 1; i <= 9; i++)
        {
            for(int j = 1; j <= 5; j++)
            {
                if(getPlateau().CheckLigneId(new Position(i, j), getValeurVictoire(), 1))
                    return true;
                if(getPlateau().CheckLigneId(new Position(i, j), getValeurVictoire(), 2))
                    return true;
            }
        }
        //On retourne faux si personne ne gagne
        return false;
    }
    
    
    public boolean partieNulle()
    {
        for(int i = 0; i < getPlateau().getLargeur(); i++)
        {
            for(int j = 0; j < getPlateau().getLongueur(); j++)
            {
                if(getPlateau().getEtatPlateau(i, j) == 0)
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
                if(getPlateau().getEtatPlateau(x - 1, y - 1) == 0) //Teste si la case est vide
                    return true;
        return false;
    }
}
