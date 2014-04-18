package Principal;

import Principal.Position;
import java.util.ArrayList;
import java.lang.Object;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Plateau {

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

    public void initialiser(ArrayList<Coup> liste) {
        for (int i = 0; i < this.longueur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                this.etatPlateau[i][j] = 0;
            }
        }
        for (Coup c : liste) {
            try {
                this.jouer(c);
            } catch (Exception ex) {
                System.out.println("Erreur, coup invalide");
            }
        }
    }

    public boolean jouer(Coup cp) {
        if (((cp.getPos().getX() - 1) >= 0) && ((cp.getPos().getX() - 1) < longueur)
                && (cp.getPos().getY() - 1 >= 0) && ((cp.getPos().getY() - 1) < largeur)) {
            this.etatPlateau[cp.getPos().getX() - 1][cp.getPos().getY() - 1] = cp.getId();
            this.historique.add(cp);
            return true;
        } else {
            System.out.println("Coup invalide");
            return false;
        }
    }

    public ArrayList<Position> etatId(int id) {
        ArrayList<Position> liste = new ArrayList<Position>();
        for (int i = 0; i < this.longueur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                if (this.etatPlateau[i][j] == id) {
                    liste.add(new Position(i+1, j+1));
                }
            }
        }

        return liste;
    }

    public void annuler() {
            Coup cp = this.historique.get(this.historique.size() - 1);
            this.etatPlateau[cp.getPos().getX() - 1][cp.getPos().getY() - 1] = 0;
            this.historique.remove(this.historique.size() - 1);
    }

    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getEtatPlateau(int x, int y) {
        return this.etatPlateau[x][y];
    }

    public int getDernierID() {
        if (!this.historique.isEmpty()) {
            return this.historique.get(this.historique.lastIndexOf(this)).getId();
        } else {
            return 0;
        }
    }

    public ArrayList<Coup> getSituation() {
        ArrayList<Coup> Liste_coup = new ArrayList<>();
        for (int i = 0; i < historique.size(); i++) {
            Liste_coup.add(new Coup(historique.get(i).getId(),
                    new Position(historique.get(i).getPos().getX(), historique.get(i).getPos().getY())));
        }
        return Liste_coup;
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

    public abstract boolean CheckLigneId(Position position, int valeur_victoire, int i);

    public abstract boolean CheckColonneId(Position position, int valeur_victoire, int i);

}
