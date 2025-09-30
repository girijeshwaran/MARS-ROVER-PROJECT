package domain.direction;
import core.Position;
public interface Direction {
    Direction turnLeft();
    Direction turnRight();
    Position move(Position p);
    String name();
}