package domain.commands;
import core.Rover;
public class LeftCommand implements Command {
    private final Rover rover;
    public LeftCommand(Rover r){ this.rover = r; }
    public void execute(){ rover.turnLeft(); }
}