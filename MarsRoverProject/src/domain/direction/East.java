package domain.direction;
import core.Position;
public class East implements Direction {
    public Direction turnLeft()  { return new North(); }
    public Direction turnRight() { return new South(); }
    public Position move(Position p){ return p.translate(1,0); }
    public String name(){ return "E"; }
}