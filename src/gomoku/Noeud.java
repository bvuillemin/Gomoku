/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

/**
 *
 * @author BVuillemin <benoit.vuil@gmail.com>
 */
public class Noeud {

    private int nbVictoire;
    private int nbSimulation;
    private Coup coup;

    public Noeud(Coup _coup) {
        this.nbVictoire = 0;
        this.nbSimulation = 0;
        this.coup = _coup;
    }

    public double getMoyenne() {
        double a = nbVictoire / nbSimulation;
        return a;
    }

    public Coup getCoup() {
        return coup;
    }

    public void ajouterVictoire() {
        this.nbVictoire++;
    }

    public void ajouterDefaite() {
        this.nbVictoire--;
    }
}
