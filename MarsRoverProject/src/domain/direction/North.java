package domain.direction;
import core.Position;
public class North implements Direction {
    public Direction turnLeft()  { return new West(); }
    public Direction turnRight() { return new East(); }
    public Position move(Position p){ return p.translate(0,1); }
    public String name(){ return "N"; }
}