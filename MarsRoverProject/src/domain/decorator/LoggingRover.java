package domain.decorator;
import core.Rover;
public class LoggingRover extends RoverDecorator {
    public LoggingRover(Rover rover){ super(rover); }
    @Override
    public void moveForward(){
        System.out.println("[LOG] Before move: " + decoratedRover.status());
        decoratedRover.moveForward();
        System.out.println("[LOG] After move: " + decoratedRover.status());
    }
}