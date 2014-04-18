package Principal;

import java.util.ArrayList;
import JeuDeGomoku.*;


public class Principal {

    public static void main(String[] args) {
        
        JeuDePlateau jeu;
        JeuDeGomokuFactory factory = new JeuDeGomokuFactory();
        ArrayList<Coup> situation = new ArrayList();
        situation.add(new Coup(1, new Position(8, 9)));
        situation.add(new Coup(2, new Position(1, 1)));
        
        /*situation.add(new Coup(2, new Position(1, 3)));
        situation.add(new Coup(2, new Position(2, 3)));
        situation.add(new Coup(2, new Position(3, 6)));
        situation.add(new Coup(2, new Position(6, 3)));
        situation.add(new Coup(1, new Position(4, 5)));
        situation.add(new Coup(1, new Position(4, 6)));
        situation.add(new Coup(1, new Position(4, 7)));
        situation.add(new Coup(1, new Position(4, 8)));*/
        
        jeu = factory.CreerPartieHumainVSAleatoire(situation);
        
        jeu.jouerPartie();
        
        System.out.println(jeu.getPlateau().toString());
        
    }
    
}
