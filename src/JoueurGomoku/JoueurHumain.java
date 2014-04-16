package JoueurGomoku;

import gomoku.*;
import java.util.Scanner;

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
        while (a <= 0 || a > etatJeu.getLongueur()
                || b <= 0 || b > etatJeu.getLargeur()||
                etatJeu.getEtatPlateau(a - 1, b - 1) != 0) {
            System.out.println("Coup non valide !");
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
