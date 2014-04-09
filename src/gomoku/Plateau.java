package gomoku;

import java.util.ArrayList;

public class Plateau {

    private int longueur;
    private int largeur;
    private int[][] etatPlateau;
    private ArrayList<Coup> historique;

    public Plateau(int longueur, int largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
        this.etatPlateau = new int[longueur][largeur];
        this.historique = new ArrayList<Coup>();
    }

    public void initialiser() {
        for (int i = 0; i < this.longueur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                this.etatPlateau[i][j] = 0;
            }
        }
    }
    
    public void initialiser(ArrayList<Coup> liste)
    {
        for (int i = 0; i < this.longueur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                this.etatPlateau[i][j] = 0;
            }
        }
        for(Coup c: liste)
        {
            this.jouer(c);
        }
    }

    public void jouer(Coup cp) {
        this.etatPlateau[cp.getPos().getX()][cp.getPos().getY()] = cp.getId();
        this.historique.add(cp);
    }

    public ArrayList<Position> etatId(int id) {
        ArrayList<Position> liste = new ArrayList<Position>();
        for (int i = 0; i < this.longueur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                if (this.etatPlateau[i][j] == id) {
                    liste.add(new Position(i, j));
                }
            }
        }

        return liste;
    }
    
    public Coup annuler()
    {
        Coup cp = this.historique.get(this.historique.size() - 1);
        this.etatPlateau[cp.getPos().getX()][cp.getPos().getY()] = 0;
        return cp;
    }

    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }
    
    public int getEtatPlateau(int x, int y){
        return this.etatPlateau[x][y];
    }

    @Override
    public String toString() {
        StringBuilder grille = new StringBuilder();
        for (int i = 0; i < this.longueur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                grille.append(this.etatPlateau[i][j]);
            }
            grille.append("\n");
        }

        return grille.toString();
    }

}
