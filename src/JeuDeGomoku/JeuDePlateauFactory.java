package JeuDeGomoku;

import gomoku.Coup;
import java.util.ArrayList;

public interface JeuDePlateauFactory {

    JeuDePlateau CreerPartieHumainVSHumain (ArrayList<Coup> situation);
    JeuDePlateau CreerPartieHumainVSAleatoire (ArrayList<Coup> situation);
    JeuDePlateau CreerPartieAleatoireVSAleatoire (ArrayList<Coup> situation);
    
}
