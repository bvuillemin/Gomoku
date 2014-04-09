package JeuDeGomoku;

import gomoku.*;
import JoueurGomoku.*;

public class JeuDeGomoku {
    
    private PlateauGomoku plateau;
    private Joueur[] tabJoueur;
    private Joueur joueurCourant;
    private int valeur_victoire;
    
    public JeuDeGomoku(boolean b)
    {
        if(b){
        this.plateau = new PlateauGomoku();
        this.tabJoueur = new Joueur[2];
        this.valeur_victoire = 5;
        }
    }
    
    public JeuDeGomoku()
    {
        
    }
    
    public boolean setJoueur(int ordre, Joueur joueur) {
        if (ordre == 1 || ordre == 2) {
            tabJoueur[ordre] = joueur;
            return true;
        } else {
            System.out.println("Erreur dans l'attribution du joueur au jeu");
            return false;
        }
    }
    
    public void setPlateau(PlateauGomoku plateau){
        this.plateau = plateau;
    }
    
    private Joueur joueurSuivant()
    {
        if(this.joueurCourant.getId() == 1)
            return this.tabJoueur[1];
        if(this.joueurCourant.getId() == 2)
            return this.tabJoueur[0];
        else
            return this.tabJoueur[0];
    }
    
    public boolean partieTerminee()
    {
        //On teste chaque ligne possible pour les deux joueurs
        for(int i = 1; i <= 5; i++)
        {
            for(int j = 1; j <= 9; j++)
            {
                if(this.plateau.CheckLigneId(new Position(i, j), 1, this.valeur_victoire))
                    return true;
                if(this.plateau.CheckLigneId(new Position(i, j), 2, this.valeur_victoire))
                    return true;
            }
        }
        //On teste chaque colonne possible pour les deux joueurs
        for(int i = 1; i <= 9; i++)
        {
            for(int j = 1; j <= 5; j++)
            {
                if(this.plateau.CheckColonneId(new Position(i, j), 1, this.valeur_victoire))
                    return true;
                if(this.plateau.CheckColonneId(new Position(i, j), 2, this.valeur_victoire))
                    return true;
            }
        }
        //On retourne faux si personne ne gagne
        return false;
    }
    
    public boolean coupValide(Coup coup)
    {
        int x = coup.getPos().getX();
        int y = coup.getPos().getY();
        if(x > 0 && x <= 9)
            if(y > 0 && y <= 9)
                if(this.plateau.getEtatPlateau(x, y) == 0) //Teste si la case est vide
                    return true;
        return false;
    }
    
    public Joueur jouerPartie(){
        boolean valide;
        while(partieTerminee())
        {
            valide = false;
            this.joueurCourant = joueurSuivant();
            
            while(!valide){
                Coup c = this.joueurCourant.genererCoup(this.plateau);
                valide = coupValide(c);
                if(valide)
                    this.plateau.jouer(c);
                else
                    System.out.println("Coup non valide");
            }
        }
        
        return this.joueurCourant;
    }
    
    
}
