/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JoueurGomoku;
import java.util.*;
/**
 *
 * @author p1106866
 */
public class Utilitaire {
    public static int monRandom(int min, int max)
    {
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(max - min + 1) + min;
        return nombreAleatoire;
    }
}
