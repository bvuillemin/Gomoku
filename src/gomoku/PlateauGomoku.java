package gomoku;

public class PlateauGomoku extends Plateau{

    public PlateauGomoku() {
        super(9, 9);
    }
    
    public boolean CheckLigneId(Position pos, int n,int id)
    {
        int x=pos.getX();
        int y=pos.getY();
        int y_end=y + n;  
        while(y <= this.getLargeur() && y< y_end && getEtatPlateau(x-1, y-1) == id)
        {
            y++;
        }
        if(y == y_end )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean CheckColonneId(Position pos, int n,int id)
    {
        int x=pos.getX();
        int y=pos.getY();
        int x_end=x + n;  
        while(x <= getLongueur() && x< x_end && getEtatPlateau(x-1, y-1) == id)
        {
            x++;
        }
        if(x == x_end )
        {
            return true;
        }
        else
        {
            return false;
        }
    }   

    
}
