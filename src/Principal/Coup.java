package Principal;

import Principal.Position;

public class Coup {
    private int id;
    private Position pos;

    public Coup(int id, Position pos) {
        this.id = id;
        this.pos = pos;
    }

    public int getId() {
        return id;
    }

    public Position getPos() {
        return pos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        String s = "Coup: Id = " + this.id + ", " + this.pos.toString();
        return s;
    }
    
    
}
