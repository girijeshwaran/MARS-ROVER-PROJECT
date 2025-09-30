package domain.direction;
import core.Position;
public class South implements Direction {
    public Direction turnLeft()  { return new East(); }
    public Direction turnRight() { return new West(); }
    public Position move(Position p){ return p.translate(0,-1); }
    public String name(){ return "S"; }
}