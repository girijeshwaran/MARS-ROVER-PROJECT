package domain.direction;
import core.Position;
public class West implements Direction {
    public Direction turnLeft()  { return new South(); }
    public Direction turnRight() { return new North(); }
    public Position move(Position p){ return p.translate(-1,0); }
    public String name(){ return "W"; }
}