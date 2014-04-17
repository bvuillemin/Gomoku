/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JoueurGomoku;
import java.util.*;

public class Utilitaire {
    public static int monRandom(int min, int max)
    {
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(max - min + 1) + min;
        // Choisit un entier entre min (inclus) et max (exclus)
        return nombreAleatoire;
    }
}
