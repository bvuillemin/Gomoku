/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Joueur;
import Principal.Coup;
import Principal.Plateau;


public abstract class Joueur {

    protected int id;

    public Joueur(int _id) {
        this.id = _id;
    }

    public int getId() {
        return id;
    }
    
    public abstract Coup genererCoup(Plateau etatJeu);
    
    @Override
    public String toString()
    {
        return Integer.toString(id);
    }
}
