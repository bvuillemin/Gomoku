/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JoueurGomoku;

import gomoku.*;
import java.util.Scanner;

/**
 *
 * @author p1106866
 */
public class JoueurHumain extends Joueur {

    public JoueurHumain(int _id) {
        super(_id);
    }

    @Override
    public Coup genererCoup(Plateau etatJeu) {
        Coup c;
        Position p;
        Scanner s = new Scanner(System.in);
        System.out.println("X ?");
        int a = s.nextInt();
        System.out.println("Y ?");
        int b = s.nextInt();
        while (etatJeu.getEtatPlateau(a - 1, b - 1) != 0) {
            System.out.println("La case est déjà occupée !");
            System.out.println("X ?");
            a = s.nextInt();
            System.out.println("Y ?");
            b = s.nextInt();
        }
        p = new Position(a, b);
        c = new Coup(this.id, p);
        return c;
    }
}
