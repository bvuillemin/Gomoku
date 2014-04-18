package Principal;

import Joueur.Joueur;
import Principal.Coup;
import Principal.Plateau;
import java.util.ArrayList;

public abstract class JeuDePlateau {

    private Plateau plateau;
    private Joueur[] tabJoueur;
    private Joueur joueurCourant;
    private int valeur_victoire;

    public JeuDePlateau() {
        this.tabJoueur = new Joueur[2];
    }
    
    public Plateau getPlateau(){
        return this.plateau;
    }
    
    public Joueur getJoueurCourant(){
        return this.joueurCourant;
    }
    
    public Joueur getJoueur(int ordre){
        return this.tabJoueur[ordre];
    }
    
    public void setPlateau(Plateau plateau){
        this.plateau = plateau;
    }
    
    public void setJoueurCourant(Joueur joueur){
        this.joueurCourant = joueur;
    }
    
    public int getValeurVictoire(){
        return this.valeur_victoire;
    }
    
    public void setValeurVictoire(int valeur){
        this.valeur_victoire = valeur;
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

    private Joueur joueurSuivant() {
        if (this.joueurCourant == null) {
            return this.tabJoueur[0];
        }
        if (this.joueurCourant.getId() == 1) {
            return this.tabJoueur[1];
        }
        if (this.joueurCourant.getId() == 2) {
            return this.tabJoueur[0];
        } else {
            return this.tabJoueur[0];
        }
    }

    public Joueur jouerPartie() {
        boolean valide;
        boolean termine = partieTerminee();
        boolean nul = false;

        while (!termine) {
            System.out.println(this.plateau.toString());
            valide = false;
            this.joueurCourant = joueurSuivant();

            while (!valide) {
                Coup c = this.joueurCourant.genererCoup(this.plateau);
                valide = coupValide(c);
                if (valide) {
                    this.plateau.jouer(c);
                } else {
                    System.out.println("Coup non valide");
                }
            }

            termine = partieTerminee();
            if (partieNulle()) {
                termine = true;
                nul = true;
            }
        }

        if (nul) {
            System.out.println("Partie Nulle!!");
            return null;
        } else {
            System.out.println("Joueur gagnant:" + this.joueurCourant);
            return this.joueurCourant;
        }
    }

    public abstract boolean partieTerminee();

    public abstract boolean partieNulle();

    public abstract boolean coupValide(Coup coup);

}
