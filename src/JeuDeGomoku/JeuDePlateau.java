package JeuDeGomoku;

import JoueurGomoku.*;
import gomoku.*;


public abstract class JeuDePlateau {
    
    public Plateau plateau;
    public Joueur[] tabJoueur;
    public Joueur joueurCourant;
    public int valeur_victoire;
    
    public JeuDePlateau()
    {
        this.tabJoueur = new Joueur[2];
        this.valeur_victoire = 5;
    }
    
    public boolean setJoueur(int ordre, Joueur joueur) {
        if (ordre == 1 || ordre == 2) {
            tabJoueur[ordre - 1] = joueur;
            return true;
        } else {
            System.out.println("Erreur dans l'attribution du joueur au jeu");
            return false;
        }
    }
    
    public void setPlateau(Plateau plateau){
        this.plateau = plateau;
    }
    
    private Joueur joueurSuivant()
    {
        if(this.joueurCourant == null)
            return this.tabJoueur[0];
        if(this.joueurCourant.getId() == 1)
            return this.tabJoueur[1];
        if(this.joueurCourant.getId() == 2)
            return this.tabJoueur[0];
        else
            return this.tabJoueur[0];
    }
    
    public abstract boolean partieTerminee();
    
    public abstract boolean coupValide(Coup coup);
    
    public Joueur jouerPartie(){
        boolean valide;
        while(!partieTerminee())
        {
            System.out.println(this.plateau.toString());
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
        System.out.println(this.joueurCourant);
        return this.joueurCourant;
    }
    
}
