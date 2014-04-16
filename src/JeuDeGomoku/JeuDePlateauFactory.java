/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JeuDeGomoku;

import gomoku.Coup;
import java.util.ArrayList;

public interface JeuDePlateauFactory {
    JeuDePlateau CreerPartieHumainVSHumain (ArrayList<Coup> situation);
    JeuDePlateau CreerPartieHumainVSAleatoire (ArrayList<Coup> situation);
    JeuDePlateau CreerPartieAleatoireVSAleatoire (ArrayList<Coup> situation);
    
}
