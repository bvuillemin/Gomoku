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
public abstract class Joueur {

    protected int id;

    public Joueur(int _id) {
        this.id = _id;
    }

    public int getId() {
        return id;
    }
    
    abstract Coup genererCoup(Plateau etatJeu);
}
