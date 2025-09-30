package domain.commands;
import core.Rover;
public class RightCommand implements Command {
    private final Rover rover;
    public RightCommand(Rover r){ this.rover = r; }
    public void execute(){ rover.turnRight(); }
}