package Principal;

import java.util.ArrayList;
import JeuDeGomoku.*;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        JeuDePlateau jeu;
        JeuDeGomokuFactory factoryGomoku = new JeuDeGomokuFactory();
        ArrayList<Coup> situation = new ArrayList();
        int a = 1;

        Scanner s = new Scanner(System.in);

        while (a != 0) {
            System.out.println();
            System.out.println("Bienvenue dans le jeu du Gomoku?");
            System.out.println("Contre qui souhaitez-vous jouer?");
            System.out.println("1 -- Humain");
            System.out.println("2 -- IA aléatoire");
            System.out.println("3 -- IA Monte Carlo");
            System.out.println("4 -- Partie test");
            System.out.println();
            System.out.println("0 -- Quitter");

            a = s.nextInt();
            switch (a) {
                case 0:
                    break;
                case 1:
                    jeu = factoryGomoku.CreerPartieHumainVSHumain(situation);
                    jeu.jouerPartie(true);
                    break;
                case 2:
                    jeu = factoryGomoku.CreerPartieHumainVSAleatoire(situation);
                    jeu.jouerPartie(true);
                    break;
                case 3:
                    jeu = factoryGomoku.CreerPartieHumainVSMonteCarlo(situation);
                    jeu.jouerPartie(true);
                    break;
                case 4:
                    situation.add(new Coup(1, new Position(8, 9)));
                    situation.add(new Coup(2, new Position(1, 1)));
                    break;
                default:
                    System.out.println("Erreur dans la sélection");
                    break;
            }
        }
    }
}
