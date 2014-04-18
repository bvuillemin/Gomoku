package Principal;

public class Noeud {

    private int nbVictoire;
    private int nbSimulation;
    private Coup coup;

    public Noeud(Coup _coup) {
        this.nbVictoire = 0;
        this.nbSimulation = 0;
        this.coup = _coup;
    }

    public double getMoyenne() {
        double a = nbVictoire / nbSimulation;
        return a;
    }

    public Coup getCoup() {
        return coup;
    }

    public void ajouterVictoire() {
        this.nbVictoire++;
    }

    public void ajouterDefaite() {
        this.nbVictoire--;
    }

    public int getNbSimulation() {
        return nbSimulation;
    }

    public void setNbSimulation(int nbSimulation) {
        this.nbSimulation = nbSimulation;
    }
}
